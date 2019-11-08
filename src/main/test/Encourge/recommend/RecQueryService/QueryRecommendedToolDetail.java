package Encourge.recommend.RecQueryService;

import Customize.DataGenerate;
import Encourge.recommend.RecommendService;
import com.xx.dubbo.result.Result;
import com.xx.marketing.recommend.api.RecQueryService;
import com.xx.marketing.recommend.api.models.request.RecommendedToolReqDTO;
import com.xx.marketing.recommend.api.models.response.RecommendedToolResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/9/27.
 * 被推荐人工具信息查询
 */
public class QueryRecommendedToolDetail extends DataGenerate {
    static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    static RecQueryService recQueryService = (RecQueryService) applicationContext.getBean("recQueryService");

    @Test
    public static void queryRecommendedToolDetail() {
        RecommendedToolReqDTO recommendedToolReqDTO = new RecommendedToolReqDTO();
        recommendedToolReqDTO.setRecommendUrl("3178002078357968T30990190927154550000034");
        recommendedToolReqDTO.setTraceLogId(TraceLogId());

        Result<RecommendedToolResDTO> result = recQueryService.queryRecommendedToolDetail(recommendedToolReqDTO);
        System.out.println("********************被推荐人工具信息查询********************");
        System.out.println("日志号:" + recommendedToolReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
