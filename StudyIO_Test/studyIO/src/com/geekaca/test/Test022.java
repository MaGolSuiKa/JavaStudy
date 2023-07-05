package com.geekaca.test;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入搜索内容：");
        String input = scanner.next();
        try (
                Reader freader = new FileReader(
                        new File("D:\\study\\lesson\\JAVA_stage2\\d032\\StudyIO_Test\\studyIO\\JavaWordList.txt")
                );
                BufferedReader br = new BufferedReader(freader);
        ) {
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.contains(input)) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
