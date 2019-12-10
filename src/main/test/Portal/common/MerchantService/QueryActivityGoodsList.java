package Portal.common.MerchantService;
import java.util.Date;

import Customize.DataGenerate;
import com.alibaba.fastjson.JSON;
import com.xx.dubbo.result.Result;
import com.xx.marketing.config.api.activity.models.PageInfoDTO;
import com.xx.marketing.config.api.common.MerchantService;
import com.xx.marketing.config.api.common.models.request.QueryActivityGoodsReqDTO;
import com.xx.marketing.config.api.common.models.response.GoodsResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/11/12.
 * 活动商品列表查询接口
 */
public class QueryActivityGoodsList extends DataGenerate{
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static MerchantService merchantService = (MerchantService)ac.getBean("merchantService");

    @Test
    public static void queryActivityGoodsList(){
        QueryActivityGoodsReqDTO queryActivityGoodsReqDTO = new QueryActivityGoodsReqDTO();
        queryActivityGoodsReqDTO.setGoodsGroupCode("GG9960191112104706000002");
        queryActivityGoodsReqDTO.setPageSize(10);
        queryActivityGoodsReqDTO.setPageNo(1);
        queryActivityGoodsReqDTO.setRequestNo("Req"+RandomStringNo());
        queryActivityGoodsReqDTO.setRequestSystem("test");
        queryActivityGoodsReqDTO.setRequestDate(new Date());
        queryActivityGoodsReqDTO.setTraceLogId(TraceLogId());

        Result<PageInfoDTO<GoodsResDTO>> result = merchantService.queryActivityGoodsList(queryActivityGoodsReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + queryActivityGoodsReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());

        PageInfoDTO<GoodsResDTO> goodsResDTOPageInfoDTO = result.getResult();
        String json = JSON.toJSONString(goodsResDTOPageInfoDTO,true);
        System.out.println(json);
    }
}
