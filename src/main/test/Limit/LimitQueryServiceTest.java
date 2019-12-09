package Limit;

import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.limit.api.LimitQueryService;
import com.bestpay.marketing.limit.api.models.*;
import com.bestpay.marketing.limit.api.models.request.AddDetailReqDTO;
import com.bestpay.marketing.limit.api.models.request.CheckLimitReqDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class LimitQueryServiceTest extends LimitConfigServiceTest {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static LimitQueryService limitQueryService = (LimitQueryService) ac.getBean("limitQueryService");
    static LimitService limitService = new LimitService();
//    static LimitService limitService = LimitAddServiceTest.limitService;
    /*@BeforeTest
    public void setup() throws Exception { }*/

    //限额校验查询接口
    @Test
    public static void checkLimit() {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");
        CheckLimitReqDTO checkLimitReqDTO = new CheckLimitReqDTO();
        checkLimitReqDTO.setLimitType("ACTIVITY");
        checkLimitReqDTO.setLimitMainNo("A87545472464544530445544");
//        checkLimitReqDTO.setLimitMainNo(limitService.getLimitMainNo());
        checkLimitReqDTO.setLimitMainNoSumCnt(limitService.getLimitMainNoSumCnt());
        checkLimitReqDTO.setLimitMainNoSumAmt(limitService.getLimitMainNoSumAmt());

        List<EquityAddDTO> equityAddDTOList = new ArrayList();
        EquityAddDTO equityAddDTO = new EquityAddDTO();
        equityAddDTO.setEquityId("E76620764171051541624256");
//        equityAddDTO.setEquityId(limitService.getEquityId());
        equityAddDTO.setSumCnt(limitService.getSumCnt());//权益总笔数
        equityAddDTO.setSumAmt(limitService.getSumAmt());//权益总金额
        equityAddDTOList.add(equityAddDTO);
        checkLimitReqDTO.setEquityAddDTOList(equityAddDTOList);

        checkLimitReqDTO.setLimitMainNoStartDate(new Date());

        ContralNoRuleDTO contralNoRuleDTO = new ContralNoRuleDTO();
        contralNoRuleDTO.setContralNo("18135352076");
        contralNoRuleDTO.setDayLimitCnt(limitService.getDayLimitCnt());
        contralNoRuleDTO.setDayLimitAmt(limitService.getDayLimitAmt());
        contralNoRuleDTO.setMonthLimitCnt(limitService.getMonthLimitCnt());
        contralNoRuleDTO.setMonthLimitAmt(limitService.getMonthLimitAmt());
        contralNoRuleDTO.setLimitCnt(limitService.getLimitCnt());
        contralNoRuleDTO.setLimitAmt(limitService.getLimitAmt());
        checkLimitReqDTO.setContralNoRuleDTO(contralNoRuleDTO);

        CustomerNoRuleDTO customerNoRuleDTO = new CustomerNoRuleDTO();
        customerNoRuleDTO.setCustomerNo("330327199009054904");
        customerNoRuleDTO.setDayLimitCnt(limitService.getDayLimitCnt());
        customerNoRuleDTO.setDayLimitAmt(limitService.getDayLimitAmt());
        customerNoRuleDTO.setMonthLimitCnt(limitService.getMonthLimitCnt());
        customerNoRuleDTO.setMonthLimitAmt(limitService.getMonthLimitAmt());
        customerNoRuleDTO.setLimitCnt(limitService.getLimitCnt());
        customerNoRuleDTO.setLimitAmt(limitService.getLimitAmt());
        checkLimitReqDTO.setCustomerNoRuleDTO(customerNoRuleDTO);

        DeviceNoRuleDTO deviceNoRuleDTO = new DeviceNoRuleDTO();
        deviceNoRuleDTO.setDeviceNo("669");
        deviceNoRuleDTO.setDayLimitCnt(limitService.getDayLimitCnt());
        deviceNoRuleDTO.setDayLimitAmt(limitService.getDayLimitAmt());
        deviceNoRuleDTO.setMonthLimitCnt(limitService.getMonthLimitCnt());
        deviceNoRuleDTO.setMonthLimitAmt(limitService.getMonthLimitAmt());
        deviceNoRuleDTO.setLimitCnt(limitService.getLimitCnt());
        deviceNoRuleDTO.setLimitAmt(limitService.getLimitAmt());
        checkLimitReqDTO.setDeviceNoRuleDTO(deviceNoRuleDTO);

        MerchantNoRuleDTO merchantNoRuleDTO = new MerchantNoRuleDTO();
        merchantNoRuleDTO.setMerchantNo("3178002068640427");
        merchantNoRuleDTO.setDayLimitCnt(limitService.getDayLimitCnt());
        merchantNoRuleDTO.setDayLimitAmt(limitService.getDayLimitAmt());
        merchantNoRuleDTO.setMonthLimitCnt(limitService.getMonthLimitCnt());
        merchantNoRuleDTO.setMonthLimitAmt(limitService.getMonthLimitAmt());
        merchantNoRuleDTO.setLimitCnt(limitService.getLimitCnt());
        merchantNoRuleDTO.setLimitAmt(limitService.getLimitAmt());
        checkLimitReqDTO.setMerchantNoRuleDTO(merchantNoRuleDTO);

        LimitMainNoRuleDTO limitMainNoRuleDTO = new LimitMainNoRuleDTO();
        limitMainNoRuleDTO.setDayLimitCnt(limitService.getActivityDayLimitCnt());
        limitMainNoRuleDTO.setDayLimitAmt(limitService.getActivityDayLimitAmt());
        limitMainNoRuleDTO.setMonthLimitCnt(limitService.getActivityMonthLimitCnt());
        limitMainNoRuleDTO.setMonthLimitAmt(limitService.getActivityMonthLimitAmt());
        limitMainNoRuleDTO.setLimitCnt(limitService.getActivityLimitCnt());
        limitMainNoRuleDTO.setLimitAmt(limitService.getActivityLimitAmt());
        checkLimitReqDTO.setLimitMainNoRuleDTO(limitMainNoRuleDTO);

        checkLimitReqDTO.setTraceLogId(traceLogId);

        Result<Boolean> result = limitQueryService.checkLimit(checkLimitReqDTO);
        System.out.println("********************限额校验查询********************");
        System.out.println("日志:" + traceLogId);
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
    }

    //限额累加结果查询接口
    @Test
    public static void checkAddDetail() throws Exception {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");

        String str = "2019-08-13 15:42:55";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(str);

        AddDetailReqDTO addDetailReqDTO = new AddDetailReqDTO();
        addDetailReqDTO.setRequestNo("Req84472241773722571406304");
        addDetailReqDTO.setRequestSystem("Test");
        addDetailReqDTO.setRequestDate(date);
        addDetailReqDTO.setLimitType("ACTIVITY");
        addDetailReqDTO.setTraceLogId(traceLogId);

        Result<Boolean> result = limitQueryService.checkAddDetail(addDetailReqDTO);
        System.out.println("********************限额累加查询********************");
        System.out.println("日志:" + traceLogId);
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());

        /*addDetailReqDTO.setRequestNo(limitService.getCanRequestNo());
        addDetailReqDTO.setRequestSystem(limitService.getRequestSystem());
        addDetailReqDTO.setRequestDate(limitService.getCanRequestDate());
        addDetailReqDTO.setLimitType(limitService.getLimitType());
        addDetailReqDTO.setTraceLogId(traceLogId);

        result = limitQueryService.checkAddDetail(addDetailReqDTO);
        System.out.println("********************限额累加撤销查询********************");
        System.out.println("日志:" + traceLogId);
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());*/
    }
}
