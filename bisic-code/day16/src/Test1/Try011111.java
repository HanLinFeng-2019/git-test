package Test1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Try011111 {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");

        try {
            Date date = format.parse("2018/04-03");
            System.out.println("程序正常");

        } catch (ParseException e) {
            System.out.println("程序异常");
        }

            }
        }

