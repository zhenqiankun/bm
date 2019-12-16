package ppp;

/* 李文东*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentAdmin {
    public List<Student>list;
    public StudentAdmin(){
        list=new ArrayList<>();
    }
    public void create(){
        Student student=new Student();
        Scanner x=new Scanner(System.in);
        System.out.println("请输入编号");
        student.setNumber(x.nextInt());
        System.out.println("请输名字");
        student.setName(x.next());
        System.out.println("请输入年龄");
        student.setAge(x.nextInt());
        list.add(student);
    }
    public void select(int id){
        Student student=null;
        for(Student studenty:list){
            if(studenty.number==id){
                student=studenty;
                break;
            }
        }
        System.out.println( "number"+student.number
                +"name"+student.name
                +"age"+student.age
                +"python"+student.python
                +"java"+student.java
                +"linux"+student.linux
                +"sql"+student.sql
                +"sum"+student.sum
                +"avg"+student.avg);
    }
    public void print(){
        for(Student student:list){
            System.out.println("number"+student.number
                    +"name"+student.name
                    +"age"+student.age
                    +"python"+student.python
                    +"java"+student.java
                    +"linux"+student.linux
                    +"sql"+student.sql
                    +"sum"+student.sum
                    +"avg"+student.avg);
        }
    }
    public void update(int id){
        Student student=null;
        for(Student studenty:list){
            if(studenty.number==id){
                student=studenty;
                break;
            }
        }
        Scanner x=new Scanner(System.in);
        System.out.println("请输入编号");
        student.setNumber(x.nextInt());
        System.out.println("请输名字");
        student.setName(x.next());
        System.out.println("请输入年龄");
        student.setAge(x.nextInt());
    }
    public void delete(int id){
        for(Student student:list) {
            if(student.number==id){
                list.remove(student);
                break;
            }
        }
    }
    public void input(int id){
        Student student=null;
        for(Student studenty:list){
            if(studenty.number==id){
                student=studenty;
                break;
            }
        }
        Scanner x=new Scanner(System.in);
        System.out.println("请输入java成绩");
        student.setJava(x.nextInt());
        System.out.println("请输入python成绩");
        student.setPython(x.nextInt());
        System.out.println("请输入linux成绩");
        student.setLinux(x.nextInt());
        System.out.print("请输入sql成绩");
        student.setSql(x.nextInt());
        student.setSum(student.python+student.linux+student.sql+student.java);
        student.setAvg(student.sum/4);
    }
    public void coursesort(int id){
        for(Student student:list){
            student.id=id;
        }
        Collections.sort(list);
    }
    public void sort(){
        for(Student student:list){
            student.id=5;
        }
        Collections.sort(list);
    }
}
