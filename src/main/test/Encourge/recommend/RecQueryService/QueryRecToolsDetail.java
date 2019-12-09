package Encourge.recommend.RecQueryService;

import Customize.DataGenerate;
import Encourge.recommend.RecommendService;
import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.recommend.api.RecQueryService;
import com.bestpay.marketing.recommend.api.models.request.RecToolDetailReqDTO;
import com.bestpay.marketing.recommend.api.models.response.RecToolDetailResDTO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/9/6.
 * 推荐人工具详情页查询
 */
public class QueryRecToolsDetail extends DataGenerate {
    static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    static RecQueryService recQueryService = (RecQueryService) applicationContext.getBean("recQueryService");
    static RecommendService recommendService = new RecommendService();

    @Test
    public static void queryRecToolsDetail() {
        RecToolDetailReqDTO recToolDetailReqDTO = new RecToolDetailReqDTO();
        recToolDetailReqDTO.setToolId("T5x5x5x");//工具ID
        recToolDetailReqDTO.setTraceLogId(TraceLogId());

        Result<RecToolDetailResDTO> result = recQueryService.queryRecToolsDetail(recToolDetailReqDTO);
        System.out.println("********************推荐人工具详情页查询********************");
        System.out.println("日志号:" + recToolDetailReqDTO.getTraceLogId());
        System.out.println("工具号:" + recToolDetailReqDTO.getToolId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
