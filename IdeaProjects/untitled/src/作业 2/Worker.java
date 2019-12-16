package ppp;

public class Worker extends Object{
    private int age;
    private String name;
    private double salary;
    public Worker(String name,int age,double salary){
        this.name=name;
        this.age=age;
        this.salary=salary;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void work(){
        System.out.println(name+"work");
    }
    @Override
    public boolean equals(Object obj){
        if(obj==null){
            return false;
        }
        if(obj==this){
            return true;
        }
        if(obj.getClass()!=this.getClass()){
            return false;
        }
        Worker worker=(Worker)obj;
        if(this.age==worker.age&&this.name.equals(worker.name)&&this.salary==worker.salary){
            return true;
        }
        else{
            return false;
        }
   }
   @Override
    public int hashCode(){
        return age*(int)salary*name.hashCode();
   }
}
