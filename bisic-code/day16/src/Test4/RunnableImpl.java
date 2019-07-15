package Test4;

public class RunnableImpl  implements Runnable{
    private int ticket=100;
    private String str="你好";

    @Override
    public void run() {
        while(true){
            synchronized (str){
                if(ticket>0){

                    try{
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+"-->正在售卖"+ticket+"张票");
                    ticket--;
                }
            }
        }
    }
}
