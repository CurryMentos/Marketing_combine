package Encourge.recommend.RecQueryService;

import Customize.DataGenerate;
import Customize.UserList;
import Encourge.recommend.RecommendService;
import com.xx.dubbo.result.Result;
import com.xx.marketing.recommend.api.RecQueryService;
import com.xx.marketing.recommend.api.models.request.RecValidListQueryReqDTO;
import com.xx.marketing.recommend.api.models.response.RecValidToolResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/9/6.
 * 推荐人可用工具列表查询
 */
public class RecValidListQuery extends DataGenerate {
    static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    static RecQueryService recQueryService = (RecQueryService) applicationContext.getBean("recQueryService");
    static RecommendService recommendService = new RecommendService();

    @Test
    public static void recValidListQuery() {
        RecValidListQueryReqDTO recValidListQueryReqDTO = new RecValidListQueryReqDTO();
        recValidListQueryReqDTO.setProductNo("18956031203");
        recValidListQueryReqDTO.setTraceLogId(TraceLogId());

        Result<RecValidToolResDTO> result = recQueryService.recValidListQuery(recValidListQueryReqDTO);
        System.out.println("********************推荐人可用工具列表查询********************");
        System.out.println("日志号:" + recValidListQueryReqDTO.getTraceLogId());
        System.out.println("推荐人手机号:" + recValidListQueryReqDTO.getProductNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
