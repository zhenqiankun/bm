package ppp;
/* 李文东*/
public class Student  implements Comparable{
    public int number;
    public String name;
    public int age;
    public int python;
    public int java;
    public int linux;
    public int sql;
    public int sum;
    public int avg;
    public int id;
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPython() {
        return python;
    }

    public void setPython(int python) {
        this.python = python;
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getLinux() {
        return linux;
    }

    public void setLinux(int linux) {
        this.linux = linux;
    }

    public int getSql() {
        return sql;
    }

    public void setSql(int sql) {
        this.sql = sql;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getAvg() {
        return avg;
    }

    public void setAvg(int avg) {
        this.avg = avg;
    }
    @Override
    public String toString(){
        return "number"+number
                +"name"+name
                +"age"+age
                +"python"+python
                +"java"+java
                +"linux"+linux
                +"sql"+sql
                +"sum"+sum
                +"avg"+avg;
    }
    public void coursesort(int id){
        this.id=id;
    }
    @Override
    public int compareTo(Object o) {
        Student student=(Student)o;
        if(id==1){
            return this.python-student.python;
        }
       else if(id==2){
            return this.java-student.java;
        }
       else if(id==3){
           return this.linux-student.linux;

        }
       else if(id==4){
           return this.sql-student.sql;
        }
       else {
           return this.avg-student.avg;
        }
    }
}
