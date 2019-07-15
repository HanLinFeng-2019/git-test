package Demo02;


import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) {
//        int[] src={1,2,3,4,5,6};
//        int[] dest={4,5,6,7,8,9};
//        System.out.println("复制前："+ Arrays.toString(dest));
//        System.arraycopy(src,0,dest,0,3);
//        System.out.println("复制后："+Arrays.toString(dest));
        char[] arr={'i','t','c','a','s','a'};
        char[] arr2={'t'};
        System.arraycopy(arr2,0,arr,5,1);
        System.out.println("复制后："+ Arrays.toString(arr));

        System.out.println(arr);
        String str=new String(arr);
        System.out.println(str);
    }
}
