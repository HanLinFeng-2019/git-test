package Test6;

import java.util.HashSet;

public class HumanTest {
    public static void main(String[] args) {
        HashSet<Human> set=new HashSet();
        Human h1=new Human("盖伦",28);
        Human h2=new Human("拉克丝",25);
        Human h3=new Human("盖伦",28);
        Human h4=new Human("蛮王",30);
        set.add(h1);
        set.add(h2);
        set.add(h3);
        set.add(h4);
        System.out.println(set);
    }
}
