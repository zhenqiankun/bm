package Test;

import Test.StudentModel.Sockett;
import org.apache.commons.dbutils.QueryRunner;

import java.io.*;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*传送数据*/
public class Seach {
    public  Socket socket;
    Seach (Socket socket){
        this.socket=socket;
    }
    public void example(ResultSet resultSet) throws SQLException, IOException, ClassNotFoundException {
        String result="";
        String daan="";
        while (resultSet.next()) {
            result += resultSet.getString(2) + "@" + resultSet.getString(3) + "@" + resultSet.getString(4) + "@" + resultSet.getString(5) + "@" + resultSet.getString(6) + "@" + "#";
            daan += resultSet.getString(7);
        }
       OutputStream outputStream= socket.getOutputStream();
       outputStream.write(result.getBytes());
       outputStream.flush();
        InputStream inputStream=null;
        inputStream=socket.getInputStream();
        byte [] bytes=new byte[1000];
        int y;
        y=inputStream.read(bytes);
        String pl=new String(bytes,0,y);
        int p=0;
        for(int i=0;i<20;i++){
            if(pl.charAt(i)!=daan.charAt(i)){
                p++;
            }
        }
        Conntions conntions=new Conntions();
        conntions.studentresult((20-p)*10);
    }
    public void chenji(String name) throws IOException, SQLException, ClassNotFoundException {
        Conntions conntions=new Conntions();
       int y= conntions.chenji(name);
        OutputStream o=null;
        o=socket.getOutputStream();
        o.write(String.valueOf(y).getBytes());
        o.flush();

    }
    public  void update() throws SQLException, ClassNotFoundException {
        Conntions conntions=new Conntions();
        InputStream inputStream1 = null;
        try {
            inputStream1 = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes1 = new byte[1023];
        int k = 0;
        try {
            k = inputStream1.read(bytes1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pk = new String(bytes1, 0, k);
        conntions.update(pk);
    }
    public void insertti() throws IOException, SQLException, ClassNotFoundException {
        Conntions conntions=new Conntions() ;
        InputStream i=socket.getInputStream();
        InputStreamReader io=new InputStreamReader(i);
        String pl="";
        int y=0;
        char [] bytes=new char[100];
        while ((y=io.read(bytes))!=-1){
            pl+=new String(bytes,0,y);
            if(y!=100){
                break;
            }
        }
        conntions.insertimu(pl);

    }
    public void addstudent() throws IOException, SQLException, ClassNotFoundException {
        Conntions conntions=new Conntions() ;
        InputStream i=socket.getInputStream();
        InputStreamReader io=new InputStreamReader(i);
        String pl="";
        int y=0;
        char [] bytes=new char[100];
        while ((y=io.read(bytes))!=-1){
            pl+=new String(bytes,0,y);
            if(y!=100){
                break;
            }
        }
        conntions.addstudent(pl);
    }
    public void selstudent() throws SQLException, ClassNotFoundException, IOException {
        while (true) {
            Conntions conntions = new Conntions();
            InputStream inputStream1 = null;
            try {
                inputStream1 = socket.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] bytes1 = new byte[1023];
            int k = 0;
            try {
                k = inputStream1.read(bytes1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(new String(bytes1,0,k).equals("退出")){
                return;
            }
            String pl = conntions.selstudent(new String(bytes1, 0, k));
            System.out.println(pl);
            OutputStream o = socket.getOutputStream();
            o.write(pl.getBytes());
            o.flush();
        }
    }
    public void delstudent() throws SQLException, ClassNotFoundException {
        Conntions conntions=new Conntions();
        InputStream inputStream1 = null;
        try {
            inputStream1 = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes1 = new byte[1023];
        int k = 0;
        try {
            k = inputStream1.read(bytes1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String(bytes1,0,k));
        conntions.delstudent(new String(bytes1,0,k));
    }
public void upstudent() throws SQLException, ClassNotFoundException {

            Conntions conntions = new Conntions();
            InputStream inputStream1 = null;
            try {
                inputStream1 = socket.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] bytes1 = new byte[1024];
            int k = 0;
            try {
                k = inputStream1.read(bytes1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] tem = new String(bytes1, 0, k).split(",");
            System.out.println(tem[0]+tem[1]+tem[2]);
            conntions.upstudent(tem[0], tem[1], tem[2]);


}
public void delexam() throws SQLException, ClassNotFoundException, IOException {

    Conntions conntions = new Conntions();
    int x=conntions.selectt();
    while (true) {
        InputStream inputStream1 = null;
        try {
            inputStream1 = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes1 = new byte[1024];
        int k = 0;
        try {
            k = inputStream1.read(bytes1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pl = new String(bytes1, 0, k);
        if (pl.equals("结束")) {
            return;
        }
       else if (pl.equals("删除")) {
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            List<String> list = (List<String>) objectInputStream.readObject();
            conntions.delexpl(list);
        } else if (Integer.parseInt(pl) > (int) Math.ceil(x / 5.0) - 1) {
            OutputStream p = socket.getOutputStream();
            System.out.println(pl);
            p.write("9".getBytes());
        } else  {
            ResultSet set = conntions.delex(pl);
            String po = "";
            while (set.next()) {
                po += set.getString("f1") + "@" + set.getString("f2") + "#";
            }
            OutputStream p = socket.getOutputStream();
            p.write(po.getBytes());
            p.flush();
        }
    }

}
public void selexamine() throws SQLException, ClassNotFoundException, IOException {
    Conntions conntions = new Conntions();
    while (true) {
        InputStream inputStream1 = null;
        try {
            inputStream1 = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes1 = new byte[1024];
        int k = 0;
        try {
            k = inputStream1.read(bytes1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pll = new String(bytes1, 0, k);
        if(pll.equals("结束")){
            System.out.println("chax");
            return;
        }
        System.out.println(pll);
        ResultSet set = conntions.selexamine(pll);
        List<List<String>> lists = new ArrayList<List<String>>();
        while (set.next()) {
            List<String> list = new ArrayList<String>();
            list.add(set.getString(2));
            list.add(set.getString(3));
            list.add(set.getString(4));
            list.add(set.getString(5));
            list.add(set.getString(6));
            list.add(set.getString(7));
            lists.add(list);
        }
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(lists);
        out.flush();
    }
}
public void upexa() throws SQLException, ClassNotFoundException, IOException {
    Conntions conntions = new Conntions();
    while (true) {
        List<List<String>> lists = new ArrayList<List<String>>();
        InputStream inputStream1 = null;
        try {
            inputStream1 = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes1 = new byte[1024];
        int k = 0;
        try {
            k = inputStream1.read(bytes1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pll = new String(bytes1, 0, k);
        if (pll.equals("修改")) {
            ObjectInputStream o = new ObjectInputStream(socket.getInputStream());
            List<List<String>> list = (List) o.readObject();
            conntions.upex(list);
        } else if (pll.equals("结束")) {
            return;
        } else {
            ResultSet set = conntions.selexamine(pll);
            while (set.next()) {
                List<String> list = new ArrayList<String>();
                list.add(set.getString(1));
                list.add(set.getString(2));
                list.add(set.getString(3));
                list.add(set.getString(4));
                list.add(set.getString(5));
                list.add(set.getString(6));
                list.add(set.getString(7));
                lists.add(list);
            }
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(lists);
            out.flush();

        }
    }

   }

}
