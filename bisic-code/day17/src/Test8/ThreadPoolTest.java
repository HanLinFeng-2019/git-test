package Test8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(new MyRunnable(),"王老师");
        es.submit(new MyRunnable(),"李老师");

    }
}
