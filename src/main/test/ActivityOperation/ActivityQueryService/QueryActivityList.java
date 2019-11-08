package ActivityOperation.ActivityQueryService;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.xx.dubbo.result.Result;
import com.xx.marketing.activity.operation.api.ActivityQueryService;
import com.xx.marketing.activity.operation.api.models.request.QueryActivityListReqDTO;
import com.xx.marketing.activity.operation.api.models.response.ActivityResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/6/3.
 * 查询活动列表
 */
public class QueryActivityList {
    @Test
    public static void queryActivityList() throws Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ActivityQueryService activityQueryService = (ActivityQueryService) ac.getBean("activityQueryService");

        String var = UUID.randomUUID().toString();
        Date before1 = Date.from(LocalDateTime.now().minusDays(30).toInstant(ZoneOffset.ofHours(8)));
        Date before2 = Date.from(LocalDateTime.now().minusDays(20).toInstant(ZoneOffset.ofHours(8)));
        Date after1 = Date.from(LocalDateTime.now().plusDays(5).toInstant(ZoneOffset.ofHours(8)));
        Date after2 = Date.from(LocalDateTime.now().plusDays(15).toInstant(ZoneOffset.ofHours(8)));
        String startBegin = new SimpleDateFormat("yyyyMMdd").format(before1);
        String startEnd = new SimpleDateFormat("yyyyMMdd").format(before2);
        String endBegin = new SimpleDateFormat("yyyyMMdd").format(after1);
        String endEnd = new SimpleDateFormat("yyyyMMdd").format(after2);

        QueryActivityListReqDTO queryActivityListReqDTO = new QueryActivityListReqDTO();
        queryActivityListReqDTO.setAdaptAreaRange("");
        queryActivityListReqDTO.setAdaptProvince("");
        queryActivityListReqDTO.setAdaptCity("");
        queryActivityListReqDTO.setApplyChannel("");
        queryActivityListReqDTO.setApplyUser("");
        queryActivityListReqDTO.setStartDateBegin(before1);
        queryActivityListReqDTO.setStartDateEnd(before2);
        queryActivityListReqDTO.setEndDateBegin(after1);
        queryActivityListReqDTO.setEndDateEnd(after2);
        queryActivityListReqDTO.setAdaptMerchantRange("");
        queryActivityListReqDTO.setMerchantId("");
        queryActivityListReqDTO.setStoreId("");
        queryActivityListReqDTO.setPublishChannel("");
        queryActivityListReqDTO.setActivityStatus("");
        queryActivityListReqDTO.setTraceLogId(var);

        Result<List<ActivityResDTO>> result = activityQueryService.queryActivityList(queryActivityListReqDTO);
        System.out.println("***********************************");
        System.out.println("日志号：" + queryActivityListReqDTO.getTraceLogId());
        System.out.println(result);

        if (result.getResult()!=null){
            List<ActivityResDTO> list = result.getResult();
            for (ActivityResDTO dto : list){
                System.out.println(result.getResult());
            }
        }
    }
}
