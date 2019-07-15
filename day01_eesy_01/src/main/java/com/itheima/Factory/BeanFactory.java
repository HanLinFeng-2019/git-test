package com.itheima.Factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 创建一个Bean对象的工厂
 * 它是创建我们的Service和Dao对象的。
 * 第一:,配置的内容：唯一标识=全限定类名（key=value）
 * 第二：通过读取配置文件中配置的内容，反射创建对象
 * 配置文件可以是xml也可以是properties
 */
public class BeanFactory {
//定义一个properties对象
    private static Properties props;
    //定义一个Map,用于存放我们要创建的对象，我们把他称之为容器
    private static Map<String,Object> beans;
    //使用静态代码块为properties对象赋值
    static{
        try {
            //实例化对象
            props=new Properties();
            //获取properties文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            //实例化容器
            beans = new HashMap<String,Object>();
            //取出配置文件所有的key
            Enumeration keys = props.keys();
            //遍历枚举
            while(keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取value(配置文件中的全类名)
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器中
                beans.put(key,value);
            }

        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败！");
        }
    }

    public static Object getBean(String beanName){
        return beans.get(beanName);
    }
    /**
     * 根据bean的名称获取bean对象
     *
     */
//    public static Object getBean(String beanName){
//        Object bean = null;
//        try {
//            String beanPath = props.getProperty(beanName);
//            System.out.println(beanPath);
//            bean = Class.forName(beanPath).newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return bean;
//    }

}
