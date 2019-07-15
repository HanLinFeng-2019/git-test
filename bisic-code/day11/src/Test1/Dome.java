package Test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Dome {
    public static void main(String[] args) {

        int[] arr={1, 8, 26, 45, 60, 78, 99};
//        System.out.println("修改前的数组："+ Arrays.toString(arr));
//        Scanner s = new Scanner(System.in);
//        int num=s.nextInt();
//
//        int[] arr1 ={1, 8, 26, 45, 60, 78, 99,num};
//        Arrays.sort(arr1);
//        System.out.println("修改后的数组："+ Arrays.toString(arr1));

        System.out.println("[");
        for(int i=0;i<arr.length;i++){
            if(i!=arr.length-1){
                System.out.print(arr[i]+",");
            }else{
                System.out.print(arr[i]+"]");
            }
        }
        Scanner s=new Scanner(System.in);
        int num=s.nextInt(100);
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(26);
        list.add(45);
        list.add(60);
        list.add(78);
        list.add(99);
        for(int i=0;i<list.size();i++){
            if (num<=list.get(i)){
                list.add(num,i+1);
            }
            }
        System.out.println("修改后的数组：");
        System.out.println("[");
            for(int i=0;i<list.size();i++){
            if(i!=list.size()-1){
                System.out.print(list.get(i)+",");
            }else{
                    System.out.print(list.get(i)+"]");
                }
            }
        }

    }
