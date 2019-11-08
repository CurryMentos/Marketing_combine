package Customize;

import java.util.List;
import java.util.Random;

/**
 * Created by zengyouzu on 2019/8/9.
 */
public class UserList {

    //从文件中随机抽取手机号
    public static String ContralNo() {
        List<String> list = null;
        int i = 1;
        try {
            list = FileOperate.getUserInfo(i);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int index = new Random().nextInt(list.size());
        String randomProductNo = list.get(index);
        return randomProductNo;
    }

    //从文件中随机抽取身份证号
    public static String CustomerNo() {
        List<String> list = null;
        int i = 2;
        try {
            list = FileOperate.getUserInfo(i);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int index = new Random().nextInt(list.size());
        String randomCustomerNo = list.get(index);
        return randomCustomerNo;
    }

    //随机生成0-1000
    public static String DeviceNo() {
        int a = 0;
        int b = 999;
        String randomDeviceNo = String.valueOf((int) (a + Math.random() * (b - a + 1)));
        return randomDeviceNo;
    }

    //从文件中随机抽取商户号
    public static String MerchantNo() {
        List<String> list = null;
        int i = 3;
        try {
            list = FileOperate.getUserInfo(i);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int index = new Random().nextInt(list.size());
        String randomMerchantNo = list.get(index);
        return randomMerchantNo;
    }
}
