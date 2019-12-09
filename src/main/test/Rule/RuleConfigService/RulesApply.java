package Rule.RuleConfigService;

import Customize.DataGenerate;
import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.config.api.enums.CarrierEnum;
import com.bestpay.marketing.config.api.enums.CustomerLevelEnum;
import com.bestpay.marketing.config.api.enums.SwitchEnum;
import com.bestpay.marketing.rule.api.enums.ApplyPurposeEnum;
import com.bestpay.marketing.rule.api.enums.RosterTypeEnum;
import com.bestpay.marketing.config.api.enums.UserDimensionEnum;
import com.bestpay.marketing.coupon.product.api.common.enums.TradeChannelEnum;
import com.bestpay.marketing.rule.api.models.BaseRulesDTO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.bestpay.marketing.rule.api.RuleConfigService;
import com.bestpay.marketing.rule.api.models.request.RulesApplyReqDTO;
import com.google.common.collect.Sets;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/9/10.
 * 规则申请
 */
public class RulesApply extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    static RuleConfigService ruleConfigService = (RuleConfigService) ac.getBean("ruleConfigService");

    @Test
    public static void rulesApply() throws Exception {
        RulesApplyReqDTO rulesApplyReqDTO = new RulesApplyReqDTO();
        rulesApplyReqDTO.setRuleGroupCode("RGC"+RandomStringNo());
        rulesApplyReqDTO.setRuleGroupName(rulesApplyReqDTO.getRuleGroupCode());
        rulesApplyReqDTO.setApplyPurpose(ApplyPurposeEnum.TOOL_CHECK.getCode());

        BaseRulesDTO baseRulesDTO = new BaseRulesDTO();
//        baseRulesDTO.setRosterType(RosterTypeEnum.BLACK_LIST.getCode());//黑名单规则校验
//        baseRulesDTO.setRosterType(RosterTypeEnum.WHITE_LIST.getCode());//白名单规则校验
//        baseRulesDTO.setRosterType(RosterTypeEnum.CLM_BLACK_LIST.getCode());//CLM黑名单规则校验
//        baseRulesDTO.setRosterType(RosterTypeEnum.CLM_WHITE_LIST.getCode());//CLM白名单规则校验
//        baseRulesDTO.setRosterTypeNo("");

        Set customerLevelSet = new HashSet();
//        customerLevelSet.add(CustomerLevelEnum.GUEST.getCode());//游客
        customerLevelSet.add(CustomerLevelEnum.TWO.getCode());//二星用户
        customerLevelSet.add(CustomerLevelEnum.THREE.getCode());//三星用户
        baseRulesDTO.setCustomerLevel(customerLevelSet);

        baseRulesDTO.setNeedBindCard(SwitchEnum.Y.getCode());
        baseRulesDTO.setAdaptProvince(Sets.newHashSet("999900"));
        baseRulesDTO.setAdaptCity(Sets.newHashSet("999901"));

        Set carrierSet = new HashSet<>();
        carrierSet.add(CarrierEnum.DX.getCode());//电信
        carrierSet.add(CarrierEnum.YD.getCode());//移动
        carrierSet.add(CarrierEnum.LT.getCode());//联通
        baseRulesDTO.setCarrier(carrierSet);

        baseRulesDTO.setStartTime(StartTime);
        baseRulesDTO.setEndTime(EndTime);
        baseRulesDTO.setDailyStartTime(DayStart);
        baseRulesDTO.setDailyEndTime(DayEnd);

        Set rebateDatePointsWeekSet = new HashSet();
        rebateDatePointsWeekSet.add("");
//        baseRulesDTO.setRebateDatePointsWeek(rebateDatePointsWeekSet);

        Set rebateDatePointsMonSet = new HashSet();
        rebateDatePointsMonSet.add("");
//        baseRulesDTO.setRebateDatePointsMon(rebateDatePointsMonSet);

        Set sceneSet = new HashSet();
        sceneSet.add("");
//        baseRulesDTO.setScene(sceneSet);

        Set expandSceneSet = new HashSet();
        expandSceneSet.add("");
//        baseRulesDTO.setExpandScene(expandSceneSet);

        Set tradeChannelSet = new HashSet();
        tradeChannelSet.add(TradeChannelEnum.POS.getCode());
        tradeChannelSet.add(TradeChannelEnum.WEB.getCode());
        tradeChannelSet.add(TradeChannelEnum.H5.getCode());
//        tradeChannelSet.add(TradeChannelEnum.ALL.getCode());
        baseRulesDTO.setTradeChannel(tradeChannelSet);

        Set tradeProductNoSet = new HashSet();
        tradeProductNoSet.add("");
//        baseRulesDTO.setTradeProductNo(tradeProductNoSet);

        Set bankCodeSet = new HashSet();
        bankCodeSet.add("");
//        baseRulesDTO.setBankCode(bankCodeSet);

        baseRulesDTO.setLowerLimit(1000L);
        baseRulesDTO.setUpperLimit(10000L);
//        baseRulesDTO.setMerchantWhiteList("");
//        baseRulesDTO.setInvitationNumber(0L);
//        baseRulesDTO.setPerInvitationAmount(0L);
//        baseRulesDTO.setMaxInvitationNumber(0L);

        Set userDimensionSet = new HashSet();
        userDimensionSet.add(UserDimensionEnum.CONTRAL_NO.getCode());//手机号
        userDimensionSet.add(UserDimensionEnum.CUSTOMER_NO.getCode());//身份证
        userDimensionSet.add(UserDimensionEnum.DEVICE_NO.getCode());//设备号
        baseRulesDTO.setUserDimension(userDimensionSet);

        rulesApplyReqDTO.setBaseRulesDTO(baseRulesDTO);
        rulesApplyReqDTO.setRequestNo("Req" + RandomStringNo());
        rulesApplyReqDTO.setRequestSystem("test");
        rulesApplyReqDTO.setRequestDate(new Date());

        String traceLogId = TraceLogId();

        Result<Boolean> result = ruleConfigService.rulesApply(rulesApplyReqDTO, traceLogId);
        System.out.println("********************规则申请********************");
        System.out.println("日志号:" + traceLogId);
        System.out.println("规则组编号:" + rulesApplyReqDTO.getRuleGroupCode());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
