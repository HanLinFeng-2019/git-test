package Test9;

import java.util.function.Consumer;

public class Demo05 {
    public static void method(String[] arr,Consumer<String> con1,Consumer<String> con2){
        for (String message : arr) {
            con1.andThen(con2).accept(message);
        }

    }

    public static void main(String[] args) {
        String[] arr={"迪丽热巴,女","古力娜扎,男","周爽里,公"};
      method(arr,message->{
          String name = message.split(",")[0];
          System.out.print("姓名："+name);
      },message->{
          String age = message.split(",")[1];
          System.out.println("。性别："+age+"。");
      });
    }
}
