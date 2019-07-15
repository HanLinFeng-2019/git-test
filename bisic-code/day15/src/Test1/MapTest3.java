package Test1;

import java.util.HashMap;

public class MapTest3 {
    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("张三",18);
        map.put("李四",20);
        map.put("王五",30);
        map.put("张三",20);
        System.out.println(map);
        Integer Z = map.remove("张三");
        System.out.println("Z:"+Z);
        System.out.println(map);
        Integer i2 = map.get("张三");
        System.out.println(i2);
        map.get("李四");
        System.out.println(map.get("李四"));
    }
}
