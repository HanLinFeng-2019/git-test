package Test12;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

/*
2.分别使用lambda表达式获得以下对象：
a)长度为5的String数组
b)包含5个1-20(含1和20)之间随机数的HashSet<Integer>集合
c)一个代表2018年4月1日的Calendar对象
 */
public class Test12 {
    public static <T> T getObj(Supplier<T> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        //第一题作业
        String[] obj = getObj(()-> {
            return new String[5];
        });
        String[] obj1=getObj(()->new String[5]);
        System.out.println(obj.length);
        //第二题作业
        HashSet<Integer> set=new HashSet<>();
        getObj(()->{
            Random r=new Random();
            while(set.size()<5){
                int num=r.nextInt(20)+1;
                set.add(num);
            }
            return set;
        });
        System.out.println(set);
        //第三题作业
        Calendar obj3 = getObj(() -> {
            Calendar calendar = Calendar.getInstance();
            calendar.set(2018, 3, 1);
            return calendar;
        });
        System.out.println(obj3.getTime());

    }
}
