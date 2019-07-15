package Test9;

import java.util.*;

public class CollectionsSort {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<Integer>();
        list.add(33);
        list.add(11);
        list.add(77);
        list.add(55);
        Collections.sort(list);
        System.out.println(list);

    }
}
