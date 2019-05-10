package cn.renyx.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPRecieve {
    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[1024];
        DatagramSocket ds = new DatagramSocket(8888);
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        ds.receive(dp);
        //System.out.println(new String(bytes));
        //拆包
        int len = dp.getLength();
        InetAddress address = dp.getAddress();
        int port = dp.getPort();
        String message = new String(bytes, 0, len);
        System.out.println(message + "-->" + address.getHostAddress() + ":" + port);


        ds.close();
    }
}
