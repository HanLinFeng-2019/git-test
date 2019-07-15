package com;

import java.util.ArrayList;
import java.util.Random;

public class day07Text1 {
    public static void main(String[] args) {
        ArrayList<Integer> biglist=new ArrayList<>();
        Random r=new Random();
        for(int i=0;i<20;i++){
            int num=r.nextInt(100)+1;
            biglist.add(num);
        }
        ArrayList<Integer> smalllist=getsmalllist(biglist);
        for(int i=0;i<smalllist.size();i++){
            System.out.println(smalllist.get(i));
        }
    }
    public static ArrayList<Integer> getsmalllist(ArrayList<Integer> biglist){
        ArrayList<Integer> smalllist=new ArrayList<>();
        for(int i=0;i<biglist.size();i++){
            int num=biglist.get(i);
            if(num%2==0){
                smalllist.add(num);
            }
        }
        return smalllist;
    }
}
