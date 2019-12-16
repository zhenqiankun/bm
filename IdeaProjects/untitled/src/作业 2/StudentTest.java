package ppp;
/* 李文东*/
import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        StudentAdmin studentAdmin=new StudentAdmin();
        Scanner x=new Scanner(System.in);
        int i=1;
        while(i==1){
            System.out.println("10,增加一个学生\n11,查找一个学生\n12,更新一个学生\n13，删除个学生\n14,输入学生成绩\n15,输入科目编号进行排序\n16,根据总分排序");
            int u=x.nextInt();
            switch (u){
                case 10:studentAdmin.create();break;
                case 11:System.out.print("输入编号");studentAdmin.select(x.nextInt());studentAdmin.print();break;
                case 12:System.out.print("输入编号");studentAdmin.update(x.nextInt());studentAdmin.print();break;
                case 13:System.out.print("输入编号");studentAdmin.delete(x.nextInt());studentAdmin.print();break;
                case 14:System.out.print("输入编号");studentAdmin.input(x.nextInt());studentAdmin.print();break;
                case 15:System.out.print("输入编号");studentAdmin.coursesort(x.nextInt());studentAdmin.print();break;
                case 16:studentAdmin.sort();break;
                case 99:i=0;break;
            }
        }
        System.out.println("系统结束");
    }
}
