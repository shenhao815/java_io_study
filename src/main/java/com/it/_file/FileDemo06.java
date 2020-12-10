package com.it._file;

import java.io.File;

/**
 * @author ch
 * @date 2020-11-4
 */

/*
    File类遍历（文件夹）目录功能
        - public String[] list() : 返回一个String数组，表示该File目录中的所有子文件或目录
        - public File[] listFiles() : 返回一个File数组，表示该File目录中所有的子文件或目录
    注意：
        list方法和listFiles方法遍历的是构造方法中给出的目录
        如果构造方法中给出的目录的路径不存在，会抛出空指针异常
        如果构造方法中给出的路径不是一个目录，也会抛出空指针异常
 */
public class FileDemo06 {
    public static void main(String[] args) {
        //show01();
        show02();
    }

    /*
        public File[] listFiles() : 返回一个File数组，表示该File目录中所有的子文件或目录
        遍历构造方法中给出的目录，会获取目录中所有的文件/文件夹，把文件/文件夹封闭为File对象，多个File对象存储到File数组中
     */
    private static void show02() {
        final File file = new File("D:\\workspace_backend\\java_io_study");
        File[] strs = file.listFiles();
        for (File f : strs) {
            System.out.println(f);
        }
    }

    /*
        public String[] list() : 返回一个String数组，表示该File目录中的所有子文件或目录
        遍历构造方法中给出的目录，会获取目录中所有文件/文件夹的名称，把获取到的多个名称存储到一个String类型的数组中。
     */
    private static void show01() {
        final File file = new File("D:\\workspace_backend\\java_io_study");
        String[] strs = file.list();
        for (String filename : strs) {
            System.out.println(filename);
        }
    }
}
