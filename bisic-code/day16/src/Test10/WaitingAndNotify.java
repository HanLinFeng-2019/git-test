package Test10;

import com.sun.source.tree.SynchronizedTree;

public class WaitingAndNotify {
    public static void main(String[] args) {
        Object obj=new Object();

        new Thread(){
            @Override
            public void run() {
                while(true){
                    synchronized(obj){
                        System.out.println("告知老板做什么包子");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("开始吃包子");
                        System.out.println("========================================");
                    }
                }
            }
        }.start();


        new Thread(){
            @Override
            public void run() {
               while(true){
                   try {
                       Thread.sleep(5000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   synchronized (obj){
                       System.out.println("包子做好了，告知顾客");
                       obj.notify();
                   }
               }
            }
        }.start();
    }
}
