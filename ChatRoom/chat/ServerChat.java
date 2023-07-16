package com.geekaca.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 服务端
 */
public class ServerChat {

    /**
     * 定义一个集合存放所有在线的socket
     *
     * 当客户端 登陆上来（带着昵称）之后，server端需要把昵称和对应的socket 存起来
     * key: 客户端socket 对象
     * value: 相对应的 昵称
     * socket1 :zhangsan
     * socket2: Tom
     * socket3:  Jack
     */
    public static Map<Socket, String> onLineSocketMap = new HashMap<>();

    public static void main(String[] args) {

        try {
            //占据端口
            ServerSocket serverSocket = new ServerSocket(ChatConstants.PORT);
            System.out.println("ServerSocket 启动 port: " + ChatConstants.PORT);
            while (true) {
                //阻塞等待   卡在这里   ，如果没人连接，代码不会向后执行
                Socket clientSocket = serverSocket.accept();
                System.out.println("有人连接");
                //分配导游
                ServerRunnable serverRunnable = new ServerRunnable(clientSocket);
                new Thread(serverRunnable).start();
            }
        } catch (IOException e) {
            System.out.println(" 发生异常 "+ e.getMessage());
            e.printStackTrace();
        }
    }
}
