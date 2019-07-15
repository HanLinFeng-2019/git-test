package Test12;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class DoubleColorBalls {
    public static void main(String[] args) {
//        String[] color={"红色","蓝色"};
        Random num=new Random();
        Integer j = num.nextInt(16)+1;
        HashSet<String> set=new HashSet();
        for(int a=0;a<6;a++){
            Integer i = num.nextInt(33)+1;
            set.add("红色"+i);
            if(set.size()<a+1){
                a--;
            }
        }
        set.add("蓝色"+j);
        System.out.println(set);
    }
}
