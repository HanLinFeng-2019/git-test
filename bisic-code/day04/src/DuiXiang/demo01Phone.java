package DuiXiang;

public class demo01Phone {
    public static void main(String[] args) {
        Phone one=new Phone();
        System.out.println(one.brand);
        System.out.println(one.price);
        System.out.println(one.color);
        one.brand="苹果";
        one.price=10000;
        one.color="黑色";
        System.out.println(one.brand);
        System.out.println(one.price);
        System.out.println(one.color);
        one.call();
        one.sendmessage();
    }
}
