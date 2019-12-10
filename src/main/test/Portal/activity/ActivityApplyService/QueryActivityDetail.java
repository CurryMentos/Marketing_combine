package Portal.activity.ActivityApplyService;

import com.xx.dubbo.result.Result;
import com.xx.marketing.config.api.activity.ActivityApplyService;
import com.xx.marketing.config.api.activity.models.request.QueryActivityApplyDetailReqDTO;
import com.xx.marketing.config.api.activity.models.response.ActivityApplyDetailResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

/**
 * Created by zengyouzu on 2019/6/18.
 * 查询营销活动草稿信息详情
 */
public class QueryActivityDetail {
    public static void queryActivityDetail() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ActivityApplyService activityApplyService = (ActivityApplyService) ac.getBean("activityApplyService");

        String var = UUID.randomUUID().toString();

        QueryActivityApplyDetailReqDTO queryActivityApplyDetailReqDTO = new QueryActivityApplyDetailReqDTO();
        queryActivityApplyDetailReqDTO.setTraceLogId(var);//日志号
        queryActivityApplyDetailReqDTO.setActivityId("");//活动编号

        Result<ActivityApplyDetailResDTO> result = activityApplyService.queryActivityDetail(queryActivityApplyDetailReqDTO);
        System.out.println("*****************************************");
        System.out.println("日志号:" + queryActivityApplyDetailReqDTO.getTraceLogId());
        System.out.println(result);

        if (result.getResult() != null) {
            System.out.println("*****************************************");
            System.out.println(result.getResult());
        }
    }
}
