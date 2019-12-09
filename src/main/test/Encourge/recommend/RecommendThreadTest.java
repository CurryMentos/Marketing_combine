package Encourge.recommend;

import Customize.HttpTest;
import Customize.SQLOperate;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/9/11.
 */
public class RecommendThreadTest extends CombineTest {

    //申请-定时任务链接生效-立即邀请
    public static class RecommendThread1 extends Thread {
        public void run() {
            CombineTest.addApplyToolRecommend();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                HttpTest.toolEffect();
                sleep(1000 * 60 * 3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            SQLOperate.CheckData();
            /*CombineTest.recInviation();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }

    //申请-定时任务链接生效-立即邀请-绑定-解绑
    public static class RecommendThread2 extends Thread {
        public void run() {
            CombineTest.addApplyToolRecommend();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                HttpTest.toolEffect();
                sleep(1000 * 60 * 3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            SQLOperate.CheckData();
            CombineTest.recInviation();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CombineTest.recBinding();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /*CombineTest.recUnBinding();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }

    //申请-定时任务链接-生效-立即邀请-工具详情查询-工具列表分页查询-绑定-活动规则详情查询
    //-推荐人规则查询-被推荐人规则查询-可用列表查询-已用列表查询-好友列表查询
    /*public static class RecommendThread3 extends Thread {
        public void run() {
            CombineTest.addApplyToolRecommend();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                HttpTest.http();
                sleep(1000*60*3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            CombineTest.recInviation();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CombineTest.queryRecToolsDetail();
            CombineTest.queryRecToolsList();
            CombineTest.recBinding();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CombineTest.queryRecActivityRuleDetail();
            CombineTest.queryRecRuleDetail();
            CombineTest.queryRecToolRuleDetail();
            CombineTest.recValidListQuery();
            CombineTest.recUsedListQuery();
            CombineTest.recFriendsListQuery();
        }
    }*/

    //申请-定时任务链接生效-立即邀请-绑定-3.0正交易
    public static class RecommendThread4 extends Thread {
        public void run() {
            CombineTest.addApplyToolRecommend();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                HttpTest.toolEffect();
                sleep(1000 * 60 * 3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            SQLOperate.CheckData();
            CombineTest.recInviation();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CombineTest.recBinding();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SQLOperate.getBindingInfo();
            SQLOperate.checkAccount();
            CombineTest.createAndPay();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SQLOperate.checkBindingStatus();
        }
    }

    //已有工具立即邀请-绑定-3.0正交易
    public static class RecommendThread5 extends Thread {
        public void run() {
            recommendService.setToolId("T30990191128142448000134");
            CombineTest.recInviation();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CombineTest.recBinding();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SQLOperate.getBindingInfo();
            SQLOperate.checkAccount();
            CombineTest.createAndPay();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SQLOperate.checkBindingStatus();
        }
    }

    //已有绑定关系-3.0正交易
    public static class RecommendThread6 extends Thread {
        public void run() {
            recommendService.setToolId("T30990191009152623000080");
            recommendService.setProductNo("13781357605");//13093067764
            recommendService.setRecommendProductNo("13333767160");//19901978519
            SQLOperate.getBindingInfo();
            SQLOperate.checkAccount();
            CombineTest.createAndPay();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SQLOperate.checkBindingStatus();

            recommendService.setRecommendProductNo("13333767160");//19901978519
            SQLOperate.getBindingInfo();
            SQLOperate.checkAccount();
            CombineTest.createAndPay();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SQLOperate.checkBindingStatus();

            recommendService.setRecommendProductNo("13333767160");//19901978519
            SQLOperate.getBindingInfo();
            SQLOperate.checkAccount();
            CombineTest.createAndPay();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SQLOperate.checkBindingStatus();
        }
    }

    //已有工具立即邀请-绑定-(3.0正交易-3.0反交易)循环
    public static class RecommendThread7 extends Thread {
        public void run() {
            recommendService.setToolId("T30990191009150907000074");
            CombineTest.recInviation();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CombineTest.recBinding();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SQLOperate.getBindingInfo();
            SQLOperate.checkAccount();
            for (int i = 1; i <= 2; i++) {
                CombineTest.createAndPay();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SQLOperate.checkBindingStatus();
                CombineTest.refund();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SQLOperate.checkBindingStatus();
            }
        }
    }

    @Test
    public void Test() {
        for (int i = 1; i <= 50; i++) {
            try {
//                new RecommendThread1().run();
//                new RecommendThread2().run();
//                new RecommendThread3().run();
//                new RecommendThread4().run();
                new RecommendThread5().run();
//                new RecommendThread6().run();
//                new RecommendThread7().run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
