package Test5;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest5 {
    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("奔驰",5000);
        map.put("宝马",6000);
        map.put("吉利",8000);
        System.out.println(map);
        //keySet方法遍历键值对
        Set<String> set = map.keySet();
        for(String key:set){
            Integer value = map.get(key);
            System.out.println(key+"="+value);
        }
        System.out.println("==============================");
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        for (Map.Entry Entry:entry){
            Object key = Entry.getKey();
            Object value = Entry.getValue();
            System.out.println(key+"="+value);
        }
    }
}
