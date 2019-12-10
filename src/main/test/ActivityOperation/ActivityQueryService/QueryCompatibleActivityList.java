package ActivityOperation.ActivityQueryService;

import com.xx.dubbo.result.Result;
import com.xx.marketing.activity.operation.api.ActivityQueryService;
import com.xx.marketing.activity.operation.api.models.request.QueryCompatibleActivityListReqDTO;
import com.xx.marketing.activity.operation.api.models.response.ApplicableActivityResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.List;
import java.util.UUID;

/**
 * Created by zengyouzu on 2019/9/10.
 * 活动硬规则校验
 */
public class QueryCompatibleActivityList {
    @Test
    public static void queryCompatibleActivityList() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ActivityQueryService activityQueryService = (ActivityQueryService) ac.getBean("activityQueryService");

        String traceLogId = UUID.randomUUID().toString().replaceAll("-", "");

        QueryCompatibleActivityListReqDTO queryCompatibleActivityListReqDTO = new QueryCompatibleActivityListReqDTO();
        queryCompatibleActivityListReqDTO.setProductNo("");
        queryCompatibleActivityListReqDTO.setToolType("");
        queryCompatibleActivityListReqDTO.setTraceLogId(traceLogId);

        Result<List<ApplicableActivityResDTO>> result = activityQueryService.queryCompatibleActivityList(queryCompatibleActivityListReqDTO);
        System.out.println("********************活动硬规则校验********************");
        System.out.println("日志号:" + queryCompatibleActivityListReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
