package cn.itcast.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Lenovo lenovo = new Lenovo();

        SaleComputer proxy_lenovo = (SaleComputer)Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName());
                System.out.println(args[0]);

                if (method.getName().equals("sale")) {
                    //1.增强参数
                    double money = (double) args[0];

                    //使用真是对象调用该方法


                    //增强返回值
                }


                return null;
            }
        });

        proxy_lenovo.show();
    }
}
