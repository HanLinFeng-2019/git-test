package Test02;

public class DemoLambda {
    public static void method(int num,Calcabl lambda){
        System.out.println(lambda.calc(num));
    }

    public static void main(String[] args) {
        method(-10,Math::abs);

        method(-10,n->Math.abs(n));
    }

}
