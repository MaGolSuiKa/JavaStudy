package com.geekaca.d12.copy;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SendSocket {
    private static final String SOURCE_FILE = "D:\\study\\japanese\\";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入IP");
        String targetIP = scanner.next();
        System.out.println("输入port");
        int targetPort = scanner.nextInt();
        System.out.println("输入文件名");
        String fileName = scanner.next();
        try (InputStream fis = new FileInputStream(SOURCE_FILE+fileName);
             InputStream bufferedis = new BufferedInputStream(fis);){

            Socket socket = new Socket(targetIP, targetPort);
            OutputStream ops = socket.getOutputStream();

            byte[] buffer = new byte[1024];
            int len;
            while ((len = bufferedis.read(buffer)) != -1) {
                ops.write(buffer, 0, len);
                ops.flush();
            }
            ops.close();
            System.out.println("复制完成");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

