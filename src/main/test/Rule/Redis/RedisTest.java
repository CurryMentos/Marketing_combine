package Rule.Redis;

import RedisHelp.impl.RedisHelp;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/9/29.
 */
public class RedisTest {
    static RedisHelp redisHelp = new RedisHelp("xxx.xx.xx.x", 26380);

    public static void getValue() {
        String key = "MARKETING_RULE_GROUP_CODE_KEY_" + "RGC37640558620450571123677";
        if (redisHelp.exists(key)) {
            System.out.println(key + "缓存是:" + redisHelp.get(key));
        } else {
            System.out.println("缓存不存在");
        }
    }

    public static void delValue() {
        String key = "MARKETING_RULE_GROUP_CODE_KEY_" + "RGC37640558620450571123677";
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

    public static void setValue() {
        String key = "MARKETING_RULE_GROUP_CODE_KEY_" + "";
        if (redisHelp.exists(key)) {
            System.out.println(key + "缓存是:" + redisHelp.get(key));
        } else {
            System.out.println("缓存不存在");
        }
        redisHelp.set(key, "THE_OLD_SYSTEM");
        System.out.println(key + "缓存更新:" + redisHelp.get(key));
    }

    @Test
    public static void getRedisValue() {
//        getValue();
//        setValue();
        delValue();
    }
}
