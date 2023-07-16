package com.geekaca.chat;

import java.io.*;
import java.net.Socket;

/**
 * 线程相关类，没有界面展示的功能
 */
public class ClientReader implements Runnable {
    private Socket socket;
    //成员变量指向聊天窗口类
    private ClientChat clientChat;

    public ClientReader(Socket socket, ClientChat clientChat) {
        this.socket = socket;
        this.clientChat = clientChat;
    }

    @Override
    public void run() {
        try {
            /**
             * 客户端线程 打开服务端的IO流后，一直保持打开着
             * 方便后续 进行读和写
             * 输入流，用来从对方（ServerSocket）读取信息
             */
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            while (true) {
                /** 读取当前的消息类型 ：登录,群发,私聊 , @消息
                 *
                 * 不断的检查，是否收到了来自server的竹子信息
                 * 收到了竹子，立即查看顶部的标记
                 *
                 **/
                int msgType = dis.readInt();

                switch (msgType) {
                    case ChatConstants.MSG_TYPE_LOGIN:
                        //来自服务端的广播  有人登陆
                        String allNickName = dis.readUTF();
                        //包含所有昵称的数组
                        String[] allNickNames = allNickName.split(ChatConstants.SPILIT);
                        /**
                         * UI：展示到在线人数的界面
                         * 刷新界面的在线用户展示
                         * 设置，刷新列表展示的内容
                         */
                        clientChat.onLineUsersJList.setListData(allNickNames);
                        break;
                    case ChatConstants.MSG_TYPE_CHAT:
                        String msgContent = dis.readUTF();
                        System.out.println("有人发言：" + msgContent);
                        //界面：把消息追加到界面的聊天记录上
                        clientChat.smsContent.append(msgContent);
                        //滾動到底端 ，始终显示最新的消息.
                        clientChat.smsContent.setCaretPosition(clientChat.smsContent.getText().length());
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("发生异常" + e.getMessage());
            e.printStackTrace();
        }
    }
}
