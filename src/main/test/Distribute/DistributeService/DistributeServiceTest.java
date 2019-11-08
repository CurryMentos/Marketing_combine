package Distribute.DistributeService;
import Customize.UserList;
import com.xx.marketing.config.api.enums.ActivityTypeEnum;
import com.xx.marketing.config.api.enums.ToolTypeEnum;
import com.google.common.collect.Lists;

import com.xx.dubbo.result.Result;
import com.xx.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.xx.marketing.distribute.api.DistributeService;
import com.xx.marketing.distribute.api.models.request.DirectDecisionDistributeReqDTO;
import com.xx.marketing.distribute.api.models.request.DirectDistributeCancelReqDTO;
import com.xx.marketing.distribute.api.models.request.DirectDistributeReqDTO;
import com.xx.marketing.distribute.api.models.request.RebateEquityDetailReqDTO;
import com.xx.marketing.distribute.api.models.response.DirectDistributeResDTO;
import com.xx.utils.DateUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class DistributeServiceTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    DistributeService distributeService = (DistributeService) ac.getBean("distributeService");

    @BeforeTest
    public void setup() throws Exception {
    }

    //直领并决策
    @Test
    public void directDecisionDistribute() throws Exception {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");
        String requestno = "ZZ" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

        DirectDecisionDistributeReqDTO directDecisionDistributeReqDTO = new DirectDecisionDistributeReqDTO();
        directDecisionDistributeReqDTO.setRequestNo(requestno);
        directDecisionDistributeReqDTO.setRequestDate(new Date());
        directDecisionDistributeReqDTO.setRequestSystem("test");
        directDecisionDistributeReqDTO.setTraceLogId(traceLogId);
        directDecisionDistributeReqDTO.setRebateDimension("PEOPLE");
        directDecisionDistributeReqDTO.setToolType("DIRECT");
        directDecisionDistributeReqDTO.setActivityType("DIRECT_ACTIVITY");
        directDecisionDistributeReqDTO.setToolId("A001");
        directDecisionDistributeReqDTO.setQrCodeId("A11111111");
        directDecisionDistributeReqDTO.setProductNo("18217285224");

        List<RebateEquityDetailReqDTO> rebateEquityDetailListReqDTO = new ArrayList<RebateEquityDetailReqDTO>();

        rebateEquityDetailListReqDTO.add(rebateEquityDetailList1());
//        directDecisionDistributeReqDTO.setRebateEquityDetailListReqDTO(rebateEquityDetailListReqDTO);

        Result<DirectDistributeResDTO> result = distributeService.directDecisionDistribute(
                directDecisionDistributeReqDTO);

        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
        System.out.println("日志:" + traceLogId);
    }

    //直领业务返利
    @Test
    public void directDistribute() throws Exception {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");
        String requestno = "ZZ" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

        DirectDistributeReqDTO directDistributeReqDTO = new DirectDistributeReqDTO();
        directDistributeReqDTO.setToolId("");
        directDistributeReqDTO.setToolName("");
        directDistributeReqDTO.setToolType(ToolTypeEnum.ENCOURAGE.getCode());
        directDistributeReqDTO.setMerchantNo("");
        directDistributeReqDTO.setStoreId("");
        directDistributeReqDTO.setRebateDimension("");
        directDistributeReqDTO.setProductNo(UserList.ContralNo());
        directDistributeReqDTO.setMarketCfgId("");
        directDistributeReqDTO.setActivityType(ActivityTypeEnum.DIRECT.getCode());

        List<RebateEquityDetailReqDTO> rebateEquityDetailReqDTOList= new ArrayList<>();
        RebateEquityDetailReqDTO rebateEquityDetailReqDTO = new RebateEquityDetailReqDTO();
        rebateEquityDetailReqDTO.setEquityType("");
        rebateEquityDetailReqDTO.setEquityId("");
        rebateEquityDetailReqDTO.setEquityName("");
        rebateEquityDetailReqDTO.setDistributeCount(0L);
        rebateEquityDetailReqDTO.setRebateAmt(0L);
        rebateEquityDetailReqDTOList.add(rebateEquityDetailReqDTO);
        directDistributeReqDTO.setRebateEquityDetailListReqDTO(rebateEquityDetailReqDTOList);
        directDistributeReqDTO.setPriority("");
        directDistributeReqDTO.setRequestNo(requestno);
        directDistributeReqDTO.setRequestSystem("test");
        directDistributeReqDTO.setRequestDate(new Date());
        directDistributeReqDTO.setTraceLogId(traceLogId);

        Result<DirectDistributeResDTO> result = distributeService.directDistribute(directDistributeReqDTO);
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
        System.out.println("日志:" + traceLogId);
    }

    //直领业务退返利
    @Test
    public void queryDirectDistribute() throws Exception {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");
        String requestno = "ZZ" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

        DirectDistributeCancelReqDTO directDistributeCancelReqDTO = new DirectDistributeCancelReqDTO();
        directDistributeCancelReqDTO.setOriginalRequestNo("");
        directDistributeCancelReqDTO.setOriginalRequestDate(DateUtil.parse("20170512"));
        directDistributeCancelReqDTO.setOriginalRequestSystem("");

        directDistributeCancelReqDTO.setRequestNo(requestno);//预制码申请人
        directDistributeCancelReqDTO.setRequestDate(new Date());//申请省份
        directDistributeCancelReqDTO.setRequestSystem("汪艳测试双向激励");//申请名称
        directDistributeCancelReqDTO.setTraceLogId(traceLogId);//生成数量

        Result<DirectDistributeResDTO> result = distributeService.directDistributeCancel(directDistributeCancelReqDTO);
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
        System.out.println("日志:" + traceLogId);
    }


    public RebateEquityDetailReqDTO rebateEquityDetailList1() {
        RebateEquityDetailReqDTO rebateEquityDetailReqDTO = new RebateEquityDetailReqDTO();
        rebateEquityDetailReqDTO.setEquityType("COUPON");
        rebateEquityDetailReqDTO.setEquityId("E201907250001");
        rebateEquityDetailReqDTO.setEquityName("汪艳测试用户直领");
        rebateEquityDetailReqDTO.setRebateAmt(8L);
        rebateEquityDetailReqDTO.setDistributeCount(1L);
        return rebateEquityDetailReqDTO;
    }
}
