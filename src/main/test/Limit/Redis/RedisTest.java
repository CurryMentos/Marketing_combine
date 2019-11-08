package Limit.Redis;

import org.testng.annotations.Test;
import redis.clients.jedis.JedisCluster;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zengyouzu on 2019/8/12.
 * redis操作类
 */
public class RedisTest extends RedisKey {
    public static Date now = new Date();
    public static String str1 = new SimpleDateFormat("yyyyMMdd").format(now);
    public static String str2 = new SimpleDateFormat("yyyyMM").format(now);
    public static String ActivityId = "A64734751130386265241217";
    public static String EquityId = "E48654740202838387285812";
    public static String ContralNo = "13103527617";
    public static String CustomerNo = "410700199107198519";
    public static String DeviceNo = "303";
    public static String MerchantNo = "3178002075650493";

    static JedisHostPost jedisHostPost = new JedisHostPost();
    static JedisCluster jedisCluster = jedisHostPost.getJedisCluster();


    /*public static JedisCluster RedisConfig() {
        RedisOperation ro = new RedisOperation();
        ro.jedisCluster = jedisCluster;
        return jedisCluster;
    }*/

    //********************redis方法********************
    //获取缓存
    public static void getValue(String redisKey) {
        String key = redisKey + "_" + EquityId;//权益
        String key1 = redisKey + "_" + str1 + "_" + ActivityId;//活动日维度
        String key2 = redisKey + "_" + str2 + "_" + ActivityId;//活动月维度
        String key3 = redisKey + "_" + ActivityId;//活动期间维度
        List<String> KeyList = new ArrayList<>();//每日用户
        KeyList.add(redisKey + "_" + ContralNo + "_" + str1 + "_" + ActivityId);
        KeyList.add(redisKey + "_" + CustomerNo + "_" + str1 + "_" + ActivityId);
        KeyList.add(redisKey + "_" + DeviceNo + "_" + str1 + "_" + ActivityId);
        KeyList.add(redisKey + "_" + MerchantNo + "_" + str1 + "_" + ActivityId);
        List<String> KeyList1 = new ArrayList<>();//每月用户
        KeyList1.add(redisKey + "_" + ContralNo + "_" + str2 + "_" + ActivityId);
        KeyList1.add(redisKey + "_" + CustomerNo + "_" + str2 + "_" + ActivityId);
        KeyList1.add(redisKey + "_" + DeviceNo + "_" + str2 + "_" + ActivityId);
        KeyList1.add(redisKey + "_" + MerchantNo + "_" + str2 + "_" + ActivityId);
        List<String> KeyList2 = new ArrayList<>();//活动期间用户
        KeyList2.add(redisKey + "_" + ContralNo + "_" + ActivityId);
        KeyList2.add(redisKey + "_" + CustomerNo + "_" + ActivityId);
        KeyList2.add(redisKey + "_" + DeviceNo + "_" + ActivityId);
        KeyList2.add(redisKey + "_" + MerchantNo + "_" + ActivityId);

        int i = 0;
        System.out.println("********************" + redisKey + "********************");
        if (jedisCluster.exists(key)) {
            System.out.println(key + "缓存是:" + jedisCluster.get(key));
        } else if (jedisCluster.exists(key1)) {
            System.out.println(key1 + "缓存是:" + jedisCluster.get(key1));
        } else if (jedisCluster.exists(key2)) {
            System.out.println(key2 + "缓存是:" + jedisCluster.get(key2));
        } else if (jedisCluster.exists(key3)) {
            System.out.println(key3 + "缓存是:" + jedisCluster.get(key3));
        } else if (jedisCluster.exists(KeyList.get(i))) {
            for (i = 0; i < KeyList.size(); i++) {
                System.out.println(KeyList.get(i) + "缓存是:" + jedisCluster.get(KeyList.get(i)));
            }
        } else if (jedisCluster.exists(KeyList1.get(i))) {
            for (i = 0; i < KeyList1.size(); i++) {
                System.out.println(KeyList1.get(i) + "缓存是:" + jedisCluster.get(KeyList1.get(i)));
            }
        } else if (jedisCluster.exists(KeyList2.get(i))) {
            for (i = 0; i < KeyList2.size(); i++) {
                System.out.println(KeyList2.get(i) + "缓存是:" + jedisCluster.get(KeyList2.get(i)));
            }
        } else {
            System.out.println("缓存不存在");
        }
    }

    //删除缓存
    public static void delValue(String redisKey) {
        String key = redisKey + "_" + EquityId;//权益
        String key1 = redisKey + "_" + str1 + "_" + ActivityId;//活动日维度
        String key2 = redisKey + "_" + str2 + "_" + ActivityId;//活动月维度
        String key3 = redisKey + "_" + ActivityId;//活动期间维度
        List<String> KeyList = new ArrayList<>();//每日用户
        KeyList.add(redisKey + "_" + ContralNo + "_" + str1 + "_" + ActivityId);
        KeyList.add(redisKey + "_" + CustomerNo + "_" + str1 + "_" + ActivityId);
        KeyList.add(redisKey + "_" + DeviceNo + "_" + str1 + "_" + ActivityId);
        KeyList.add(redisKey + "_" + MerchantNo + "_" + str1 + "_" + ActivityId);
        List<String> KeyList1 = new ArrayList<>();//每月用户
        KeyList1.add(redisKey + "_" + ContralNo + "_" + str2 + "_" + ActivityId);
        KeyList1.add(redisKey + "_" + CustomerNo + "_" + str2 + "_" + ActivityId);
        KeyList1.add(redisKey + "_" + DeviceNo + "_" + str2 + "_" + ActivityId);
        KeyList1.add(redisKey + "_" + MerchantNo + "_" + str2 + "_" + ActivityId);
        List<String> KeyList2 = new ArrayList<>();//活动期间用户
        KeyList2.add(redisKey + "_" + ContralNo + "_" + ActivityId);
        KeyList2.add(redisKey + "_" + CustomerNo + "_" + ActivityId);
        KeyList2.add(redisKey + "_" + DeviceNo + "_" + ActivityId);
        KeyList2.add(redisKey + "_" + MerchantNo + "_" + ActivityId);

        int i = 0;
        System.out.println("********************" + redisKey + "********************");
        if (jedisCluster.exists(key)) {
            System.out.println(key + "缓存是:" + jedisCluster.get(key));
            jedisCluster.del(key);
            if (jedisCluster.exists(key) == false) {
                System.out.println(key + "缓存已删除");
            } else {
                System.out.println("删除失败");
            }
        } else if (jedisCluster.exists(key1)) {
            System.out.println(key1 + "缓存是:" + jedisCluster.get(key1));
            jedisCluster.del(key1);
            if (jedisCluster.exists(key1) == false) {
                System.out.println(key1 + "缓存已删除");
            } else {
                System.out.println("删除失败");
            }
        } else if (jedisCluster.exists(key2)) {
            System.out.println(key2 + "缓存是:" + jedisCluster.get(key2));
            jedisCluster.del(key2);
            if (jedisCluster.exists(key2) == false) {
                System.out.println(key2 + "缓存已删除");
            } else {
                System.out.println("删除失败");
            }
        } else if (jedisCluster.exists(key3)) {
            System.out.println(key3 + "缓存是:" + jedisCluster.get(key3));
            jedisCluster.del(key3);
            if (jedisCluster.exists(key3) == false) {
                System.out.println(key3 + "缓存已删除");
            } else {
                System.out.println("删除失败");
            }
        } else if (jedisCluster.exists(KeyList.get(i))) {
            for (i = 0; i < KeyList.size(); i++) {
                System.out.println(KeyList.get(i) + "缓存是:" + jedisCluster.get(KeyList.get(i)));
                jedisCluster.del(KeyList.get(i));
                if (jedisCluster.exists(KeyList.get(i)) == false) {
                    System.out.println(KeyList.get(i) + "缓存已删除");
                } else {
                    System.out.println("删除失败");
                }
            }
        } else if (jedisCluster.exists(KeyList1.get(i))) {
            for (i = 0; i < KeyList1.size(); i++) {
                System.out.println(KeyList1.get(i) + "缓存是:" + jedisCluster.get(KeyList1.get(i)));
                jedisCluster.del(KeyList1.get(i));
                if (jedisCluster.exists(KeyList1.get(i)) == false) {
                    System.out.println(KeyList1.get(i) + "缓存已删除");
                } else {
                    System.out.println("删除失败");
                }
            }
        } else if (jedisCluster.exists(KeyList2.get(i))) {
            for (i = 0; i < KeyList2.size(); i++) {
                System.out.println(KeyList2.get(i) + "缓存是:" + jedisCluster.get(KeyList2.get(i)));
                jedisCluster.del(KeyList2.get(i));
                if (jedisCluster.exists(KeyList2.get(i)) == false) {
                    System.out.println(KeyList2.get(i) + "缓存已删除");
                } else {
                    System.out.println("删除失败");
                }
            }
        } else {
            System.out.println("缓存不存在");
        }
    }

    //更新缓存
    public static void updateValue(String redisKey) {
        String key = redisKey + "_" + EquityId;//权益
        String key1 = redisKey + "_" + str1 + "_" + ActivityId;//活动日维度
        String key2 = redisKey + "_" + str2 + "_" + ActivityId;//活动月维度
        String key3 = redisKey + "_" + ActivityId;//活动期间维度
        List<String> KeyList = new ArrayList<>();//每日用户
        KeyList.add(redisKey + "_" + ContralNo + "_" + str1 + "_" + ActivityId);
        KeyList.add(redisKey + "_" + CustomerNo + "_" + str1 + "_" + ActivityId);
        KeyList.add(redisKey + "_" + DeviceNo + "_" + str1 + "_" + ActivityId);
        KeyList.add(redisKey + "_" + MerchantNo + "_" + str1 + "_" + ActivityId);
        List<String> KeyList1 = new ArrayList<>();//每月用户
        KeyList1.add(redisKey + "_" + ContralNo + "_" + str2 + "_" + ActivityId);
        KeyList1.add(redisKey + "_" + CustomerNo + "_" + str2 + "_" + ActivityId);
        KeyList1.add(redisKey + "_" + DeviceNo + "_" + str2 + "_" + ActivityId);
        KeyList1.add(redisKey + "_" + MerchantNo + "_" + str2 + "_" + ActivityId);
        List<String> KeyList2 = new ArrayList<>();//活动期间用户
        KeyList2.add(redisKey + "_" + ContralNo + "_" + ActivityId);
        KeyList2.add(redisKey + "_" + CustomerNo + "_" + ActivityId);
        KeyList2.add(redisKey + "_" + DeviceNo + "_" + ActivityId);
        KeyList2.add(redisKey + "_" + MerchantNo + "_" + ActivityId);

        int i = 0;
        System.out.println("********************" + redisKey + "********************");
        if (jedisCluster.exists(key)) {
            System.out.println(key + "缓存是:" + jedisCluster.get(key));
            jedisCluster.set(key, "1");
            System.out.println(key + "缓存更新:" + jedisCluster.get(key));
        } else if (jedisCluster.exists(key1)) {
            System.out.println(key1 + "缓存是:" + jedisCluster.get(key1));
            jedisCluster.set(key1, "1");
            System.out.println(key1 + "缓存更新:" + jedisCluster.get(key1));
        } else if (jedisCluster.exists(key2)) {
            System.out.println(key2 + "缓存是:" + jedisCluster.get(key2));
            jedisCluster.set(key2, "1");
            System.out.println(key2 + "缓存更新:" + jedisCluster.get(key2));
        } else if (jedisCluster.exists(key3)) {
            System.out.println(key3 + "缓存是:" + jedisCluster.get(key3));
            jedisCluster.set(key3, "1");
            System.out.println(key3 + "缓存更新:" + jedisCluster.get(key3));
        } else if (jedisCluster.exists(KeyList.get(i))) {
            for (i = 0; i < KeyList.size(); i++) {
                System.out.println(KeyList.get(i) + "缓存是:" + jedisCluster.get(KeyList.get(i)));
                jedisCluster.set(KeyList.get(i), "1");
                System.out.println(KeyList.get(i) + "缓存更新:" + jedisCluster.get(KeyList.get(i)));
            }
        } else if (jedisCluster.exists(KeyList1.get(i))) {
            for (i = 0; i < KeyList1.size(); i++) {
                System.out.println(KeyList1.get(i) + "缓存是:" + jedisCluster.get(KeyList1.get(i)));
                jedisCluster.set(KeyList1.get(i), "1");
                System.out.println(KeyList1.get(i) + "缓存更新:" + jedisCluster.get(KeyList1.get(i)));
            }
        } else if (jedisCluster.exists(KeyList2.get(i))) {
            for (i = 0; i < KeyList2.size(); i++) {
                System.out.println(KeyList2.get(i) + "缓存是:" + jedisCluster.get(KeyList2.get(i)));
                jedisCluster.set(KeyList2.get(i), "1");
                System.out.println(KeyList2.get(i) + "缓存更新:" + jedisCluster.get(KeyList2.get(i)));
            }
        } else {
            System.out.println("缓存不存在");
        }
    }

    public static void setnxValue(String redisKey) {
        String key = redisKey + "_" + EquityId;//权益
        String key1 = redisKey + "_" + str1 + "_" + ActivityId;//活动日维度
        String key2 = redisKey + "_" + str2 + "_" + ActivityId;//活动月维度
        String key3 = redisKey + "_" + ActivityId;//活动期间维度
        List<String> KeyList = new ArrayList<>();//每日用户
        KeyList.add(redisKey + "_" + ContralNo + "_" + str1 + "_" + ActivityId);
        KeyList.add(redisKey + "_" + CustomerNo + "_" + str1 + "_" + ActivityId);
        KeyList.add(redisKey + "_" + DeviceNo + "_" + str1 + "_" + ActivityId);
        KeyList.add(redisKey + "_" + MerchantNo + "_" + str1 + "_" + ActivityId);
        List<String> KeyList1 = new ArrayList<>();//每月用户
        KeyList1.add(redisKey + "_" + ContralNo + "_" + str2 + "_" + ActivityId);
        KeyList1.add(redisKey + "_" + CustomerNo + "_" + str2 + "_" + ActivityId);
        KeyList1.add(redisKey + "_" + DeviceNo + "_" + str2 + "_" + ActivityId);
        KeyList1.add(redisKey + "_" + MerchantNo + "_" + str2 + "_" + ActivityId);
        List<String> KeyList2 = new ArrayList<>();//活动期间用户
        KeyList2.add(redisKey + "_" + ContralNo + "_" + ActivityId);
        KeyList2.add(redisKey + "_" + CustomerNo + "_" + ActivityId);
        KeyList2.add(redisKey + "_" + DeviceNo + "_" + ActivityId);
        KeyList2.add(redisKey + "_" + MerchantNo + "_" + ActivityId);

        int i = 0;
        System.out.println("********************" + redisKey + "********************");
        /*if (jedisCluster.exists(key)) {
            System.out.println(key + "缓存是:" + jedisCluster.get(key));
            jedisCluster.setnx(key, "1");
            System.out.println(key + "缓存更新:" + jedisCluster.get(key));
        } else if (jedisCluster.exists(key1)) {
            System.out.println(key1 + "缓存是:" + jedisCluster.get(key1));
            jedisCluster.setnx(key1, "1");
            System.out.println(key1 + "缓存更新:" + jedisCluster.get(key1));
        } else if (jedisCluster.exists(key2)) {
            System.out.println(key2 + "缓存是:" + jedisCluster.get(key2));
            jedisCluster.setnx(key2, "1");
            System.out.println(key2 + "缓存更新:" + jedisCluster.get(key2));
        } else if (jedisCluster.exists(key3)) {
            System.out.println(key3 + "缓存是:" + jedisCluster.get(key3));
            jedisCluster.setnx(key3, "1");
            System.out.println(key3 + "缓存更新:" + jedisCluster.get(key3));
        } else if (jedisCluster.exists(KeyList.get(i))) {
            for (i = 0; i < KeyList.size(); i++) {
                System.out.println(KeyList.get(i) + "缓存是:" + jedisCluster.get(KeyList.get(i)));
                jedisCluster.setnx(KeyList.get(i), "1");
                System.out.println(KeyList.get(i) + "缓存更新:" + jedisCluster.get(KeyList.get(i)));
            }
        } else if (jedisCluster.exists(KeyList1.get(i))) {
            for (i = 0; i < KeyList1.size(); i++) {
                System.out.println(KeyList1.get(i) + "缓存是:" + jedisCluster.get(KeyList1.get(i)));
                jedisCluster.setnx(KeyList1.get(i), "1");
                System.out.println(KeyList1.get(i) + "缓存更新:" + jedisCluster.get(KeyList1.get(i)));
            }
        } else if (jedisCluster.exists(KeyList2.get(i))) {
            for (i = 0; i < KeyList2.size(); i++) {
                System.out.println(KeyList2.get(i) + "缓存是:" + jedisCluster.get(KeyList2.get(i)));
                jedisCluster.setnx(KeyList2.get(i), "1");
                System.out.println(KeyList2.get(i) + "缓存更新:" + jedisCluster.get(KeyList2.get(i)));
            }
        } else {
            System.out.println("缓存不存在");
        }*/
        jedisCluster.set(key, "1");
        System.out.println(key + "缓存更新:" + jedisCluster.get(key));
    }


    @Test
    public static void getRedisValue() {
//        getValue(RedisEquityCostCnt());
//        getValue(RedisEquityCostAmt());
//        getValue(RedisActivityCntDay());
//        getValue(RedisActivityAmtDay());
//        getValue(RedisActivityCntMonth());
//        getValue(RedisActivityAmtMonth());
//        getValue(RedisActivityCntCycle());
//        getValue(RedisActivityAmtCycle());
        getValue(RedisKey.RedisUserMainNoDay());
        getValue(RedisKey.RedisUserMainNoMonth());
        getValue(RedisKey.RedisUserMainNoCycle());
//        getValue(RedisKey.RedisActivityCostRedisLock());
//        getValue(RedisKey.RedisEquityCostRedisLock());
    }

    @Test
    public static void delRedisValue() {
//        delValue(RedisEquityCostCnt());
//        delValue(RedisEquityCostAmt());
//        delValue(RedisActivityCntDay());
//        delValue(RedisActivityAmtDay());
//        delValue(RedisActivityCntMonth());
//        delValue(RedisActivityAmtMonth());
//        delValue(RedisActivityCntCycle());
//        delValue(RedisActivityAmtCycle());
        delValue(RedisUserMainNoDay());
//        delValue(RedisUserMainNoMonth());
//        delValue(RedisUserMainNoCycle());
//        delValue(RedisActivityCostRedisLock());
//        delValue(RedisEquityCostRedisLock());
    }

    @Test
    public static void updateRedisValue() {
//        updateValue(RedisEquityCostCnt());
//        updateValue(RedisEquityCostAmt());
//        updateValue(RedisActivityCntDay());
//        updateValue(RedisActivityAmtDay());
//        updateValue(RedisActivityCntMonth());
//        updateValue(RedisActivityAmtMonth());
//        updateValue(RedisActivityCntCycle());
//        updateValue(RedisActivityAmtCycle());
//        updateValue(RedisUserMainNoDay());
//        updateValue(RedisUserMainNoMonth());
//        updateValue(RedisUserMainNoCycle());
//        updateValue(RedisActivityCostRedisLock());
//        updateValue(RedisEquityCostRedisLock());
    }

    @Test
    public static void setnxRedisValue() {
//        setnxValue(RedisEquityCostCnt());
//        setnxValue(RedisEquityCostAmt());
//        setnxValue(RedisActivityCntDay());
//        setnxValue(RedisActivityAmtDay());
//        setnxValue(RedisActivityCntMonth());
//        setnxValue(RedisActivityAmtMonth());
//        setnxValue(RedisActivityCntCycle());
//        setnxValue(RedisActivityAmtCycle());
//        setnxValue(RedisUserMainNoDay());
//        setnxValue(RedisUserMainNoMonth());
//        setnxValue(RedisUserMainNoCycle());
    }
}
