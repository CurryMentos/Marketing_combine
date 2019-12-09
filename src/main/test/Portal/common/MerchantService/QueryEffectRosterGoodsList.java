package Portal.common.MerchantService;

import Customize.DataGenerate;
import com.alibaba.fastjson.JSON;
import com.bestpay.dubbo.result.Result;
import com.bestpay.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.bestpay.marketing.config.api.activity.models.PageInfoDTO;
import com.bestpay.marketing.config.api.common.MerchantService;
import com.bestpay.marketing.config.api.common.models.request.QueryEffectRosterGoodsReqDTO;
import com.bestpay.marketing.config.api.common.models.response.EffectRosterGoodsResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;
import java.util.UUID;

/**
 * Created by Administrator on 2019/10/31.
 * 商品生效分页查询（名单中心）
 */
public class QueryEffectRosterGoodsList extends DataGenerate{
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static MerchantService merchantService = (MerchantService)ac.getBean("merchantService");

    @Test
    public static void queryEffectRosterGoodsList() {
        QueryEffectRosterGoodsReqDTO queryEffectRosterGoodsReqDTO = new QueryEffectRosterGoodsReqDTO();
        queryEffectRosterGoodsReqDTO.setGoodsGroupCode("GG4880191122093701000003");//商品组编号
        queryEffectRosterGoodsReqDTO.setGoodsId("");//商品号
        queryEffectRosterGoodsReqDTO.setGoodsName("");//商品名称
        queryEffectRosterGoodsReqDTO.setBizType("");//业务类型
        queryEffectRosterGoodsReqDTO.setPageSize(100);//分页大小
        queryEffectRosterGoodsReqDTO.setPageNo(1);//当前页数
        queryEffectRosterGoodsReqDTO.setTraceLogId(TraceLogId());

        Result<PageInfoDTO<EffectRosterGoodsResDTO>> result = merchantService.queryEffectRosterGoodsList(queryEffectRosterGoodsReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + queryEffectRosterGoodsReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());

        PageInfoDTO<EffectRosterGoodsResDTO> effectRosterGoodsResDTOPageInfoDTO = result.getResult();
        String json = JSON.toJSONString(effectRosterGoodsResDTOPageInfoDTO,true);
        System.out.println(json);
    }
}
