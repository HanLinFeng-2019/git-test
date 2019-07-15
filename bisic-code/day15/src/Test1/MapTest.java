package Test1;

import java.util.HashMap;
import java.util.Scanner;

public class MapTest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输出字符串：");
        String str = sc.next();
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:str.toCharArray()){
            if(map.containsKey(c)){
                Integer value = map.get(c);
                value++;
                map.put(c,value);
            }else{
                map.put(c,1);
            }

        }
        System.out.println(map);
    }
}
