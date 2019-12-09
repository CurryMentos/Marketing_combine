package Portal.common.MerchantService;
import java.util.Date;

import Customize.DataGenerate;
import com.alibaba.fastjson.JSON;
import com.bestpay.dubbo.result.Result;
import com.bestpay.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.bestpay.marketing.config.api.activity.models.PageInfoDTO;
import com.bestpay.marketing.config.api.common.MerchantService;
import com.bestpay.marketing.config.api.common.models.request.QueryActivityMerchantReqDTO;
import com.bestpay.marketing.config.api.common.models.response.MerchantResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/11/12.
 * 活动有效商户列表查询接口
 */
public class QueryActivityMerchantList extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static MerchantService merchantService = (MerchantService)ac.getBean("merchantService");

    @Test
    public static void queryActivityMerchantList() {
        QueryActivityMerchantReqDTO queryActivityMerchantReqDTO = new QueryActivityMerchantReqDTO();
        queryActivityMerchantReqDTO.setActivityId("");
        queryActivityMerchantReqDTO.setMerchantId("");
        queryActivityMerchantReqDTO.setStatus("");
        queryActivityMerchantReqDTO.setPageSize(0);
        queryActivityMerchantReqDTO.setPageNo(0);
        queryActivityMerchantReqDTO.setTranslateFlag(false);
        queryActivityMerchantReqDTO.setRequestNo("");
        queryActivityMerchantReqDTO.setRequestSystem("test");
        queryActivityMerchantReqDTO.setRequestDate(new Date());
        queryActivityMerchantReqDTO.setTraceLogId(TraceLogId());

        Result<PageInfoDTO<MerchantResDTO>> result = merchantService.queryActivityMerchantList(queryActivityMerchantReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + queryActivityMerchantReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());

        PageInfoDTO<MerchantResDTO> merchantResDTOPageInfoDTO = result.getResult();
        String json = JSON.toJSONString(merchantResDTOPageInfoDTO,true);
        System.out.println(json);
    }
}
