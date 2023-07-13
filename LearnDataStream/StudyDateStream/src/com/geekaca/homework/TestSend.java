package com.geekaca.homework;

import java.io.*;
import java.net.Socket;

public class TestSend {
    private static String path = "D:\\study\\test\\tt.txt";
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream(path);
            DataInputStream dis = new DataInputStream(fis);
            Socket socket = new Socket("192.168.1.100", 7894);
            OutputStream ops = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(ops);) {

            dos.writeUTF(dis.readUTF());
            dos.writeInt(dis.readInt());
            dos.writeDouble(dis.readDouble());
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
