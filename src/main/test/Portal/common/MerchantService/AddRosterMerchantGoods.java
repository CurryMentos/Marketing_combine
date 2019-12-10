package Portal.common.MerchantService;
import com.xx.dubbo.result.Result;
import com.xx.marketing.config.api.common.models.request.RosterGoodsReqDTO;
import com.xx.marketing.config.api.common.models.request.RosterMerchantReqDTO;
import com.google.common.collect.Lists;

import Customize.DataGenerate;
import com.xx.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.xx.marketing.config.api.common.MerchantService;
import com.xx.marketing.config.api.common.models.request.RosterMerchantGoodsReqDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengyouzu on 2019/11/12.
 * 名单中心添加商户商品信息
 */
public class AddRosterMerchantGoods extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static MerchantService merchantService = (MerchantService)ac.getBean("merchantService");

    @Test
    public static void addRosterMerchantGoods() {
        RosterMerchantGoodsReqDTO rosterMerchantGoodsReqDTO = new RosterMerchantGoodsReqDTO();
        rosterMerchantGoodsReqDTO.setRelationId("");
        rosterMerchantGoodsReqDTO.setRelationType("");
        rosterMerchantGoodsReqDTO.setBizId("");

        List<RosterMerchantReqDTO> rosterMerchantReqDTOList = new ArrayList<>();
        RosterMerchantReqDTO rosterMerchantReqDTO = new RosterMerchantReqDTO();
        rosterMerchantReqDTO.setMerchantId("");

        List<RosterGoodsReqDTO> rosterGoodsReqDTOList = new ArrayList<>();
        RosterGoodsReqDTO rosterGoodsReqDTO = new RosterGoodsReqDTO();
        rosterGoodsReqDTO.setGoodsId("");
        rosterGoodsReqDTO.setGoodsName("");
        rosterGoodsReqDTOList.add(rosterGoodsReqDTO);
        rosterMerchantReqDTO.setRosterGoodsReqDTOS(rosterGoodsReqDTOList);
        rosterMerchantReqDTOList.add(rosterMerchantReqDTO);
        rosterMerchantGoodsReqDTO.setRosterMerchantReqDTOS(rosterMerchantReqDTOList);
        rosterMerchantGoodsReqDTO.setTraceLogId(TraceLogId());

        Result<Boolean> result = merchantService.addRosterMerchantGoods(rosterMerchantGoodsReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + rosterMerchantGoodsReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
    }
}
