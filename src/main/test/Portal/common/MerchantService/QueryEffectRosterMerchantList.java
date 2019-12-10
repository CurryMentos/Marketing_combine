package Portal.common.MerchantService;

import Customize.DataGenerate;
import com.alibaba.fastjson.JSON;
import com.xx.dubbo.result.Result;
import com.xx.marketing.config.api.activity.models.PageInfoDTO;
import com.xx.marketing.config.api.common.MerchantService;
import com.xx.marketing.config.api.common.models.request.QueryEffectRosterMerchantReqDTO;
import com.xx.marketing.config.api.common.models.response.EffectRosterMerchantResDTO;
import com.xx.marketing.roster.api.enums.RelationTypeEnum;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * Created by Administrator on 2019/10/31.
 * 商户生效分页查询（名单中心）
 */
public class QueryEffectRosterMerchantList extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static MerchantService merchantService = (MerchantService)ac.getBean("merchantService");

    @Test
    public static void queryEffectRosterMerchantList() {
        QueryEffectRosterMerchantReqDTO queryEffectRosterMerchantReqDTO = new QueryEffectRosterMerchantReqDTO();
        queryEffectRosterMerchantReqDTO.setRelationId("A10990191115145236000036");//关联编号
        //工具号、活动号、权益号
        queryEffectRosterMerchantReqDTO.setRelationType(RelationTypeEnum.ACTIVITY.getCode());//关联类型
        //推荐人工具：RECOMMEND，双向激励工具：ENCOURAGE，商户红包工具：MERCHANT_REDBAG；
        //活动：ACTIVITY；代金券权益：VOUCHER，红包金权益：COUPON
//        queryEffectRosterMerchantReqDTO.setMerchantId("3178000000938019");//商户号
//        queryEffectRosterMerchantReqDTO.setBizType("");//业务类型
        queryEffectRosterMerchantReqDTO.setPageSize(10);//分页大小
        queryEffectRosterMerchantReqDTO.setPageNo(1);//当前页数
        queryEffectRosterMerchantReqDTO.setTraceLogId(TraceLogId());

        Result<PageInfoDTO<EffectRosterMerchantResDTO>> result = merchantService.queryEffectRosterMerchantList(queryEffectRosterMerchantReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + queryEffectRosterMerchantReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());

        PageInfoDTO<EffectRosterMerchantResDTO> effectRosterMerchantResDTOPageInfoDTO = result.getResult();
        String json = JSON.toJSONString(effectRosterMerchantResDTOPageInfoDTO,true);
        System.out.println(json);
    }
}
