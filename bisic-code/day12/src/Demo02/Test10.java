package Demo02;

public class Test10 {

    public static void main(String[] args) {
        String[] arr={"010","3223","666","7890987","123123","1221"};
        int num=0;
            for(int i=0;i<arr.length;i++){
                StringBuilder sb = new StringBuilder(arr[i]).reverse();
                if(sb.toString().equals(arr[i])){
                    System.out.println(arr[i]);
                    num++;
                }else{
                    continue;
                }

            }
        System.out.println("该数组中对称字符串的个数:"+num);
    }
}
