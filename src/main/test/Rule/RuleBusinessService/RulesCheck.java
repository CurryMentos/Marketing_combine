package Rule.RuleBusinessService;

import Customize.DataGenerate;
import Customize.UserList;
import com.xx.marketing.rule.api.enums.UserActionTypeEnum;
import com.xx.marketing.rule.api.enums.UserTypeEnum;
import com.xx.marketing.rule.api.models.GoodsDetailDTO;
import com.xx.marketing.rule.api.models.PayToolMessageDTO;

import com.xx.marketing.rule.api.models.UserTradeActionDTO;

import com.xx.dubbo.result.Result;
import com.xx.marketing.rule.api.RuleBusinessService;
import com.xx.marketing.rule.api.models.request.RulesCheckReqDTO;
import com.xx.marketing.rule.api.models.response.RulesCheckResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengyouzu on 2019/9/10.
 * 规则校验
 */
public class RulesCheck extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    static RuleBusinessService ruleBusinessService = (RuleBusinessService) ac.getBean("ruleBusinessService");

    @Test
    public static void rulesCheck() {
        RulesCheckReqDTO rulesCheckReqDTO = new RulesCheckReqDTO();
        rulesCheckReqDTO.setRuleGroupCode("");
        rulesCheckReqDTO.setUserType(UserTypeEnum.PRODUCT.getCode());
//        rulesCheckReqDTO.setUserType(UserTypeEnum.CONTRACT_NO.getCode());
        rulesCheckReqDTO.setUserNo("");
//        rulesCheckReqDTO.setUserActionType(UserActionTypeEnum.ACTION_TRADE.getCode());//交易类
        rulesCheckReqDTO.setUserActionType(UserActionTypeEnum.ACTION_BUSINESS.getCode());//业务类
//        rulesCheckReqDTO.setUserActionType(UserActionTypeEnum.ACTION_DIRECT.getCode());//直领类
//        rulesCheckReqDTO.setUserActionType(UserActionTypeEnum.ACTION_RECHARGE.getCode());//批冲类
        rulesCheckReqDTO.setUserActionScene("");

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

        rulesCheckReqDTO.setUserTradeActionDTO(userTradeActionDTO);

        String traceLogId = TraceLogId();

        Result<RulesCheckResDTO> result = ruleBusinessService.rulesCheck(rulesCheckReqDTO, traceLogId);
        System.out.println("********************规则校验********************");
        System.out.println("日志号:" + traceLogId);
        System.out.println("规则组编号:" + rulesCheckReqDTO.getRuleGroupCode());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
