package com.armin.socket.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

@SuppressWarnings("all")
public class SocketServer {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6666); // 监听指定端口
        System.out.println("server is running...");
        while (true) {
            // 得到一个客服端的 channel or socket; 其余时刻阻塞
            Socket sock = ss.accept();
            System.out.println("connected from " + sock.getRemoteSocketAddress());
            Thread t = new Handler(sock);
            t.start();
        }
    }

    static class Handler extends Thread {
        Socket sock;

        public Handler(Socket sock) {
            this.sock = sock;
        }

        @Override
        public void run() {
            try (InputStream input = this.sock.getInputStream();
                    OutputStream output = this.sock.getOutputStream()) {
                handle(input, output);
            } catch (Exception e) {
                try {
                    this.sock.close();
                } catch (IOException ignored) {
                }
            }
            System.out.println("client disconnected.");
        }

        private void handle(InputStream input, OutputStream output) throws IOException {
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
            // output 向客户端写入 hello 并🚽
            writer.write("hello\n");
            writer.flush();
            while (true) {
                // input 读取字符 会阻塞
                String s = reader.readLine();
                System.out.println("message = " + s);
                if (s.equals("bye")) {
                    writer.write("bye\n");
                    writer.flush();
                    break;
                }
                // output 向客服端 返回数据
                writer.write("ok: " + s + "\n");
                writer.flush();
            }
        }
    }
}
