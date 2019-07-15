package Test8;

public class MyRunnable implements Runnable {
        Object obj=new Object();
    @Override
    public void run() {
        synchronized(obj){
            System.out.println("我需要一个老师");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println("教我java,教完后，老师回到了办公室");
        }

        obj.notify();
    }
}
