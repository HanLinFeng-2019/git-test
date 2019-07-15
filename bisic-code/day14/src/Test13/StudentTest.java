package Test13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentTest {
    public static void main(String[] args) {
        ArrayList<Student> list=new ArrayList<>();
        Collections.addAll(list,new Student("liusan",20,90.0F),
                new Student("lisi",22,90.0F),new Student("wangwu",20,99.0F),
                new Student("sunliu",22,100.0F));
        System.out.println(list);
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {


                return 0;
            }
        });
    }
}
