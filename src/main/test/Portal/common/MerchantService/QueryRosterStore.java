package Portal.common.MerchantService;

import Customize.DataGenerate;
import com.alibaba.fastjson.JSON;
import com.bestpay.dubbo.result.Result;
import com.bestpay.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.bestpay.marketing.config.api.activity.models.PageInfoDTO;
import com.bestpay.marketing.config.api.common.MerchantService;
import com.bestpay.marketing.config.api.common.models.request.QueryRosterStoreReqDTO;
import com.bestpay.marketing.config.api.common.models.response.RosterStoreResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * Created by Administrator on 2019/10/31.
 * 商户门店名单信息分页查询
 */
public class QueryRosterStore extends DataGenerate{
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static MerchantService merchantService = (MerchantService)ac.getBean("merchantService");

    @Test
    public static void queryRosterStore() {
        QueryRosterStoreReqDTO queryRosterStoreReqDTO = new QueryRosterStoreReqDTO();
        queryRosterStoreReqDTO.setStoreGroupCode("SG5730191111164015000029");//门店组编码
//        queryRosterStoreReqDTO.setStoreId("S1");//门店编号
//        queryRosterStoreReqDTO.setStoreName("");//门店名称
        queryRosterStoreReqDTO.setStatus("");//状态
        queryRosterStoreReqDTO.setPageSize(10);//分页大小
        queryRosterStoreReqDTO.setPageNo(1);//当前页数
        queryRosterStoreReqDTO.setTraceLogId(TraceLogId());

        Result<PageInfoDTO<RosterStoreResDTO>> result = merchantService.queryRosterStore(queryRosterStoreReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + queryRosterStoreReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());

        PageInfoDTO<RosterStoreResDTO> rosterStoreResDTOPageInfoDTO = result.getResult();
        String json = JSON.toJSONString(rosterStoreResDTOPageInfoDTO,true);
        System.out.println(json);
    }
}
