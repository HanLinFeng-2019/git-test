package Test6;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest6 {
    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"张三丰");
        map.put(2,"周芷若");
        map.put(3,"汪峰");
        map.put(4,"灭绝师太");
        Set<Integer> set = map.keySet();
        for(Integer key:set){
            String value = map.get(key);
            System.out.println(key+"="+value);
        }
        map.put(5,"李晓红");
        String str = map.remove(1);
        map.put(2,"周林");
        System.out.println(map);

    }

}
