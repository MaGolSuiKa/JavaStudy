package com.geekaca.chat;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class ServerRunnable implements Runnable {
    /**
     * 指向当前连接的对方socket(客户端socket)
     * 引用类型
     */
    private Socket clientSocket;

    public ServerRunnable(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (InputStream ips = clientSocket.getInputStream();
             //OutputStream ops = clientSocket.getOutputStream();
             DataInputStream dis = new DataInputStream(ips);
        ) {
            while (true) {
                //不断读取对方的消息
                //判断消息类型
                int msgType = dis.readInt();

                switch (msgType) {
                    case ChatConstants.MSG_TYPE_LOGIN:
                        //登陆消息
                        String nickName = dis.readUTF();
                        System.out.println("login : " + clientSocket.getRemoteSocketAddress() + " nick:" + nickName);
                        ServerChat.onLineSocketMap.put(clientSocket, nickName);
                        //广播一遍，当前房间，大厅 所有人名字
                        /**
                         * 1, 拿到所有人的昵称
                         * 2，发出去  消息类型  1
                         */
                        StringBuilder stringBuilder = new StringBuilder();
                        //取出 map中的所有values
                        Collection<String> userNicknames = ServerChat.onLineSocketMap.values();
                        for (String name : userNicknames) {
                            stringBuilder.append(name + ChatConstants.SPILIT);
                        }
                        //去掉最后一个分隔符
                        stringBuilder.substring(0, stringBuilder.lastIndexOf(ChatConstants.SPILIT));
                        sendMsgToAll(stringBuilder.toString());
                        break;
                    case ChatConstants.MSG_TYPE_CHAT:
                        //对应截图第二步骤：接收聊天消息
                        String msgContent = dis.readUTF();
                        //获取是谁发的消息   昵称
                        String userNickName = ServerChat.onLineSocketMap.get(clientSocket);
                        //把收到的消息广播发给每个客户端socket
                        StringBuilder toSendMsg = new StringBuilder();
                        LocalDateTime now = LocalDateTime.now();
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        toSendMsg.append(now.format(dtf)).append("  ").append(userNickName).append(":")
                                .append("\r\n")
                                .append(msgContent)
                                .append("\r\n")
                        ;
                        System.out.println("sendChatToAll:" + toSendMsg);
                        sendChatToAll(toSendMsg.toString());
                        break;
                }

            }
        } catch (IOException e) {
            System.out.println("发生异常" + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 把收到的消息广播发给每个客户端socket
     *
     * @param msg
     */
    private void sendChatToAll(String msg) {
        //key  socket    value: 昵称.
        ServerChat.onLineSocketMap.forEach((socket, nick) -> {
            try {
                //带有数据类型
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                //有人登陆，广播所有人的名字
                //首先刻一个2  代表  有人说话
                dos.writeInt(ChatConstants.MSG_TYPE_CHAT);
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 广播
     * 把房间内所有人昵称 发送给所有人
     * 循环访问每一个socket，发出信息
     *
     * @param msg 一长串的用户昵称连接在一起
     * @throws Exception
     */
    private void sendMsgToAll(String msg) {
        //key  socket    value: 昵称
        ServerChat.onLineSocketMap.forEach((socket, nick) -> {
            try {
                //带有数据类型  发送消息
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                //有人登陆，广播所有人的名字
                dos.writeInt(ChatConstants.MSG_TYPE_LOGIN);
                //房间内所有昵称
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
