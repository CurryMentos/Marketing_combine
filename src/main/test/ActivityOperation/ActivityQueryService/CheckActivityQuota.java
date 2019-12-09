package ActivityOperation.ActivityQueryService;

import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.activity.operation.api.ActivityQueryService;
import com.bestpay.marketing.activity.operation.api.models.request.CheckActivityQuotaReqDTO;
import com.bestpay.marketing.activity.operation.api.models.response.CheckActivityResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by zengyouzu on 2019/9/10.
 * 活动权益剩余笔数金额校验
 */
public class CheckActivityQuota {
    @Test
    public static void checkActivityQuota() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ActivityQueryService activityQueryService = (ActivityQueryService) ac.getBean("activityQueryService");

        String traceLogId = UUID.randomUUID().toString().replaceAll("-", "");

        CheckActivityQuotaReqDTO checkActivityQuotaReqDTO = new CheckActivityQuotaReqDTO();
        List<String> activityIdList = new ArrayList<>();
        activityIdList.add("A01000190603195859000028");
        checkActivityQuotaReqDTO.setActivityIdList(activityIdList);

        checkActivityQuotaReqDTO.setTraceLogId(traceLogId);

        Result<List<CheckActivityResDTO>> result = activityQueryService.checkActivityQuota(checkActivityQuotaReqDTO);
        System.out.println("********************活动权益剩余笔数金额校验********************");
        System.out.println("日志号:" + checkActivityQuotaReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
