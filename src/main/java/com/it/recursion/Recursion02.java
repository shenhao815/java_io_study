package com.it.recursion;

import java.io.File;

/**
 * @author ch
 * @date 2020-11-4
 *
 * 递归打印多级目录
 */
public class Recursion02 {
    public static void main(String[] args) {
        getAllFiles(new File("D:\\workspace_backend\\java_io_study"));
    }

    /*

     */
    public static void getAllFiles(File dir){
        System.out.println(dir); // 打印被遍历的目录名称
        final File[] files = dir.listFiles();
        for (File f : files) {
            // 对遍历得到的File对象f进行判断，判断是否是文件夹
            if (f.isDirectory()) {
                // f是一个文件夹，则继续遍历这个文件夹
                // 我们发现getAllFile方法就是传递文件夹，遍历方件夹的方法
                // 所以直接调用getAllFile方法即可：递归（自己调用自己）
                getAllFiles(f);
            } else {
                System.out.println(f);
            }

        }
    }
}
