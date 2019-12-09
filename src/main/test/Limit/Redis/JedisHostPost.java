package Limit.Redis;

import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis集群配置
 */
public class JedisHostPost {
    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

    JedisClusterFactory jedisClusterFactory = new JedisClusterFactory();

    String HostPost1 = "172.17.46.11:36379";
    String HostPost2 = "172.17.46.11:36381";
    String HostPost3 = "172.17.45.12:36379";
    String HostPost4 = "172.17.45.12:36381";
    String HostPost5 = "172.17.45.13:36379";
    String HostPost6 = "172.17.45.13:36381";

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
