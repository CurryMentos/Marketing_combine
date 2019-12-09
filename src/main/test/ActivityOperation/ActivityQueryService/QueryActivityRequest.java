package ActivityOperation.ActivityQueryService;

import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.activity.operation.api.ActivityQueryService;
import com.bestpay.marketing.activity.operation.api.models.request.QueryActivityRequestReqDTO;
import com.bestpay.marketing.activity.operation.api.models.response.ActivityRequestResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * Created by yangwei on 2019/6/4.
 * ��ѯ�����
 */
public class QueryActivityRequest {
    @Test
    public static void queryActivityDetail() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ActivityQueryService activityQueryService = (ActivityQueryService) ac.getBean("activityQueryService");
        String traceLogId = UUID.randomUUID().toString().replaceAll("-", "");

        QueryActivityRequestReqDTO queryActivityRequestReqDTO = new QueryActivityRequestReqDTO();
        queryActivityRequestReqDTO.setRequestNo("");    //������ˮ
        queryActivityRequestReqDTO.setRequestSystem("");     //����ϵͳ
        queryActivityRequestReqDTO.setTraceLogId(traceLogId);

        Result<ActivityRequestResDTO> result = activityQueryService.queryActivityRequest(queryActivityRequestReqDTO);
        System.out.println("***********************************");
        System.out.println("��־�ţ�" + queryActivityRequestReqDTO.getTraceLogId());
        System.out.println(result);

        if (result.getResult() != null){
            System.out.println(result.getResult());
        }

    }
}
