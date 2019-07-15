package com.itheima.Exam30;

import java.util.ArrayList;
import java.util.Random;

public class FactoryImp implements Factory{

    @Override
    public void describe(Hat hat) {
        if(hat.getColor()%2!=0){
            System.out.print("颜色为红色,");
        }else{
            System.out.print("颜色为黄色,");
        }
        System.out.print("价格为："+hat.getPrice());
        System.out.print("元的"+hat.getType());
        System.out.println("");
    }

    @Override
    public ArrayList<Hat> piliang(int num) {
        ArrayList<Hat> list=new ArrayList<>();

        for(int i=0;i<num;i++){
            Hat hat=new Hat();
            Random ra=new Random();
            int c=ra.nextInt(81)+20;
            int p=ra.nextInt(81)+20;
            hat.setColor(c);
            hat.setPrice(p);
            hat.setType("太阳帽");
            list.add(hat);
        }

        return list;
    }
}
