package Encourge.recommend.RecQueryService;

import com.xx.dubbo.result.Result;
import com.xx.marketing.recommend.api.RecQueryService;
import com.xx.marketing.recommend.api.models.request.RecBindingDetailReqDTO;
import com.xx.marketing.recommend.api.models.response.RecBindingDetailResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zengyouzu on 2019/9/27.
 * 绑定关系查询
 */
public class QueryBindingDetail {
    static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    static RecQueryService recQueryService = (RecQueryService) applicationContext.getBean("recQueryService");

    public static void queryBindingDetail() {
        RecBindingDetailReqDTO recBindingDetailReqDTO = new RecBindingDetailReqDTO();
        recBindingDetailReqDTO.setToolId("");
        recBindingDetailReqDTO.setProvince("");
        recBindingDetailReqDTO.setRebateTriggerType("");
        recBindingDetailReqDTO.setRelationActivityId("");
        recBindingDetailReqDTO.setProductNo("");
        recBindingDetailReqDTO.setCustomerNo("");
        recBindingDetailReqDTO.setRecommendProductNo("");
        recBindingDetailReqDTO.setRecommendCustomerNo("");
        recBindingDetailReqDTO.setBingStartTime("");
        recBindingDetailReqDTO.setBingEndTime("");
        recBindingDetailReqDTO.setStatus("");
        recBindingDetailReqDTO.setPageSize(0);
        recBindingDetailReqDTO.setPageNo(0);
        recBindingDetailReqDTO.setTraceLogId("");

        Result<RecBindingDetailResDTO> result = recQueryService.queryBindingDetail(recBindingDetailReqDTO);
        System.out.println("********************绑定关系查询********************");
        System.out.println("日志号:" + recBindingDetailReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
