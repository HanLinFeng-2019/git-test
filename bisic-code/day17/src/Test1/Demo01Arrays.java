package Test1;

import java.util.Arrays;
import java.util.Comparator;

public class Demo01Arrays {
    public static void main(String[] args) {
        Person[] arr={
                new Person("张三",18),
                new Person("李四",20),
                new Person("王五",30)
        };
//        Arrays.sort(arr,new Comparator<Person>(){
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge()-o2.getAge();
//            }
//        });
        Arrays.sort(arr,(Person o1, Person o2)->{
            return o1.getAge()-o2.getAge();
        });

        for(Person p:arr){
            System.out.println(p);
        }
    }
}
