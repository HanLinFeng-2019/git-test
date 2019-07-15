package Test9;

import java.util.function.Predicate;

public class Demo6 {
    public static boolean checkString(String s, Predicate<String> pre){
        return pre.test(s);
    }

    public static void main(String[] args) {
        String s="advfsdf";
        boolean b = checkString(s,(String str)->{
            return str.length()>5;
        });
        System.out.println(b);
    }

}
