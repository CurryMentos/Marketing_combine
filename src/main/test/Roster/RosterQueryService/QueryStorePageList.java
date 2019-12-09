package Roster.RosterQueryService;
import java.util.Date;

import Customize.DataGenerate;
import com.alibaba.fastjson.JSON;
import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.roster.api.RosterQueryService;
import com.bestpay.marketing.roster.api.models.request.merchant.StoreQueryReqDTO;
import com.bestpay.marketing.roster.api.models.response.PageResDTO;
import com.bestpay.marketing.roster.api.models.response.merchant.StoreQueryResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/11/14.
 * 门店列表分页查询
 */
public class QueryStorePageList extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static RosterQueryService rosterQueryService = (RosterQueryService) ac.getBean("rosterQueryService");

    @Test
    public static void queryStorePageList() {
        StoreQueryReqDTO storeQueryReqDTO = new StoreQueryReqDTO();
        storeQueryReqDTO.setStoreGroupNo("");
        storeQueryReqDTO.setStoreId("");
        storeQueryReqDTO.setStoreName("");
        storeQueryReqDTO.setBizType("");
        storeQueryReqDTO.setPageSize(0);
        storeQueryReqDTO.setPageNo(0);
        storeQueryReqDTO.setTraceLogId(TraceLogId());
        storeQueryReqDTO.setRequestNo("");
        storeQueryReqDTO.setRequestSystem("test");
        storeQueryReqDTO.setRequestDate(new Date());

        Result<PageResDTO<StoreQueryResDTO>> result = rosterQueryService.queryStorePageList(storeQueryReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + storeQueryReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());

        PageResDTO<StoreQueryResDTO> storeQueryResDTOPageResDTO = result.getResult();
        String json = JSON.toJSONString(storeQueryResDTOPageResDTO, true);
        System.out.println(json);
    }
}
