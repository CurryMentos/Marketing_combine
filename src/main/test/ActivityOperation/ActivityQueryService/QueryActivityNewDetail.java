package ActivityOperation.ActivityQueryService;

import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.activity.operation.api.ActivityQueryService;
import com.bestpay.marketing.activity.operation.api.models.request.QueryActivityDetailReqDTO;
import com.bestpay.marketing.activity.operation.api.models.response.ActivityNewDetailResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.UUID;

//  查询活动详情
public class QueryActivityNewDetail {
    @Test
    public void queryActivityNewDetail() throws Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ActivityQueryService activityQueryService = (ActivityQueryService) ac.getBean("activityQueryService");
        String traceLogId = UUID.randomUUID().toString().replaceAll("-", "");

        QueryActivityDetailReqDTO queryActivityDetailReqDTO = new QueryActivityDetailReqDTO();
        queryActivityDetailReqDTO.setTraceLogId(traceLogId);
        queryActivityDetailReqDTO.setActivityId("");
        queryActivityDetailReqDTO.setNeedEquity("");

        Result<ActivityNewDetailResDTO> result = activityQueryService.queryActivityNewDetail(queryActivityDetailReqDTO);
        System.out.println("********************查询活动详情********************");
        System.out.println("日志号:" + queryActivityDetailReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());


    }
}
