package Limit;

import Customize.UserList;
import com.xx.dubbo.result.Result;
import com.xx.marketing.limit.api.LimitAddService;
import com.xx.marketing.limit.api.LimitConfigService;
import com.xx.marketing.limit.api.LimitQueryService;
import com.xx.marketing.limit.api.models.*;
import com.xx.marketing.limit.api.models.request.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

/**
 * Created by zengyouzu on 2019/8/7.
 */
public class CombineTest {
    static LimitService limitService = new LimitService();
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static LimitConfigService limitConfigService = (LimitConfigService) ac.getBean("limitConfigService");
    static LimitAddService limitAddService = (LimitAddService) ac.getBean("limitAddService");
    static LimitQueryService limitQueryService = (LimitQueryService) ac.getBean("limitQueryService");
    static Date Before = Date.from(LocalDateTime.now(ZoneOffset.ofHours(8)).minusDays(10).withHour(0).withMinute(0).withSecond(0).toInstant(ZoneOffset.ofHours(8)));
    static Date After = Date.from(LocalDateTime.now(ZoneOffset.ofHours(8)).minusDays(8).withHour(23).withMinute(59).withSecond(59).toInstant(ZoneOffset.ofHours(8)));

    //随机生成流水
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

    //限额配置同步接口
    public static void synchronizingLimitInfo() {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");

        SynchronizingLimitReqDTO synchronizingLimitReqDTO = new SynchronizingLimitReqDTO();

        List<LimitDTO> limitDTOList = new ArrayList();
        LimitDTO limitDTO = new LimitDTO();
        limitDTO.setLimitType("ACTIVITY");//限额类型 ACTIVITY:活动维度;EQUITY:权益维度;TOOL:工具维度
        limitDTO.setLimitMainNo("A" + RandomStringNo());//限额主体编号(活动号\权益号\工具号)
//        limitDTO.setLimitMainNo("E" + RandomCreate.RandomStringNo());
//        limitDTO.setLimitMainNo("T" + RandomCreate.RandomStringNo());
//        limitDTO.setLimitMainNo("A12157167364883735272832");
        limitDTO.setLimitMainNoStartTime(Before);
        limitDTO.setLimitMainNoExpireTime(After);

        List<EquityLimitDTO> equityLimitDTOList = new ArrayList();
        EquityLimitDTO equityLimitDTO = new EquityLimitDTO();
//        equityLimitDTO.setActivityId(limitDTO.getLimitMainNo());
        equityLimitDTO.setEquityId("E" + RandomStringNo());
//        equityLimitDTO.setToolId(limitDTO.getLimitMainNo());
//        equityLimitDTO.setEquityId("E41517845310485473674038");
        equityLimitDTO.setTotalCnt(limitService.getTotalCnt());//总笔数
        equityLimitDTO.setTotalAmt(limitService.getTotalAmt());//总金额
        equityLimitDTO.setEquityExpireTime(After);

        equityLimitDTOList.add(equityLimitDTO);
        limitDTO.setEquityLimitDTOList(equityLimitDTOList);
        limitDTOList.add(limitDTO);
        synchronizingLimitReqDTO.setLimitDTOList(limitDTOList);
        synchronizingLimitReqDTO.setTraceLogId(traceLogId);

        //参数保存到自定义Service
        limitService.setLimitType(limitDTO.getLimitType());
        limitService.setLimitMainNo(limitDTO.getLimitMainNo());
//        limitService.setActivityId(equityLimitDTO.getActivityId());
        limitService.setEquityId(equityLimitDTO.getEquityId());
//        limitService.setToolId(equityLimitDTO.getToolId());

        Result<Boolean> result = limitConfigService.synchronizingLimitInfo(synchronizingLimitReqDTO);
        System.out.println("********************限额配置同步********************");
        System.out.println("日志:" + traceLogId);
        System.out.println("活动号:" + limitDTO.getLimitMainNo());
        System.out.println("权益号:" + equityLimitDTO.getEquityId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
    }

    //限额累加接口
    public static void addLimit() {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");

        AddLimitReqDTO addLimitReqDTO = new AddLimitReqDTO();
        addLimitReqDTO.setRequestNo("Req" + RandomStringNo());
        addLimitReqDTO.setRequestSystem("Test");
        addLimitReqDTO.setRequestDate(new Date());
        addLimitReqDTO.setProductNo(UserList.ContralNo());
        addLimitReqDTO.setMerchantNo(UserList.MerchantNo());
        addLimitReqDTO.setLimitType(limitService.getLimitType());//ACTIVITY:活动维度;EQUITY:权益维度;TOOL:工具维度
//        addLimitReqDTO.setLimitMainNo("A45070618068680576122001");
        addLimitReqDTO.setLimitMainNo(limitService.getLimitMainNo());
        addLimitReqDTO.setLimitMainNoSumCnt(limitService.getLimitMainNoSumCnt());
        addLimitReqDTO.setLimitMainNoSumAmt(limitService.getLimitMainNoSumAmt());

        List<EquityAddDTO> equityAddDTOList = new ArrayList();
        EquityAddDTO equityAddDTO = new EquityAddDTO();
//        equityAddDTO.setEquityId("E45070618068680576122001");
        equityAddDTO.setEquityId(limitService.getEquityId());
        equityAddDTO.setSumCnt(limitService.getSumCnt());//权益总笔数(和限额同步EquityLimitDTO中总笔数相比)
        equityAddDTO.setSumAmt(limitService.getSumAmt());//权益总金额(和限额同步EquityLimitDTO中总金额相比)
        equityAddDTOList.add(equityAddDTO);
        addLimitReqDTO.setEquityAddDTOList(equityAddDTOList);

        addLimitReqDTO.setLimitMainNoStartDate(new Date());

        ContralNoRuleDTO contralNoRuleDTO = new ContralNoRuleDTO();
        contralNoRuleDTO.setContralNo(UserList.ContralNo());
        contralNoRuleDTO.setDayLimitCnt(limitService.getDayLimitCnt());
        contralNoRuleDTO.setDayLimitAmt(limitService.getDayLimitAmt());
        contralNoRuleDTO.setMonthLimitCnt(limitService.getMonthLimitCnt());
        contralNoRuleDTO.setMonthLimitAmt(limitService.getMonthLimitAmt());
        contralNoRuleDTO.setLimitCnt(limitService.getLimitCnt());
        contralNoRuleDTO.setLimitAmt(limitService.getLimitAmt());
        addLimitReqDTO.setContralNoRuleDTO(contralNoRuleDTO);

        CustomerNoRuleDTO customerNoRuleDTO = new CustomerNoRuleDTO();
        customerNoRuleDTO.setCustomerNo(UserList.CustomerNo());
        customerNoRuleDTO.setDayLimitCnt(limitService.getDayLimitCnt());
        customerNoRuleDTO.setDayLimitAmt(limitService.getDayLimitAmt());
        customerNoRuleDTO.setMonthLimitCnt(limitService.getMonthLimitCnt());
        customerNoRuleDTO.setMonthLimitAmt(limitService.getMonthLimitAmt());
        customerNoRuleDTO.setLimitCnt(limitService.getLimitCnt());
        customerNoRuleDTO.setLimitAmt(limitService.getLimitAmt());
        addLimitReqDTO.setCustomerNoRuleDTO(customerNoRuleDTO);

        DeviceNoRuleDTO deviceNoRuleDTO = new DeviceNoRuleDTO();
        deviceNoRuleDTO.setDeviceNo(UserList.DeviceNo());
        deviceNoRuleDTO.setDayLimitCnt(limitService.getDayLimitCnt());
        deviceNoRuleDTO.setDayLimitAmt(limitService.getDayLimitAmt());
        deviceNoRuleDTO.setMonthLimitCnt(limitService.getMonthLimitCnt());
        deviceNoRuleDTO.setMonthLimitAmt(limitService.getMonthLimitAmt());
        deviceNoRuleDTO.setLimitCnt(limitService.getLimitCnt());
        deviceNoRuleDTO.setLimitAmt(limitService.getLimitAmt());
        addLimitReqDTO.setDeviceNoRuleDTO(deviceNoRuleDTO);

        MerchantNoRuleDTO merchantNoRuleDTO = new MerchantNoRuleDTO();
        merchantNoRuleDTO.setMerchantNo(UserList.MerchantNo());
        merchantNoRuleDTO.setDayLimitCnt(limitService.getDayLimitCnt());
        merchantNoRuleDTO.setDayLimitAmt(limitService.getDayLimitAmt());
        merchantNoRuleDTO.setMonthLimitCnt(limitService.getMonthLimitCnt());
        merchantNoRuleDTO.setMonthLimitAmt(limitService.getMonthLimitAmt());
        merchantNoRuleDTO.setLimitCnt(limitService.getLimitCnt());
        merchantNoRuleDTO.setLimitAmt(limitService.getLimitAmt());
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
        limitService.setMerchantNo(addLimitReqDTO.getMerchantNo());
        limitService.setContralNo(contralNoRuleDTO.getContralNo());
        limitService.setCustomerNo(customerNoRuleDTO.getCustomerNo());
        limitService.setDeviceNo(deviceNoRuleDTO.getDeviceNo());
        limitService.setUserMerchantNo(merchantNoRuleDTO.getMerchantNo());
        limitService.setLimitMainNoStartDate(addLimitReqDTO.getLimitMainNoStartDate());

        Result<Boolean> result = limitAddService.addLimit(addLimitReqDTO);
        System.out.println("********************限额累加********************");
        System.out.println("日志:" + traceLogId);
        System.out.println("请求流水:" + addLimitReqDTO.getRequestNo());
        System.out.println("ContralNo:" + contralNoRuleDTO.getContralNo());
        System.out.println("CustomerNo:" + customerNoRuleDTO.getCustomerNo());
        System.out.println("DeviceNo:" + deviceNoRuleDTO.getDeviceNo());
        System.out.println("MerchantNo:" + merchantNoRuleDTO.getMerchantNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
    }

    //限额累加撤销接口
    public static void cancelAddLimit() {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");
//        String str = "2019-08-06 17:58:24";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = sdf.parse(str);

        CancelAddLimitReqDTO cancelAddLimitReqDTO = new CancelAddLimitReqDTO();
        cancelAddLimitReqDTO.setRequestNo("Can" + RandomStringNo());
        cancelAddLimitReqDTO.setRequestSystem(limitService.getRequestSystem());
        cancelAddLimitReqDTO.setRequestDate(new Date());
        cancelAddLimitReqDTO.setOriginalRequestNo(limitService.getAddRequestNo());
        cancelAddLimitReqDTO.setOriginalRequestSystem(limitService.getRequestSystem());
        cancelAddLimitReqDTO.setOriginalRequestDate(limitService.getAddRequestDate());
//        cancelAddLimitReqDTO.setOriginalRequestNo("Req1506448432247784617387150");
//        cancelAddLimitReqDTO.setOriginalRequestSystem("Test");
//        cancelAddLimitReqDTO.setOriginalRequestDate(date);
        cancelAddLimitReqDTO.setProductNo(limitService.getProductNo());
        cancelAddLimitReqDTO.setMerchantNo(limitService.getMerchantNo());
        cancelAddLimitReqDTO.setLimitType(limitService.getLimitType());
//        cancelAddLimitReqDTO.setLimitMainNo("A80602556644081517667021");
        cancelAddLimitReqDTO.setLimitMainNo(limitService.getLimitMainNo());
        cancelAddLimitReqDTO.setLimitMainNoSumCnt(limitService.getLimitMainNoSumCnt());
        cancelAddLimitReqDTO.setLimitMainNoSumAmt(limitService.getLimitMainNoSumAmt());

        List<EquityAddDTO> equityAddDTOList = new ArrayList();
        EquityAddDTO equityAddDTO = new EquityAddDTO();
//        equityAddDTO.setEquityId("E80602556644081517667021");
        equityAddDTO.setEquityId(limitService.getEquityId());
        equityAddDTO.setSumCnt(limitService.getSumCnt());//权益总笔数
        equityAddDTO.setSumAmt(limitService.getSumAmt());//权益总金额
        equityAddDTOList.add(equityAddDTO);
        cancelAddLimitReqDTO.setEquityAddDTOList(equityAddDTOList);

        cancelAddLimitReqDTO.setLimitMainNoStartDate(limitService.getLimitMainNoStartDate());

        ContralNoRuleDTO contralNoRuleDTO = new ContralNoRuleDTO();
        contralNoRuleDTO.setContralNo(limitService.getContralNo());
        contralNoRuleDTO.setDayLimitCnt(limitService.getDayLimitCnt());
        contralNoRuleDTO.setDayLimitAmt(limitService.getDayLimitAmt());
        contralNoRuleDTO.setMonthLimitCnt(limitService.getMonthLimitCnt());
        contralNoRuleDTO.setMonthLimitAmt(limitService.getMonthLimitAmt());
        contralNoRuleDTO.setLimitCnt(limitService.getLimitCnt());
        contralNoRuleDTO.setLimitAmt(limitService.getLimitAmt());
        cancelAddLimitReqDTO.setContralNoRuleDTO(contralNoRuleDTO);

        CustomerNoRuleDTO customerNoRuleDTO = new CustomerNoRuleDTO();
        customerNoRuleDTO.setCustomerNo(limitService.getCustomerNo());
        customerNoRuleDTO.setDayLimitCnt(limitService.getDayLimitCnt());
        customerNoRuleDTO.setDayLimitAmt(limitService.getDayLimitAmt());
        customerNoRuleDTO.setMonthLimitCnt(limitService.getMonthLimitCnt());
        customerNoRuleDTO.setMonthLimitAmt(limitService.getMonthLimitAmt());
        customerNoRuleDTO.setLimitCnt(limitService.getLimitCnt());
        customerNoRuleDTO.setLimitAmt(limitService.getLimitAmt());
        cancelAddLimitReqDTO.setCustomerNoRuleDTO(customerNoRuleDTO);

        DeviceNoRuleDTO deviceNoRuleDTO = new DeviceNoRuleDTO();
        deviceNoRuleDTO.setDeviceNo(limitService.getDeviceNo());
        deviceNoRuleDTO.setDayLimitCnt(limitService.getDayLimitCnt());
        deviceNoRuleDTO.setDayLimitAmt(limitService.getDayLimitAmt());
        deviceNoRuleDTO.setMonthLimitCnt(limitService.getMonthLimitCnt());
        deviceNoRuleDTO.setMonthLimitAmt(limitService.getMonthLimitAmt());
        deviceNoRuleDTO.setLimitCnt(limitService.getLimitCnt());
        deviceNoRuleDTO.setLimitAmt(limitService.getLimitAmt());
        cancelAddLimitReqDTO.setDeviceNoRuleDTO(deviceNoRuleDTO);

        MerchantNoRuleDTO merchantNoRuleDTO = new MerchantNoRuleDTO();
        merchantNoRuleDTO.setMerchantNo(limitService.getUserMerchantNo());
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
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
    }

    //限额校验查询接口
    public static void checkLimit() {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");
        CheckLimitReqDTO checkLimitReqDTO = new CheckLimitReqDTO();
        checkLimitReqDTO.setLimitType(limitService.getLimitType());
//        checkLimitReqDTO.setLimitMainNo("99999");
        checkLimitReqDTO.setLimitMainNo(limitService.getLimitMainNo());
        checkLimitReqDTO.setLimitMainNoSumCnt(limitService.getLimitMainNoSumCnt());
        checkLimitReqDTO.setLimitMainNoSumAmt(limitService.getLimitMainNoSumAmt());

        List<EquityAddDTO> equityAddDTOList = new ArrayList();
        EquityAddDTO equityAddDTO = new EquityAddDTO();
//        equityAddDTO.setEquityId("E23421491468736369392347");
        equityAddDTO.setEquityId(limitService.getEquityId());
        equityAddDTO.setSumCnt(limitService.getSumCnt());//权益总笔数
        equityAddDTO.setSumAmt(limitService.getSumAmt());//权益总金额
        equityAddDTOList.add(equityAddDTO);
        checkLimitReqDTO.setEquityAddDTOList(equityAddDTOList);

        checkLimitReqDTO.setLimitMainNoStartDate(limitService.getLimitMainNoStartDate());

        ContralNoRuleDTO contralNoRuleDTO = new ContralNoRuleDTO();
        contralNoRuleDTO.setContralNo(UserList.ContralNo());
        contralNoRuleDTO.setDayLimitCnt(limitService.getDayLimitCnt());
        contralNoRuleDTO.setDayLimitAmt(limitService.getDayLimitAmt());
        contralNoRuleDTO.setMonthLimitCnt(limitService.getMonthLimitCnt());
        contralNoRuleDTO.setMonthLimitAmt(limitService.getMonthLimitAmt());
        contralNoRuleDTO.setLimitCnt(limitService.getLimitCnt());
        contralNoRuleDTO.setLimitAmt(limitService.getLimitAmt());
        checkLimitReqDTO.setContralNoRuleDTO(contralNoRuleDTO);

        CustomerNoRuleDTO customerNoRuleDTO = new CustomerNoRuleDTO();
        customerNoRuleDTO.setCustomerNo(UserList.CustomerNo());
        customerNoRuleDTO.setDayLimitCnt(limitService.getDayLimitCnt());
        customerNoRuleDTO.setDayLimitAmt(limitService.getDayLimitAmt());
        customerNoRuleDTO.setMonthLimitCnt(limitService.getMonthLimitCnt());
        customerNoRuleDTO.setMonthLimitAmt(limitService.getMonthLimitAmt());
        customerNoRuleDTO.setLimitCnt(limitService.getLimitCnt());
        customerNoRuleDTO.setLimitAmt(limitService.getLimitAmt());
        checkLimitReqDTO.setCustomerNoRuleDTO(customerNoRuleDTO);

        DeviceNoRuleDTO deviceNoRuleDTO = new DeviceNoRuleDTO();
        deviceNoRuleDTO.setDeviceNo(UserList.DeviceNo());
        deviceNoRuleDTO.setDayLimitCnt(limitService.getDayLimitCnt());
        deviceNoRuleDTO.setDayLimitAmt(limitService.getDayLimitAmt());
        deviceNoRuleDTO.setMonthLimitCnt(limitService.getMonthLimitCnt());
        deviceNoRuleDTO.setMonthLimitAmt(limitService.getMonthLimitAmt());
        deviceNoRuleDTO.setLimitCnt(limitService.getLimitCnt());
        deviceNoRuleDTO.setLimitAmt(limitService.getLimitAmt());
        checkLimitReqDTO.setDeviceNoRuleDTO(deviceNoRuleDTO);

        MerchantNoRuleDTO merchantNoRuleDTO = new MerchantNoRuleDTO();
        merchantNoRuleDTO.setMerchantNo(UserList.MerchantNo());
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
    public static void checkAddDetail() {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");

        AddDetailReqDTO addDetailReqDTO = new AddDetailReqDTO();
        addDetailReqDTO.setRequestNo(limitService.getAddRequestNo());
        addDetailReqDTO.setRequestSystem(limitService.getRequestSystem());
        addDetailReqDTO.setRequestDate(limitService.getAddRequestDate());
        addDetailReqDTO.setLimitType(limitService.getLimitType());
        addDetailReqDTO.setTraceLogId(traceLogId);

        Result<Boolean> result = limitQueryService.checkAddDetail(addDetailReqDTO);
        System.out.println("********************限额累加查询********************");
        System.out.println("日志:" + traceLogId);
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());

        if (limitService.getCanRequestNo() != null) {
            traceLogId = UUID.randomUUID().toString().replace("-", "");

            addDetailReqDTO.setRequestNo(limitService.getCanRequestNo());
            addDetailReqDTO.setRequestSystem(limitService.getRequestSystem());
            addDetailReqDTO.setRequestDate(limitService.getCanRequestDate());
            addDetailReqDTO.setLimitType(limitService.getLimitType());
            addDetailReqDTO.setTraceLogId(traceLogId);

            result = limitQueryService.checkAddDetail(addDetailReqDTO);
            System.out.println("********************限额累加撤销查询********************");
            System.out.println("日志:" + traceLogId);
            System.out.println("是否成功:" + result.isSuccess());
            System.out.println("错误信息:" + result.getErrorMsg());
            System.out.println("返回信息:" + result.getResult());
        } else {
            System.out.println("********************当前活动未执行限额累加撤销********************");
        }
    }

    //限额部分累加撤销接口
    public static void partialCancelAddLimit() {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");
//        String str = "2019-08-06 17:58:24";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = sdf.parse(str);

        CancelAddLimitReqDTO cancelAddLimitReqDTO = new CancelAddLimitReqDTO();
        cancelAddLimitReqDTO.setRequestNo("Can" + RandomStringNo());
        cancelAddLimitReqDTO.setRequestSystem(limitService.getRequestSystem());
        cancelAddLimitReqDTO.setRequestDate(new Date());
        cancelAddLimitReqDTO.setOriginalRequestNo(limitService.getAddRequestNo());
        cancelAddLimitReqDTO.setOriginalRequestSystem(limitService.getRequestSystem());
        cancelAddLimitReqDTO.setOriginalRequestDate(limitService.getAddRequestDate());
//        cancelAddLimitReqDTO.setOriginalRequestNo("Req1506448432247784617387150");
//        cancelAddLimitReqDTO.setOriginalRequestSystem("Test");
//        cancelAddLimitReqDTO.setOriginalRequestDate(date);
        cancelAddLimitReqDTO.setProductNo(limitService.getProductNo());
        cancelAddLimitReqDTO.setMerchantNo(limitService.getMerchantNo());
        cancelAddLimitReqDTO.setLimitType(limitService.getLimitType());
//        cancelAddLimitReqDTO.setLimitMainNo("A80602556644081517667021");
        cancelAddLimitReqDTO.setLimitMainNo(limitService.getLimitMainNo());
        cancelAddLimitReqDTO.setLimitMainNoSumCnt(limitService.getLimitMainNoSumCnt() / 1000);
        cancelAddLimitReqDTO.setLimitMainNoSumAmt(limitService.getLimitMainNoSumAmt() / 1000);

        List<EquityAddDTO> equityAddDTOList = new ArrayList();
        EquityAddDTO equityAddDTO = new EquityAddDTO();
//        equityAddDTO.setEquityId("E80602556644081517667021");
        equityAddDTO.setEquityId(limitService.getEquityId());
        equityAddDTO.setSumCnt(limitService.getSumCnt() / 1000);//权益总笔数
        equityAddDTO.setSumAmt(limitService.getSumAmt() / 1000);//权益总金额
        equityAddDTOList.add(equityAddDTO);
        cancelAddLimitReqDTO.setEquityAddDTOList(equityAddDTOList);

        cancelAddLimitReqDTO.setLimitMainNoStartDate(limitService.getLimitMainNoStartDate());

        ContralNoRuleDTO contralNoRuleDTO = new ContralNoRuleDTO();
        contralNoRuleDTO.setContralNo(limitService.getContralNo());
        contralNoRuleDTO.setDayLimitCnt(limitService.getDayLimitCnt() / 1000);
        contralNoRuleDTO.setDayLimitAmt(limitService.getDayLimitAmt() / 1000);
        contralNoRuleDTO.setMonthLimitCnt(limitService.getMonthLimitCnt() / 1000);
        contralNoRuleDTO.setMonthLimitAmt(limitService.getMonthLimitAmt() / 1000);
        contralNoRuleDTO.setLimitCnt(limitService.getLimitCnt() / 1000);
        contralNoRuleDTO.setLimitAmt(limitService.getLimitAmt() / 1000);
        cancelAddLimitReqDTO.setContralNoRuleDTO(contralNoRuleDTO);

        CustomerNoRuleDTO customerNoRuleDTO = new CustomerNoRuleDTO();
        customerNoRuleDTO.setCustomerNo(limitService.getCustomerNo());
        customerNoRuleDTO.setDayLimitCnt(limitService.getDayLimitCnt() / 1000);
        customerNoRuleDTO.setDayLimitAmt(limitService.getDayLimitAmt() / 1000);
        customerNoRuleDTO.setMonthLimitCnt(limitService.getMonthLimitCnt() / 1000);
        customerNoRuleDTO.setMonthLimitAmt(limitService.getMonthLimitAmt() / 1000);
        customerNoRuleDTO.setLimitCnt(limitService.getLimitCnt() / 1000);
        customerNoRuleDTO.setLimitAmt(limitService.getLimitAmt() / 1000);
        cancelAddLimitReqDTO.setCustomerNoRuleDTO(customerNoRuleDTO);

        DeviceNoRuleDTO deviceNoRuleDTO = new DeviceNoRuleDTO();
        deviceNoRuleDTO.setDeviceNo(limitService.getDeviceNo());
        deviceNoRuleDTO.setDayLimitCnt(limitService.getDayLimitCnt() / 1000);
        deviceNoRuleDTO.setDayLimitAmt(limitService.getDayLimitAmt() / 1000);
        deviceNoRuleDTO.setMonthLimitCnt(limitService.getMonthLimitCnt() / 1000);
        deviceNoRuleDTO.setMonthLimitAmt(limitService.getMonthLimitAmt() / 1000);
        deviceNoRuleDTO.setLimitCnt(limitService.getLimitCnt() / 1000);
        deviceNoRuleDTO.setLimitAmt(limitService.getLimitAmt() / 1000);
        cancelAddLimitReqDTO.setDeviceNoRuleDTO(deviceNoRuleDTO);

        MerchantNoRuleDTO merchantNoRuleDTO = new MerchantNoRuleDTO();
        merchantNoRuleDTO.setMerchantNo(limitService.getUserMerchantNo());
        merchantNoRuleDTO.setDayLimitCnt(limitService.getDayLimitCnt() / 1000);
        merchantNoRuleDTO.setDayLimitAmt(limitService.getDayLimitAmt() / 1000);
        merchantNoRuleDTO.setMonthLimitCnt(limitService.getMonthLimitCnt() / 1000);
        merchantNoRuleDTO.setMonthLimitAmt(limitService.getMonthLimitAmt() / 1000);
        merchantNoRuleDTO.setLimitCnt(limitService.getLimitCnt() / 1000);
        merchantNoRuleDTO.setLimitAmt(limitService.getLimitAmt() / 1000);
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

        Result<Boolean> result = limitAddService.cancelAddLimit(cancelAddLimitReqDTO);
        System.out.println("********************限额累加部分撤销********************");
        System.out.println("日志:" + traceLogId);
        System.out.println("请求流水:" + cancelAddLimitReqDTO.getRequestNo());
        System.out.println("请求时间:" + cancelAddLimitReqDTO.getRequestDate());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
    }
}
