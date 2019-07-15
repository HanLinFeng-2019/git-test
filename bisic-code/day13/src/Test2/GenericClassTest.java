package Test2;

public class GenericClassTest {
    public static void main(String[] args) {
        GenericClass<String> ge=new GenericClass<>();
        ge.setName("张三丰");
        String name = ge.getName();
        System.out.println(name);

        GenericClass<Integer> ge1=new GenericClass<>();
        ge1.setName(11);
        Integer name1 = ge1.getName();
        System.out.println(name1);

    }
}
