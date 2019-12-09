package Portal.common.MerchantService;
import java.util.Date;

import Customize.DataGenerate;
import com.alibaba.fastjson.JSON;
import com.bestpay.dubbo.result.Result;
import com.bestpay.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.bestpay.marketing.config.api.activity.models.PageInfoDTO;
import com.bestpay.marketing.config.api.common.MerchantService;
import com.bestpay.marketing.config.api.common.models.request.QueryActivityStoreReqDTO;
import com.bestpay.marketing.config.api.common.models.response.StoreResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/11/12.
 * 活动门店列表查询接口
 */
public class QueryActivityStoreList extends DataGenerate{
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static MerchantService merchantService = (MerchantService)ac.getBean("merchantService");

    @Test
    public static void queryActivityStoreList(){
        QueryActivityStoreReqDTO queryActivityStoreReqDTO = new QueryActivityStoreReqDTO();
        queryActivityStoreReqDTO.setStoreGroupCode("");
        queryActivityStoreReqDTO.setPageSize(0);
        queryActivityStoreReqDTO.setPageNo(0);
        queryActivityStoreReqDTO.setRequestNo("");
        queryActivityStoreReqDTO.setRequestSystem("test");
        queryActivityStoreReqDTO.setRequestDate(new Date());
        queryActivityStoreReqDTO.setTraceLogId(TraceLogId());

        Result<PageInfoDTO<StoreResDTO>> result  = merchantService.queryActivityStoreList(queryActivityStoreReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + queryActivityStoreReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());

        PageInfoDTO<StoreResDTO> storeResDTOPageInfoDTO = result.getResult();
        String json = JSON.toJSONString(storeResDTOPageInfoDTO,true);
        System.out.println(json);
    }
}
