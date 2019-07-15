package Test10;

public class Monkey {
    public static void main(String[] args) {
//       int s=sum(1);
//        System.out.println(s);
////        int add=1;
////        for(int i=1;i<10;i++){
////            add+=(add+1)*2;
////        }
////        System.out.println(add);
//    }

//    private static int sum(int day) {
//        if(day==10){
//            return 1;
//        }
// (x-2)/2+((x-2)/2-2)/2
//        return n+sum(n/2+1);
//        return 2 * sum(day + 1) + 2;
//        return n+sum(n-1);
        int day=1;
        int add=DiGui(day);
        System.out.println("第1天的桃子有："+add);
    }

    private static int DiGui(int day) {
        if(day==10){
            return 1;
        }
        return (DiGui(day+1)+1)*2;
    }
}
