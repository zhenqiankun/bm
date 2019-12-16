package pl;

import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.Socket;

public class lll {
    public static void main(String[] args) throws IOException {
//        Socket socket=new Socket("192.168.11.22",1234);
//        OutputStream os=socket.getOutputStream();
//        os.write("123".getBytes());
//        socket.close();
        DatagramSocket datagramSocket = new DatagramSocket();
        DatagramSocket datagramSocket1 = new DatagramSocket(1123);
        Re re = new Re(datagramSocket);
        Chat chat = new Chat(datagramSocket1);
        new Thread(re).start();
        new Thread(chat).start();
//    }
    }
}
