package TestT;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SocketP {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
            Socket socket=new Socket("192.168.9.41",1444);
            OutputStream outputStream=socket.getOutputStream();
            String ui=scanner.next()+","+scanner.next();
            outputStream.write(ui.getBytes());
            socket.shutdownOutput();
            InputStream inputStream=socket.getInputStream();
            byte [] bytes=new byte[1000];
            int y=0;
            while ((y=inputStream.read(bytes))!=-1){
                if(new String(bytes,0,y).equals("true")){
                    System.out.println("登陆成功");
                }
                else {
                    System.out.println("密码或者账号错误");
                }
            }
            socket.close();
        }
    }

