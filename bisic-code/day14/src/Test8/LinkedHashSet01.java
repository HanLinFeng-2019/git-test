package Test8;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSet01 {
    public static void main(String[] args) {
        HashSet<String> set=new LinkedHashSet<>();//"王昭君","王昭君","西施","杨玉环","貂蝉"
        set.add("王昭君");
        set.add("王昭君");
        set.add("西施");
        set.add("杨玉环");
        set.add("貂蝉");
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            String str = it.next();
            System.out.println(str);
        }
        System.out.println("=======================");
        for(String i:set){
            System.out.println(i);
        }
    }
}
