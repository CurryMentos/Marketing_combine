package Portal.common.MerchantService;

import java.util.Date;

import Customize.DataGenerate;
import com.alibaba.fastjson.JSON;
import com.xx.dubbo.result.Result;
import com.xx.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.xx.marketing.config.api.activity.models.PageInfoDTO;
import com.xx.marketing.config.api.common.MerchantService;
import com.xx.marketing.config.api.common.models.request.QueryEquityGoodsReqDTO;
import com.xx.marketing.config.api.common.models.response.GoodsResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/11/12.
 * 权益商品列表查询接口
 */
public class QueryEquityGoodsList extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static MerchantService merchantService = (MerchantService)ac.getBean("merchantService");

    @Test
    public static void queryEquityGoodsList() {
        QueryEquityGoodsReqDTO queryEquityGoodsReqDTO = new QueryEquityGoodsReqDTO();
        queryEquityGoodsReqDTO.setGoodsGroupCode("");
        queryEquityGoodsReqDTO.setEquityType("");
        queryEquityGoodsReqDTO.setPageSize(0);
        queryEquityGoodsReqDTO.setPageNo(0);
        queryEquityGoodsReqDTO.setRequestNo("");
        queryEquityGoodsReqDTO.setRequestSystem("test");
        queryEquityGoodsReqDTO.setRequestDate(new Date());
        queryEquityGoodsReqDTO.setTraceLogId(TraceLogId());

        Result<PageInfoDTO<GoodsResDTO>> result = merchantService.queryEquityGoodsList(queryEquityGoodsReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + queryEquityGoodsReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());

        PageInfoDTO<GoodsResDTO> goodsResDTOPageInfoDTO = result.getResult();
        String json = JSON.toJSONString(goodsResDTOPageInfoDTO,true);
        System.out.println(json);
    }
}
