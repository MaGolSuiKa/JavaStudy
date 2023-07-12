package com.geekaca.homework;

import java.io.*;
import java.net.Socket;

/**
 * 用来 对接 连接上来的每个客户端socket
 * ServerSocket 类似公司门口保安大爷  ，只负责门口接待客人（accept()），
 * 不负责带领客人(客户端socket)参观公司
 * <p>
 * ServerThread导游
 */
public class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //以线程方式运行，各个客人互不干扰
        String clientInfo = "";
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            //对方信息  ip  port
            clientInfo = socket.getRemoteSocketAddress().toString() ;
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
            bw.write("欢迎连接");
            bw.newLine();
            bw.flush();

            //不断读取对方的数据
            String str = null;
            while ((str = br.readLine()) != null) {
                System.out.println(clientInfo + " :" + str);
            }
        } catch (IOException e) {
            System.out.println(clientInfo +" 断开连接: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
