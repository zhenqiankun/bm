package pl;

public class OneL  implements  Runnable{
    public  boolean tem=false;
    public Ujg ujg;
    public OneL(Ujg ujg){
        this.ujg=ujg;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (ujg) {
                if ((!tem&&ujg.i == 3)||(!tem&&ujg.i==4)) {
                    System.out.println(Thread.currentThread().getName()+","+ --ujg.yoo+","+ujg.i);
                    ujg.i++;
                    tem=true;
                    ujg.notify();
                    break;
                } else {
                    try {
                        ujg.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
