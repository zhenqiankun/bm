package pl;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Re  implements Runnable{
    public DatagramSocket datagramSocket;
    public  Re(DatagramSocket datagramSocket){
        this.datagramSocket=datagramSocket;
    }

    @Override
    public void run() {
        InetAddress ip= null;
        try {
            ip = InetAddress.getByName("192.168.9.41");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String pl="123";
        int port=1123;
        DatagramPacket datagramPacket=new DatagramPacket(pl.getBytes(),pl.getBytes().length,ip,port);
        try {
            datagramSocket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        datagramSocket.close();
//        InetAddress ip=InetAddress.getByName("192.168.11.22");
//        String str="123";
//        int port=1122;
//        DatagramPacket dp=new DatagramPacket(str.getBytes(),str.getBytes().length,ip,port);
//        ds.send(dp);
//        ds.close();
    }
}
