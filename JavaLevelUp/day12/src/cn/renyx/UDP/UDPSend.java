package cn.renyx.UDP;

import java.io.IOException;
import java.net.*;

public class UDPSend {
    public static void main(String[] args) throws IOException {
        byte[] bytes = "你好".getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, 8888);
        DatagramSocket ds = new DatagramSocket();
        ds.send(dp);
        ds.close();
    }
}
