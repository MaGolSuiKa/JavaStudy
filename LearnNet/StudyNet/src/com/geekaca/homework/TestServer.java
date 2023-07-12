package com.geekaca.homework;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestServer {
    private static ExecutorService pool = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
    //集合用来保存 当前在房间中的 客户端对象
    public static List<Socket> clients = new ArrayList<>();
    public static void main(String[] args) {
        int port = 7894;
        //ServerSocket门口保安大爷，等待连接
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            //获取服务器自己的地址信息
            InetAddress lh = InetAddress.getLocalHost();
            System.out.println("聊天室地址：" + lh.getHostAddress());

            System.out.println("服务器启动");
            while (true) {
                //阻塞等待   有客户端连接上来了， 创建对象指向客户端socket
                Socket clientSocket = serverSocket.accept();
                System.out.println("有人连接上了:" + clientSocket.getRemoteSocketAddress());
                //每一个ServerThread对象都类似一个导游    一个导游对应一个客人clientSocket
                //来一个客人，雇佣一个导游，比较浪费
//                ServerThread serverThread = new ServerThread(clientSocket);
//                serverThread.start();
                clients.add(clientSocket);
                pool.execute(new ServerThread(clientSocket));
            }
//            //打开客户端的输入流，为了读取客户端发送来的数据
//            InputStream clientIps = clientSocket.getInputStream();
//            //打开客户端的输出流，为了向客户端发送数据
//            OutputStream clientOps = clientSocket.getOutputStream();
//            //打印流
//            PrintStream psOps = new PrintStream(clientOps);
//            psOps.println("欢迎来到"+lh.getHostName()+"的聊天室");
//
//
//            while (true){
//                //把客户端的输入流 包装一层缓冲流，为了更加高效的读取， 可以按照行的方式读取
//                BufferedReader br = new BufferedReader((new InputStreamReader(clientIps)));
//                SocketAddress remoteSocketAddress = clientSocket.getRemoteSocketAddress();
//                String msg = null;//接收客户端发来的每一行数据
//                while ((msg = br.readLine()) != null) {
//                    System.out.println(remoteSocketAddress + "的信息：" + msg);
//                    //如果客户端发来一个end，结束通信
//                    if(msg.equals("end")){
//                        System.out.println("连接结束");
//                        return;
//                    }
//                }
//            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
