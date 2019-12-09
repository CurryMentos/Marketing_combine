package Limit;

import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.limit.api.LimitAddService;
import com.bestpay.marketing.limit.api.models.*;
import com.bestpay.marketing.limit.api.models.request.AddLimitReqDTO;
import com.bestpay.marketing.limit.api.models.request.CancelAddLimitReqDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.*;

public class LimitAddServiceTest extends LimitConfigServiceTest {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static LimitAddService limitAddService = (LimitAddService) ac.getBean("limitAddService");
//    static LimitService limitService = new LimitService();
    static LimitService limitService = LimitConfigServiceTest.limitService;

    static String RandomStringNo() {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i <= 23; i++) {
            int randomNum = random.nextInt(9);
            String num = randomNum + "";
            stringBuffer = stringBuffer.append(num);
        }

        String randomRequestNo = String.valueOf(stringBuffer);
        return randomRequestNo;
    }
    /*@BeforeTest
    public void setup() throws Exception {
    }*/

    //限额累加接口
    @Test
    public static void addLimit() throws Exception {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");

//        String str = "2019-08-20 18:19:26";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = sdf.parse(str);

        AddLimitReqDTO addLimitReqDTO = new AddLimitReqDTO();
        addLimitReqDTO.setRequestNo("Req" + RandomStringNo());
        addLimitReqDTO.setRequestSystem("Test");
        addLimitReqDTO.setRequestDate(new Date());
        addLimitReqDTO.setProductNo("13728173655");
        addLimitReqDTO.setMerchantNo("3178002075671928");
        addLimitReqDTO.setLimitType("ACTIVITY");//ACTIVITY:活动维度;EQUITY:权益维度;TOOL:工具维度
        addLimitReqDTO.setLimitMainNo("A64734751130386265241217");
//        addLimitReqDTO.setLimitMainNo(limitService.getLimitMainNo());
        addLimitReqDTO.setLimitMainNoSumCnt(1L);
        addLimitReqDTO.setLimitMainNoSumAmt(2L);

        List<EquityAddDTO> equityAddDTOList = new ArrayList();
        EquityAddDTO equityAddDTO = new EquityAddDTO();
        equityAddDTO.setEquityId("E48654740202838387285812");
//        equityAddDTO.setEquityId(limitService.getEquityId());
        equityAddDTO.setSumCnt(limitService.getSumCnt());//权益总笔数(和限额同步EquityLimitDTO中总笔数相比)
        equityAddDTO.setSumAmt(limitService.getSumAmt());//权益总金额(和限额同步EquityLimitDTO中总金额相比)
        equityAddDTOList.add(equityAddDTO);
        addLimitReqDTO.setEquityAddDTOList(equityAddDTOList);

        addLimitReqDTO.setLimitMainNoStartDate(new Date());

        Long l = 1L;
        Long nl = 100L;
        ContralNoRuleDTO contralNoRuleDTO = new ContralNoRuleDTO();
        contralNoRuleDTO.setContralNo("13103527617");
        contralNoRuleDTO.setDayLimitCnt(nl);
        contralNoRuleDTO.setDayLimitAmt(nl);
        contralNoRuleDTO.setMonthLimitCnt(nl);
        contralNoRuleDTO.setMonthLimitAmt(nl);
        contralNoRuleDTO.setLimitCnt(nl);
        contralNoRuleDTO.setLimitAmt(nl);
        addLimitReqDTO.setContralNoRuleDTO(contralNoRuleDTO);

        CustomerNoRuleDTO customerNoRuleDTO = new CustomerNoRuleDTO();
        customerNoRuleDTO.setCustomerNo("410700199107198519");
        customerNoRuleDTO.setDayLimitCnt(l);
        customerNoRuleDTO.setDayLimitAmt(l);
        customerNoRuleDTO.setMonthLimitCnt(nl);
        customerNoRuleDTO.setMonthLimitAmt(nl);
        customerNoRuleDTO.setLimitCnt(nl);
        customerNoRuleDTO.setLimitAmt(nl);
        addLimitReqDTO.setCustomerNoRuleDTO(customerNoRuleDTO);

        DeviceNoRuleDTO deviceNoRuleDTO = new DeviceNoRuleDTO();
        deviceNoRuleDTO.setDeviceNo("303");
        deviceNoRuleDTO.setDayLimitCnt(nl);
        deviceNoRuleDTO.setDayLimitAmt(nl);
        deviceNoRuleDTO.setMonthLimitCnt(nl);
        deviceNoRuleDTO.setMonthLimitAmt(nl);
        deviceNoRuleDTO.setLimitCnt(nl);
        deviceNoRuleDTO.setLimitAmt(nl);
        addLimitReqDTO.setDeviceNoRuleDTO(deviceNoRuleDTO);

        MerchantNoRuleDTO merchantNoRuleDTO = new MerchantNoRuleDTO();
        merchantNoRuleDTO.setMerchantNo("3178002075650493");
        merchantNoRuleDTO.setDayLimitCnt(nl);
        merchantNoRuleDTO.setDayLimitAmt(nl);
        merchantNoRuleDTO.setMonthLimitCnt(nl);
        merchantNoRuleDTO.setMonthLimitAmt(nl);
        merchantNoRuleDTO.setLimitCnt(nl);
        merchantNoRuleDTO.setLimitAmt(nl);
        addLimitReqDTO.setMerchantNoRuleDTO(merchantNoRuleDTO);

        //活动限制主体()
        LimitMainNoRuleDTO limitMainNoRuleDTO = new LimitMainNoRuleDTO();
        limitMainNoRuleDTO.setDayLimitCnt(limitService.getActivityDayLimitCnt());
        limitMainNoRuleDTO.setDayLimitAmt(limitService.getActivityDayLimitAmt());
        limitMainNoRuleDTO.setMonthLimitCnt(limitService.getActivityMonthLimitCnt());
        limitMainNoRuleDTO.setMonthLimitAmt(limitService.getActivityMonthLimitAmt());
        limitMainNoRuleDTO.setLimitCnt(limitService.getActivityLimitCnt());
        limitMainNoRuleDTO.setLimitAmt(limitService.getActivityLimitAmt());
        addLimitReqDTO.setLimitMainNoRuleDTO(limitMainNoRuleDTO);

        addLimitReqDTO.setTraceLogId(traceLogId);

        //正交易参数保存到自定义Service,供反交易使用
        limitService.setAddRequestNo(addLimitReqDTO.getRequestNo());
        limitService.setRequestSystem(addLimitReqDTO.getRequestSystem());
        limitService.setAddRequestDate(addLimitReqDTO.getRequestDate());
        limitService.setProductNo(addLimitReqDTO.getProductNo());
        limitService.setLimitMainNoStartDate(addLimitReqDTO.getLimitMainNoStartDate());

        Result<Boolean> result = limitAddService.addLimit(addLimitReqDTO);
        System.out.println("********************限额累加********************");
        System.out.println("日志:" + traceLogId);
        System.out.println("请求流水:" + addLimitReqDTO.getRequestNo());
        System.out.println("请求时间:" + addLimitReqDTO.getRequestDate());
        System.out.println("ContralNo:" + contralNoRuleDTO.getContralNo());
        System.out.println("CustomerNo:" + customerNoRuleDTO.getCustomerNo());
        System.out.println("DeviceNo:" + deviceNoRuleDTO.getDeviceNo());
        System.out.println("MerchantNo:" + merchantNoRuleDTO.getMerchantNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
    }

    //限额累加撤销接口
    @Test
    public static void cancelAddLimit() throws Exception {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");
        String str = "2019-08-15 10:13:41";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(str);

        CancelAddLimitReqDTO cancelAddLimitReqDTO = new CancelAddLimitReqDTO();
        cancelAddLimitReqDTO.setRequestNo("Can" + RandomStringNo());
        cancelAddLimitReqDTO.setRequestSystem("Test");
        cancelAddLimitReqDTO.setRequestDate(new Date());
        cancelAddLimitReqDTO.setOriginalRequestNo("Req64850235024782587238234");
        cancelAddLimitReqDTO.setOriginalRequestSystem("Test");
        cancelAddLimitReqDTO.setOriginalRequestDate(date);
//        cancelAddLimitReqDTO.setOriginalRequestNo("Req1506448432247784617387150");
//        cancelAddLimitReqDTO.setOriginalRequestSystem("Test");
//        cancelAddLimitReqDTO.setOriginalRequestDate(date);
        cancelAddLimitReqDTO.setProductNo(limitService.getProductNo());
        cancelAddLimitReqDTO.setMerchantNo("3178002068640427");
        cancelAddLimitReqDTO.setLimitType("ACTIVITY");
//        cancelAddLimitReqDTO.setLimitMainNo("A80602556644081517667021");
        cancelAddLimitReqDTO.setLimitMainNo("A82275574154801524607646");
        cancelAddLimitReqDTO.setLimitMainNoSumCnt(limitService.getLimitMainNoSumCnt());
        cancelAddLimitReqDTO.setLimitMainNoSumAmt(limitService.getLimitMainNoSumAmt());

        List<EquityAddDTO> equityAddDTOList = new ArrayList();
        EquityAddDTO equityAddDTO = new EquityAddDTO();
        equityAddDTO.setEquityId("E28288685051340686551700");
//        equityAddDTO.setEquityId(limitService.getEquityId());
        equityAddDTO.setSumCnt(limitService.getSumCnt());//权益总笔数
        equityAddDTO.setSumAmt(limitService.getSumAmt());//权益总金额
        equityAddDTOList.add(equityAddDTO);
        cancelAddLimitReqDTO.setEquityAddDTOList(equityAddDTOList);

        cancelAddLimitReqDTO.setLimitMainNoStartDate(new Date());

        ContralNoRuleDTO contralNoRuleDTO = new ContralNoRuleDTO();
        contralNoRuleDTO.setContralNo("3178000008997824");
        contralNoRuleDTO.setDayLimitCnt(limitService.getDayLimitCnt());
        contralNoRuleDTO.setDayLimitAmt(limitService.getDayLimitAmt());
        contralNoRuleDTO.setMonthLimitCnt(limitService.getMonthLimitCnt());
        contralNoRuleDTO.setMonthLimitAmt(limitService.getMonthLimitAmt());
        contralNoRuleDTO.setLimitCnt(limitService.getLimitCnt());
        contralNoRuleDTO.setLimitAmt(limitService.getLimitAmt());
        cancelAddLimitReqDTO.setContralNoRuleDTO(contralNoRuleDTO);

        CustomerNoRuleDTO customerNoRuleDTO = new CustomerNoRuleDTO();
        customerNoRuleDTO.setCustomerNo("3177002076736243");
        customerNoRuleDTO.setDayLimitCnt(limitService.getDayLimitCnt());
        customerNoRuleDTO.setDayLimitAmt(limitService.getDayLimitAmt());
        customerNoRuleDTO.setMonthLimitCnt(limitService.getMonthLimitCnt());
        customerNoRuleDTO.setMonthLimitAmt(limitService.getMonthLimitAmt());
        customerNoRuleDTO.setLimitCnt(limitService.getLimitCnt());
        customerNoRuleDTO.setLimitAmt(limitService.getLimitAmt());
        cancelAddLimitReqDTO.setCustomerNoRuleDTO(customerNoRuleDTO);

        DeviceNoRuleDTO deviceNoRuleDTO = new DeviceNoRuleDTO();
        deviceNoRuleDTO.setDeviceNo("222");
        deviceNoRuleDTO.setDayLimitCnt(limitService.getDayLimitCnt());
        deviceNoRuleDTO.setDayLimitAmt(limitService.getDayLimitAmt());
        deviceNoRuleDTO.setMonthLimitCnt(limitService.getMonthLimitCnt());
        deviceNoRuleDTO.setMonthLimitAmt(limitService.getMonthLimitAmt());
        deviceNoRuleDTO.setLimitCnt(limitService.getLimitCnt());
        deviceNoRuleDTO.setLimitAmt(limitService.getLimitAmt());
        cancelAddLimitReqDTO.setDeviceNoRuleDTO(deviceNoRuleDTO);

        MerchantNoRuleDTO merchantNoRuleDTO = new MerchantNoRuleDTO();
        merchantNoRuleDTO.setMerchantNo("3178002068640427");
        merchantNoRuleDTO.setDayLimitCnt(limitService.getDayLimitCnt());
        merchantNoRuleDTO.setDayLimitAmt(limitService.getDayLimitAmt());
        merchantNoRuleDTO.setMonthLimitCnt(limitService.getMonthLimitCnt());
        merchantNoRuleDTO.setMonthLimitAmt(limitService.getMonthLimitAmt());
        merchantNoRuleDTO.setLimitCnt(limitService.getLimitCnt());
        merchantNoRuleDTO.setLimitAmt(limitService.getLimitAmt());
        cancelAddLimitReqDTO.setMerchantNoRuleDTO(merchantNoRuleDTO);

        LimitMainNoRuleDTO limitMainNoRuleDTO = new LimitMainNoRuleDTO();
        limitMainNoRuleDTO.setDayLimitCnt(limitService.getActivityDayLimitCnt());
        limitMainNoRuleDTO.setDayLimitAmt(limitService.getActivityDayLimitAmt());
        limitMainNoRuleDTO.setMonthLimitCnt(limitService.getActivityMonthLimitCnt());
        limitMainNoRuleDTO.setMonthLimitAmt(limitService.getActivityMonthLimitAmt());
        limitMainNoRuleDTO.setLimitCnt(limitService.getActivityLimitCnt());
        limitMainNoRuleDTO.setLimitAmt(limitService.getActivityLimitAmt());
        cancelAddLimitReqDTO.setLimitMainNoRuleDTO(limitMainNoRuleDTO);

        cancelAddLimitReqDTO.setTraceLogId(traceLogId);

        limitService.setCanRequestNo(cancelAddLimitReqDTO.getRequestNo());
        limitService.setCanRequestDate(cancelAddLimitReqDTO.getRequestDate());

        Result<Boolean> result = limitAddService.cancelAddLimit(cancelAddLimitReqDTO);
        System.out.println("********************限额累加撤销********************");
        System.out.println("日志:" + traceLogId);
        System.out.println("请求流水:" + cancelAddLimitReqDTO.getRequestNo());
        System.out.println("请求时间:" + cancelAddLimitReqDTO.getRequestDate());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
    }
}
