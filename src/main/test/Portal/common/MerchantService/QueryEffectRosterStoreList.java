package Portal.common.MerchantService;

import com.xx.dubbo.result.Result;
import com.xx.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.xx.marketing.config.api.activity.models.PageInfoDTO;
import com.xx.marketing.config.api.common.MerchantService;
import com.xx.marketing.config.api.common.models.request.QueryEffectRosterStoreReqDTO;
import com.xx.marketing.config.api.common.models.response.EffectRosterStoreResDTO;
import org.testng.annotations.Test;


import java.util.UUID;

/**
 * Created by Administrator on 2019/10/31.
 */
public class QueryEffectRosterStoreList {
    MerchantService merchantService = BeanUtil.getBean("merchantService");

    //门店生效查询接口
    @Test
    public void queryEffectRosterStoreList() throws Exception {
        String traceLogId = UUID.randomUUID().toString();
        QueryEffectRosterStoreReqDTO queryEffectRosterStoreReqDTO = new QueryEffectRosterStoreReqDTO();
        queryEffectRosterStoreReqDTO.setStoreGroupCode("E30990190909095721000085");//门店组编号
        queryEffectRosterStoreReqDTO.setStoreId("");//门店号
        queryEffectRosterStoreReqDTO.setStoreName("");//门店名称
        queryEffectRosterStoreReqDTO.setBizType("");//业务类型--新增/启用：ENABLE；停用：DISENABLE
        queryEffectRosterStoreReqDTO.setPageSize("1");//分页大小
        queryEffectRosterStoreReqDTO.setPageNo("1");//当前页数
        queryEffectRosterStoreReqDTO.setTraceLogId(traceLogId);

        Result<PageInfoDTO<EffectRosterStoreResDTO>> result = merchantService.queryEffectRosterStoreList(queryEffectRosterStoreReqDTO);
        System.out.println("是否成功：" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
        System.out.println("日志:" + traceLogId);
    }
}
