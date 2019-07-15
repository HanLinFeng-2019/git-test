package com.itheima.Exam30;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        FactoryImp Fac=new FactoryImp();
         ArrayList<Hat> list=Fac.piliang(5);//接收集合
        for(int i=0;i<list.size();i++){

            Fac.describe(list.get(i));
        }

    }
}
