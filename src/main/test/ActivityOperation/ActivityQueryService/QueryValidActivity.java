package ActivityOperation.ActivityQueryService;

import Customize.DataGenerate;
import com.xx.dubbo.result.Result;
import com.xx.marketing.activity.operation.api.ActivityQueryService;
import com.xx.marketing.activity.operation.api.models.request.QueryValidActivityReqDTO;
import com.xx.marketing.activity.operation.api.models.response.ApplicableActivityResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/9/10.
 * 活动号手机号校验
 */
public class QueryValidActivity extends DataGenerate {

    @Test
    public static void queryValidActivity() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ActivityQueryService activityQueryService = (ActivityQueryService) ac.getBean("activityQueryService");

        QueryValidActivityReqDTO queryValidActivityReqDTO = new QueryValidActivityReqDTO();
        queryValidActivityReqDTO.setMerchantId("3178002068584435");
        queryValidActivityReqDTO.setStoreId("");
        queryValidActivityReqDTO.setProductNo("");
        queryValidActivityReqDTO.setActivityId("");
        queryValidActivityReqDTO.setRebateDimension("");
        queryValidActivityReqDTO.setTraceLogId(TraceLogId());

        Result<ApplicableActivityResDTO> result = activityQueryService.queryValidActivity(queryValidActivityReqDTO);
        System.out.println("********************活动号手机号校验********************");
        System.out.println("日志号:" + queryValidActivityReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
