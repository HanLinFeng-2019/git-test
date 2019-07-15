package Test4;

import Test3.RunnableIMP;

public class DemoTicket {
    public static void main(String[] args) {
        RunnableImpl run=new RunnableImpl();
        Thread t0=new Thread(run);
        Thread t1=new Thread(run);
        Thread t2=new Thread(run);
        t0.start();
        t1.start();
        t2.start();
    }
}
