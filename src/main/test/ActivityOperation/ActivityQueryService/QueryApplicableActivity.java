package ActivityOperation.ActivityQueryService;

import Customize.DataGenerate;
import com.xx.dubbo.result.Result;
import com.xx.marketing.activity.operation.api.ActivityQueryService;
import com.xx.marketing.activity.operation.api.models.request.QueryApplicableActivityReqDTO;
import com.xx.marketing.activity.operation.api.models.response.ApplicableActivityResDTO;
import com.xx.marketing.config.api.enums.ToolTypeEnum;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by zengyouzu on 2019/9/18.
 */
public class QueryApplicableActivity extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static ActivityQueryService activityQueryService = (ActivityQueryService) ac.getBean("activityQueryService");

    @Test
    public static void queryApplicableActivity() {
        QueryApplicableActivityReqDTO queryApplicableActivityReqDTO = new QueryApplicableActivityReqDTO();
        queryApplicableActivityReqDTO.setRequestNo("Req" + RandomStringNo());
        queryApplicableActivityReqDTO.setRequestSystem("test");
        queryApplicableActivityReqDTO.setMerchantId("3178002068584435");
        queryApplicableActivityReqDTO.setProductNo("");
        queryApplicableActivityReqDTO.setToolType(ToolTypeEnum.ENCOURAGE.getCode());
        queryApplicableActivityReqDTO.setActivityType("");
        queryApplicableActivityReqDTO.setQrCodeId("123");
        queryApplicableActivityReqDTO.setTraceLogId(TraceLogId());

        Result<List<ApplicableActivityResDTO>> result = activityQueryService.queryApplicableActivity(queryApplicableActivityReqDTO);
        System.out.println("***********************************");
        System.out.println("日志号:" + queryApplicableActivityReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
