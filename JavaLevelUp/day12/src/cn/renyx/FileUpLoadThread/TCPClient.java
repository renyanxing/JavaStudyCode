package cn.renyx.FileUpLoadThread;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
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
}
