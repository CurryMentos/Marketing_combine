package Portal.common.MerchantService;

import java.util.Date;

import Customize.DataGenerate;
import com.alibaba.fastjson.JSON;
import com.bestpay.dubbo.result.Result;
import com.bestpay.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.bestpay.marketing.config.api.common.MerchantService;
import com.bestpay.marketing.config.api.common.models.request.MerchantReviewQueryReqDTO;
import com.bestpay.marketing.config.api.common.models.response.MerchantReviewRespDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/11/12.
 * 商户复核列表查询接口
 */
public class QueryMerchantReviewList extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static MerchantService merchantService = (MerchantService) ac.getBean("merchantService");

    @Test
    public static void queryMerchantReviewList() {
        MerchantReviewQueryReqDTO merchantReviewQueryReqDTO = new MerchantReviewQueryReqDTO();
        merchantReviewQueryReqDTO.setRelationId("");
        merchantReviewQueryReqDTO.setMerchantId("");
        merchantReviewQueryReqDTO.setStoreId("");
        merchantReviewQueryReqDTO.setStatus("");
        merchantReviewQueryReqDTO.setPageSize(0);
        merchantReviewQueryReqDTO.setPageNum(0);
        merchantReviewQueryReqDTO.setRequestNo("Req" + RandomStringNo());
        merchantReviewQueryReqDTO.setRequestSystem("test");
        merchantReviewQueryReqDTO.setRequestDate(new Date());
        merchantReviewQueryReqDTO.setTraceLogId(TraceLogId());

        Result<MerchantReviewRespDTO> result = merchantService.queryMerchantReviewList(merchantReviewQueryReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + merchantReviewQueryReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());

        MerchantReviewRespDTO merchantReviewRespDTO = result.getResult();
        String json = JSON.toJSONString(merchantReviewRespDTO, true);
        System.out.println(json);
    }
}
