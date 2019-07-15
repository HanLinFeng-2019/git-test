package Demo02;

public class Test11 {
    public static void main(String[] args) {
        String[] arr = {"7", "8", "9"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for(int j=0;j < arr.length;j++){
                for(int k=0;k < arr.length;k++){
                    if(i!=j&&j!=k&&k!=i){
                        sb.append(arr[i]);

                    }
                }
            }

        }
        System.out.println(sb);
    }
}