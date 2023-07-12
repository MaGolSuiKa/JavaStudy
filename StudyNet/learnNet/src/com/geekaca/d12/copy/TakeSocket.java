package com.geekaca.d12.copy;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class TakeSocket {
    private static final String TARGET_FILE = "D:\\study\\test\\";

    public static void main(String[] args) {
        int port = 7777;

        try (ServerSocket serverSocket = new ServerSocket(port);
             OutputStream os = new FileOutputStream(TARGET_FILE + "copy.png");) {

            InetAddress localHostAddr = InetAddress.getLocalHost();
            System.out.println("接收端启动: IP:" +localHostAddr.getHostAddress()+" Port:"+ port);
            Socket clientSocket = serverSocket.accept();
            String cname = clientSocket.getInetAddress().getHostAddress() + " " + clientSocket.getPort();
            System.out.println("有人连接上了 " + cname);

            InputStream clientIps = clientSocket.getInputStream();

            byte[] buffer = new byte[1024];
            int len;
            while ((len = clientIps.read(buffer)) != -1) {
                os.write(buffer, 0, len);
                os.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件错误");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("离线");
        }
        System.out.println("复制完成");

    }
}

