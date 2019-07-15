package Demo02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    public static void main(String[] args) throws ParseException {
        Date now=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String T=sdf.format(now);
        System.out.println(T);

        System.out.println(now);
        long l=now.getTime();
        System.out.println(l);


        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str="1980年10月2日 12:20:59";
        Date date=df.parse("1980年10月2日 12:20:59");
        System.out.println(date);



    }
}
