package MVC;

public class student {
    public int age;
    public teacher  teacher;

    public MVC.teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(MVC.teacher teacher) {
        this.teacher = teacher;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
