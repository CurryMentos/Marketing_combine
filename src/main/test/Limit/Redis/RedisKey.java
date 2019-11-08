package Limit.Redis;

/**
 * Created by zengyouzu on 2019/8/16.
 * redisKey
 */

public class RedisKey {
    //权益成本总笔数
    public static String RedisEquityCostCnt() {
        String redisKey = "LIMIT_EQUITY_COST_CNT";
        return redisKey;
    }

    //权益成本总金额
    public static String RedisEquityCostAmt() {
        String redisKey = "LIMIT_EQUITY_COST_AMT";
        return redisKey;
    }

    //每日活动累加笔数
    public static String RedisActivityCntDay() {
        String redisKey = "LIMIT_ACTIVITY_CNT_DAY";
        return redisKey;
    }

    //每日活动累加金额
    public static String RedisActivityAmtDay() {
        String redisKey = "LIMIT_ACTIVITY_AMT_DAY";
        return redisKey;
    }

    //每月活动累加笔数
    public static String RedisActivityCntMonth() {
        String redisKey = "LIMIT_ACTIVITY_CNT_MONTH";
        return redisKey;
    }

    //每月活动累加金额
    public static String RedisActivityAmtMonth() {
        String redisKey = "LIMIT_ACTIVITY_AMT_MONTH";
        return redisKey;
    }

    //活动期间活动累加笔数
    public static String RedisActivityCntCycle() {
        String redisKey = "LIMIT_ACTIVITY_CNT_CYCLE";
        return redisKey;
    }

    //活动期间活动累加金额
    public static String RedisActivityAmtCycle() {
        String redisKey = "LIMIT_ACTIVITY_AMT_CYCLE";
        return redisKey;
    }

    //每日用户限额主体累加
    public static String RedisUserMainNoDay() {
        String redisKey = "LIMIT_USER_MAIN_NO_DAY";
        return redisKey;
    }

    //每月用户限额主体累加
    public static String RedisUserMainNoMonth() {
        String redisKey = "LIMIT_USER_MAIN_NO_MONTH";
        return redisKey;
    }

    //活动期间用户限额主体累加
    public static String RedisUserMainNoCycle() {
        String redisKey = "LIMIT_USER_MAIN_NO_CYCLE";
        return redisKey;
    }

    //活动成本限额核算锁
    public static String RedisActivityCostRedisLock() {
        String redisKey = "LIMIT_ACTIVITY_COST_REDIS_LOCK";
        return redisKey;
    }

    //权益成本限额核算锁
    public static String RedisEquityCostRedisLock() {
        String redisKey = "LIMIT_EQUITY_COST_REDIS_LOCK";
        return redisKey;
    }

    /*public String excuteAllMethods() {
        String redisKey = null;
        for (int i = 0; i < getClass().getMethods().length; i++) {
            Method method = getClass().getMethods()[i];
            if (method.getName() != null) {
                try {
                    System.out.println(method.invoke(null, null));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return redisKey;
    }

    @Test
    public void test(String redisKey) {
        System.out.println(redisKey);
    }*/
}
