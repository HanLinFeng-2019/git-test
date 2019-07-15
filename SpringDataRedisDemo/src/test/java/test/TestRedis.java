package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-redis.xml")
public class TestRedis {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test1(){
        redisTemplate.boundHashOps("content").put("a","唐僧");
        redisTemplate.boundHashOps("content").put("b","沙僧");
        redisTemplate.boundHashOps("content").put("c","八戒");
    }
    @Test
    public void testGetKey(){
        Set content = redisTemplate.boundHashOps("content").keys();
        System.out.println(content);
    }
    @Test
    public void testGetValues(){
        List content = redisTemplate.boundHashOps("content").values();
        System.out.println(content);
    }
}
