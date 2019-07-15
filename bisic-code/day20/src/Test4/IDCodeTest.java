package Test4;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class IDCodeTest {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> list=new ArrayList<>();
        list.add(sc.next());
        list.add(sc.next());
        list.add(sc.next());
        BufferedWriter bw=new BufferedWriter(new FileWriter("day20\\src\\data.txt"));
        for (String s : list) {
            bw.write(s);
           bw.newLine();
        }
       bw.close();
        System.out.println("请输入验证码：");
        String str = sc.next();
        BufferedReader br=new BufferedReader(new FileReader("day20\\src\\data.txt"));
        String line;
        boolean b;
        while((line=br.readLine())!=null){
            b = str.equals(line);

        }
        if (b=true){
            System.out.println("验证成功");
        }else{

        }

        br.close();




    }
}
