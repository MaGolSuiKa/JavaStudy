package com.geekaca.homework;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestTake {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7894);) {
            Socket socket = serverSocket.accept();
            System.out.println("启动");
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            String name = dis.readUTF();
            int age = dis.readInt();
            double length = dis.readDouble();

            System.out.println("学生姓名：" + name + "年龄" + age + "身高" + length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
