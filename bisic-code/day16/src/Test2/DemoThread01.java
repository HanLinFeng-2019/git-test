package Test2;

public class DemoThread01 {
    public static void main(String[] args) {
        ThreadZi tz=new ThreadZi();
        tz.start();
        for(int j=0;j<20;j++){
            System.out.println("j:"+j);
        }
    }
}
