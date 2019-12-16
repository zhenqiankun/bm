package mmmm;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner x=new Scanner(System.in);
        int i=x.nextInt();
        int j=x.nextInt();
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("qwertyuiiiidgf");
       String m=stringBuilder.substring(0,i)+(new StringBuilder(stringBuilder.substring(i,j+1)).reverse()).append(stringBuilder.substring(j,stringBuilder.length()));
        System.out.println(m);
    }
}
