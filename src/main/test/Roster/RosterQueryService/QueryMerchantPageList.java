package Roster.RosterQueryService;

import java.util.Date;

import Customize.DataGenerate;
import com.alibaba.fastjson.JSON;
import com.xx.dubbo.result.Result;
import com.xx.marketing.roster.api.RosterQueryService;
import com.xx.marketing.roster.api.models.request.merchant.MerchantQueryReqDTO;
import com.xx.marketing.roster.api.models.response.PageResDTO;
import com.xx.marketing.roster.api.models.response.merchant.MerchantQueryResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/11/14.
 * 商户列表分页查询
 */
public class QueryMerchantPageList extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static RosterQueryService rosterQueryService = (RosterQueryService) ac.getBean("rosterQueryService");

    @Test
    public static void queryMerchantPageList() {
        MerchantQueryReqDTO merchantQueryReqDTO = new MerchantQueryReqDTO();
        merchantQueryReqDTO.setRelationId("");
        merchantQueryReqDTO.setMerchantId("");
        merchantQueryReqDTO.setBizType("");
        merchantQueryReqDTO.setPageSize(0);
        merchantQueryReqDTO.setPageNo(0);
        merchantQueryReqDTO.setTraceLogId(TraceLogId());
        merchantQueryReqDTO.setRequestNo("");
        merchantQueryReqDTO.setRequestSystem("test");
        merchantQueryReqDTO.setRequestDate(new Date());

        Result<PageResDTO<MerchantQueryResDTO>> result = rosterQueryService.queryMerchantPageList(merchantQueryReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + merchantQueryReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());

        PageResDTO<MerchantQueryResDTO> merchantQueryResDTOPageResDTO = result.getResult();
        String json = JSON.toJSONString(merchantQueryResDTOPageResDTO, true);
        System.out.println(json);
    }
}
