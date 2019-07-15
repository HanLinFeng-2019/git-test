package Test1;

import java.util.HashMap;

public class HashSetmapTest {
    public static void main(String[] args) {
        HashMap<Person,String> map=new HashMap<>();
        map.put(new Person("女王",20),"英国");
        map.put(new Person("蛮王",30),"艾欧尼亚");
        map.put(new Person("盖伦",25),"德玛西亚");
        map.put(new Person("女王",20),"丹麦");
        System.out.println(map);
    }
}
