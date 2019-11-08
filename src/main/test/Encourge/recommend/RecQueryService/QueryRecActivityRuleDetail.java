package Encourge.recommend.RecQueryService;

import Customize.DataGenerate;
import Encourge.recommend.RecommendService;
import com.xx.dubbo.result.Result;
import com.xx.marketing.recommend.api.RecQueryService;
import com.xx.marketing.recommend.api.models.request.RecRuleDetailReqDTO;
import com.xx.marketing.recommend.api.models.response.RecToolRuleDetailResDTO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/9/6.
 * 推荐人活动规则查询（活动详情）
 */
public class QueryRecActivityRuleDetail extends DataGenerate {
    static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    static RecQueryService recQueryService = (RecQueryService) applicationContext.getBean("recQueryService");
    static RecommendService recommendService = new RecommendService();

    @Test
    public static void queryRecActivityRuleDetail() {
        RecRuleDetailReqDTO recRuleDetailReqDTO = new RecRuleDetailReqDTO();
        recRuleDetailReqDTO.setToolId(recommendService.getToolId());//工具ID
        recRuleDetailReqDTO.setTraceLogId(TraceLogId());

        Result<RecToolRuleDetailResDTO> result = recQueryService.queryRecActivityRuleDetail(recRuleDetailReqDTO);
        System.out.println("********************推荐人活动详情规则查询********************");
        System.out.println("日志号:" + recRuleDetailReqDTO.getTraceLogId());
        System.out.println("工具号:" + recRuleDetailReqDTO.getToolId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
