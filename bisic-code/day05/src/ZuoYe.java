public class ZuoYe {
    public static void main(String[] args){
        int[] score={80,90,85,90,78,88,89,93,98,75};
        int num=0;
        for(int i=0;i<score.length;i++){
            if( score[i]<60){
                num++;
            }
        }
        System.out.println(num);
        double add=0;
        for(int i=0;i<score.length;i++){
            add+=score[i];
        }
        System.out.println(add/score.length);
        System.out.println(add);
    }
}


