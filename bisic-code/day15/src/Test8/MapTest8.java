package Test8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapTest8 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("abc");
        list.add("bcd");
        System.out.println(list);
        HashMap<Character,Integer> map=new HashMap<>();
        for(String str:list){
            char[] arr= str.toCharArray();

            for(Character c:arr){
                Integer num = map.get(c);
                if(num==null){
                    map.put(c,1);
                }else{
                    map.put(c,num+1);
                }
            }
        }
        System.out.println(map);
    }
}
