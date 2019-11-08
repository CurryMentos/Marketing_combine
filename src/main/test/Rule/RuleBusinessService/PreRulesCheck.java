package Rule.RuleBusinessService;

import Customize.DataGenerate;
import Customize.UserList;
import com.xx.dubbo.result.Result;
import com.xx.marketing.rule.api.enums.UserActionTypeEnum;
import com.xx.marketing.rule.api.enums.UserTypeEnum;
import com.xx.marketing.rule.api.models.GoodsDetailDTO;
import com.xx.marketing.rule.api.models.PayToolMessageDTO;
import com.xx.marketing.rule.api.models.UserTradeActionDTO;

import com.xx.marketing.rule.api.RuleBusinessService;
import com.xx.marketing.rule.api.models.request.PreRulesCheckReqDTO;
import com.xx.marketing.rule.api.models.response.PreRulesCheckResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengyouzu on 2019/9/19.
 * 规则预校验
 */
public class PreRulesCheck extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    static RuleBusinessService ruleBusinessService = (RuleBusinessService) ac.getBean("ruleBusinessService");

    @Test
    public static void preRulesCheck() {
        PreRulesCheckReqDTO preRulesCheckReqDTO = new PreRulesCheckReqDTO();
        preRulesCheckReqDTO.setRuleGroupCode("RGC20190910140159");
        preRulesCheckReqDTO.setUserType(UserTypeEnum.PRODUCT.getCode());
        preRulesCheckReqDTO.setUserNo("16715292345");
        preRulesCheckReqDTO.setUserActionType(UserActionTypeEnum.ACTION_BUSINESS.getCode());
        preRulesCheckReqDTO.setUserActionScene("");

        UserTradeActionDTO userTradeActionDTO = new UserTradeActionDTO();
        userTradeActionDTO.setTradeNo("");
        userTradeActionDTO.setTradeAmt(0L);
        userTradeActionDTO.setMerchantNo(UserList.MerchantNo());
        userTradeActionDTO.setMerchantName("");
        userTradeActionDTO.setStoreCode("");

        List<GoodsDetailDTO> goodsDetailDTOList = new ArrayList<>();
        GoodsDetailDTO goodsDetailDTO = new GoodsDetailDTO();
        goodsDetailDTO.setGoodsId("");
        goodsDetailDTO.setGoodsName("");
        goodsDetailDTO.setQuantity(0L);
        goodsDetailDTO.setPrice(0L);
        goodsDetailDTO.setGoodsCategory("");
        goodsDetailDTO.setBody("");
        goodsDetailDTOList.add(goodsDetailDTO);
        userTradeActionDTO.setGoodsDetailDTOs(goodsDetailDTOList);

        userTradeActionDTO.setTradeChannel("");
        userTradeActionDTO.setProductNo(UserList.ContralNo());
        userTradeActionDTO.setSolutionNo("");
        userTradeActionDTO.setBuyerLoginNo("");
        userTradeActionDTO.setBuyerName("");

        List<PayToolMessageDTO> payToolMessageDTOList = new ArrayList<>();
        PayToolMessageDTO payToolMessageDTO = new PayToolMessageDTO();
        payToolMessageDTO.setPayToolType("");
        payToolMessageDTO.setPayToolAmt(0L);
        payToolMessageDTO.setPayToolAccountNo("");
        payToolMessageDTO.setBankCardNo("");
        payToolMessageDTO.setMaskBankCardNo("");
        payToolMessageDTO.setBankOrg("");
        payToolMessageDTO.setBankName("");
        payToolMessageDTOList.add(payToolMessageDTO);
        userTradeActionDTO.setPayTools(payToolMessageDTOList);

        preRulesCheckReqDTO.setUserTradeActionDTO(userTradeActionDTO);

        String traceLogId = TraceLogId();

        Result<PreRulesCheckResDTO> result = ruleBusinessService.preRulesCheck(preRulesCheckReqDTO, traceLogId);
        System.out.println("********************规则预校验********************");
        System.out.println("日志号:" + traceLogId);
        System.out.println("规则组编号:" + preRulesCheckReqDTO.getRuleGroupCode());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
