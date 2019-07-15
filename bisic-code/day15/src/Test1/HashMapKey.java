package Test1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapKey {
    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("杨幂",20);
        map.put("黄渤",30);
        map.put("刘德华",40);
//        Set<String> set = map.keySet();
//        Iterator<String> it = set.iterator();
//        while(it.hasNext()){
//            String key = it.next();
//            Integer value = map.get(key);
//            System.out.println(key+"="+value);
//        }
        System.out.println(map);
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        Iterator<Map.Entry<String, Integer>> it = set.iterator();
        while(it.hasNext()){
            Map.Entry<String, Integer> entry = it.next();
            System.out.println(entry);
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+"="+value);
        }
    }

}
