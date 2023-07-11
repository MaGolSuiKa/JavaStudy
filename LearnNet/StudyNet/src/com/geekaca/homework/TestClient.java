package com.geekaca.homework;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TestClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Socket socket = new Socket("192.168.1.5", 7894);
            OutputStream ops = socket.getOutputStream();
            InputStream ips = socket.getInputStream();
            PrintStream ps = new PrintStream(ops);

            BufferedReader br = new BufferedReader(new InputStreamReader(ips));
            String mess = null;
            while ((mess = br.readLine()) != null) {
                System.out.println("服务器信息：" + mess);
                break;
            }
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
