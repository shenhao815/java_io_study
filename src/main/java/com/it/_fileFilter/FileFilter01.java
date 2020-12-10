package com.it._fileFilter;

import java.io.File;

/**
 * @author ch
 * @date 2020-11-4
 * <p>
 * 文件过滤
 */

/*
    需求：
        遍历指定文件夹，且只要.java结尾的文件
    我们可以使用过滤器来实现
    在File类中有两个和ListFiles重载的方法，方法的参数传递的就是过滤器
    File[] listFiles(FileFilter filter)
        java.io.FileFilter 接口：用于抽象路径名（File对象）的过滤器。
            作用：用来过滤文件（File对象）
            抽象方法：用来过滤文件的方法
                boolean accept(File pathname) 测试指定抽象路径名是否应该包含在某个路径名列表中。
                    参数：
                        File pathname：使用listFiles方法遍历目录，得到的每一个文件对象
    File[] listFiles(FilenameFilter filter)
        java.io.FilenameFilter 接口：实现此接口的实例可用于过滤文件名。
            作用：用于过滤文件名称
            抽象方法：用于过滤文件的方法
                boolean accept(File dir,String name) 测试指定文件是否应该包含在某一文件列表中。
                参数：
                    File dir：构造方法中传递的被遍历的目录
                    String name：使用listFiles方法遍历目录，获取的每一个文件/文件夹的名称
    注意：
        两个过滤器接口是没有实现类的，需要我们自己写实现类，重写过滤的方法accept，在方法中自己定义过滤规则
 */
public class FileFilter01 {

    public static void main(String[] args) {
        getAllFiles(new File("D:\\workspace_backend\\java_io_study"));
    }

    public static void getAllFiles(File dir) {
        final File[] files = dir.listFiles(new FileFilterImpl());
        for (File f : files) {
            if (f.isDirectory()) {
                getAllFiles(f);
            } else {
                System.out.println(f);
            }
        }
    }
}
