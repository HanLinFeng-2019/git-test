package Test9;

public class Demo02 {
    public static void showlog(int level,MessageReceive mr){
        if(level==1){
            System.out.println(mr.method());
        }
    }



    public static void main(String[] args) {

        String msg1="hello";
        String msg2="world";
        String msg3="java";

        showlog(2,()->msg1+msg2+msg3);
    }
}
