package Test5;

public class RunnableName implements Runnable {

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println("子线程执行"+i);
        }

    }

}
