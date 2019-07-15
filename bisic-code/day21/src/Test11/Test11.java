package Test11;

public class Test11 {
    public static void getProduct(int a , int b ,IntCalc calc){
        int num = calc.calc(a, b);
        System.out.println(num);
    }

    public static void main(String[] args) {
        getProduct(10,15, new IntCalc() {
            @Override
            public int calc(int a, int b) {
                return a*b;
            }
        });
         //lambda表达式
        getProduct(10,15,(a,b)->a*b);
    }
}
