public class Bike {

    public static Bike bike1=new Bike();
    public static Bike bike2=new Bike();

    {
        System.out.println("构造代码块");
    }

    static{
        System.out.println("静态代码块");
    }


    public static void main(String[] args) {
       new Bike();
    }

}
