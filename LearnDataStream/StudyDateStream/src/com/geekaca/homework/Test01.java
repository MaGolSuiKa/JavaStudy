package com.geekaca.homework;

import java.io.*;

public class Test01 {
    private static String path = "D:\\study\\test\\tt.txt";

    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream(path);
             DataOutputStream dos = new DataOutputStream(fos)) {
            dos.writeUTF("tom");
            dos.writeInt(18);
            dos.writeDouble(178.5);
            dos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        read();
    }

    public static void read() {
        try (FileInputStream fis = new FileInputStream(path);
             DataInputStream dis = new DataInputStream(fis);) {
            String name = dis.readUTF();
            int age = dis.readInt();
            double height = dis.readDouble();
            System.out.println("姓名：" + name + " 年龄：" + age + " 身高： " + height);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
