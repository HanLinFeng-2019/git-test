package Test8;

public class Demo {
    public static void show(MyFunctionalInterface myInter){
        myInter.method();
    }

    public static void main(String[] args) {
//        show(new MyFunctionalInterfaceImpl());


        show(new MyFunctionalInterface() {
            @Override
            public void method() {
                System.out.println("使用匿名内部类重写抽象方法");
            }
        });

        show(()->{System.out.println("使用匿名内部类重写抽象方法");});

        show(()->System.out.println("使用匿名内部类重写抽象方法"));

    }
}
