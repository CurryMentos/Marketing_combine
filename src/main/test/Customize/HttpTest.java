package Customize;

import Encourge.recommend.CombineTest;
import Encourge.recommend.RecommendService;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by zengyouzu on 2019/9/17.
 */
public class HttpTest {
    static RecommendService recommendService = CombineTest.recommendService;

    //配置中心推荐人工具定时任务生效
    public static void toolEffect() throws Exception {
        //打印结果
        boolean flag = false;
        //定义url
        //46地址
        String url = "http://xxx.xx.xx.x:8030/batchAddMarketSyncDetail.html?applyId=" + recommendService.getApplyId();
        //综测地址
//        String url = "http://xxx.xx.xx.x:8030/batchAddMarketSyncDetail.html?applyId=" + recommendService.getApplyId();

        System.out.println("********************推荐人工具定时任务生效链接********************");

        JSONObject request = new JSONObject();

        String respone = HttpMethod.httpGet(url, request.toString(), "", "", flag);

        System.out.println("********************请等待......********************");
    }

    //台账异步认款定时任务
    public static void asynRecognize() throws Exception {
        //打印结果
        boolean flag = false;
        //定义url
        //46地址
//        String url = "http://xxx.xx.xx.x:8030/asynRecognizeJob.html";
        //综测地址
        String url = "http://xxx.xx.xx.x:8030/asynRecognizeJob.html";

        System.out.println("********************台账异步认款定时任务********************");

        JSONObject request = new JSONObject();

        String respone = HttpMethod.httpPost(url, request.toString(), "", "", flag);

        System.out.println("********************请等待......********************");
    }
}
