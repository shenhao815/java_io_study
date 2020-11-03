package com.it._file;

import java.io.File;

/**
 * @author ch
 * @date 2020-11-3
 */
/*
    File类获取功能的方法
        - public String getAbsolutePath() : 返回些File的绝对路径名字符串
        - public String getPath() : 将此File转换为路径名字符串
        - public String getName() : 返回由此File表示的文件或目录的名称。
        - public long length() ： 返回由此File表示的文件的长度。
 */
public class FileDemo03 {

    public static void main(String[] args) {
        // show01();
        // show02();
        // show03();
        show04();
    }

    /*
        public long length() : 返回由此File表示的文件的长度。
        获取的是构造方法指定的文件的大小，以字节为单位。
        注意：
            文件夹是没有大小概念的，不能获取文件夹的大小。
            如果构造方法中给出的路径不存在，那么length的方法返回0。
     */
    private static void show04() {
        final File f1 = new File("D:\\workspace_backend\\java_io_study\\src\\main\\java\\com\\it\\_file\\FileDemo02.java");
        long l1 = f1.length();
        System.out.println(l1);

        final File f2 = new File("d:\\abc.txt");
        long l2 = f2.length();
        System.out.println(l2); // 0  不存在的文件

    }


    /*
        public String getName() : 返回由此File表示的文件或目录的名称。
        获取的就是构造方法传递路径的结尾部分（文件/文件夹）
     */
    private static void show03() {
        final File f1 = new File("D:\\workspace_backend\\java_io_study\\b.txt");
        final String name1 = f1.getName();
        System.out.println(name1);// b.txt

        final File f2 = new File("D:\\workspace_backend\\java_io_study");
        final String name2 = f2.getName();
        System.out.println(name2);// java_io_study
    }

    /*
        public String getPath() : 将此File转换为路径名字符串。
        获取的构造方法中传递的路径。

        toString()方法调用的就是getPath方法
     */
    private static void show02() {
        final File f1 = new File("D:\\workspace_backend\\java_io_study\\src\\main\\java\\com\\it\\_file\\FileDemo03.java");
        final File f2 = new File("b.txt");
        final String path1 = f1.getPath();
        System.out.println(path1);// D:\workspace_backend\java_io_study\src\main\java\com\it\_file\FileDemo03.java
        final String path2 = f2.getPath();
        System.out.println(path2);// b.txt

        System.out.println(f2);// b.txt
        System.out.println(f2.toString());// b.txt
    }

    /*
        public String getAbsolutePath() : 返回File的绝对路径名字符串。
        获取的构造方法中传递的路径
        无论路径是绝对的还是相对的，getAbsolutePath方法返回的都是绝对路径。
     */
    private static void show01() {
        final File f1 = new File("D:\\workspace_backend\\java_io_study\\src\\main\\java\\com\\it\\_file\\FileDemo03.java");
        final String absolutePath1 = f1.getAbsolutePath();
        System.out.println(absolutePath1); // D:\workspace_backend\java_io_study\src\main\java\com\it\_file\FileDemo03.java

        final File f2 = new File("b.txt");
        final String absolutePath2 = f2.getAbsolutePath();
        System.out.println(absolutePath2);// D:\workspace_backend\java_io_study\b.txt
    }

}
