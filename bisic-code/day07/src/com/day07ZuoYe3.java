package com;

import java.util.ArrayList;

public class day07ZuoYe3 {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("def");
        list.add("ghi");
        list.add("def");
        list.add("hij");
        list.add("jkol");
        System.out.println(list);
        for(int i=0;i<list.size();i++){
            list.remove("def");
        }
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println(list);
    }
}
