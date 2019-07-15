package Test10;
/*
2.在测试类中定义static void showLongTime(CurrentTimePrinter timePrinter)，该方法的预期行为是使用timePrinter打印系统当前毫秒值
测试showLongTime(),通过lambda表达式完成需求
 */
public class InterfaceTest {
    public static void main(String[] args) {


        showLongTime(new CurrentTimePrinter() {
            @Override
            public void printCurrentTime() {
                System.out.println("当前系统毫秒值为："+System.currentTimeMillis());
            }
        });

        showLongTime(()->{System.out.println("当前系统毫秒值为："+System.currentTimeMillis());});

        showLongTime(()->System.out.println("当前系统毫秒值为："+System.currentTimeMillis()));

    }


    public static void showLongTime(CurrentTimePrinter timePrinter){
        timePrinter.printCurrentTime();
    }
}
