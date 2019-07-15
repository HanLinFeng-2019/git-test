package Test9;

public class RunnableImp implements Runnable {
    private int num=1;
    Object obj=new Object();
    @Override
    public void run() {
        if(num<=10){
            synchronized (obj){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+"第"+num+"个通过山洞");
                num++;
            }
        }
    }



}

