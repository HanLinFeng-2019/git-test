package it.com;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 完成的客户的基本需求
 */
public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader br;
        BufferedWriter bw;
        try {
            socket = new Socket(InetAddress.getByName("192.168.43.211"), 9999);
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入您的选择：A(注册)、B(登录)、C(注销)、D(修改密码)、E(修改昵称)");
            String option = scanner.next();
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            if (option.equalsIgnoreCase("a")) {
                //注册
                registe(bw, scanner, option);
                respon(br);

            } else if (option.equalsIgnoreCase("b")) {
                //登录
                login(bw, scanner, option);
                respon(br);


            } else if (option.equalsIgnoreCase("c")) {
                //注销（登录之后才可以进行注销）
                login(bw, scanner, option);
                respon(br);
            } else if (option.equalsIgnoreCase("d")) {
                //修改密码
                uodatePassword(bw, scanner, option);
                respon(br);
            } else if (option.equalsIgnoreCase("e")) {
                //修改昵称
                updateName(bw, scanner, option);
                respon(br);
            } else {
                System.out.println("用户选择输入错误！");
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端连接失败....");
        } finally {
            if (null != socket) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void respon(BufferedReader br) throws IOException {
        String info = br.readLine();
        System.out.println(info);
    }


    private static void updateName(BufferedWriter bw, Scanner scanner, String option) throws IOException {
        System.out.println("请输入用户名：");
        String username = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();
        System.out.println("请输入昵称：");
        String name = scanner.next();
        String keyOption = option + "-" + username + "-" + password + "-" + name;
        bw.write(keyOption + "\r\n");
        bw.flush();
    }

    private static void uodatePassword(BufferedWriter bw, Scanner scanner, String option) throws IOException {
        System.out.println("请输入用户名：");
        String username = scanner.next();
        System.out.println("请输入旧密码：");
        String password = scanner.next();
        System.out.println("请输入新密码：");
        String newPassword = scanner.next();
        String keyOption = option + "-" + username + "-" + password + "-" + newPassword;
        bw.write(keyOption + "\r\n");
        bw.flush();
    }

    private static void login(BufferedWriter bw, Scanner scanner, String option) throws IOException {
        System.out.println("请输入用户名：");
        String username = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();
        String keyOption = option + "-" + username + "-" + password;
        bw.write(keyOption + "\r\n");
        bw.flush();
    }

    private static void registe(BufferedWriter bw, Scanner scanner, String option) throws IOException {
        System.out.println("请输入用户名：");
        String username = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();
        System.out.println("请输入昵称：");
        String name = scanner.next();
        System.out.println("请输入性别：");
        String gender = scanner.next();
        String keyOption = option + "-" + username + "-" + password + "-" + name + "-" + gender;
        bw.write(keyOption + "\r\n");
        bw.flush();
    }

}


