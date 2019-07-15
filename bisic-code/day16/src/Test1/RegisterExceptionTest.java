package Test1;

import java.util.Scanner;

public class RegisterExceptionTest {
    static String[] usernames={"张三","李四","王五"};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要注册的用户名：");
        String username=sc.next();
        checkUsername(username);

    }
    public static void checkUsername(String username){
        for(String name:usernames){
            if(name.equals(username)){
                try{
                    throw new RegisterException("亲，该用户名已被注册");
                }catch(RegisterException e){
                    e.printStackTrace();
                    return;
                }
            }
        }
        System.out.println("恭喜您，注册成功");
    }
}
