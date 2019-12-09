package Roster.RosterQueryService;
import java.util.Date;

import Customize.DataGenerate;
import com.alibaba.fastjson.JSON;
import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.roster.api.RosterQueryService;
import com.bestpay.marketing.roster.api.models.request.BaseReqDTO;
import com.bestpay.marketing.roster.api.models.response.RosterApplyResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/11/14.
 * 查询名单申请结果接口
 */
public class QueryRosterApply extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static RosterQueryService rosterQueryService = (RosterQueryService) ac.getBean("rosterQueryService");

    @Test
    public static void queryRosterApply(){
        BaseReqDTO baseReqDTO = new BaseReqDTO();
        baseReqDTO.setTraceLogId(TraceLogId());
        baseReqDTO.setRequestNo("");
        baseReqDTO.setRequestSystem("test");
        baseReqDTO.setRequestDate(new Date());

        Result<RosterApplyResDTO> result = rosterQueryService.queryRosterApply(baseReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + baseReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());

        RosterApplyResDTO rosterApplyResDTO = result.getResult();
        String json = JSON.toJSONString(rosterApplyResDTO, true);
        System.out.println(json);
    }
}
