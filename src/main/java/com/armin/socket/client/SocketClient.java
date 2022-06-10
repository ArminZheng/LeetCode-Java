package com.armin.socket.client;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SocketClient {

    public static void main(String[] args) throws IOException {
        Socket sock = new Socket("localhost", 6666); // 连接指定服务器和端口
        try (InputStream input = sock.getInputStream();
                OutputStream output = sock.getOutputStream()) {
            handle(input, output);
        }
        sock.close();
        System.out.println("disconnected.");
    }

    private static void handle(InputStream input, OutputStream output) throws IOException {
        BufferedWriter writer =
                new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(System.in);
        System.out.println("[server] " + reader.readLine());
        for (; ; ) {
            System.out.print(">>> "); // 打印提示
            String s = scanner.nextLine(); // 读取一行输入
            writer.write(s);
            writer.newLine();
            writer.flush();
            String resp = reader.readLine();
            System.out.println("<<< " + resp);
            if (resp.equals("bye")) {
                break;
            }
        }
    }

    private static void socketConnect(InputStream input, OutputStream output) throws IOException {
        final DataInputStream dataInputStream = new DataInputStream(input);
        final DataOutputStream dataOutputStream = new DataOutputStream(output);

        String s =
                "{\"FuncName\":\"ApplyCenterPUBKey\",\"Random\":\"43577740\",\"SignCode\":\"d909qfKpy7ripmaCFQhMmt5MqH0=\",\"RetCode\":\"-1\",\"ErrMsg\":\"\",\"Data\":{\"LockID\":\"22130004\",\"LockType\":\"1\"}}";
        String len = String.format("%010d", s.length());

        dataOutputStream.write((len + s).getBytes());
        // writer.newLine();
        dataOutputStream.flush();

        byte[] lenght = new byte[10];
        dataInputStream.read(lenght);
        int leng = Integer.parseInt(new String(lenght));

        byte[] returnMsg = new byte[leng];
        dataInputStream.read(returnMsg);
        String returnMsgXml = new String(returnMsg);
        System.out.println("returnMsgXml = " + returnMsgXml);
    }
}
