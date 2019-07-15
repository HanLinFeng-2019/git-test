package Test12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
Comparator<Person> comp = new Comparator<Person>(){     
        @Override             
public int compare(Person o1, Person o2) {
        return o1.getAge() ‐ o2.getAge();             
 }         
 };         
 Arrays.sort(array, comp); 
 */
public class StudentTest {
    public static void main(String[] args) {
        Student[] array={
                new Student("张三",60),
                new Student("李四",40),
                new Student("王五",80),
                new Student("赵六",100)

        };
//        Comparator<Student> comp= new Comparator<>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//
//                return o1.getScore()-o2.getScore();
//            }
//        };
        Arrays.sort(array,(o1,  o2)->
             o1.getScore()-o2.getScore()
        );

        for(Student s:array){
            System.out.println(s);
        }

    }


}
