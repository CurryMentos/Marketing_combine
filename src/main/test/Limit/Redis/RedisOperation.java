package Limit.Redis;
/**
 * xx.com.cn Inc.
 * Copyright (c) 2011-2017 All Rights Reserved.
 */

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * redis接口
 *
 * @author CJY
 * @version Id: RedisManager.java, v 0.1 2016/7/17 16:59 CJY Exp $$
 */
@Slf4j
@Service
public class RedisOperation {
    /**
     * redis集群操作类
     */
    JedisCluster jedisCluster;


    public boolean setnx(String key, Object value, int timeout) {

        if (key == null || value == null) {
            return false;
        }
        //Redis设值
        String valueStr = JSONObject.toJSONString(value);
        jedisCluster.setnx(key, valueStr);
        if (timeout > 0) {
            jedisCluster.expire(key, timeout);
        }else{
            jedisCluster.expire(key, TimeEnum.DAY.getCode());
        }
        return true;
    }

//    @Autowired
//    @Lazy
//    private RedissonClient redissonClient;

    /**
     * 根据redisKey删除对应的redis缓存的key
     *
     * @param keys redisKeys
     * @return 删除的键数
     */
    public Long delete(String... keys) {

        Long count = 0L;
        for (String key : keys) {
            if (StringUtils.isNotBlank(key)) {
                count += jedisCluster.del(key);
            }
        }
        return count;
    }

    /**
     * 根据redisKey删除对应的redis缓存的key
     *
     * @param keys redisKeys
     * @return 删除的键数
     */
    public Long delete(Set<String> keys) {

        if (keys == null) {
            return 0L;
        }
        Long count = 0L;
        for (String key : keys) {
            if (StringUtils.isNotBlank(key)) {
                count += jedisCluster.del(key);
            }
        }
        return count;
    }

    /*--------------------------------- redis-string-start  ---------------------------------*/

    /**
     * 插入redis数据库,设置有效期，数据类型key-value形式
     *
     * @param key     redisKey
     * @param value   保存对象，转换为JSON格式存放
     * @param timeout 有效期（秒），默认为24小时；
     * @return true-插入成功，false-插入失败
     */
    public boolean set(String key, Object value, int timeout) {

        if (key == null || value == null) {
            return false;
        }
        //Redis设值
        String valueStr = JSONObject.toJSONString(value);
        jedisCluster.set(key, valueStr);
        if (timeout > 0) {
            jedisCluster.expire(key, timeout);
        } else {
            jedisCluster.expire(key, TimeEnum.DAY.getCode());
        }
        return true;
    }

    /**
     * 根据key，查询string-value值
     *
     * @param key   redisKey
     * @param clazz 格式化的类信息
     * @param <T>   泛型参数
     * @return 查询结果
     */
    public <T> T get(String key, Class<T> clazz) {

        if (key == null || clazz == null) {
            return null;
        }
        T result = JSONObject.parseObject(jedisCluster.get(key), clazz);
        return result;
    }

    /**
     * 校验key 是否存在
     */
    public boolean exists(String key) {
        Boolean keyResult = jedisCluster.exists(key);
        return keyResult;
    }

    /**
     * 累加
     *
     * @param key
     * @return
     */
    public Long incrBy(String key, long delta) {
        return jedisCluster.incrBy(key, delta);
    }


//    /**
//     * @param key 具体键值
//     * @return 锁对象
//     */
//    public RLock getLock(String key) {
//        return redissonClient.getLock(key);
//    }
    /*--------------------------------- redis-string-end  ---------------------------------*/

    /*--------------------------------- redis-set-start  ---------------------------------*/

    /**
     * 判断在key的set集中是否包含元素value
     *
     * @param key   redisKey
     * @param value 集合元素
     * @return true-包含；false-不包含
     */
    public boolean isSetMember(String key, String value) {

        if (key == null || value == null) {
            return false;
        }
        return jedisCluster.sismember(key, value);
    }

    /**
     * 查询指定set中元素个数
     *
     * @param key redis-key
     * @return 元素个数
     */
    public Long setCard(String key) {

        if (key == null) {
            return 0L;
        }
        return jedisCluster.scard(key);
    }

    /**
     * 删除指定的key值的set中的元素
     *
     * @param key   set的key
     * @param value 元素set列表
     * @return 新增元素的个数
     */
    public Long removeSet(String key, String value) {

        if (key == null || value == null) {
            return 0L;
        }
        return jedisCluster.srem(key, value);
    }

    /**
     * 向指定的key值的set中添加元素
     *
     * @param key    set的key
     * @param values 元素数组
     * @return 新增元素的个数
     */
    public Long addSet(String key, String... values) {

        if (key == null || values == null) {
            return 0L;
        }
        Long result = jedisCluster.sadd(key, values);
        jedisCluster.expire(key, TimeEnum.DAY.getCode());
        return result;
    }

    /**
     * 向指定的key值的set中添加元素
     *
     * @param key    set的key
     * @param time   超时时间
     * @param values 元素数组
     * @return 新增元素的个数
     */
    public Long addSet(String key, Integer time, String... values) {

        if (key == null || values == null) {
            return 0L;
        }
        Long result = jedisCluster.sadd(key, values);
        jedisCluster.expire(key, time);
        return result;
    }


    /**
     * 向指定的key值的set中添加元素
     *
     * @param key    set的key
     * @param values 元素数组
     * @return 新增元素的个数
     */
    public Long addSet(String key, Set<String> values) {

        return this.addSet(key, values, TimeEnum.DAY.getCode());
    }

    /**
     * 向指定的key值的set中添加元素
     *
     * @param key     set的key
     * @param values  元素数组
     * @param timeout 超时时间
     * @return 新增元素的个数
     */
    public Long addSet(String key, Set<String> values, Integer timeout) {

        if (key == null || values == null) {
            return 0L;
        }
        Long result = jedisCluster.sadd(key, values.toArray(new String[values.size()]));
        if (timeout > 0) {
            jedisCluster.expire(key, timeout);
        } else {
            jedisCluster.expire(key, TimeEnum.DAY.getCode());
        }
        return result;
    }

    /**
     * 获取set
     *
     * @param key
     * @return
     */
    public Set<String> getSet(String key) {

        if (key == null) {
            return new HashSet<>();
        }
        return jedisCluster.smembers(key);
    }

    /**
     * set中随机返回一个元素
     *
     * @param key redis set key
     * @return set中随机一个元素
     */
    public String getSetRand(String key) {

        if (key == null) {
            return null;
        }
        return jedisCluster.srandmember(key);
    }

    /*--------------------------------- redis-set-end  ---------------------------------*/

    /*--------------------------------- redis-Zset-start  ---------------------------------*/

    /**
     * 查询指定zset中元素个数
     *
     * @param key redis-key
     * @return 元素个数
     */
    public Long zsetCard(String key) {

        if (key == null) {
            return 0L;
        }
        return jedisCluster.zcard(key);
    }

    /**
     * 根据给定的分数范围查询Zset集合中的元素
     *
     * @param key        Zet的redisKey
     * @param startScore 起始分数
     * @param endScore   终止分数
     * @return 查询到的结果集
     */
    public Set<String> rangeZsetByScore(String key, Double startScore, Double endScore) {

        if (key == null || startScore == null || endScore == null) {
            return new HashSet<>();
        }
        return jedisCluster.zrangeByScore(key, startScore, endScore);
    }

    /**
     * 向redis的Zset集合中批量插入数据
     *
     * @param key    Zset的key值
     * @param values 录入的缓存数据
     * @return 录入的数据数量
     */
    public Long addZset(String key, Map<String, Double> values) {

        return this.addZset(key, values, null);
    }

    /**
     * 向redis的Zset集合中批量插入数据
     *
     * @param key    Zset的key值
     * @param values 录入的缓存数据
     * @return 录入的数据数量
     */
    public Long addZset(String key, Map<String, Double> values, Integer timeout) {
        if (key == null || values == null || values.isEmpty()) {
            return 0L;
        }
        Long result = jedisCluster.zadd(key, values);
        if (timeout != null && timeout >= 0) {
            jedisCluster.expire(key, timeout);
        } else {
            jedisCluster.expire(key, TimeEnum.DAY.getCode());
        }
        return result;
    }

    /*--------------------------------- redis-Zset-end  ---------------------------------*/

    /*--------------------------------- redis-Hash-start  ---------------------------------*/

    /**
     * 向指定的key值的Map中添加元素
     *
     * @param key    hash的key
     * @param values 元素数组
     * @return 新增元素的个数
     */
    public Boolean addHash(String key, Map<String, String> values) {
        return this.addHash(key, values, null);
    }

    /**
     * 向指定的key值的Map中添加元素
     *
     * @param key     hash的key
     * @param values  元素数组
     * @param timeout 超时时间
     * @return 新增元素的个数
     */
    public Boolean addHash(String key, Map<String, String> values, Integer timeout) {

        if (key == null || values == null || values.isEmpty()) {
            return false;
        }
        jedisCluster.hmset(key, values);
        if (timeout != null && timeout >= 0) {
            jedisCluster.expire(key, timeout);
        } else {
            jedisCluster.expire(key, TimeEnum.DAY.getCode());
        }
        return true;
    }

    /**
     * 获取hash value
     *
     * @param key   hashKey
     * @param field haskField
     * @return hash value
     */
    public String getHash(String key, String field) {

        if (key == null || field == null) {
            return null;
        }
        return jedisCluster.hget(key, field);
    }

    /**
     * 获取哈希表中字段的数量
     *
     * @param key hashKey
     * @return 哈希表中字段的数量
     */
    public Long getHashLen(String key) {

        if (key == null) {
            return null;
        }
        return jedisCluster.hlen(key);
    }

    /**
     * 获取hash全部数据
     *
     * @param key 缓存key
     * @return hash表中全部数据
     */
    public Map<String, String> getHashWeightAll(String key) {

        if (key == null) {
            return Collections.emptyMap();
        }
        return jedisCluster.hgetAll(key);
    }

    /**
     * 判断hash表中是否有指定field
     *
     * @param key   hashKey
     * @param field hashField
     * @return 哈希表是否有指定field
     */
    public Boolean hashExist(String key, String field) {

        if (key == null) {
            return false;
        }
        return jedisCluster.hexists(key, field);
    }
    /*--------------------------------- redis-Hash-end  ---------------------------------*/
}
