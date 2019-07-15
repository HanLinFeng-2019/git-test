package Test1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Colllection11 {
    public static void main(String[] args) {
        Collection<String> co=new ArrayList<>();
        co.add("hello");
        co.add("world");
        co.add("java");
        co.add("php");
        Iterator<String> it=co.iterator();
        while(it.hasNext()){
               String str= it.next();
            System.out.println(str);
        }
        System.out.println("========================");
        for(String i:co){
            System.out.println(i);
        }
        System.out.println("==============");
    }
}
