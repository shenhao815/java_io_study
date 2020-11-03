package com.it._file;

import java.io.File;

/**
 * @author ch
 * @date 2020-11-3
 */

/*
    File判断功能的方法
        - public boolean exists() : 此File表示的文件或目录是否实际存在
        - public boolean isDirectory() : 此File表示的的是否为目录。
        - public boolean isFile() : 此File表示的是否为文件。
 */
public class FileDemo04 {
    public static void main(String[] args) {
        // show01();
        show02();
    }

    /*
        public boolean isDirectory() : 此File表示的的是否为目录。
            用于判断构造方法中给定的路径是否以文件夹结尾
                是：true
                否：false
        public boolean isFile() : 此File表示的是否为文件。
            用于判断构造方法中给定的路径是否以文件结尾
                是：true
                否：false
        注意：
            电脑的硬盘中只有文件／文件夹，所以两个方法是互斥的
            这两个方法使用的前提是：路径必须是存在的，否则都返回false
     */
    private static void show02() {
        final File f1 = new File("D:\\workspace_backend\\java_io_study222");
        // 不存在，就没有必要获取
        if (f1.exists()) {
            System.out.println(f1.isDirectory());
            System.out.println(f1.isFile());
        }

        final File f2 = new File("D:\\workspace_backend\\java_io_study");
        if (f2.exists()) {
            System.out.println(f2.isDirectory()); // true
            System.out.println(f2.isFile());// false
        }

        final File f3 = new File("D:\\workspace_backend\\java_io_study\\pom.xml");
        if (f3.exists()) {
            System.out.println(f3.isDirectory()); // false
            System.out.println(f3.isFile());// true
        }
    }

    /*
        public boolean exists() : 此File表示的文件或目录是否实际存在
        用于判断构造方法中的路径是否存在
            存在：true
            不存在：false
     */
    private static void show01() {
        final File f1 = new File("D:\\workspace_backend\\java_io_study");
        System.out.println(f1.exists()); // true

        final File f2 = new File("D:\\workspace_backend\\java_io_study222");
        System.out.println(f2.exists()); // false

        final File f3 = new File("pom.xml");
        System.out.println(f3.exists()); // true

        final File f4 = new File("pom22.xml");
        System.out.println(f4.exists()); // false

    }
}
