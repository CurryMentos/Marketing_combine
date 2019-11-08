package Portal.common.MerchantService;

import com.xx.dubbo.result.Result;
import com.xx.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.xx.marketing.config.api.activity.models.PageInfoDTO;
import com.xx.marketing.config.api.common.MerchantService;
import com.xx.marketing.config.api.common.models.request.QueryEffectRosterMerchantReqDTO;
import com.xx.marketing.config.api.common.models.response.EffectRosterMerchantResDTO;
import org.testng.annotations.Test;
import java.util.UUID;

/**
 * Created by Administrator on 2019/10/31.
 */
public class QueryEffectRosterMerchantList {
    MerchantService merchantService = BeanUtil.getBean("merchantService");

    //商户生效查询接口
    @Test
    public void queryEffectRosterMerchantList() throws Exception {
        String traceLogId = UUID.randomUUID().toString();
        QueryEffectRosterMerchantReqDTO queryEffectRosterMerchantReqDTO = new QueryEffectRosterMerchantReqDTO();
        queryEffectRosterMerchantReqDTO.setRelationId("E30990190909095721000085");//关联编号
        //工具号、活动号、权益号
        queryEffectRosterMerchantReqDTO.setRelationType("");//关联类型
        //推荐人工具：RECOMMEND，双向激励工具：ENCOURAGE，商户红包工具：MERCHANT_REDBAG；
        //活动：ACTIVITY；代金券权益：VOUCHER，红包金权益：COUPON
        queryEffectRosterMerchantReqDTO.setToolId("");//工具号
        queryEffectRosterMerchantReqDTO.setMerchantId("");//商户号
        queryEffectRosterMerchantReqDTO.setBizType("");//业务类型
        queryEffectRosterMerchantReqDTO.setPageSize(1);//分页大小
        queryEffectRosterMerchantReqDTO.setPageNo(1);//当前页数
        queryEffectRosterMerchantReqDTO.setTraceLogId(traceLogId);

        Result<PageInfoDTO<EffectRosterMerchantResDTO>> result = merchantService.queryEffectRosterMerchantList(queryEffectRosterMerchantReqDTO);
        System.out.println("是否成功：" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
        System.out.println("日志:" + traceLogId);
    }
}
