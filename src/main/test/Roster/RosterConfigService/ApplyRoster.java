package Roster.RosterConfigService;
import java.util.Date;

import Customize.DataGenerate;
import Customize.UserList;
import com.alibaba.fastjson.JSON;
import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.roster.api.RosterConfigService;
import com.bestpay.marketing.roster.api.enums.RelationTypeEnum;
import com.bestpay.marketing.roster.api.enums.RosterTypeEnum;
import com.bestpay.marketing.roster.api.models.request.RosterApplyReqDTO;
import com.bestpay.marketing.roster.api.models.response.RosterApplyResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/11/14.
 * 商户门店商品新增/启用、停用接口
 */
public class ApplyRoster extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static RosterConfigService rosterConfigService = (RosterConfigService) ac.getBean("rosterConfigService");

    @Test
    public static void applyRoster() {
        RosterApplyReqDTO rosterApplyReqDTO = new RosterApplyReqDTO();
        rosterApplyReqDTO.setFileName("");
        rosterApplyReqDTO.setFilePath(UserList.MerchantNo());
        rosterApplyReqDTO.setBizType("Enable");
        rosterApplyReqDTO.setRelationId("T30990191111101306000023");
        rosterApplyReqDTO.setRelationType(RelationTypeEnum.RECOMMEND.getCode());
        rosterApplyReqDTO.setRosterType(RosterTypeEnum.MERCHANT.getCode());
        rosterApplyReqDTO.setRosterChannelSource("");
        rosterApplyReqDTO.setTraceLogId(TraceLogId());
        rosterApplyReqDTO.setRequestNo("Req"+RandomStringNo());
        rosterApplyReqDTO.setRequestSystem("test");
        rosterApplyReqDTO.setRequestDate(new Date());

        Result<RosterApplyResDTO> result = rosterConfigService.applyRoster(rosterApplyReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + rosterApplyReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());

        RosterApplyResDTO rosterApplyResDTO = result.getResult();
        String json = JSON.toJSONString(rosterApplyResDTO, true);
        System.out.println(json);
    }
}
