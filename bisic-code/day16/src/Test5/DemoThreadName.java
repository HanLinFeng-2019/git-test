package Test5;

public class DemoThreadName {
    public static void main(String[] args) {
        RunnableName run=new RunnableName();
        Thread name=new Thread(run,"thread");
        name.start();
        for(int i=0;i<5;i++){
            System.out.println("主线程执行"+i);
        }
    }
}
