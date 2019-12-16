public class Tank {
    public int x;
    public int y;
    public String dir;
    public String type;
    public Tank(int x,int y,String dir,String type){
        this.x=x;
        this.dir=dir;
        this.type=type;
        this.y=y;
    }
    public void ShowData(){
        System.out.println("横坐标"+x+"纵坐标"+y+"方向"+dir+"类型"+type);
    }

    public static void main(String[] args) {
        Tank tank=new Tank(10,50,"右","重型坦克");
        tank.ShowData();
    }
}
