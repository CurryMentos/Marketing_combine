package ActivityOperation.ActivityQueryService;

import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.activity.operation.api.ActivityQueryService;
import com.bestpay.marketing.activity.operation.api.models.request.CheckActivitySoftRuleReqDTO;
import com.bestpay.marketing.activity.operation.api.models.response.CheckActivityResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by zengyouzu on 2019/9/10.
 * 活动软规则校验
 */
public class CheckActivitySoftRule {
    @Test
    public static void checkActivitySoftRule() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ActivityQueryService activityQueryService = (ActivityQueryService) ac.getBean("activityQueryService");

        String traceLogId = UUID.randomUUID().toString().replaceAll("-", "");

        CheckActivitySoftRuleReqDTO checkActivitySoftRuleReqDTO = new CheckActivitySoftRuleReqDTO();
        checkActivitySoftRuleReqDTO.setProductNo("16215756");

        List<String> activityIdList = new ArrayList<>();
        activityIdList.add("A40990191009150907000075");
        checkActivitySoftRuleReqDTO.setActivityIdList(activityIdList);

        checkActivitySoftRuleReqDTO.setTraceLogId(traceLogId);

        Result<List<CheckActivityResDTO>> result = activityQueryService.checkActivitySoftRule(checkActivitySoftRuleReqDTO);
        System.out.println("***********************************");
        System.out.println("日志号:" + checkActivitySoftRuleReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
