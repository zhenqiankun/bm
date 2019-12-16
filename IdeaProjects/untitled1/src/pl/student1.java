package pl;

public class student1 {
   int t=1;
   int pl=0;
    public   synchronized void get() throws InterruptedException {
        pl++;

        Thread.sleep(Long.parseLong("2000"));

            System.out.print( pl);

    }
    public  void menthod1(){
        System.out.print("po");
    }
}
