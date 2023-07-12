package com.geekaca.homework;

import java.io.*;
import java.net.Socket;

/**
 * 客户端 用来 接收(读取)服务端消息的线程
 */
public class ClientReaderThread extends Thread{
    private Socket socket;

    public ClientReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //客户端 打开 指向服务端的 输入流和输出流
        System.out.println("clientReader start");
        try {
            InputStream ips = socket.getInputStream();
            // 4、把字节输入流包装成缓冲字符输入流进行消息的接收
            BufferedReader br = new BufferedReader(new InputStreamReader(ips));
            // 5、按照行读取消息
            String msg;
            while ((msg = br.readLine()) != null){
                System.out.println(socket.getRemoteSocketAddress() + "收到了: " + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
