package Server;



import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MyMain {
    public static void main(String[] args){
        System.out.println("欢迎来到半圆学社");
        Class c = null;
        try {
            c = Class.forName("Server.People");
            Annotation[] annotations1 = c.getAnnotations();
//            Method method = c.getMethod("getName");
//            Annotation[] annotations = method.getAnnotations();

            MyAnnotation myAnnotation=(MyAnnotation) annotations1[0];

            System.out.println(myAnnotation.name());

            for(Annotation e:annotations1){
//                System.out.println("查找getName上的注解");
                System.out.println();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

