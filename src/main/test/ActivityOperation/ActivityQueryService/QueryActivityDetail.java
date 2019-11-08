package ActivityOperation.ActivityQueryService;

import com.xx.dubbo.result.Result;
import com.xx.marketing.activity.operation.api.ActivityQueryService;
import com.xx.marketing.activity.operation.api.models.request.QueryActivityDetailReqDTO;
import com.xx.marketing.activity.operation.api.models.response.ActivityDetailResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * Created by yangwei on 2019/6/3.
 * 查询活动详情
 */
public class QueryActivityDetail {
    @Test
    public static void queryActivityDetail() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ActivityQueryService activityQueryService = (ActivityQueryService) ac.getBean("activityQueryService");
        String traceLogId = UUID.randomUUID().toString().replaceAll("-", "");;

        QueryActivityDetailReqDTO queryActivityDetailReqDTO = new QueryActivityDetailReqDTO();
        queryActivityDetailReqDTO.setActivityId("D99191115557");  //活动号
        queryActivityDetailReqDTO.setTraceLogId(traceLogId);

        Result<ActivityDetailResDTO> result = activityQueryService.queryActivityDetail(queryActivityDetailReqDTO);
        System.out.println("***********************************");
        System.out.println("日志号：" + queryActivityDetailReqDTO.getTraceLogId());
        System.out.println(result);

        if (result.getResult() != null){
            System.out.println(result.getResult());
        }
    }
}
