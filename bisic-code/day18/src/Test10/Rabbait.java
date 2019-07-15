package Test10;

public class Rabbait {
    public static void main(String[] args) {
        int m=24;
        int s=sum(m);
        System.out.println("第"+m+"个月的兔子对数为："+s);
    }

    private static int sum(int m) {

            if(m==1||m==2){
                return 1;
            }
            return sum(m-1)+sum(m-2);
        }


}
