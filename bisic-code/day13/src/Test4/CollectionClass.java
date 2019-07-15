package Test4;

import java.util.ArrayList;

public class CollectionClass {
    public static void main(String[] args) {
        ArrayList<Integer> al=new ArrayList<>();
        System.out.println(listTest(al,5));
    }
//    public static void main(String[] args) {
//        Collection<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("a");
//        list.add("b");
//        list.add("b");
//        list.add("c");
//        System.out.println("a:"+listTest(list, "a"));
//        System.out.println("b:"+listTest(list, "b"));
//        System.out.println("c:"+listTest(list, "c"));
//        System.out.println("xxx:"+listTest(list, "xxx"));
//    }
//    public static int listTest(Collection<String> list,String s){
//        Iterator<String> it=list.iterator();
//        int num=0;
//        while(it.hasNext()){
//            String str = it.next();
//            if(s.equals(str)){
//                num++;
//            }
//        }
//        return num;
//    }
//    public static List  arraylist(){
//        int[] arr={};
////
////    ArrayList<Integer> coll=new ArrayList<>();
////    for(int i:arr){
////    coll.add(i);
////}
////return coll;
//        List<int[]> ints = Arrays.asList(arr);
////        return ints;
//    }
//    public static Object[] arraylist(){
//        Collection<Integer> coll=new ArrayList<>();
//        Object[] arr=coll.toArray();
//        System.out.println(arr);
//        return arr;
//    }

public static int listTest(ArrayList<Integer> al,Integer s){
    int i = al.indexOf(s);
    return i;
}
}
