package cn.renyx.FileUpLoad;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\79109\\Desktop\\login.jpg");
        Socket socket = new Socket("127.0.0.1", 9999);
        OutputStream os = socket.getOutputStream();
        byte[] byt = new byte[1024];
        int len = 0;
        while ((len = fis.read(byt)) != -1) {
            os.write(byt, 0, len);

        }
        socket.shutdownOutput();
        InputStream is = socket.getInputStream();
        while ((len = is.read(byt)) != -1) {
            System.out.println(new String(byt,0,len));

        }
        fis.close();
        socket.close();
    }
}
