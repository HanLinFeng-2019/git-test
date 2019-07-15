package Test9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class StudentTest {
    public static void main(String[] args) {
        Student stu1=new Student("张三","男",28);
        Student stu2=new Student("李四","男",29);
        Student stu3=new Student("王五","男",30);
        Collection<Object> coll=new ArrayList<>();
        coll.add(stu1);
        coll.add(stu2);
        coll.add(stu3);
        for(Object i:coll){
            System.out.println(i);
        }
        int max= stu1.getAge();
        Iterator<Object> it=coll.iterator();
        while(it.hasNext()){
            Student obj = (Student)it.next();
            //判断最大年龄，修改name,
            if(obj.getAge()>max&&!it.hasNext()){
                max=obj.getAge();
                obj.setName("小猪佩奇");
                System.out.println(max);
                System.out.println(obj);
            }

        }
    }
}
