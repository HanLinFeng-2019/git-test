package Test10;

public class BaoZiMaker extends Thread {
    private BaoZi bz;

    public BaoZiMaker(BaoZi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int count=1;
        synchronized (bz){
            if(count%2==0){
                bz.pi="薄皮";
                bz.xian="三鲜馅";
            }else{
                bz.pi="冰皮";
                bz.xian="大葱馅";
            }
            System.out.println(bz.pi+bz.xian+"的包子已经做好了");
        }
        bz.flag=true;
        bz.notify();
        System.out.println("");

    }
}
