/**
 * @author edz
 */
public class Person {
   public  String sex;
   public String name;
   public String phone;
  @Override
  public boolean equals(Object obj){
      if(obj==null){
          return false;
      }
      if(this.getClass()!=obj.getClass()){
          return false;
      }
      if(this==obj){
          return true;
      }
      Person objj=(Person)obj;
      if(this.sex!=null){
          if(!this.sex.equals(objj.sex)){
              return false;
          }
      }
      else{
          if(objj.sex!=null) {return false;}
      }
      if(this.name!=null){
          if(!this.name.equals(objj.name)){
              return false;
          }
      }
      else{
          if(objj.name!=null) {return false;}
      }
      if(this.phone!=null){
          if(!this.phone.equals(objj.phone)){
              return false;
          }
      }
      else{
          if(objj.phone!=null) {return false;}
      }
      return true;

  }
}
