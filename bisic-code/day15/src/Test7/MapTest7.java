package Test7;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest7 {
    public static void main(String[] args) {
        String[] str1={"黑龙江省","浙江省","江西省","广东省","福建省"};
        String[] str2={"哈尔滨","杭州","南昌","广州","福州"};
        Map<String,String> map=new HashMap<>();
        for(int i=0;i<str1.length;i++){
            for(int j=i;j<str2.length;j++){
                String key = str1[i];
                String value = str2[i];
                map.put(key,value);
            }
        }
        System.out.println(map);
        
    }
}
