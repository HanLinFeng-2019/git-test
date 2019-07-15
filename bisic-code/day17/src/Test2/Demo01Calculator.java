package Test2;

public class Demo01Calculator {
    public static void main(String[] args) {
        //匿名内部类的书写方式
        invokeCalc(10,20,new Calculator(){

            @Override
            public int calc(int a, int b) {
                return a+b;
            }
        });

        //使用lambda表达式简化内部类的书写
        invokeCalc(120,130,(int a,int b)->{
            return a+b;
        });

    }

    public static void invokeCalc(int a,int b,Calculator c){
        int sum=c.calc(a,b);
        System.out.println(sum);
    }
}
