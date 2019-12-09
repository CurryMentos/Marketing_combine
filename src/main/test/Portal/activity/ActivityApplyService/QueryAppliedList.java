package Portal.activity.ActivityApplyService;

import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.config.api.activity.ActivityApplyService;
import com.bestpay.marketing.config.api.activity.models.request.QueryCommonAppliedReqDTO;
import com.bestpay.marketing.config.api.activity.models.response.ActivityApplyInfoDTO;
import com.bestpay.marketing.config.api.enums.QueryTypeEnum;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by zengyouzu on 2019/6/18.
 * 查询活动已申请列表
 */
public class QueryAppliedList {
    public static void queryAppliedList() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ActivityApplyService activityApplyService = (ActivityApplyService) ac.getBean("activityApplyService");

        String var = UUID.randomUUID().toString();
        Date now = new Date();
        String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now);

        QueryCommonAppliedReqDTO queryCommonAppliedReqDTO = new QueryCommonAppliedReqDTO();
        queryCommonAppliedReqDTO.setApplyUser("");
        queryCommonAppliedReqDTO.setApplyId("");
        queryCommonAppliedReqDTO.setAdaptProvince("");
        queryCommonAppliedReqDTO.setApplyModel("");
        queryCommonAppliedReqDTO.setApplyType("");
        queryCommonAppliedReqDTO.setStartTime("");
        queryCommonAppliedReqDTO.setEndTime("");
        queryCommonAppliedReqDTO.setActivityType("");
        queryCommonAppliedReqDTO.setAuditStatus("");
        queryCommonAppliedReqDTO.setApplyDepartment("");
        queryCommonAppliedReqDTO.setRelationId("");
        queryCommonAppliedReqDTO.setRelationName("");
        queryCommonAppliedReqDTO.setRelationType("");
        queryCommonAppliedReqDTO.setTraceLogId("");
        queryCommonAppliedReqDTO.setRequestNo("");
        queryCommonAppliedReqDTO.setRequestSystem("");
        queryCommonAppliedReqDTO.setRequestDate(new Date());
        queryCommonAppliedReqDTO.setTraceLogId("");

        Result<List<ActivityApplyInfoDTO>> result = activityApplyService.queryAppliedList(queryCommonAppliedReqDTO);
        System.out.println("*****************************************");
        System.out.println("请求流水:" + queryCommonAppliedReqDTO.getRequestNo());
        System.out.println("日志号:" + queryCommonAppliedReqDTO.getTraceLogId());
        System.out.println(result);

        if (result.getResult() != null) {
            System.out.println("*****************************************");
            System.out.println(result.getResult());
        }
    }
}
