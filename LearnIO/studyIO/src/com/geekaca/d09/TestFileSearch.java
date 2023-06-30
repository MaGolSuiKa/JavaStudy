package com.geekaca.d09;

import java.io.File;

public class TestFileSearch {
    public static void main(String[] args) {
        /**
         * 作业：
         * 递归方式文件搜索
         * 根据文件名在目录下递归的搜索
         * 遇到文件就判断名字
         * 遇到文件夹，就递归搜索
         */
        searchFile(new File("D:\\study\\lesson\\JAVA_stage2\\d029"), "TestDir2");
    }

    /**
     * @param dir          在哪个目录中搜索
     * @param toSearchName 要搜索的文件名字
     */
    public static void searchFile(File dir, String toSearchName) {
        if (dir != null && dir.isDirectory()) {
            File[] files = dir.listFiles();

            if (files != null && files.length > 0) {
                //文件夹下有文件
                for (File file : files) {

                    if (file.isFile()) {
                        //todo: 遇到文件就判断名字
                        if (toSearchName.equals(dir.getName())) {
                            System.out.println("已找到文件:" + dir.getName());
                            System.out.println("地址：" + file.getPath());
                            //return;
                        }
                        String[] fileLastName = file.getName().split("\\.");
                        if (fileLastName[1].equals(toSearchName)) {
                            System.out.println("找到扩展名为:" + fileLastName[1]);
                            System.out.println("地址：" + file.getPath());
                            //return;
                        }
                        if (fileLastName[0].equals(toSearchName)) {
                            System.out.println("找到文件名为:" + fileLastName[0]);
                            System.out.println("地址：" + file.getPath());
                            //return;
                        }
                    } else if (file.isDirectory()) {
                        //如果是当前file也指向一个目录
                        searchFile(file, toSearchName);
                    }
                }
            }
        }
    }

}
