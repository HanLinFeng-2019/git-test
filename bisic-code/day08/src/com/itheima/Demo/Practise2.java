package com.itheima.Demo;

import java.util.ArrayList;

public class Practise2 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};

        ArrayList<String> result =new ArrayList<>();
        result= fromArrayToString(array);
        System.out.println(result);
    }
    public static ArrayList fromArrayToString(int[] array ) {
        ArrayList<String> str =new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                str.add("word" + array[i] );
            } else {
                str.add("word" + array[i] + "#");
            }
        }
        return str;
    }
}
