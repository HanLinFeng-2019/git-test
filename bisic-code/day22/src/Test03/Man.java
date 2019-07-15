package Test03;

public class Man extends Human {
    @Override
    public void sayHello() {
        System.out.println("Hello,你是猪！");
    }
    public void method(Greetable g){
        g.greet();
    }
    public  void show(){
//        method(super.sayHello());
    }

    public static void main(String[] args) {
//        new Man.;
    }
}
