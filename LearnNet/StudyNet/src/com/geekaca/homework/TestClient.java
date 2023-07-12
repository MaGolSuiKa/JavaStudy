package com.geekaca.homework;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * guo
 */
public class TestClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            //创建客户端socket   指定 要连接的服务端 ip地址   服务端的端口
            //Connection refused: connect 没有启动server情况下，去连接，会拒绝
            Socket socket = new Socket("localhost", 7894);
            System.out.println("客户端连接成功 客户端自己的端口：" + socket.getLocalPort());
            OutputStream ops = socket.getOutputStream();
            InputStream ips = socket.getInputStream();
            PrintStream ps = new PrintStream(ops);
            //客户端连接server端，连接成功后，读取来自server的所有信息，来自服务端的问好
            BufferedReader br = new BufferedReader(new InputStreamReader(ips));
            String mess = null;
            while ((mess = br.readLine()) != null) {
                System.out.println("服务器信息：" + mess);
                break;
            }
            //客户端缺少一个 接收server的信息的逻辑 ，要依赖多线程
            new ClientReaderThread(socket).start();
            //客户端接收用户的键盘录入
            while (true){
                System.out.println("请输入信息：");
                String input = scanner.next();
                ps.println(input);
                ps.flush();
                if(input.equals("end")){
                    socket.close();
                    return;
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
