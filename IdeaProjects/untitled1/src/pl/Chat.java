package pl;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class Chat implements Runnable {
    public DatagramSocket datagramSocket;
    public Chat(DatagramSocket datagramSocket){
        this.datagramSocket=datagramSocket;
    }
    @Override
    public void run() {
        byte [] bytes=new byte[100];
        DatagramPacket datagramPacket=new DatagramPacket(bytes,bytes.length);
        try {
            datagramSocket.receive(datagramPacket);
            byte [] bytes1=Arrays.copyOf(bytes,datagramPacket.getLength());

            System.out.println(new String(bytes1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
