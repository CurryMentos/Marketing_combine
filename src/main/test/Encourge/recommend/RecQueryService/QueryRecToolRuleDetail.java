package Encourge.recommend.RecQueryService;

import Customize.DataGenerate;
import Encourge.recommend.RecommendService;
import com.xx.dubbo.result.Result;
import com.xx.marketing.recommend.api.RecQueryService;
import com.xx.marketing.recommend.api.models.request.RecToolRuleDetailReqDTO;
import com.xx.marketing.recommend.api.models.response.RecToolRuleDetailResDTO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;


/**
 * Created by zengyouzu on 2019/9/6.
 * 被推荐人规则查询
 */
public class QueryRecToolRuleDetail extends DataGenerate {
    static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    static RecQueryService recQueryService = (RecQueryService) applicationContext.getBean("recQueryService");
    static RecommendService recommendService = new RecommendService();

    @Test
    public static void queryRecToolRuleDetail() {
        RecToolRuleDetailReqDTO recToolRuleDetailReqDTO = new RecToolRuleDetailReqDTO();
        recToolRuleDetailReqDTO.setRecommendUrl(recommendService.getRecommendUrl());//邀请链接
        recToolRuleDetailReqDTO.setTraceLogId(TraceLogId());

        Result<RecToolRuleDetailResDTO> result = recQueryService.queryRecToolRuleDetail(recToolRuleDetailReqDTO);
        System.out.println("********************被推荐人规则查询********************");
        System.out.println("日志号:" + recToolRuleDetailReqDTO.getTraceLogId());
        System.out.println("邀请链接:" + recToolRuleDetailReqDTO.getRecommendUrl());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
