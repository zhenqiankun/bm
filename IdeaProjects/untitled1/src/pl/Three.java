package pl;

public class Three {
    public static  int i=1;
    public static void main(String[] args) {

        Object object=new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(i<=75){
                    synchronized (object) {
                        if((int)Math.ceil(i/5)%3==1){
                            for (int j = 1; j <= 5; j++) {
                                System.out.println(Thread.currentThread().getName() + "," + i);
                                i++;

                            }
                            object.notifyAll();
                        }

                 else {
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(i<=75) {
                    synchronized (object) {
                        if ((int) Math.ceil(i / 5) % 3 == 2) {
                            for (int j = 0; j <= 5; j++) {
                                System.out.println(Thread.currentThread().getName() + "," + i);
                                i++;

                            }
                            object.notifyAll();
                        } else {
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(i<=75) {
                    synchronized (object) {
                        if ((int) Math.ceil(i / 5) % 3 == 0) {
                            for (int j = 0; j <= 5; j++) {
                                System.out.println(Thread.currentThread().getName() + "," + i++);

                            }
                            object.notifyAll();
                        } else {
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();
    }


}
