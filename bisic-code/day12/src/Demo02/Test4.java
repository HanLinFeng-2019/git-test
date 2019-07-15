package Demo02;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test4 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c);
        //操作单独的年月日(2018年2月14日)
        c.set(2018,2,14);
        Date date=c.getTime();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
        String time=sdf.format(date);
        System.out.println(time);


        int w=c.get(Calendar.DAY_OF_WEEK);
        System.out.println(w);
        }

    }

