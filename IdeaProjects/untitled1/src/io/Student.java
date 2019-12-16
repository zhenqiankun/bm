package io;

import java.io.*;

public class Student implements Externalizable {
    private static final long serialVersionUID=1L;
    public String op="10";
    public String lm;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

        out.writeObject(op);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        op=(String)in.readObject();
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student as=new Student();
        File file=new File("src/io/1.txt");
        as.op="123";
        as.lm="1234";
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(as);
        ObjectInputStream o=new ObjectInputStream(new FileInputStream(file));
        Student student=(Student)o.readObject();
        System.out.println(student.op+","+student.lm);
    }
}
