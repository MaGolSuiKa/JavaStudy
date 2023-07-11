package com.geekaca.net;

import java.io.*;
import java.net.*;

public class TestServer {
    public static void main(String[] args) {
        int port = 7894;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            InetAddress lh = InetAddress.getLocalHost();
            System.out.println("聊天室地址：" + lh.getHostAddress());

            System.out.println("服务器启动");
            Socket clientSocket = serverSocket.accept();

            InputStream clientIps = clientSocket.getInputStream();
            OutputStream clientOps = clientSocket.getOutputStream();

            PrintStream psOps = new PrintStream(clientOps);
            psOps.println("欢迎来到"+lh.getHostName()+"的聊天室");


            while (true){
                BufferedReader br = new BufferedReader((new InputStreamReader(clientIps)));
                SocketAddress remoteSocketAddress = clientSocket.getRemoteSocketAddress();
                String msg = null;
                while ((msg = br.readLine()) != null) {
                    System.out.println(remoteSocketAddress + "的信息：" + msg);
                    if(msg.equals("end")){
                        System.out.println("连接结束");
                        return;
                    }
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
