package mmn;

public class k extends Object implements Comparable<k>,Cloneable{
    public String lm;
    public String mn;
    public int hash;

    @Override
    public int compareTo(k o) {
        if(o.lm.compareTo(this.lm)==0){
            return 1;
        }
        return o.lm.compareTo(this.lm);

    }
    @Override
    public boolean equals(Object object){

        return true;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    @Override
    public int hashCode(){
        return lm.hashCode()*mn.hashCode();
    }
}
