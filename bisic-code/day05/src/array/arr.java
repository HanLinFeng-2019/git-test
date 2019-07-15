package array;

public class arr {
    public static void main(String[] args) {
        int[] array={5,15,2000,10000,100,4000};
        for(int min=0;min<array.length/2;min++) {
            int temp = array[min];
            array[min] = array[array.length - 1 - min];
            array[array.length - 1 - min] = temp;
        }
        for(int min=0;min<array.length;min++){
            System.out.println(array[min]);
        }
    }
}
