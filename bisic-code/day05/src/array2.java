public class array2 {
    public static void main(String[] args) {
        int[] array={5,15,30,20,10000};
        int max=array[0];
        for(int i=1;i<array.length;i++){
            if(array[i]>max){
                max=array[i];
            }
        }
        System.out.println("最大值"+max);
    }
}
