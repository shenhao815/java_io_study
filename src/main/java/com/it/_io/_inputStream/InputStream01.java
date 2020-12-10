package com.it._io._inputStream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author ch
 * @date 2020-11-5
 */

/*
    java.io.InputStream:�ֽ�������
    �˳������Ǳ�ʾ�ֽ�����������ĳ��ࡣ

    �������������๲�Եķ�����
        int read() ���������ж�ȡ���ݵ���һ���ֽ�
        int read(byte[] b)���������ж�ȡһ���������ֽڣ�������洢�ڻ��������� b ��
        void close() �رմ����������ͷ����������������ϵͳ��Դ��

    java.io.FileInputStream extends InputStream
    FileInputStream: �ļ��ֽ�������
    ���ã���Ӳ���ļ��е����ݣ���ȡ���ڴ���ʹ��

    ���췽����
        FileInputStream(String name)
        FileInputStream(File file)
        ��������ȡ�ļ�������Դ
            String name: �ļ���·��
            File file�� �ļ�
        ���췽��������:
            1. �ᴴ��һ��FileInputStream����
            2. ���FileInputStream����ָ�����췽����Ҫ��ȡ���ļ�

    ��ȡ���ݵ�ԭ��Ӳ��-->�ڴ棩
        java����-->JVM-->OS-->OS��ȡ���ݵķ���-->��ȡ�ļ�

    �ֽ���������ʹ�ò��裨�ص㣩��
        1. ����FileInputStream���󣬹��췽���а�Ҫ��ȡ������Դ
        2. ʹ��FileInputStream�����еķ���read����ȡ�ļ�
        3. �ͷ���Դ
 */
public class InputStream01 {
    public static void main(String[] args) throws IOException {
        show01();
    }

    private static void show01() throws IOException {
        // 1. ����FileInputStream���󣬹��췽���а�Ҫ��ȡ������Դ
        final FileInputStream fis = new FileInputStream("2.txt");
        // 2. ʹ��FileInputStream�����еķ���read����ȡ�ļ�
        // int read()��ȡ�ļ��е�һ���ֽڲ����أ������ļ���ĩβ����-1
        /*int len = fis.read();
        System.out.println(len);// 97 a

        len = fis.read();
        System.out.println(len);// 98 b

        len = fis.read();
        System.out.println(len);// 99 c

        len = fis.read();
        System.out.println(len);// -1
        len = fis.read();
        System.out.println(len);// -1*/

        /*
            �������϶�ȡ�ļ���һ���ظ��Ĺ��̣����Կ���ʹ��ѭ���Ż�
            ��֪���ļ����ж����ֽڣ�����ʹ��whileѭ��
            whileѭ��������������ȡ��-1��ʱ�����

            �������ʽ(len = fis.read()) != -1
                1. fis.read(): ��ȡһ���ֽ�
                2. len = fis.read() : �Ѷ�ȡ�����ֽڸ�ֵ������len
                3. (len = fis.read()) != -1: �жϱ���len�Ƿ񲻵���-1
         */
        int len = 0; // ��¼��ȡ�����ֽ�
        while ((len = fis.read()) != -1) {
            System.out.print((char)len);
        }
        // 3. �ͷ���Դ
        fis.close();
    }
}
