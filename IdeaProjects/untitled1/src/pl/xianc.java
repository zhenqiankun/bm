package pl;

public class xianc  {
    public  int ticket=1000;
    public  void method(){
        while(true){
            synchronized (this){
                if(ticket>=100){
                    ticket=ticket-100;
                    System.out.println(Thread.currentThread().getName()+","+"取了100"+ticket);
                }
                else{
                    break;
                }
            }
        }
    }
    public void method1(){
        while(true){
            synchronized (this){
                if(ticket>=200){
                    ticket=ticket-200;
                    System.out.println(Thread.currentThread().getName()+","+"取了200"+ticket);
                }
                else{
                    break;
                }
            }
        }
    }
}
