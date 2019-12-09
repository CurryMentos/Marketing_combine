package Portal.common.MerchantService;

import Customize.DataGenerate;
import com.alibaba.fastjson.JSON;
import com.bestpay.dubbo.result.Result;
import com.bestpay.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.bestpay.marketing.config.api.activity.models.PageInfoDTO;
import com.bestpay.marketing.config.api.common.MerchantService;
import com.bestpay.marketing.config.api.common.models.request.QueryEffectRosterStoreReqDTO;
import com.bestpay.marketing.config.api.common.models.response.EffectRosterStoreResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;


import java.util.UUID;

/**
 * Created by Administrator on 2019/10/31.
 * 门店生效分页查询（名单中心）
 */
public class QueryEffectRosterStoreList extends DataGenerate{
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static MerchantService merchantService = (MerchantService)ac.getBean("merchantService");

    @Test
    public static void queryEffectRosterStoreList() {
        QueryEffectRosterStoreReqDTO queryEffectRosterStoreReqDTO = new QueryEffectRosterStoreReqDTO();
        queryEffectRosterStoreReqDTO.setStoreGroupCode("SG5680191121174500000024");//门店组编号
        queryEffectRosterStoreReqDTO.setStoreId("");//门店号
        queryEffectRosterStoreReqDTO.setStoreName("");//门店名称
        queryEffectRosterStoreReqDTO.setBizType("");//业务类型--新增/启用：ENABLE；停用：DISENABLE
        queryEffectRosterStoreReqDTO.setPageSize(100);//分页大小
        queryEffectRosterStoreReqDTO.setPageNo(1);//当前页数
        queryEffectRosterStoreReqDTO.setTraceLogId(TraceLogId());

        Result<PageInfoDTO<EffectRosterStoreResDTO>> result = merchantService.queryEffectRosterStoreList(queryEffectRosterStoreReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + queryEffectRosterStoreReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());

        PageInfoDTO<EffectRosterStoreResDTO> effectRosterStoreResDTOPageInfoDTO = result.getResult();
        String json = JSON.toJSONString(effectRosterStoreResDTOPageInfoDTO,true);
        System.out.println(json);
    }
}
