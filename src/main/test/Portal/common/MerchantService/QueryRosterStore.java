package Portal.common.MerchantService;

import com.xx.dubbo.result.Result;
import com.xx.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.xx.marketing.config.api.activity.models.PageInfoDTO;
import com.xx.marketing.config.api.common.MerchantService;
import com.xx.marketing.config.api.common.models.request.QueryRosterStoreReqDTO;
import com.xx.marketing.config.api.common.models.response.RosterStoreResDTO;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * Created by Administrator on 2019/10/31.
 */
public class QueryRosterStore {
    MerchantService merchantService = BeanUtil.getBean("merchantService");

    //门店信息查询接口
    @Test
    public void queryRosterStore() throws Exception {
        String traceLogId = UUID.randomUUID().toString();
        QueryRosterStoreReqDTO queryRosterStoreReqDTO = new QueryRosterStoreReqDTO();
        queryRosterStoreReqDTO.setStoreGroupCode("E30990190909095721000085");//门店组编码
        queryRosterStoreReqDTO.setStoreId("");//门店编号
        queryRosterStoreReqDTO.setStoreName("");//门店名称
        queryRosterStoreReqDTO.setStatus("");//状态
        queryRosterStoreReqDTO.setPageSize(1);//分页大小
        queryRosterStoreReqDTO.setPageNo(1);//当前页数
        queryRosterStoreReqDTO.setTraceLogId(traceLogId);

        Result<PageInfoDTO<RosterStoreResDTO>> result = merchantService.queryRosterStore(queryRosterStoreReqDTO);
        System.out.println("是否成功：" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
        System.out.println("日志:" + traceLogId);
    }
}
