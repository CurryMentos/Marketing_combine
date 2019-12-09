package ActivityOperation.ActivityQueryService;
import java.util.Date;
import java.util.UUID;

import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.activity.operation.api.ActivityQueryService;
import com.bestpay.marketing.activity.operation.api.models.request.QueryActivityListPageReqDTO;
import com.bestpay.marketing.activity.operation.api.models.response.ActivityPageResDTO;
import com.bestpay.marketing.activity.operation.api.models.response.PageInfoDTO;
import com.bestpay.utils.DateUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

//  查询活动列表页信息
public class QueryActivityListPage {
    @Test
    public void queryActivityListPage() throws Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ActivityQueryService activityQueryService = (ActivityQueryService) ac.getBean("activityQueryService");
        String traceLogId = UUID.randomUUID().toString().replaceAll("-", "");

        QueryActivityListPageReqDTO queryActivityListPageReqDTO = new QueryActivityListPageReqDTO();
        queryActivityListPageReqDTO.setAdaptProvince("");
        queryActivityListPageReqDTO.setAdaptCity("");
        queryActivityListPageReqDTO.setApplyDepartment("");
        queryActivityListPageReqDTO.setStartDateBegin(DateUtil.parse("20170512"));
        queryActivityListPageReqDTO.setStartDateEnd(DateUtil.parse("20170512"));
        queryActivityListPageReqDTO.setEndDateBegin(DateUtil.parse("20170512"));
        queryActivityListPageReqDTO.setEndDateEnd(DateUtil.parse("20170512"));
//        queryActivityListPageReqDTO.setApplyTimeBegin(DateUtil.parse("20170512"));
//        queryActivityListPageReqDTO.setApplyTimeEnd(DateUtil.parse("20170512"));
        queryActivityListPageReqDTO.setActivityId("");
        queryActivityListPageReqDTO.setActivityName("");
        queryActivityListPageReqDTO.setActivityType("");
        queryActivityListPageReqDTO.setPageSize(10);
        queryActivityListPageReqDTO.setPageNo(1);
        queryActivityListPageReqDTO.setTraceLogId(traceLogId);
//        queryActivityListPageReqDTO.setRelationTool("");

        Result<PageInfoDTO<ActivityPageResDTO>> result = activityQueryService.queryActivityListPage(queryActivityListPageReqDTO);
        System.out.println("********************查询活动列表页信息********************");
        System.out.println("日志号:" + queryActivityListPageReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());

    }
}
