package Test11;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Spliterator;

public class LinkedHashSet01 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入字符串：");
        String str = sc.next();
        char[] arr = str.toCharArray();
        LinkedHashSet<Character> set=new LinkedHashSet();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        System.out.println("去除掉相同字母：");
        System.out.println(set);
        Iterator<Character> it = set.iterator();
        System.out.println("结果为：");
        while(it.hasNext()){
            Character cha = it.next();
            System.out.print(cha);
        }


    }
}
