package array;

public class Beautiful {
    public static void main(String[] args) {
        int[] array = {5, 15, 2000, 10000, 100, 4000};
        int beautiful = array[0];
        int ungly = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > beautiful) {
                beautiful = array[i];
            }
        }
        System.out.println("美的是：" + beautiful);
        for (int i = 0; i < array.length; i++) {
            if (array[i] < ungly) {
                ungly = array[i];
            }
        }
        System.out.println("丑的是：" + ungly);
        for (int min = 0; min <=array.length-1; min++) {
            for (int max = array.length - 1; max >= 0; max--) {
                if (max > min) {
                    int temp = array[min];
                    array[min] = array[max];
                    array[max] = temp;
                }
            }
        }
        for (int min = 0; min < array.length; min++) {
            System.out.println(array[min]);
        }
    }
}