package Encourge.recommend.RecQueryService;

import Customize.DataGenerate;
import Encourge.recommend.RecommendService;
import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.recommend.api.RecQueryService;
import com.bestpay.marketing.recommend.api.models.request.RecUsedListQueryReqDTO;
import com.bestpay.marketing.recommend.api.models.response.RecListQueryResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/9/6.
 * 推荐人已用工具列表分页查询
 */
public class RecUsedListQuery extends DataGenerate {
    static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    static RecQueryService recQueryService = (RecQueryService) applicationContext.getBean("recQueryService");
    static RecommendService recommendService = new RecommendService();

    @Test
    public static void recUsedListQuery() {
        RecUsedListQueryReqDTO recUsedListQueryReqDTO = new RecUsedListQueryReqDTO();
        recUsedListQueryReqDTO.setProductNo("13093067764");
        recUsedListQueryReqDTO.setPageSize(5);
        recUsedListQueryReqDTO.setPageNo(1);
        recUsedListQueryReqDTO.setTraceLogId(TraceLogId());

        Result<RecListQueryResDTO> result = recQueryService.recUsedListQuery(recUsedListQueryReqDTO);
        System.out.println("********************推荐人已用工具列表分页查询********************");
        System.out.println("日志号:" + recUsedListQueryReqDTO.getTraceLogId());
        System.out.println("推荐人手机号:" + recUsedListQueryReqDTO.getProductNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
