package Portal.common.MerchantService;

import Customize.DataGenerate;
import com.alibaba.fastjson.JSON;
import com.xx.dubbo.result.Result;
import com.xx.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.xx.marketing.config.api.activity.models.PageInfoDTO;
import com.xx.marketing.config.api.common.MerchantService;
import com.xx.marketing.config.api.common.models.request.QueryRosterMerchantReqDTO;
import com.xx.marketing.config.api.common.models.response.RosterMerchantResDTO;
import com.xx.marketing.roster.api.enums.RelationTypeEnum;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * Created by Administrator on 2019/10/31.
 * 商户名单信息分页查询
 */
public class QueryRosterMerchant extends DataGenerate{
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static MerchantService merchantService = (MerchantService)ac.getBean("merchantService");

    @Test
    public static void queryRosterMerchant() {
        QueryRosterMerchantReqDTO queryRosterMerchantReqDTO = new QueryRosterMerchantReqDTO();
        queryRosterMerchantReqDTO.setRelationId("A40990191115175350000004");//关联编号
//        queryRosterMerchantReqDTO.setRelationType(RelationTypeEnum.ENCOURAGE.getCode());//关联类型
        queryRosterMerchantReqDTO.setBizId("RO9310191115203358000009");//业务编号
        queryRosterMerchantReqDTO.setMerchantId("");//商户号
        queryRosterMerchantReqDTO.setMerchantName("");//商户名称
        queryRosterMerchantReqDTO.setPageSize(10);//分页大小
        queryRosterMerchantReqDTO.setPageNo(1);//当前页数
        queryRosterMerchantReqDTO.setStatus("");
        queryRosterMerchantReqDTO.setTraceLogId(TraceLogId());

        Result<PageInfoDTO<RosterMerchantResDTO>> result = merchantService.queryRosterMerchant(queryRosterMerchantReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + queryRosterMerchantReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());

        PageInfoDTO<RosterMerchantResDTO> rosterMerchantResDTOPageInfoDTO = result.getResult();
        String json = JSON.toJSONString(rosterMerchantResDTOPageInfoDTO,true);
        System.out.println(json);
    }
}
