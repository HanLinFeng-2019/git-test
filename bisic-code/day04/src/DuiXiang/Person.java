package DuiXiang;

public class Person {
    String name;
    private int age;
    public void show(){
        System.out.println("姓名："+name+"年龄："+age);
    }
    public static void setAge(int num){
        if(num<100&&num>0){
            age=num;
        }else{
            System.out.println("数据不合理");
        }
    }
    public int getAge(){
        return num;
    }

}
