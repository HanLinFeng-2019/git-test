package com;

import java.util.ArrayList;
import java.util.Scanner;

public class day07ZuoYe2 {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<5;i++){
            Scanner r=new Scanner(System.in);
            list.add(r.next());
        }
        System.out.println(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }
}
