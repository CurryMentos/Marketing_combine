package Portal.activity.ActivityApplyService;

import com.xx.marketing.config.api.activity.models.PageInfoDTO;
import com.google.common.collect.Lists;

import com.xx.dubbo.result.Result;
import com.xx.marketing.config.api.activity.ActivityApplyService;
import com.xx.marketing.config.api.activity.models.request.ActivityTodoAndDoneQueryReqDTO;
import com.xx.marketing.config.api.activity.models.response.ActivityApplyInfoDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by zengyouzu on 2019/6/18.
 * 查询已办或待办列表
 */
public class QueryActivityDoneAndToDoList {
    public static void queryActivityDoneAndToDoList() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ActivityApplyService activityApplyService = (ActivityApplyService) ac.getBean("activityApplyService");

        String var = UUID.randomUUID().toString();
        Date now = new Date();
        String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now);

        ActivityTodoAndDoneQueryReqDTO activityTodoAndDoneQueryReqDTO = new ActivityTodoAndDoneQueryReqDTO();
        activityTodoAndDoneQueryReqDTO.setQueryType("");
        activityTodoAndDoneQueryReqDTO.setRoleGroup(Lists.newArrayList());
        activityTodoAndDoneQueryReqDTO.setApplyUser("");
        activityTodoAndDoneQueryReqDTO.setAdaptProvince("");
        activityTodoAndDoneQueryReqDTO.setStartTime("");
        activityTodoAndDoneQueryReqDTO.setEndTime("");
        activityTodoAndDoneQueryReqDTO.setApplyDepartment("");
//        activityTodoAndDoneQueryReqDTO.setFirstResult(0);
//        activityTodoAndDoneQueryReqDTO.setMaxResults(0);
        activityTodoAndDoneQueryReqDTO.setApplyModelAndType("");
        activityTodoAndDoneQueryReqDTO.setRelationId("");
        activityTodoAndDoneQueryReqDTO.setRelationName("");
        activityTodoAndDoneQueryReqDTO.setPayCompanyFlag(false);
        activityTodoAndDoneQueryReqDTO.setUserOfficeId("");
        activityTodoAndDoneQueryReqDTO.setUserProvince("");
        activityTodoAndDoneQueryReqDTO.setRequestNo("");
        activityTodoAndDoneQueryReqDTO.setRequestSystem("");
        activityTodoAndDoneQueryReqDTO.setRequestDate(new Date());
        activityTodoAndDoneQueryReqDTO.setTraceLogId("");

        Result<PageInfoDTO<ActivityApplyInfoDTO>> result = activityApplyService.queryActivityDoneAndToDoList(activityTodoAndDoneQueryReqDTO);
        System.out.println("*****************************************");
        System.out.println("请求流水:" + activityTodoAndDoneQueryReqDTO.getRequestNo());
        System.out.println("日志号:" + activityTodoAndDoneQueryReqDTO.getTraceLogId());
        System.out.println(result);

        if (result.getResult() != null) {
            System.out.println("*****************************************");
            System.out.println(result.getResult());
        }
    }
}
