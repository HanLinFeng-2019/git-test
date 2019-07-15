package Test9;

public class DemoPerson {
    public static void main(String[] args) {
        RunnableImp run=new RunnableImp();
    for(int i=1;i<=10;i++){
        Thread t=new Thread(run,"p"+i);
        t.start();
    }
    }
}
