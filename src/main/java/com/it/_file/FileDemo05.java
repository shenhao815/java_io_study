package com.it._file;

import java.io.File;
import java.io.IOException;

/**
 * @author ch
 * @date 2020-11-3
 */

/*
    File类出你妹删除功能的方法
        - public boolean createNewFile() : 当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
        - public boolean delete() : 删除由此File表示的文件或目录。
        - public boolean mkdir() : 创建由此File表示的目录。
        - public boolean mkdirs() : 创建由此File表示的目录，包括任何必需但不存在的父目录。（即可以创建多级目录。）
 */
public class FileDemo05 {
    public static void main(String[] args) throws IOException {
        // show01();
        // show02();
        show03();
    }

    /*
        public boolean delete() : 删除由此File表示的文件或目录。
        返回值：布尔值
            true：文件/文件夹删除成功，返回true
            false: 文件夹中有内容，不会删除返回false;构造方法中路径不存在返回false
        注意：
            delete方法是直接在硬盘删除文件/文件夹，不走回收站，所以删除要谨慎。
     */
    private static void show03() {
        final File f1 = new File("fileDirector");
        final boolean b1 = f1.delete();
        System.out.println(b1);

        final File f2 = new File("abc.txt");
        final boolean b2 = f2.delete();
        System.out.println(b2);

    }

    /*
        public boolean mkdir() : 创建单级空文件夹
        public boolean mkdirs() : 既可以创建单级文件夹，也可以创建多级文件夹
        创建文件夹的路径和名称在构造方法中给出（构造方法的参数）
        返回值：布尔值
            true: 文件夹不存在，创建文件夹，返回true
            false: 文件夹存在，不会创建，返回false
        注意：
            1.此方法只能创建文件夹，不能创建文件
     */
    private static void show02() {
        final File f1 = new File("aaa");
        final boolean b1 = f1.mkdir();
        System.out.println(b1);

        final File f2 = new File("aaa\\111\\222");
        final boolean b2 = f2.mkdirs();
        System.out.println(b2);// false

        final File f3 = new File("abc.txt");// 注意本意可能是想创建文件，但实际创建的还是文件夹
        final boolean b3 = f3.mkdirs();// 只能创建文件夹
        System.out.println(b3);
    }

    /*
        public boolean createNewFile() : 当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
        创建文件的路径和名称在构造方法中给出（构造方法的参数）
        返回值：布尔值
            true: 文件不存在，创建文件，返回true
            false: 文件存在，不会创建，返回false
        注意：
            1.此方法只能创建文件，不能创建文件夹
            2.创建文件的路径必须存在，否则会抛出异常。
     */
    private static void show01() throws IOException {
        final File f1 = new File("D:\\workspace_backend\\java_io_study\\src\\main\\java\\com\\it\\a.txt");
        final boolean b1 = f1.createNewFile();
        System.out.println(b1); // true

        final File f2 = new File("2.txt");
        final boolean b2 = f2.createNewFile();
        System.out.println(b2);// true

        final File f3 = new File("fileDirector");// 本意是想创建文件夹，但是实际不是创建了文件
        final boolean b3 = f3.createNewFile();// createNewFile只能创建文件
        System.out.println(b3);

        final File f4 = new File("fileDirector222\\3.txt");//该文件夹不存在
        final boolean b4 = f4.createNewFile();
        System.out.println(b4); // Exception in thread "main" java.io.IOException: 系统找不到指定的路径。

    }
}
