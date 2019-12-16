package pl;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class RevicedServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(1123);
        Socket s=ss.accept();
        InputStream inputStream=s.getInputStream();
    }
}
