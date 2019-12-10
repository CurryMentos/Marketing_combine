package Portal.common.MerchantService;

import java.util.Date;
import java.util.List;

import Customize.DataGenerate;
import com.alibaba.fastjson.JSON;
import com.xx.dubbo.result.Result;
import com.xx.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.xx.marketing.config.api.common.MerchantService;
import com.xx.marketing.config.api.common.models.request.MerchantDistinctQueryReqDTO;
import com.xx.marketing.config.api.common.models.response.MerchantDistinctRespDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/11/12.
 * 商户去重列表查询接口
 */
public class QueryMerchantDistinctList extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static MerchantService merchantService = (MerchantService)ac.getBean("merchantService");

    @Test
    public static void queryMerchantDistinctList() {
        MerchantDistinctQueryReqDTO merchantDistinctQueryReqDTO = new MerchantDistinctQueryReqDTO();
        merchantDistinctQueryReqDTO.setRelationId("");
        merchantDistinctQueryReqDTO.setMerchantId("");
        merchantDistinctQueryReqDTO.setRequestNo("");
        merchantDistinctQueryReqDTO.setRequestSystem("test");
        merchantDistinctQueryReqDTO.setRequestDate(new Date());
        merchantDistinctQueryReqDTO.setTraceLogId(TraceLogId());

        Result<List<MerchantDistinctRespDTO>> result = merchantService.queryMerchantDistinctList(merchantDistinctQueryReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + merchantDistinctQueryReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());

        List<MerchantDistinctRespDTO> merchantDistinctRespDTOList = result.getResult();
        String json = JSON.toJSONString(merchantDistinctRespDTOList,true);
        System.out.println(json);
    }
}
