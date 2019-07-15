package Test01;

import java.util.*;
import java.util.stream.Stream;

public class Stream1 {
    public static void main(String[] args) {
//        List<String> list=new ArrayList<>();
//        Stream<String> stream1 = list.stream();
//
//        Set<String> set=new HashSet<>();
//        Stream<String> stream2 = set.stream();
//
//        Map<String,String> map=new HashMap<>();
//        Set<String> keySet = map.keySet();
//        Stream<String> stream3 = keySet.stream();

//
//        String[] arr={"张三","李四","王五","赵六","刚黄"};
//        Stream<String> stream9 = Stream.of(arr);
////        stream9.forEach(name->System.out.println(name));
//        Stream<String> stream10 = stream9.filter((String name) -> {
//            return name.startsWith("张");
//        });
//        stream10.forEach((name)-> System.out.println(name));

        Stream<String> stream = Stream.of("4", "5", "6", "7", "9");
//        Stream<Integer> stream2 = stream.map(s -> Integer.parseInt(s));
//        stream2.forEach(i-> System.out.println(i));
        Stream<String> limit = stream.limit(4);
        limit.forEach(i-> System.out.println(i));
//“冯蘅”,“郭靖”,“黄蓉”,“郭芙”,“郭破虏”
//        stream.map(s->Integer.parse1Int(s)).forEach(i-> System.out.println(i));
        String[] arr={"黄药师","冯蘅","郭靖","黄蓉","郭芙","郭破虏"};
        Stream<String> stream1 = Stream.of(arr);
        stream1.filter((i)->i.startsWith("郭"));

    }
}
