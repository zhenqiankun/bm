package pl;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Number number=new Number();
     Thread thread=new Thread(number);
     Thread thread1=new Thread(number);
     Thread thread2=new Thread(number);
     for(int i=1;i<=5;i++){
         thread.start();
         thread.join();
         thread1.start();
         thread1.join();
         thread2.start();
     }
    }
}
