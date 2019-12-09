package Portal.common.MerchantService;
import java.util.Date;

import Customize.DataGenerate;
import com.bestpay.dubbo.result.Result;
import com.bestpay.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.bestpay.marketing.config.api.common.MerchantService;
import com.bestpay.marketing.config.api.common.models.request.RemoveMerchantGoodsReqDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/11/12.
 * 删除商户商品接口
 */
public class RemoveMerchantGoods extends DataGenerate{
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static MerchantService merchantService = (MerchantService)ac.getBean("merchantService");

    @Test
    public static void removeMerchantGoods() {
        RemoveMerchantGoodsReqDTO removeMerchantGoodsReqDTO = new RemoveMerchantGoodsReqDTO();
        removeMerchantGoodsReqDTO.setRelationId("");
        removeMerchantGoodsReqDTO.setMerchantId("");
        removeMerchantGoodsReqDTO.setRequestNo("");
        removeMerchantGoodsReqDTO.setRequestSystem("test");
        removeMerchantGoodsReqDTO.setRequestDate(new Date());
        removeMerchantGoodsReqDTO.setTraceLogId(TraceLogId());

        Result<Boolean> result = merchantService.removeMerchantGoods(removeMerchantGoodsReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + removeMerchantGoodsReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
    }
}
