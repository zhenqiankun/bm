package ppp;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Worker> list = new ArrayList<>();
        Worker person1 = new Worker("zhang3", 18, 3000.1);
        Worker person5 = new Worker("zhang3", 18, 3000.1);
        Worker person2 = new Worker("li4", 25, 3500);
        Worker person3 = new Worker("wang5", 22, 3200);
        list.add(person1);
        list.add(person2);
        list.add(person3);
        Worker person4 = new Worker("zhao6", 24, 3300);
        list.remove(person3);
        list.add(1, person4);
        for (Worker person : list) {
            System.out.println(person.getName() + "," + person.getAge() + "," + person.getSalary());
        }
        Iterator iterator=list.iterator();
        while (iterator.hasNext()){
           ((Worker)iterator.next()).work();
        }
        System.out.println(person1.equals(null));

    }
}
