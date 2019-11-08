package Portal.common.MerchantService;

import com.xx.dubbo.result.Result;
import com.xx.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.xx.marketing.config.api.activity.models.PageInfoDTO;
import com.xx.marketing.config.api.common.MerchantService;
import com.xx.marketing.config.api.common.models.request.QueryRosterMerchantReqDTO;
import com.xx.marketing.config.api.common.models.response.RosterMerchantResDTO;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * Created by Administrator on 2019/10/31.
 */
public class QueryRosterMerchant {
    MerchantService merchantService = BeanUtil.getBean("merchantService");

    //商户信息查询接口
    @Test
    public void queryRosterMerchant() throws Exception {
        String traceLogId = UUID.randomUUID().toString();
        QueryRosterMerchantReqDTO queryRosterMerchantReqDTO = new QueryRosterMerchantReqDTO();
        queryRosterMerchantReqDTO.setRelationId("E30990190909095721000085");//关联编号
        queryRosterMerchantReqDTO.setRelationType("");//关联类型
        queryRosterMerchantReqDTO.setBizId("");//业务编号
        queryRosterMerchantReqDTO.setMerchantId("");//商户号
        queryRosterMerchantReqDTO.setMerchantName("");//商户名称
        queryRosterMerchantReqDTO.setPageSize(1);//分页大小
        queryRosterMerchantReqDTO.setPageNo(1);//当前页数
        queryRosterMerchantReqDTO.setStatus("");
        queryRosterMerchantReqDTO.setTraceLogId(traceLogId);

        Result<PageInfoDTO<RosterMerchantResDTO>> result = merchantService.queryRosterMerchant(queryRosterMerchantReqDTO);
        System.out.println("是否成功：" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
        System.out.println("日志:" + traceLogId);
    }
}
