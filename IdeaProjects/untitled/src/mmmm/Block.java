package mmmm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Block {
    public static void main(String[] args) {
        String string=new Scanner(System.in).next();
        int x=new Scanner(System.in).nextInt();
        List<String> list=new ArrayList<>();
        int sum=0;
        int left=0;
        for(int i=0;i<string.length();i++){
            if(isChineseChar(string.charAt(i))){
                sum=sum+2;
                if(sum==x){
                    list.add(string.substring(left,i+1));
                    sum=0;
                    left=i+1;
                }
                else if(sum+2>x){
                    list.add(string.substring(left,i));
                    sum=2;
                    left=i;
                }
            }
            else {
                sum=sum+1;
                if(sum==x){
                    list.add(string.substring(left,i+1));
                    sum=0;
                    left=i+1;
                }
            }

        }
        if(left!= string.length()){
            list.add(string.substring(left, string.length()));
        }
        for (String l:list){
            System.out.println(l);
        }

    }
    public static boolean isChineseChar(char c) {
        return String.valueOf(c).matches("[\u4e00-\u9fa5]");
    }
}
