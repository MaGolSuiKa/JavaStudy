package com.geekaca.test;

import java.io.File;
import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要搜索的内容：");
        String input = scanner.next();

        File file = new File("D:\\study\\lesson\\JAVA_stage2\\d032\\");
        searchFile(file, input);
    }

    public static void searchFile(File fileToSearch, String toSearchName) {
        if (fileToSearch != null && fileToSearch.isDirectory()) {
            File[] files = fileToSearch.listFiles();

            if (files != null && files.length > 0) {
                for (File file : files) {

                    if (file.isFile()) {

                        if (file.getName().contains(toSearchName)) {
                            System.out.println("已找到文件:" + file.getName());
                            System.out.println("地址：" + file.getPath());
                        }

                    } else if (file.isDirectory()) {
                        searchFile(file, toSearchName);
                    }
                }
            }
        }
    }
}
