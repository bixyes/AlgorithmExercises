package com.itheima.day09.demo2;

import java.io.*;

public class Test {
    /**
     * 	将D盘中某文件夹中的所有文件，复制到E盘中某文件夹中，要求E盘复制的文件夹，必须同D盘中被赋值的文件夹名称一致，文件夹中的内容也必须一致。
     * */
    public static void main(String[] args) {
        //需要复制的文件夹路径
        File dir = new File("D:\\黑马java\\day09-IO(一)");

        //复制的文件夹路径
        File copyDir = new File("D:\\黑马java\\copyDay09-IO(一)");
        copyDir(dir,copyDir);
        System.out.println("复制完成！");
    }

    private static void copyDir(File dir,File copyDir) {

        if (dir.isDirectory()){
            //如果复制的文件夹不存在,则创建文件夹
            if (!copyDir.exists()){
                copyDir.mkdir();
            }
            //遍历文件夹下的所有文件，即使该文件夹为空也不影响遍历结果
            File[] files = dir.listFiles();
            for (File file : files) {
                File copyFile = new File(copyDir,file.getName());
                copyDir(file,copyFile);
            }
        }else {
            try (
                    InputStream is = new FileInputStream(dir);
                    OutputStream os = new FileOutputStream(copyDir);
            )
           {
               int len  = 0;
               byte[] buffer = new byte[1024];
               while ((len=is.read(buffer))!=-1){
                   os.write(buffer,0,len);
               }
           }
           catch (Exception e){
               e.printStackTrace();
           }
        }
    }
}
