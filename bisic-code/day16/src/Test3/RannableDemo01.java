package Test3;

public class RannableDemo01 {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
               for(int i=0;i<100;i++){
                   System.out.println("Hello"+i);
               }
            }
        }.start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    System.out.println("World"+i);
                }
            }
        }).start();
    }

}
