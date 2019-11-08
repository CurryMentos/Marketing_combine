package Limit.Redis;

import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis集群配置
 */
public class JedisHostPost {
    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

    JedisClusterFactory jedisClusterFactory = new JedisClusterFactory();

    String HostPost1 = "xxx.xx.xx.x:36379";
    String HostPost2 = "xxx.xx.xx.x:36381";
    String HostPost3 = "xxx.xx.xx.x:36379";
    String HostPost4 = "xxx.xx.xx.x:36381";
    String HostPost5 = "xxx.xx.xx.x:36379";
    String HostPost6 = "xxx.xx.xx.x:36381";

    public JedisCluster getJedisCluster() {
        jedisClusterFactory.setGenericObjectPoolConfig(jedisPoolConfig);
        jedisClusterFactory.setAddress(HostPost1 + "," + HostPost2 + "," + HostPost3 + "," + HostPost4 + "," + HostPost5 + "," + HostPost6);
        jedisClusterFactory.setTimeout(100000);
        jedisClusterFactory.setMaxRedirections(5);
        JedisCluster jedisCluster = null;
        try {
            jedisClusterFactory.afterPropertiesSet();
            jedisCluster = jedisClusterFactory.getObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jedisCluster;
    }
}
