package Test9;

import java.util.*;

public class WorldCup {
    public static void main(String[] args) {

//        Map<String, String> map = Map.of("1930年", "乌拉圭", "1934年", "意大利","1938年","意大利",
//                "1950年","乌拉圭","1954年","西德","1958年","巴西","1962年","巴西",
//                "1966年","英格兰","1970年","巴西","1974年","西德");
        Map<String,String> map=new LinkedHashMap<>();
        String[] arr1={"1930","1934","1938","1950","1954","1958","1962","1966","1970","1974","1978",
                "1982","1986","1990","1994","1998","2002","2006","2010","2014"};
        String[] arr2={"乌拉圭","意大利","意大利","乌拉圭","西德","巴西","巴西","英格兰","巴西","西德","阿根廷","意大利",
                "阿根廷","西德","巴西","法国","巴西","意大利","西班牙","西德"};
        for(int i=0;i<arr1.length;i++){
            String key=arr1[i];
            String value=arr2[i];
            map.put(key,value);
        }

        System.out.println(map);
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个年份：");
        String years = sc.next();
        boolean b = map.containsKey(years);
        if(b){
            System.out.println("夺冠的球队是："+map.get(years));
        }else{
            System.out.println("没有举办世界杯");
        }
        while(true){
            System.out.println("请输入要球队名字：");
            String team=sc.next();
            Set<Map.Entry<String, String>> entry = map.entrySet();
            if(map.containsValue(team)){
                for(Map.Entry e:entry){
                    if(e.getValue().equals(team)){
                        System.out.println(e.getKey());
                    }
                }
            }else{
                System.out.println("没有获得过世界杯 ");
            }
        }

    }
}
