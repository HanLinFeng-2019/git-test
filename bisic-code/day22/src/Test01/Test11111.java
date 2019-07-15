package Test01;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Test11111 {
    public static void main(String[] args) {
        ArrayList<String> one=new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");
        ArrayList<String> two=new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古莱是找死");
        two.add("张天爱");
        two.add("张二狗");
        Stream<String> stream1 = one.stream();
        Stream<String> stream2 = stream1.filter(name -> name.length() == 3);
        Stream<String> stream3 = stream2.limit(3);

        Stream<String> stream4 = two.stream();
        Stream<String> stream5 = stream4.filter(name -> name.startsWith("张"));
        Stream<String> stream6 = stream5.skip(2);
        Stream<String> concat = Stream.concat(stream3, stream6);
        Person p=new Person();
        concat.forEach(name->p.setName(name));
        p.getName();




    }
}
