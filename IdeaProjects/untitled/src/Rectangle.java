/**
 * @author edz
 */
public class Rectangle {
    public  int length=1;
    public int width=1;

    public int getLength() {
        return length;
    }


    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    public void perimeter(){
        System.out.println("周长"+(length+width)*2);
    }
    public void area(){
        System.out.println("面积" +length*width);
    }

    public static void main(String[] args) {
        Rectangle rectangle=new Rectangle();
        rectangle.setLength(10);
        rectangle.setWidth(24);
        rectangle.perimeter();
        rectangle.area();
    }
}
