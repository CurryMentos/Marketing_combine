package MarketingBusiness;

import Customize.SQLOperate;
import Customize.UserList;
import com.bestpay.marketing.minus.api.model.reqmodel.GoodsDetailDTO;
import com.google.common.collect.Lists;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bestpay.marketing.minus.api.model.MinusRequest;
import com.bestpay.marketing.minus.api.model.reqmodel.MinusHoldRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.bestpay.marketing.minus.api.IMarketingMinusService;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/12/3.
 * 立减现金
 */
public class MarketingMinus {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static IMarketingMinusService iMarketingMinusService = (IMarketingMinusService) ac.getBean("iMarketingMinusService");
    static String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    static BusinessService businessService = new BusinessService();
    static Map ActivityInfoMap = businessService.getActivityInfoMap();

    @Test
    public static void Minus() {
//        SQLOperate.getActivityBasicInfo();

        MinusRequest minusRequest = new MinusRequest();
        MinusHoldRequest minusHoldRequest = new MinusHoldRequest();
        minusHoldRequest.setLoginNo(UserList.ContralNo());
        minusHoldRequest.setMerchantCode(ActivityInfoMap.get("MerchantId").toString());
        minusHoldRequest.setPlatformMerchantCode("");
        minusHoldRequest.setAcceptTransSeq("Hol" + str);
        minusHoldRequest.setProductCode(ActivityInfoMap.get("OutTxnType").toString());
        minusHoldRequest.setOrderAmt(Long.valueOf(ActivityInfoMap.get("Threshold").toString()));
        minusHoldRequest.setAcceptTransTime(new Date());
        minusHoldRequest.setConsumAreaCode("");
        minusHoldRequest.setConsumCityCode("");
        minusHoldRequest.setTxnChannel(ActivityInfoMap.get("TxnChannel").toString());
        minusHoldRequest.setStoreNo("");

        List<GoodsDetailDTO> goodsDetailDTOList = new ArrayList<>();
        GoodsDetailDTO goodsDetailDTO = new GoodsDetailDTO();
        goodsDetailDTO.setGoodsId("");
//        goodsDetailDTO.setGoodsName("");
//        goodsDetailDTO.setQuantity(0L);
//        goodsDetailDTO.setPrice(0L);
//        goodsDetailDTO.setGoodsCategory("");
//        goodsDetailDTO.setBody("");
        goodsDetailDTOList.add(goodsDetailDTO);
        minusHoldRequest.setGoodsDetailDTOs(goodsDetailDTOList);


    }
}
