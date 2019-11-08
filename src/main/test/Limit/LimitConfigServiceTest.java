package Limit;

import com.xx.dubbo.result.Result;
import com.xx.marketing.limit.api.LimitConfigService;
import com.xx.marketing.limit.api.models.EquityLimitDTO;
import com.xx.marketing.limit.api.models.LimitDTO;
import com.xx.marketing.limit.api.models.request.ModifyLimitReqDTO;
import com.xx.marketing.limit.api.models.request.SynchronizingLimitReqDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

public class LimitConfigServiceTest {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static LimitConfigService limitConfigService = (LimitConfigService) ac.getBean("limitConfigService");
    static LimitService limitService = new LimitService();
    static Date Before = Date.from(LocalDateTime.now(ZoneOffset.ofHours(8)).minusDays(10).withHour(0).withMinute(0).withSecond(0).toInstant(ZoneOffset.ofHours(8)));
    static Date After = Date.from(LocalDateTime.now(ZoneOffset.ofHours(8)).plusDays(8).withHour(23).withMinute(59).withSecond(59).toInstant(ZoneOffset.ofHours(8)));

    /*@BeforeTest
    public void setup() throws Exception {
    }*/

    //限额配置同步接口
    @Test
    public static void synchronizingLimitInfo() {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i <= 23; i++) {
            int randomNum = random.nextInt(9);
            String num = randomNum + "";
            stringBuffer = stringBuffer.append(num);
        }

        SynchronizingLimitReqDTO synchronizingLimitReqDTO = new SynchronizingLimitReqDTO();

        List<LimitDTO> limitDTOList = new ArrayList();
        LimitDTO limitDTO = new LimitDTO();
        limitDTO.setLimitType("ACTIVITY");//限额类型 ACTIVITY:活动维度;EQUITY:权益维度;TOOL:工具维度
        limitDTO.setLimitMainNo("A" + stringBuffer);//限额主体编号(活动号)
//        limitDTO.setLimitMainNo("A12157167364883735272832");
        limitDTO.setLimitMainNoStartTime(Before);
        limitDTO.setLimitMainNoExpireTime(After);

        List<EquityLimitDTO> equityLimitDTOList = new ArrayList();
        EquityLimitDTO equityLimitDTO = new EquityLimitDTO();
        equityLimitDTO.setEquityId("E" + stringBuffer);//权益号
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
        limitService.setEquityId(equityLimitDTO.getEquityId());

        Result<Boolean> result = limitConfigService.synchronizingLimitInfo(synchronizingLimitReqDTO);
        System.out.println("********************限额配置同步********************");
        System.out.println("日志:" + traceLogId);
        System.out.println("活动号:" + limitDTO.getLimitMainNo());
        System.out.println("权益号:" + equityLimitDTO.getEquityId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
    }

    //限额配置变更接口(尚未生效)
    @Test
    public void modifyLimitInfo() throws Exception {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");

        ModifyLimitReqDTO modifyLimitReqDTO = new ModifyLimitReqDTO();

        List<LimitDTO> limitDTOList = new ArrayList();
        LimitDTO limitDTO = new LimitDTO();
        limitDTO.setLimitType("ACTIVITY");//限额类型 ACTIVITY:活动维度;EQUITY:权益维度;TOOL:工具维度
        limitDTO.setLimitMainNo("");//限额主体编号
        limitDTO.setLimitMainNoStartTime(Before);
        limitDTO.setLimitMainNoExpireTime(After);

        List<EquityLimitDTO> equityLimitDTOList = new ArrayList();
        EquityLimitDTO equityLimitDTO = new EquityLimitDTO();
        equityLimitDTO.setEquityId("");//权益号
        equityLimitDTO.setTotalCnt(0L);//总笔数
        equityLimitDTO.setTotalAmt(0L);//总金额
        equityLimitDTO.setEquityExpireTime(new Date());

        equityLimitDTOList.add(equityLimitDTO);
        limitDTO.setEquityLimitDTOList(equityLimitDTOList);
        limitDTOList.add(limitDTO);
        modifyLimitReqDTO.setLimitDTOList(limitDTOList);
        modifyLimitReqDTO.setTraceLogId(traceLogId);

        Result<Boolean> result = limitConfigService.modifyLimitInfo(modifyLimitReqDTO);
        System.out.println("********************限额配置变更********************");
        System.out.println("日志:" + traceLogId);
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
    }
}
