package com.itheima.test_01;

import java.util.ArrayList;
import java.util.Scanner;

public class Test8 {
    private  static  ArrayList<Student> students=new ArrayList<>();
    public static void main(String[] args) {
        addStudent();
        System.out.println(getStudentById("123").toString());
    }

    /**
     * 在集合中添加5个学生
     */
    public static void addStudent(){
        Scanner sc = new  Scanner(System.in);
        for (int i = 1; i <= 5; i++) {
            Student student = new Student();
            System.out.println("请录入第" + i +"个学生对象的信息：");
            while (true) {
                System.out.println("请输入学生ID");
                String id = sc.next();
                Student student1=getStudentById(id);
                if (student1!=null){
                    System.out.println("添加的id重复，请重新添加");
                }else {
                    student.setId(id);
                    break;
                }
            }
            System.out.println("请输入学生姓名：");
            String name = sc.next();
            student.setName(name);
            System.out.println("请输入学生年龄：");
            int age = sc.nextInt();
            student.setAge(age);
            students.add(student);
        }
    }

    private static Student getStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }


}
