package ActivityOperation.ActivityConfigService;

import com.xx.dubbo.result.Result;
import com.xx.marketing.activity.operation.api.models.GoodsDTO;
import com.xx.marketing.activity.operation.api.models.StoreDTO;

import java.util.*;

import com.xx.marketing.activity.operation.api.models.MerchantDTO;

import com.xx.marketing.activity.operation.api.ActivityConfigService;
import com.xx.marketing.activity.operation.api.models.request.ModifyMerchantReqDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zengyouzu on 2019/11/1.
 * 变更商户
 */
public class ModifyMerchant {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static ActivityConfigService activityConfigService = (ActivityConfigService) ac.getBean("activityConfigService");

    public static String RandomStringNo() {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i <= 23; i++) {
            int randomNum = random.nextInt(9);
            String num = randomNum + "";
            stringBuffer = stringBuffer.append(num);
        }

        String str = String.valueOf(stringBuffer);
        return str;
    }

    public static void modifyMerchant() throws Exception {
        String traceLogId = UUID.randomUUID().toString();

        ModifyMerchantReqDTO modifyMerchantReqDTO = new ModifyMerchantReqDTO();
        modifyMerchantReqDTO.setRequestNo("Req" + RandomStringNo());
        modifyMerchantReqDTO.setRequestDate(new Date());
        modifyMerchantReqDTO.setRequestSystem("test");
        modifyMerchantReqDTO.setActivityId("");

        Set merchantDTOSet = new HashSet<>();
        MerchantDTO merchantDTO = new MerchantDTO();
        merchantDTO.setMerchantId("");
        merchantDTO.setMerchantName("");

        List<StoreDTO> StoreDTOList = new ArrayList<>();
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setStoreId("");
        storeDTO.setStoreName("");
        storeDTO.setStatus("");
        StoreDTOList.add(storeDTO);
        merchantDTO.setStoreDTOS(StoreDTOList);

        List<GoodsDTO> GoodsDTOList = new ArrayList<>();
        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setGoodsId("");
        goodsDTO.setGoodsName("");
        goodsDTO.setStatus("");
        GoodsDTOList.add(goodsDTO);
        merchantDTO.setGoodsDTOS(GoodsDTOList);

        merchantDTO.setToolCode("");
        merchantDTO.setToolType("");
        merchantDTO.setMerchantSource("");
        merchantDTO.setStatus("");

        modifyMerchantReqDTO.setMerchantDTOSet(merchantDTOSet);
        modifyMerchantReqDTO.setTraceLogId(traceLogId);

        Result<Boolean> result = activityConfigService.modifyMerchant(modifyMerchantReqDTO);
        System.out.println("***********************************");
        System.out.println("日志号:" + modifyMerchantReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
