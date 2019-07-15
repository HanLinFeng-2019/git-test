package Demo02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) throws ParseException {
        Date date=new Date();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你的生日(按照如下格式XXXX/XX/XX)：");
        String birthday=sc.next();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
        Date time=sdf.parse(birthday);
        time.getTime();
        long longtime=date.getTime()-time.getTime();
        System.out.println("在这个世界上已经活了"+longtime/1000/60/60/24);


    }
}
