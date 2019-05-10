package cn.renyx.FileUpLoad;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\79109\\Desktop");
        if (!file.exists()) {
            file.mkdirs();
        }
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(file.toString() + "\\1.jpg");
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len=is.read(bytes))!=-1)
        {
            fos.write(bytes,0,len);
        }
        socket.getOutputStream().write("上传成功".getBytes());
        fos.close();
        socket.close();
        serverSocket.close();
    }
}
