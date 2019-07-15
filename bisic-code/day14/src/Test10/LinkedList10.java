package Test10;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedList10 {
    public static void main(String[] args) {
        String[] str={"12345","67891","12347809933","98765432102","67891","12347809933"};
        List<String> list=new LinkedList();
        for(int i=0;i<str.length;i++){
            list.add(str[i]);
        }
        for(int i=0;i<list.size();i++){
            int a = list.get(i).hashCode();
            for(int j=i+1;j<list.size();j++){
                int b=list.get(j).hashCode();
                if(a==b&&list.get(i).equals(list.get(j))){
                    list.remove(j);
                }
            }
        }
        System.out.println(list);

    }
}
