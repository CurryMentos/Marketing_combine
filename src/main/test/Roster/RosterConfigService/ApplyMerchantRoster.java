package Roster.RosterConfigService;
import com.alibaba.fastjson.JSON;
import com.xx.dubbo.result.Result;
import com.xx.marketing.roster.api.models.request.merchant.GoodsApplyReqDTO;
import com.xx.marketing.roster.api.models.request.merchant.MerchantApplyReqDTO;
import com.xx.marketing.roster.api.models.request.merchant.StoreApplyReqDTO;
import com.xx.marketing.roster.api.models.response.RosterApplyResDTO;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Customize.DataGenerate;
import com.xx.marketing.roster.api.RosterConfigService;
import com.xx.marketing.roster.api.models.request.merchant.MerchantRosterApplyReqDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/11/14.
 * 商户门店商品新增/启用、停用接口1000
 */
public class ApplyMerchantRoster extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static RosterConfigService rosterConfigService = (RosterConfigService) ac.getBean("rosterConfigService");

    @Test
    public static void applyMerchantRoster() {
        MerchantRosterApplyReqDTO merchantRosterApplyReqDTO = new MerchantRosterApplyReqDTO();
        merchantRosterApplyReqDTO.setBizType("");
        merchantRosterApplyReqDTO.setRelationId("");
        merchantRosterApplyReqDTO.setRelationType("");
        merchantRosterApplyReqDTO.setRosterType("");
        merchantRosterApplyReqDTO.setRosterChannelSource("");
        merchantRosterApplyReqDTO.setApplyUser("");

        List<MerchantApplyReqDTO> merchantApplyReqDTOList = new ArrayList<>();
        MerchantApplyReqDTO merchantApplyReqDTO = new MerchantApplyReqDTO();
        merchantApplyReqDTO.setToolId("");
        merchantApplyReqDTO.setToolType("");
        merchantApplyReqDTO.setMerchantId("");
        merchantApplyReqDTO.setMerchantName("");
        merchantApplyReqDTO.setMerchantSource("");
        merchantApplyReqDTO.setSubMerchantSource("");

        List<StoreApplyReqDTO> storeApplyReqDTOList = new ArrayList<>();
        StoreApplyReqDTO storeApplyReqDTO = new StoreApplyReqDTO();
        storeApplyReqDTO.setStoreId("");
        storeApplyReqDTO.setStoreName("");
        storeApplyReqDTOList.add(storeApplyReqDTO);
        merchantApplyReqDTO.setStoreApplyReqDTOList(storeApplyReqDTOList);

        List<GoodsApplyReqDTO> goodsApplyReqDTOList = new ArrayList<>();
        GoodsApplyReqDTO goodsApplyReqDTO = new GoodsApplyReqDTO();
        goodsApplyReqDTO.setGoodsId("");
        goodsApplyReqDTO.setGoodsName("");
        goodsApplyReqDTOList.add(goodsApplyReqDTO);
        merchantApplyReqDTO.setGoodsApplyReqDTOList(goodsApplyReqDTOList);

        merchantApplyReqDTOList.add(merchantApplyReqDTO);
        merchantRosterApplyReqDTO.setMerchantApplyReqDTOList(merchantApplyReqDTOList);
        merchantRosterApplyReqDTO.setTraceLogId(TraceLogId());
        merchantRosterApplyReqDTO.setRequestNo("");
        merchantRosterApplyReqDTO.setRequestSystem("test");
        merchantRosterApplyReqDTO.setRequestDate(new Date());

        Result<RosterApplyResDTO> result = rosterConfigService.applyMerchantRoster(merchantRosterApplyReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + merchantRosterApplyReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());

        RosterApplyResDTO rosterApplyResDTO = result.getResult();
        String json = JSON.toJSONString(rosterApplyResDTO, true);
        System.out.println(json);
    }
}
