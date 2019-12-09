package Portal.common.MerchantService;

import java.util.Date;

import Customize.DataGenerate;
import com.bestpay.dubbo.result.Result;
import com.bestpay.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.bestpay.marketing.config.api.common.MerchantService;
import com.bestpay.marketing.config.api.common.models.request.RemoveSingleMerchantReviewReqDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/11/12.
 * 删除单个商户名单接口
 */
public class RemoveSingleMerchantReview extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static MerchantService merchantService = (MerchantService)ac.getBean("merchantService");

    @Test
    public static void removeSingleMerchantReview() {
        RemoveSingleMerchantReviewReqDTO removeSingleMerchantReviewReqDTO = new RemoveSingleMerchantReviewReqDTO();
        removeSingleMerchantReviewReqDTO.setRelationId("");
        removeSingleMerchantReviewReqDTO.setMerchantId("");
        removeSingleMerchantReviewReqDTO.setStoreId("");
        removeSingleMerchantReviewReqDTO.setRequestNo("");
        removeSingleMerchantReviewReqDTO.setRequestSystem("test");
        removeSingleMerchantReviewReqDTO.setRequestDate(new Date());
        removeSingleMerchantReviewReqDTO.setTraceLogId(TraceLogId());

        Result<Boolean> result = merchantService.removeSingleMerchantReview(removeSingleMerchantReviewReqDTO);
        System.out.println("日志:" + removeSingleMerchantReviewReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
