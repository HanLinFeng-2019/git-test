package DuiXiang;

public class Demo02Student {
    public static void main(String[] args){
        Student stu=new Student();
        System.out.println(stu.name);
        System.out.println(stu.age);
        System.out.println("================");
        stu.name="赵丽颖";
        stu.age=18;
        System.out.println(stu.name);
        System.out.println(stu.age);
        System.out.println("================");
        stu.eat();
        stu.sleep();
        stu.study();
    }
}
