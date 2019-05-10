package cn.renyx.BSTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serv = new ServerSocket(8080);
        while (true){
            Socket socket = serv.accept();
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        InputStream is = socket.getInputStream();
//                        BufferedReader bf = new BufferedReader(new InputStreamReader(is));
//                        String path = bf.readLine().split(" ")[1].substring(1);
//                        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
//                        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
//                        bos.write("HTTP/1.1 200 OK\r\n".getBytes());
//                        bos.write("Content-Type:text/html\r\n".getBytes());
//                        // 必须要写入空行,否则浏览器不解析
//                        bos.write("\r\n".getBytes());
//                        int len = 0;
//                        while ((len = bis.read()) != -1) {
//                            bos.write(len);
//                        }
//                        bos.close();
//                        bis.close();
//                        socket.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
            new Thread(()->{
                try {
                    InputStream is = socket.getInputStream();
                    BufferedReader bf = new BufferedReader(new InputStreamReader(is));
                    String path = bf.readLine().split(" ")[1].substring(1);
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
                    BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
                    bos.write("HTTP/1.1 200 OK\r\n".getBytes());
                    bos.write("Content-Type:text/html\r\n".getBytes());
                    // 必须要写入空行,否则浏览器不解析
                    bos.write("\r\n".getBytes());
                    int len = 0;
                    while ((len = bis.read()) != -1) {
                        bos.write(len);
                    }
                    bos.close();
                    bis.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        }


        //serv.close();
    }


}
