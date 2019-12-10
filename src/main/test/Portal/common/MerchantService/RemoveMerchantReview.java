package Portal.common.MerchantService;

import java.util.Date;

import Customize.DataGenerate;
import com.xx.dubbo.result.Result;
import com.xx.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.xx.marketing.config.api.common.MerchantService;
import com.xx.marketing.config.api.common.models.request.RemoveMerchantReviewReqDTO;
import com.xx.marketing.config.api.enums.RemoveTypeEnum;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/11/12.
 * 删除商户名单接口
 */
public class RemoveMerchantReview extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static MerchantService merchantService = (MerchantService)ac.getBean("merchantService");

    @Test
    public static void removeMerchantReview() {
        RemoveMerchantReviewReqDTO removeMerchantReviewReqDTO = new RemoveMerchantReviewReqDTO();
        removeMerchantReviewReqDTO.setRelationId("");
        removeMerchantReviewReqDTO.setRemoveType(RemoveTypeEnum.INVALID.getCode());
        removeMerchantReviewReqDTO.setRequestNo("");
        removeMerchantReviewReqDTO.setRequestSystem("test");
        removeMerchantReviewReqDTO.setRequestDate(new Date());
        removeMerchantReviewReqDTO.setTraceLogId(TraceLogId());

        Result<Boolean> result = merchantService.removeMerchantReview(removeMerchantReviewReqDTO);
        System.out.println("日志:" + removeMerchantReviewReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
