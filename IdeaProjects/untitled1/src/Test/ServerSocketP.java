package Test;

import TestT.ThreadP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSocketP {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        ExecutorService service= Executors.newFixedThreadPool(1000);
        Socket socket;
        ServerSocket serverSocket=new ServerSocket(1111);
        while (true){
            socket=serverSocket.accept();
            ServerThread serverThread=new ServerThread(socket);
            service.execute(serverThread);
        }
    }
}
