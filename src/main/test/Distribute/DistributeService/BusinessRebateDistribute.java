package Distribute.DistributeService;

import java.util.Date;

import Customize.DataGenerate;
import Customize.UserList;
import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.config.api.enums.ActivityTypeEnum;
import com.bestpay.marketing.distribute.api.DistributeService;
import com.bestpay.marketing.distribute.api.enums.PriorityEnums;
import com.bestpay.marketing.distribute.api.enums.RebateDimension;
import com.bestpay.marketing.distribute.api.models.request.BusinessRebateDistributeReqDTO;
import com.bestpay.marketing.distribute.api.models.response.DirectDistributeResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/11/5.
 * 业务返
 */
public class BusinessRebateDistribute extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static DistributeService distributeService = (DistributeService) ac.getBean("distributeService");

    @Test
    public static void businessRebateDistribute() throws Exception {
        BusinessRebateDistributeReqDTO businessRebateDistributeReqDTO = new BusinessRebateDistributeReqDTO();
//        businessRebateDistributeReqDTO.setToolId("");
//        businessRebateDistributeReqDTO.setToolType("");
        businessRebateDistributeReqDTO.setRebateDimension(RebateDimension.PEOPLE.getCode());
        businessRebateDistributeReqDTO.setMerchantNo("");
        businessRebateDistributeReqDTO.setProductNo(UserList.ContralNo());
        businessRebateDistributeReqDTO.setActivityType(ActivityTypeEnum.BUSINESS_REBATE.getCode());
        businessRebateDistributeReqDTO.setMarketCfgId("A40990191107092833000032");
        businessRebateDistributeReqDTO.setProductCode("");
        businessRebateDistributeReqDTO.setPriority(PriorityEnums.MEDIUM.getCode());
        businessRebateDistributeReqDTO.setTradeAmt(200L);
        businessRebateDistributeReqDTO.setRelationNo("");
        businessRebateDistributeReqDTO.setRequestNo("Req" + RandomStringNo());
        businessRebateDistributeReqDTO.setRequestSystem("test");
        businessRebateDistributeReqDTO.setRequestDate(new Date());
        businessRebateDistributeReqDTO.setTraceLogId(TraceLogId());

        Result<DirectDistributeResDTO> result = distributeService.businessRebateDistribute(businessRebateDistributeReqDTO);
        System.out.println("***********************************");
        System.out.println("日志号:" + businessRebateDistributeReqDTO.getTraceLogId());
        System.out.println("手机号:"+businessRebateDistributeReqDTO.getProductNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
