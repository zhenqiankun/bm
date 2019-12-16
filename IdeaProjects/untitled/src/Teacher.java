import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class Teacher {
    public int id;
    public String name;
    public String sex;
    public int age;
    public double height;
    public  Teacher(int id,String name,String sex,int age,double height){
        this.id=id;
        this.sex=sex;
        this.age=age;
        this.height=height;
        this.name=name;
    }
    public void ShowData(){
        System.out.println("姓名"+name+"编号"+id+"年龄"+age+"性别"+sex+"身高"+height);
    }

    public static void main(String[] args) {
       int id;
       String name;
        String sex;
        int age;
        double height;
        Scanner x=new Scanner(System.in);
        id=x.nextInt();
        while(true){
            System.out.println("输入姓名");
            name=x.next();
            if(name.length()>=1&&name.length()<=4){
                break;
            }
        }
        while(true){
            System.out.println("输入性别");
            sex=x.next();
            if(sex.equals("男")||sex.equals("女")){
                break;
            }
        }
        while (true){
            System.out.println("输入年龄");
            age=x.nextInt();
            if(age>=20&&age<=25){
                break;
            }
        }
        while (true){
            System.out.println("输入身高");
            height= x.nextDouble();
            if(height>1.499999999&&height<1.8000000001){
                break;
            }
        }
        Teacher teacher=new Teacher(id,name,sex,age,height);
        teacher.ShowData();
    }
}
