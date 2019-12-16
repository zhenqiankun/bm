package pl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Filename {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Student> list=new ArrayList<>();
        File file=new File("file/op/km/1.txt");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(file));
        Student student=new Student();
        student.age=1;
        student.classroom="123";
        student.id=1;
        student.name="123";
        Student student3=new Student();
        student3.age=2;
        list.add(student);
        list.add(student3);
        Student student4=new Student();
        student4.age=10000;
        objectOutputStream.writeObject(student4);
        objectOutputStream.writeObject(list);
        ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream(file));
       Student list1=(Student) inputStream.readObject();

}}
