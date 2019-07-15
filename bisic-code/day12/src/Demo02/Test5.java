package Demo02;

public class Test5 {
    public static void main(String[] args) {
        long s1 = System.currentTimeMillis();
        String str="a";
        for(int i=1;i<=100000;i++){
            str+="a";
        }
        System.out.println(str);
        long e1 = System.currentTimeMillis();
        System.out.println("程序共耗时:"+(e1-s1)+"毫秒");
        long s2= System.currentTimeMillis();
        StringBuilder str3=new StringBuilder("a");
        for(int i=1;i<=100000;i++){
            str3.append("a");
        }
        System.out.println(str3);
        long e2 = System.currentTimeMillis();
        System.out.println("程序共耗时:"+(e2-s2)+"毫秒");
    }
}
