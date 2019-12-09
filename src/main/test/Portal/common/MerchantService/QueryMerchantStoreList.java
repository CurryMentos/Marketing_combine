package Portal.common.MerchantService;
import java.util.Date;
import java.util.List;

import Customize.DataGenerate;
import com.alibaba.fastjson.JSON;
import com.bestpay.dubbo.result.Result;
import com.bestpay.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.bestpay.marketing.config.api.common.MerchantService;
import com.bestpay.marketing.config.api.common.models.request.MerchantStoreQueryReqDTO;
import com.bestpay.marketing.config.api.common.models.response.MerchantStoreRespDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/11/12.
 * 商户门店列表查询接口
 */
public class QueryMerchantStoreList extends DataGenerate{
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static MerchantService merchantService = (MerchantService)ac.getBean("merchantService");

    @Test
    public static void queryMerchantStoreList() {
        MerchantStoreQueryReqDTO merchantStoreQueryReqDTO = new MerchantStoreQueryReqDTO();
        merchantStoreQueryReqDTO.setRelationId("");
        merchantStoreQueryReqDTO.setMerchantId("");
        merchantStoreQueryReqDTO.setRequestNo("");
        merchantStoreQueryReqDTO.setRequestSystem("");
        merchantStoreQueryReqDTO.setRequestDate(new Date());
        merchantStoreQueryReqDTO.setTraceLogId(TraceLogId());

        Result<List<MerchantStoreRespDTO>> result = merchantService.queryMerchantStoreList(merchantStoreQueryReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + merchantStoreQueryReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());

        List<MerchantStoreRespDTO> merchantStoreRespDTOList = result.getResult();
        String json = JSON.toJSONString(merchantStoreRespDTOList,true);
        System.out.println(json);
    }
}
