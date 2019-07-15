package Test10;

import Test4.RunnableImpl;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {
    public static void main(String[] args) {
        ExecutorService es= Executors.newFixedThreadPool(2);
        RunnableImpl run= new RunnableImpl();
        es.submit(run,"11");
        es.submit(run,"22");

    }
}
