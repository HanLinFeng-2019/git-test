package Test14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
b)使用Collections.sort(List<T> list, Comparator<? super T> c)方法将学生成绩从小到大进行排序（忽略非空判断）
i.使用匿名内部类
ii.使用Lambda表达式答案
 */
public class Test14 {
    public static void main(String[] args) {
        ArrayList<Student> list=new ArrayList<>();
        list.add(new Student("谢霆锋",85));
        list.add(new Student("章子怡",63));
        list.add(new Student("刘亦菲",77));
        list.add(new Student("黄晓明",33));
        list.add(new Student("岑小村",92));
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getScore()-o2.getScore();
            }
        });
        System.out.println(list);

        Collections.sort(list,(o1,o2)->o1.getScore()-o2.getScore());

        System.out.println(list);




    }
}
