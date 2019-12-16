package Test.StudentModel;

public class daojis extends Thread {
    public StuTest stuTest;
    public int time=1800;
    daojis(StuTest stuTest){
        this.stuTest=stuTest;
    }
    @Override
    public void run() {
        while (time > 0) {
            int mtime =  time /60;
            int stime = time % 60;
            time--;
            String pl = "半圆考试还剩" + mtime + "分钟" + stime + "秒";
            StuTest.jTextField1.setText(pl);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stuTest.close();
    }
}
