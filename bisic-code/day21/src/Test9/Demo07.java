package Test9;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Demo07 {

    public static ArrayList<String> filter(String[] arr, Predicate<String> pre1,Predicate<String> pre2){
        ArrayList<String> list=new ArrayList<>();
        for (String s : list) {
            boolean b = pre1.and(pre2).test(s);
            if(b){
            list.add(s);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        String[] arr={"迪丽热巴,女","迪丽热巴,女","周礼,女","马儿扎哈,男"};
        ArrayList<String> L = filter(arr, (String str) -> {
            return str.split(",")[1].equals("女");
        }, (String str) -> {
            return str.split(",")[0].length() == 4;
        });
        for (String s : L) {
            System.out.println(s);
        }
    }
}
