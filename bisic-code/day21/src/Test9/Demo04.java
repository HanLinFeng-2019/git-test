package Test9;

import java.util.function.Supplier;

public class Demo04 {

    public static int getMax(Supplier<Integer> sup){
        return sup.get();
    }

    public static void main(String[] args) {
        int[] arr={1000,0,20,80,99,36,9999};
        int max1 = getMax(() -> {
            int max = arr[0];
            for (int i : arr) {
                if (i > max) {
                    max = i;
                }
            }
            return max;
        });
        System.out.println("最大值为："+max1);
    }
}
