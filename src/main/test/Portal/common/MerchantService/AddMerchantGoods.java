package Portal.common.MerchantService;
import Customize.DataGenerate;
import com.xx.dubbo.result.Result;
import com.google.common.collect.Lists;
import java.util.Date;

import com.xx.marketing.config.api.common.MerchantService;
import com.xx.marketing.config.api.common.models.request.AddMerchantGoodsReqDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/11/12.
 * 新增商户商品接口
 */
public class AddMerchantGoods extends DataGenerate{
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static MerchantService merchantService = (MerchantService)ac.getBean("merchantService");

    @Test
    public static void addMerchantGoods() {
        AddMerchantGoodsReqDTO addMerchantGoodsReqDTO = new AddMerchantGoodsReqDTO();
        addMerchantGoodsReqDTO.setRelationId("");
        addMerchantGoodsReqDTO.setMerchantId("");
        addMerchantGoodsReqDTO.setAddMerchantGoodsDTOList(Lists.newArrayList());
        addMerchantGoodsReqDTO.setRequestNo("");
        addMerchantGoodsReqDTO.setRequestSystem("");
        addMerchantGoodsReqDTO.setRequestDate(new Date());
        addMerchantGoodsReqDTO.setTraceLogId(TraceLogId());

        Result<Boolean> result = merchantService.addMerchantGoods(addMerchantGoodsReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + addMerchantGoodsReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
    }
}
