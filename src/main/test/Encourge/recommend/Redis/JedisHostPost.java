package Encourge.recommend.Redis;

import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis集群配置
 */
public class JedisHostPost {
    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

    JedisClusterFactory jedisClusterFactory = new JedisClusterFactory();

    String HostPost = "172.17.46.11:26379";

    public JedisCluster getJedisCluster() {
        jedisClusterFactory.setGenericObjectPoolConfig(jedisPoolConfig);
        jedisClusterFactory.setAddress(HostPost);
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
