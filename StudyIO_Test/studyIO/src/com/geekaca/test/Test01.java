package com.geekaca.test;

import java.io.*;

public class Test01 {
    private static final String SOURCE_FILE = "D:\\study\\lesson\\JAVA_stage2\\d032\\文件IO流梳理.pdf";
    private static final String TARGET_FILE = "D:\\study\\test\\";

    public static void main(String[] args) {

        try (InputStream is = new FileInputStream(SOURCE_FILE);
             InputStream bufferedis = new BufferedInputStream(is);
             OutputStream os = new FileOutputStream(TARGET_FILE + "copy.pdf");
             OutputStream bufferedos = new BufferedOutputStream(os);
        ) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bufferedis.read(buffer)) != -1) {
                bufferedos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("复制完成");
    }
}
