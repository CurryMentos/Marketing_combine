package Encourge.recommend.Redis;

import Encourge.recommend.CombineTest;
import Encourge.recommend.RecommendService;
import Encourge.recommend.Redis.JedisHostPost;
import RedisHelp.impl.RedisHelp;
import org.testng.annotations.Test;
import redis.clients.jedis.JedisCluster;

/**
 * Created by zengyouzu on 2019/9/29.
 */
public class RedisTest {
    //    static JedisHostPost jedisHostPost = new JedisHostPost();
//    static JedisCluster jedisCluster = jedisHostPost.getJedisCluster();
    static RecommendService recommendService = CombineTest.recommendService;
    static RedisHelp redisHelp = new RedisHelp("xxx.xx.xx.x", 26380);

    public static void getValue() {
//        String ToolId = recommendService.getToolId();
        String ToolId = "T30990190929163157000092";
        String key = "marketing-encourage" + ToolId;
        if (redisHelp.exists(key)) {
            System.out.println(key + "缓存是:" + redisHelp.get(key));
        } else {
            System.out.println("缓存不存在");
        }
    }

    public static void delValue() {
        String ToolId = recommendService.getToolId();
        String key = "marketing-encourage" + ToolId;
        if (redisHelp.exists(key)) {
            System.out.println(key + "缓存是:" + redisHelp.get(key));
            redisHelp.del(key);
            if (redisHelp.exists(key) == false) {
                System.out.println(key + "缓存已删除");
            } else {
                System.out.println("删除失败");
            }
        } else {
            System.out.println("缓存不存在");
        }
    }

    @Test
    public static void getRedisValue() {
        getValue();
    }
}
