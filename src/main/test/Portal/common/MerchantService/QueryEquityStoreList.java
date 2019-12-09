package Portal.common.MerchantService;
import java.util.Date;

import Customize.DataGenerate;
import com.alibaba.fastjson.JSON;
import com.bestpay.dubbo.result.Result;
import com.bestpay.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.bestpay.marketing.config.api.activity.models.PageInfoDTO;
import com.bestpay.marketing.config.api.common.MerchantService;
import com.bestpay.marketing.config.api.common.models.request.QueryEquityStoreReqDTO;
import com.bestpay.marketing.config.api.common.models.response.StoreResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/11/12.
 * 权益门店列表查询接口
 */
public class QueryEquityStoreList extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static MerchantService merchantService = (MerchantService)ac.getBean("merchantService");

    @Test
    public static void queryEquityStoreList() {
        QueryEquityStoreReqDTO queryEquityStoreReqDTO = new QueryEquityStoreReqDTO();
        queryEquityStoreReqDTO.setStoreGroupCode("");
        queryEquityStoreReqDTO.setEquityType("");
        queryEquityStoreReqDTO.setPageSize(0);
        queryEquityStoreReqDTO.setPageNo(0);
        queryEquityStoreReqDTO.setRequestNo("");
        queryEquityStoreReqDTO.setRequestSystem("test");
        queryEquityStoreReqDTO.setRequestDate(new Date());
        queryEquityStoreReqDTO.setTraceLogId(TraceLogId());

        Result<PageInfoDTO<StoreResDTO>> result = merchantService.queryEquityStoreList(queryEquityStoreReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + queryEquityStoreReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());

        PageInfoDTO<StoreResDTO> storeResDTOPageInfoDTO = result.getResult();
        String json = JSON.toJSONString(storeResDTOPageInfoDTO,true);
        System.out.println(json);
    }
}
