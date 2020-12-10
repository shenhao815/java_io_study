package com.it._io._outputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author ch
 * @date 2020-11-4
 */
/*
    java.io.OutputStream:字节输出流
        此抽象类是表示输出字节流的所有类的超类。

    定义了一些子类共性的成员方法：
        - public void close() : 关闭此输出流并释放与此流相关联的所有系统资源。
        - public void flush() : 刷新此输出流并强制所有缓冲的输出字节被写出。
        - public void write(byte[] b) : 将b.length字节从指定的字节数组写入此输出流。
        - public void write(byte[] b,int off ,int len) : 从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流
        - public abstract void write(int b) : 将指定的字节输出流。写数据的时候会将10进制的数据转换为二进制。

    任意的文本编辑器（记事本、notepad++、idea）在打开文件的时候，都会查询编码表，把字节转成字符表示。
    0~127：查询ASCII表  97-->a
    其它值：查询系统默认码表（中文系统GBK）

    java.io.FileOutputStream extends OutputStream
    FileOutputStream: 文件字节输出流
    作用：把内存中的数据写入到硬盘文件中

    构造方法：
        FileOutputStream(String name) 创建一个向具有指定名称的文件中写入数据的输出文件流。
        FileOutputStream(File file) 创建一个向指定File对象表示的文件中写入数据的文件输出流。
        参数：写入数据的目的地
            String name：目的地是一个文件的路径
            File file：目的地是一个文件
        构造方法的作用：
            1. 创建一个FileOutputStream对象
            2. 会根据构造方法中传递的文件/文件路径，创建一个空的文件
            3. 会把FileOutputStream对象指向创建好的文件

    写入数据的原理（内存--->硬盘）
        java程序-->JVM(java虚拟机)-->OS(操作系统)-->OS调用写数据的方法-->把数据写入到文件中

    字节输出流的使用步骤（重点）：
        1. 创建一个FileOutputStream对象，构造方法中传递写入数据的目的地
        2. 调用FileOutputStream对象中的方法write,把数据写入到文件中
        3. 释放资源（流使用会占用一定的内存，使用完毕要把内存清空，提高程序的效率）

    如果想对文件进行追加写，使用构造器FileOutputStream(File file,boolean append) 或 FileOutputStream(String name,boolean append)
    写换行：写换行符号：
        windows:\r\n
        linux:/n
        mac:/r
       fos.write("\r\n".getBytes());
 */
public class OutputStream01 {

    public static void main(String[] args) throws IOException {
        // writeInt();
        write01();
    }

    // 一次写多个字节
    /*
        - public void write(byte[] b) : 将b.length字节从指定的字节数组写入此输出流。
        - public void write(byte[] b,int off ,int len) : 从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流
     */
    private static void write01() throws IOException {
        final FileOutputStream fos = new FileOutputStream("c.txt");

        /*
            - public void write(byte[] b) : 将b.length字节从指定的字节数组写入此输出流。
            一次写多个字节：
                如果写的第一个字节是正数（0~127），那么显示的时候会查询ASCII表
                如果写的第一个字节是负数，那第一个字节会和第二个字节组成一个中文显示，查询系统默认码表（GBK）
         */
        byte[] bytes = {65, 66, 67, 68, 69};// ABCDE
        //byte[] bytes = {-65, -66, -67, 68, 69};// -65和-66组成一个中文，-67和68组成一个中文
        fos.write(bytes);

        /*
            - public void write(byte[] b,int off ,int len) : 从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流
                int off: 数组的开始索引
                int len：写几个字节
         */
        fos.write(bytes,1,2);// BC

        /*
            写入字符方法：可以使用String类中的方法把字符串，转换为字节数组
                byte[] getBytes() 把字符串转换为字节数组
         */
        fos.write("\r\n".getBytes());
        byte[] bytes1 = "你好".getBytes();
        System.out.println(Arrays.toString(bytes));
        fos.write(bytes1);

        fos.close();
    }



    // 一次写一个字节
    private static void writeInt() throws IOException {
        // 1. 创建一个FileOutputStream对象，构造方法中传递写入数据的目的地
        final FileOutputStream fos = new FileOutputStream("b.txt");
        // 2. 调用FileOutputStream对象中的方法write,把数据写入到文件中
        fos.write(97);
        // 3. 释放资源（流使用会占用一定的内存，使用完毕要把内存清空，提高程序的效率）
        fos.close();
    }
}
