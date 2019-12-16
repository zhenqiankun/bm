package TestT;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ThreadP extends Thread {
    public Socket socket;
    public ThreadP (Socket socket){
        this.socket=socket;
    }
    @Override
    public void run(){
        InputStream inputStream=null;
        try {
            inputStream =socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte [] bytes=new byte[1000];
        String tem = null;
        int y=0;
        while (true){
            try {
                if (((y=inputStream.read(bytes))==-1)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String [] temp=new String(bytes,0,y).split(",");
            if(temp[0].equals("bisxt")&&temp[1].equals("bisxt")){
                tem="true";
            }else {
                tem="false";
            }
        }
        OutputStream outputStream=null;
        try {
            outputStream=socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.write(tem.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
