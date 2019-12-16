import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Random;

public class Book{
    public String pl="345";
    public String title;
    public int pageNum;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public  void detail (){
        System.out.print("名称"+title+"页数"+pageNum);
    }
   public   void  pl(){
        System.out.println(pl);
   }
    public static void main(String[] args) throws ParseException {
//        Scanner pl=new Scanner(System.in);
//        Book book=new Book();
//        book.setTitle(pl.next());
//        while(true){
//            System.out.println("输入页数");
//            int x=pl.nextInt();
//            if(x>=0&&x<=200){
//                book.setPageNum(x);
//                book.detail();
//                break;
//            }
//        }
//
        double pl=0.01;
        double pll=0.01;
        BigDecimal bigDecimal=new BigDecimal(String.valueOf(pl));
        BigDecimal plg=new BigDecimal(String.valueOf(pll));
        System.out.println(bigDecimal.add(plg));
        BigInteger bigInteger=new BigInteger("11111123123123123");
        System.out.println(bigInteger);
        Character.isDigit('l');
        Random random=new Random(1000);
        System.out.println(random.nextInt(2));
//        给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
//
//        示例：
//
//        输入: S = "ADOBECODEBANC", T = "ABC"
//        输出: "BANC"
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/minimum-window-substring
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明

    }
}
