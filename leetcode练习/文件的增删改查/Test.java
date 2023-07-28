package com.itheima.day10.demo2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static List<File> allSongs = new ArrayList<>();
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        Scanner sc = new Scanner(System.in);
        String path = "D:\\视频素材";
        File dir = new File(path);
        addAllSongs(dir);
        while (true){
            System.out.println("请选择您要进行的操作：1：查询所有歌曲   2：根据歌曲名称复制  3：根据歌曲名称删除 4: 退出");
            int operate = sc.nextInt();

            switch (operate){
                case 1 : searchAllSongs();
                break;
                case 2: copyByName();
                break;
                case 3: deleteByName();
                break;
                case 4:
                    System.out.println("退出系统");
                    return;
                default:
                    System.out.println("没有该操作！");
                    break;
            }
        }
    }

    /**
     * 输出该文件夹下所有歌曲
     */
    private static void searchAllSongs() {
        System.out.println("存在以下歌曲：");
        allSongs.forEach(o-> System.out.println(o.getName()));
    }


    /**
     * 根据名字找到音乐源文件
     * @param name
     * @return
     */
    private static File searchByName(String name){
        File songFile = null;
        for (File song : allSongs) {
            int len = song.getName().indexOf(".");
            String songName = song.getName().substring(0,len);
            if (songName.equals(name)){
                songFile = song;
                break;
            }
        }

        if (songFile==null){
            System.out.println("没有该文件！");
            return null;
        }

        return songFile;
    }

    /**
     * 根据音乐删除文件
     */
    private static void deleteByName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要删除的歌曲名称:");
        String name = sc.next();
        System.out.println();
        File deleteSong = searchByName(name);
        if (deleteSong==null){
            return;
        }

        deleteSong.delete();
        System.out.println("删除结果："+"歌曲"+name+"已经成功删除");
    }

    /**
     * 根据歌曲名复制文件到指定路径
     */
    private static void copyByName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要复制的歌曲名称:");
        String name = sc.next();
        System.out.println();
        File songFile = searchByName(name);
        if (songFile==null){
            return;
        }
        System.out.print("请输入存储路径:");
        String copyPath = sc.next();
        System.out.println();
        File copyDir = new File(copyPath);
        if (!copyDir.exists()){
            copyDir.mkdirs();
        }

        copyFile(songFile,copyDir);
        System.out.println("歌曲"+name+"已经成功复制到"+copyPath+"目录中");
    }

    /**
     * 复制文件
     * @param songFile 源文件
     * @param copyDir 目标文件
     */
    private static void copyFile(File songFile, File copyDir){
        try (
                InputStream is = new BufferedInputStream(new FileInputStream(songFile));
                OutputStream os = new BufferedOutputStream(new FileOutputStream(new File(copyDir,songFile.getName())));
        ) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len=is.read(buffer))!=-1){
                os.write(buffer,0,len);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将文件夹下的所有歌曲添加到allSongs集合中
     * @param dir
     */
    private static void addAllSongs(File dir) {
        if (!dir.exists() || dir==null){
            throw new NumberFormatException();
        }

        if (dir.isFile()){
            return;
        }

        File[] files = dir.listFiles();
        if (files==null){
            return;
        }

        for (File file : files) {
            if (file.isFile()){
                if (file.getName().endsWith(".mp3"))
                {
                    allSongs.add(file);
                }else {
                    addAllSongs(file);
                }
            }
        }
    }
}
