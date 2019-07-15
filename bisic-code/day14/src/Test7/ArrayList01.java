package Test7;

import java.util.ArrayList;
import java.util.List;

public class ArrayList01 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("张三");//张三,李四,王五,二丫,钱六,孙七
        list.add("李四");
        list.add("王五");
        list.add("二丫");
        list.add("钱六");
        list.add("孙七");
        System.out.println(list);
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals("二丫")){
                list.set(i,"王小丫");
            }
        }
        System.out.println(list);
    }
}
