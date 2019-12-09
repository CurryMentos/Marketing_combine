package Roster.RosterQueryService;
import java.util.Date;

import Customize.DataGenerate;
import com.alibaba.fastjson.JSON;
import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.roster.api.RosterQueryService;
import com.bestpay.marketing.roster.api.models.request.merchant.GoodsQueryReqDTO;
import com.bestpay.marketing.roster.api.models.response.PageResDTO;
import com.bestpay.marketing.roster.api.models.response.merchant.GoodsQueryResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/11/14.
 * 商品列表分页查询
 */
public class QueryGoodsPageList extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static RosterQueryService rosterQueryService = (RosterQueryService) ac.getBean("rosterQueryService");

    @Test
    public static void queryGoodsPageList() {
        GoodsQueryReqDTO goodsQueryReqDTO = new GoodsQueryReqDTO();
        goodsQueryReqDTO.setGoodsGroupNo("");
        goodsQueryReqDTO.setGoodsId("");
        goodsQueryReqDTO.setGoodsName("");
        goodsQueryReqDTO.setBizType("");
        goodsQueryReqDTO.setPageSize(0);
        goodsQueryReqDTO.setPageNo(0);
        goodsQueryReqDTO.setTraceLogId(TraceLogId());
        goodsQueryReqDTO.setRequestNo("");
        goodsQueryReqDTO.setRequestSystem("test");
        goodsQueryReqDTO.setRequestDate(new Date());

        Result<PageResDTO<GoodsQueryResDTO>> result = rosterQueryService.queryGoodsPageList(goodsQueryReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + goodsQueryReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());

        PageResDTO<GoodsQueryResDTO> goodsQueryResDTOPageResDTO = result.getResult();
        String json = JSON.toJSONString(goodsQueryResDTOPageResDTO, true);
        System.out.println(json);
    }
}
