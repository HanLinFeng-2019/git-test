package Test7;

public class DemoRunnable01 {
    public static void main(String[] args) {

        new Thread(new RunnableImp(){
            @Override
            public void run() {
                while(true){
                    System.out.println("显示画面");
                }

            }
        }).start();



            System.out.println("播放背景音乐");

    }
}
