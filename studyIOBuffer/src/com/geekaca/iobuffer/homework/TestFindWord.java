package com.geekaca.iobuffer.homework;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestFindWord {
    public static void main(String[] args) {
        Map<String, Integer> wordMap = new HashMap<>();
        int wordCount = 0;
        try (
                FileInputStream is = new FileInputStream(new File("src\\JavaWordList.txt"));
        ) {
            BufferedInputStream bis = new BufferedInputStream(is);
            int len = -1;
            byte[] buffer = new byte[512];
            Pattern pattern = Pattern.compile("[a-zA-Z]+");

            while ((len = bis.read(buffer)) != -1) {
                Matcher matcher = pattern.matcher(new String(buffer, 0, len));
                while (matcher.find()) {
                    Integer wordsNo = wordMap.get(matcher.group());
                    if (wordsNo == null) {
                        wordMap.put(matcher.group(), 1);
                    } else {
                        wordMap.put(matcher.group(), wordsNo + 1);
                    }
                    wordCount++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件内有单词" + wordCount + "个");
        wordMap.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
    }

}
