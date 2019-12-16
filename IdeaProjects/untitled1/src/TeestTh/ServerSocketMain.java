package TeestTh;
import Test.ServerThread;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSocketMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        ExecutorService service=Executors.newFixedThreadPool(100);
        ServerSocket serverSocket=new ServerSocket(8111);
       while (true){
        Socket socket=serverSocket.accept();
        ServerThread serverThread=new ServerThread(socket);
       service.execute(serverThread);
      }
    }
}
