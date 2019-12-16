package TeestTh;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Main main=new Main();
        while (true){
            System.out.println("1,查找队伍\n2,添加队伍");

            int x=new Scanner(System.in).nextInt();
            switch (x){
                case 1: main.select();break;
                case 2: main.Insert();
            }
        }
    }
    public void select() throws IOException, ClassNotFoundException {
        String name=new Scanner(System.in).next();
        File file=new File("src/TeestTh/play.txt");
        ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(file));
        Play play;
        try {
            while((play=(Play) objectInputStream.readObject())!=null){
                if(play.name.equals(name)){
                    System.out.println(play.tearm);
                }
            }
        }catch (Exception e){

        }

    }
    public void Insert() throws IOException {

        String name=new Scanner(System.in).next();
        String team=new Scanner(System.in).next();
        File file=new File("src/TeestTh/play.txt");
        MyObjectOutStream myObjectOutStream=MyObjectOutStream.newInstance(new FileOutputStream(file,true),file);
        Play play=new Play();
        play.name=name;
        play.tearm=team;
        myObjectOutStream.writeObject(play);
    }
}
