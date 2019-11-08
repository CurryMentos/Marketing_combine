/**
 * xx.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package Limit.Redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * jedis集群工厂
 *
 * @author huangning
 * @version Id: JedisClusterFactory.java, v 0.1 2018/9/19 15:42 huangning Exp $$
 */
public class JedisClusterFactory implements FactoryBean<JedisCluster>, InitializingBean {

    /**
     * ip:port
     */
    private String address;

    /**
     * Redis客户端
     */
    private JedisCluster jedisCluster;

    /**
     * 超时时间
     */
    private Integer timeout;

    /**
     * 重试次数
     */
    private Integer maxRedirections;

    /**
     * 连接池
     */
    private GenericObjectPoolConfig genericObjectPoolConfig;

    /**
     * 检测ip正则表达式
     */
    private Pattern p = Pattern.compile("^.+[:]\\d{1,5}\\s*$");

    @Override
    public JedisCluster getObject() throws Exception {
        return jedisCluster;
    }

    @Override
    public Class<? extends JedisCluster> getObjectType() {
        return this.jedisCluster != null ? this.jedisCluster.getClass() : JedisCluster.class;
    }

    /**
     * 是否单例
     *
     * @return true 单例
     */
    @Override
    public boolean isSingleton() {
        return true;
    }

    /**
     * 解析IP地址和端口
     *
     * @return IP地址和端口集合
     * @throws Exception
     */
    private Set<HostAndPort> parseHostAndPort() {
        try {

            String[] addresses = address.split(",");

            Set<HostAndPort> haps = new HashSet<>();

            for (String ad : addresses) {

                boolean isIpPort = p.matcher(ad).matches();

                if (!isIpPort) {
                    throw new IllegalArgumentException("ip 或 port 不合法");
                }

                String[] ipAndPort = ad.split(":");

                HostAndPort hap = new HostAndPort(ipAndPort[0], Integer.parseInt(ipAndPort[1]));
                haps.add(hap);
            }
            return haps;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Set<HostAndPort> haps = this.parseHostAndPort();

        jedisCluster = new JedisCluster(haps, timeout, maxRedirections, genericObjectPoolConfig);

    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMaxRedirections(int maxRedirections) {
        this.maxRedirections = maxRedirections;
    }

    public void setGenericObjectPoolConfig(GenericObjectPoolConfig genericObjectPoolConfig) {
        this.genericObjectPoolConfig = genericObjectPoolConfig;
    }

}
