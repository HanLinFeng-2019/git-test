package Test9;

import java.util.Arrays;
import java.util.Comparator;

public class Demo03 {

    public static Comparator<String> getcomparator(){

        return (o1,o2)->o2.length()-o1.length();
    }

    public static void main(String[] args) {
        String[] arr={"aaa","bb","cccc","d"};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr,getcomparator());
        System.out.println(Arrays.toString(arr));
    }

}
