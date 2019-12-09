package Roster.RosterCheckService;

import com.alibaba.fastjson.JSON;
import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.roster.api.RosterCheckService;
import com.bestpay.marketing.roster.api.models.response.merchant.MerchantCheckResDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Customize.DataGenerate;
import com.bestpay.marketing.roster.api.models.request.merchant.MerchantCheckReqDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/11/14.
 * 交易商户校验
 */
public class CheckMerchantRoster extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static RosterCheckService rosterCheckService = (RosterCheckService) ac.getBean("rosterCheckService");

    @Test
    public static void checkMerchantRoster() {
        MerchantCheckReqDTO merchantCheckReqDTO = new MerchantCheckReqDTO();
        merchantCheckReqDTO.setRelationId("");
        merchantCheckReqDTO.setMerchantId("");
        merchantCheckReqDTO.setStoreId("");

        List<String> goodsIdList = new ArrayList<>();
        goodsIdList.add("");
        merchantCheckReqDTO.setGoodsIdList(goodsIdList);
        merchantCheckReqDTO.setTraceLogId(TraceLogId());
        merchantCheckReqDTO.setRequestNo("");
        merchantCheckReqDTO.setRequestSystem("test");
        merchantCheckReqDTO.setRequestDate(new Date());

        Result<MerchantCheckResDTO> result = rosterCheckService.checkMerchantRoster(merchantCheckReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + merchantCheckReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());

        MerchantCheckResDTO merchantCheckResDTO = result.getResult();
        String json = JSON.toJSONString(merchantCheckResDTO, true);
        System.out.println(json);
    }
}
