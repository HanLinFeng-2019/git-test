package cn.itcast.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Set;

public class jedisTest {







    @Test
    public void ListTest4(){
        //获取连接
        Jedis jedis = new Jedis();//无参 默认连接本地数据库
        //操作
        //存储
        jedis.lpush("mylist","a","b");
        jedis.rpush("mylist","a","b");

        //范围获取
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);
        //list弹出
    }

    @Test
    public void SetTest(){
        Jedis jedis = new Jedis();

        jedis.sadd("myset","java","php");



    }
    @Test
    public void SortedSetTest(){
        Jedis jedis = new Jedis();

        jedis.zadd("mysortedset",3,"亚瑟");
        jedis.zadd("mysortedset",30,"后羿");
        jedis.zadd("mysortedset",25,"孙悟空");

        Set<String> mysortedset = jedis.zrange("mysortedset", 0, -1);
        jedis.zrangeWithScores("mysortedset", 0, -1);
        System.out.println(mysortedset);

    }

    @Test
    public void JedisPoolTest(){
        //创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(10);
        config.setMaxTotal(50);

        //1.创建jedis连接池对象
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);
        //获取连接
        Jedis jedis = jedisPool.getResource();
        //使用
        jedis.set("","");
        jedis.close();
    }
}
