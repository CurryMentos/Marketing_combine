package Portal.common.MerchantService;

import com.xx.dubbo.result.Result;
import com.xx.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.xx.marketing.config.api.activity.models.PageInfoDTO;
import com.xx.marketing.config.api.common.MerchantService;
import com.xx.marketing.config.api.common.models.request.QueryEffectRosterGoodsReqDTO;
import com.xx.marketing.config.api.common.models.response.EffectRosterGoodsResDTO;
import org.testng.annotations.Test;
import java.util.UUID;

/**
 * Created by Administrator on 2019/10/31.
 */
public class QueryEffectRosterGoodsList {
    MerchantService merchantService = BeanUtil.getBean("merchantService");

    //商品生效查询接口
    @Test
    public void queryEffectRosterGoodsList() throws Exception {
        String traceLogId = UUID.randomUUID().toString();
        QueryEffectRosterGoodsReqDTO queryEffectRosterGoodsReqDTO = new QueryEffectRosterGoodsReqDTO();
        queryEffectRosterGoodsReqDTO.setGoodsGroupCode("E30990190909095721000085");//商品组编号
        queryEffectRosterGoodsReqDTO.setGoodsId("");//商品号
        queryEffectRosterGoodsReqDTO.setGoodsName("");//商品名称
        queryEffectRosterGoodsReqDTO.setBizType("");//业务类型
        queryEffectRosterGoodsReqDTO.setPageSize("1");//分页大小
        queryEffectRosterGoodsReqDTO.setPageNo("1");//当前页数
        queryEffectRosterGoodsReqDTO.setTraceLogId(traceLogId);


        Result<PageInfoDTO<EffectRosterGoodsResDTO>> result = merchantService.queryEffectRosterGoodsList(queryEffectRosterGoodsReqDTO);
        System.out.println("是否成功：" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
        System.out.println("日志:" + traceLogId);
    }
}
