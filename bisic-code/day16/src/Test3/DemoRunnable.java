package Test3;

public class DemoRunnable {
    public static void main(String[] args) {
        RunnableIMP run=new RunnableIMP();
        Thread t=new Thread(run,"青钢影");
        t.start();

        for(int i=0;i<20;i++){
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }

    }
}
