package Portal.common.MerchantService;
import java.util.Date;
import java.util.List;

import Customize.DataGenerate;
import com.alibaba.fastjson.JSON;
import com.xx.dubbo.result.Result;
import com.xx.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.xx.marketing.config.api.common.MerchantService;
import com.xx.marketing.config.api.common.models.request.MerchantGoodsQueryReqDTO;
import com.xx.marketing.config.api.common.models.response.MerchantGoodsRespDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/11/12.
 * 商户商品列表查询接口
 */
public class QueryMerchantGoodsList extends DataGenerate{
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static MerchantService merchantService = (MerchantService)ac.getBean("merchantService");

    @Test
    public static void queryMerchantGoodsList(){
        MerchantGoodsQueryReqDTO merchantGoodsQueryReqDTO = new MerchantGoodsQueryReqDTO();
        merchantGoodsQueryReqDTO.setRelationId("");
        merchantGoodsQueryReqDTO.setMerchantId("");
        merchantGoodsQueryReqDTO.setRequestNo("");
        merchantGoodsQueryReqDTO.setRequestSystem("");
        merchantGoodsQueryReqDTO.setRequestDate(new Date());
        merchantGoodsQueryReqDTO.setTraceLogId(TraceLogId());

        Result<List<MerchantGoodsRespDTO>> result = merchantService.queryMerchantGoodsList(merchantGoodsQueryReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + merchantGoodsQueryReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());

        List<MerchantGoodsRespDTO> merchantGoodsRespDTOList = result.getResult();
        String json = JSON.toJSONString(merchantGoodsRespDTOList,true);
        System.out.println(json);
    }
}
