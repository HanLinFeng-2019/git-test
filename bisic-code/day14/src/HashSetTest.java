import java.util.HashSet;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<Person> hash=new HashSet();
        Person p1=new Person("小美女",20);
        Person p2=new Person("小美女",20);
        Person p3=new Person("小美女",25);
        Person p4=new Person("小帅哥",20);

        hash.add(p1);
        hash.add(p2);
        hash.add(p3);
        hash.add(p4);
        System.out.println(hash);
    }
}
