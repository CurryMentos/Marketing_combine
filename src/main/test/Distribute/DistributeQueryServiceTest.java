package Distribute;

import com.bestpay.dubbo.result.Result;
import com.bestpay.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.bestpay.marketing.distribute.api.DistributeQueryService;
import com.bestpay.marketing.distribute.api.models.request.QueryDirectDistributeReqDTO;
import com.bestpay.marketing.distribute.api.models.response.QueryDirectDistributeResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class DistributeQueryServiceTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    DistributeQueryService distributeQueryService = (DistributeQueryService) ac.getBean("distributeQueryService");

    @BeforeTest
    public void setup() throws Exception {
    }

    //直领业务返利查询
    @Test
    public void queryDirectDistribute() throws Exception {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");
        String requestno = "ZZ" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

        QueryDirectDistributeReqDTO queryDirectDistributeReqDTO = new QueryDirectDistributeReqDTO();
        queryDirectDistributeReqDTO.setRequestNo(requestno);//预制码申请人
        queryDirectDistributeReqDTO.setRequestDate(new Date());//申请省份
        queryDirectDistributeReqDTO.setRequestSystem("汪艳测试双向激励");//申请名称
        queryDirectDistributeReqDTO.setTraceLogId(traceLogId);//生成数量

        Result<List<QueryDirectDistributeResDTO>> result = distributeQueryService.queryDirectDistribute(queryDirectDistributeReqDTO);
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
        System.out.println("日志:" + traceLogId);
    }
}
