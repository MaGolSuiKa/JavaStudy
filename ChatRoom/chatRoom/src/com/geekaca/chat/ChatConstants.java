package com.geekaca.chat;

public class ChatConstants {
    /** 常量  大写
     *  final  不可修改
     *  static  静态为了方便使用
     * */
    public static final int PORT = 7779 ;

    /**
     * 用户登录
     * 客户端发给server ，实现登陆
     * server广播给每个客户端，通知有人登陆
     */
    // 登陆消息
    public static final int MSG_TYPE_LOGIN = 1;
    /**
     * 大厅的聊天
     */
    public static final int MSG_TYPE_CHAT = 2;
    /**
     * 密语
     */
    public static final int MSG_TYPE_MI = 3;
    /**
     * 协议分隔符
     * */
    public static final String SPILIT = "00#%#@￥#@￥";
}
