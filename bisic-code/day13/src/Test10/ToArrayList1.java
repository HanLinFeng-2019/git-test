package Test10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class ToArrayList1 {
    public static void main(String[] args) {
        Random r=new Random();
       int num1=r.nextInt(100)+1;
        int num2=r.nextInt(100)+1;
        int num3=r.nextInt(100)+1;
        int num4=r.nextInt(100)+1;
        int num5=r.nextInt(100)+1;
        int num6=r.nextInt(100)+1;
        int num7=r.nextInt(100)+1;
        int num8=r.nextInt(100)+1;
        int num9=r.nextInt(100)+1;
        int num10=r.nextInt(100)+1;
        int[] arr={num1,num2,num3,num4,num5,num6,num7,num8,num9,num10};
        Collection list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
            if(arr[i]>=10){
                list.add(arr[i]);
            }
        }
        System.out.println(list);
    }
}
