package Portal.common.MerchantService;

import java.util.Date;

import Customize.DataGenerate;
import com.alibaba.fastjson.JSON;
import com.xx.dubbo.result.Result;
import com.xx.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.xx.marketing.config.api.activity.models.PageInfoDTO;
import com.xx.marketing.config.api.common.MerchantService;
import com.xx.marketing.config.api.common.models.request.QueryEquityMerchantReqDTO;
import com.xx.marketing.config.api.common.models.response.MerchantResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/11/12.
 * 权益有效商户列表查询接口
 */
public class QueryEquityMerchantList extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static MerchantService merchantService = (MerchantService)ac.getBean("merchantService");

    @Test
    public static void queryEquityMerchantList() {
        QueryEquityMerchantReqDTO queryEquityMerchantReqDTO = new QueryEquityMerchantReqDTO();
        queryEquityMerchantReqDTO.setEquityId("");
        queryEquityMerchantReqDTO.setEquityType("");
        queryEquityMerchantReqDTO.setMerchantId("");
        queryEquityMerchantReqDTO.setStatus("");
        queryEquityMerchantReqDTO.setPageSize(0);
        queryEquityMerchantReqDTO.setPageNo(0);
        queryEquityMerchantReqDTO.setTranslateFlag(false);
        queryEquityMerchantReqDTO.setRequestNo("");
        queryEquityMerchantReqDTO.setRequestSystem("");
        queryEquityMerchantReqDTO.setRequestDate(new Date());
        queryEquityMerchantReqDTO.setTraceLogId(TraceLogId());

        Result<PageInfoDTO<MerchantResDTO>> result = merchantService.queryEquityMerchantList(queryEquityMerchantReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + queryEquityMerchantReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());

        PageInfoDTO<MerchantResDTO> merchantResDTOPageInfoDTO = result.getResult();
        String json = JSON.toJSONString(merchantResDTOPageInfoDTO,true);
        System.out.println(json);
    }
}
