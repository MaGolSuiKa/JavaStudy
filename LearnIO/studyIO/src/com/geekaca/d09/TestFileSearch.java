package com.geekaca.d09;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TestFileSearch {
    public static void main(String[] args) {
        /**
         * 作业：
         * 递归方式文件搜索
         * 根据文件名在目录下递归的搜索
         * 遇到文件就判断名字
         * 遇到文件夹，就递归搜索
         *
         * 作业：0703
         *
         * 1, 在之前文件搜索的基础上
         *
         * 搜索某个目录下的所有.java(.mp3  .mp4 .pdf)文件，
         * 文件名，完整路径写出到一个单独的txt中保存
         * FileOutputStream.write("\r\n".getBytes())  写出一个换行符
         *
         * 。。。。。。。。。。.png文件，  复制到一个单独的文件夹
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要搜索的文件名或扩展名：");
        String input = scanner.next();
        searchFile(new File("D:\\study\\lesson\\JAVA_stage2"), input);
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
                            writeFile(file);
                        }
                        String[] fileLastName = file.getName().split("\\.");
                        if (fileLastName[1].equals(toSearchName)) {
                            System.out.println("找到扩展名为:" + fileLastName[1]);
                            System.out.println("地址：" + file.getPath());
                            writeFile(file);
                            if(fileLastName[1].equals("png")){
                                copyFile(file);
                            }
                        }
                        if (fileLastName[0].equals(toSearchName)) {
                            System.out.println("找到文件名为:" + fileLastName[0]);
                            System.out.println("地址：" + file.getPath());
                            writeFile(file);
                        }
                    } else if (file.isDirectory()) {
                        //如果是当前file也指向一个目录
                        searchFile(file, toSearchName);
                    }
                }
            }
        }
    }

    public static void writeFile(File file) {

        try (OutputStream fileOutputStream = new FileOutputStream("D:\\study\\git\\LearnIO\\FileList.txt",true)) {
            fileOutputStream.write(("文件名：" + file.getName()).getBytes(StandardCharsets.UTF_8));
            fileOutputStream.write(("地址：" + file.getPath()).getBytes(StandardCharsets.UTF_8));
            fileOutputStream.write("\r\n".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(File file){
        File files = new File(file.getPath());

        try (InputStream fileInputStream = new FileInputStream(file);
        OutputStream fileOutputStream = new FileOutputStream("D:\\study\\git\\LearnIO\\copyPNG\\"+file.getName())){
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("复制完成");
    }
}
