package Test1;

public class LamdaTest {
    public static void main(String[] args) {

        invokeCookMaker(()->{
            System.out.println("吃饭了");
        });
    }
    public static void invokeCookMaker(CookMaker cookmaker){
        cookmaker.makefood();
    }
}
