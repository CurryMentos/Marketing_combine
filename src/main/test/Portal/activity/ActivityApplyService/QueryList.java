package Portal.activity.ActivityApplyService;

import com.xx.dubbo.result.Result;
import com.xx.marketing.config.api.activity.models.request.QueryActivityDraftReqDTO;
import com.xx.marketing.config.api.activity.models.response.ActivityApplyInfoDTO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.xx.marketing.config.api.activity.ActivityApplyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zengyouzu on 2019/6/18.
 * 查询营销活动草稿列表
 */
public class QueryList {
    public static void queryList() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ActivityApplyService activityApplyService = (ActivityApplyService) ac.getBean("activityApplyService");

        String var = UUID.randomUUID().toString();
        Date now = new Date();
        String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now);

        QueryActivityDraftReqDTO queryActivityDraftReqDTO = new QueryActivityDraftReqDTO();
        queryActivityDraftReqDTO.setTraceLogId("");
        queryActivityDraftReqDTO.setRelationId("");
        queryActivityDraftReqDTO.setRelationName("");
        queryActivityDraftReqDTO.setAdaptProvince("");
        queryActivityDraftReqDTO.setApplyType("");
        queryActivityDraftReqDTO.setStartTime("");
        queryActivityDraftReqDTO.setEndTime("");
        queryActivityDraftReqDTO.setActivityType("");
        queryActivityDraftReqDTO.setApplyDepartment("");
        queryActivityDraftReqDTO.setAuditStatus("");
        queryActivityDraftReqDTO.setApplyUser("");


        Result<List<ActivityApplyInfoDTO>> result = activityApplyService.queryList(queryActivityDraftReqDTO);
        System.out.println("*****************************************");
        System.out.println("日志号:" + queryActivityDraftReqDTO.getTraceLogId());
        System.out.println(result);

        if (result.getResult() != null) {
            System.out.println("*****************************************");
            System.out.println(result.getResult());
        }
    }
}
