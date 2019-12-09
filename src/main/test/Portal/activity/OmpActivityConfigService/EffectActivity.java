package Portal.activity.OmpActivityConfigService;/*
package config.activity.OmpActivityConfigService;
import com.bestpay.marketing.config.api.activity.models.request.*;
import com.bestpay.marketing.config.api.enums.*;
import com.google.common.collect.Sets;

import com.bestpay.dubbo.result.Result;

import java.text.SimpleDateFormat;
import java.util.*;

import com.bestpay.marketing.config.api.activity.OmpActivityConfigService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

*/
/**
 * Created by zengyouzu on 2019/6/18.
 * 活动生效
 *//*

public class EffectActivity {
    public static void effectActivity() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        OmpActivityConfigService ompActivityConfigService = (OmpActivityConfigService) ac.getBean("ompActivityConfigService");

        String var = UUID.randomUUID().toString();
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        Calendar cal1 = cal;
        Calendar cal2 = cal;
        cal1.add(Calendar.DAY_OF_YEAR, -10);
        cal2.add(Calendar.DAY_OF_YEAR, 10);
        String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now);

        ApplyActivityConfigReqDTO applyActivityConfigReqDTO = new ApplyActivityConfigReqDTO();
        applyActivityConfigReqDTO.setApplyId("");//申请编号
        applyActivityConfigReqDTO.setActionType("");//操作类型(h5必传) SAVE：保存，不用走工作流;SUBMIT：提交，要走工作流
        applyActivityConfigReqDTO.setApplyUser("");//申请人
        applyActivityConfigReqDTO.setApplyUserArea("");//申请人所属区域
        applyActivityConfigReqDTO.setActivityType("");//活动类型
        applyActivityConfigReqDTO.setApplyChannel("");//申请渠道
        applyActivityConfigReqDTO.setActivityId("");//活动编号

        */
/*-----------------------------活动基本信息DTO-----------------------------*//*

        ApplyActivityBasicInfoReqDTO applyActivityBasicInfoReqDTO = new ApplyActivityBasicInfoReqDTO();
//        applyActivityBasicInfoReqDTO.setDataCheckMark(DataCheckMark.ADD.getCode());//数据变动标记,新增
//        applyActivityBasicInfoReqDTO.setDataCheckMark(DataCheckMark.MODIFY.getCode());//数据变动标记,变更
        applyActivityBasicInfoReqDTO.setDataCheckMark(DataCheckMark.IGNORE.getCode());//数据变动标记,无需处理
        applyActivityBasicInfoReqDTO.setActivityName("");//活动名称
        applyActivityBasicInfoReqDTO.setActivityDesc("");//活动简介
        applyActivityBasicInfoReqDTO.setNeedInvoice(SwitchEnum.N.getCode());//是否开票,不开票
//        applyActivityBasicInfoReqDTO.setNeedInvoice(SwitchEnum.Y.getCode());//是否开票,开票

        //活动目的
        Set purpose = new HashSet();
        purpose.add(ActivityPurposeEnum.NEW_CUSTOMER.getCode());//用户拉新
        purpose.add(ActivityPurposeEnum.INCREASE_ACTIVITY.getCode());//用户促活
        purpose.add(ActivityPurposeEnum.INCREASE_INCOME.getCode());//拉动收入
        purpose.add(ActivityPurposeEnum.NOTHING.getCode());//无
        applyActivityBasicInfoReqDTO.setPurpose(purpose);

        applyActivityBasicInfoReqDTO.setApplyEmail("");//申请人邮箱
        applyActivityBasicInfoReqDTO.setLoginNumber("");//申请人手机号
        applyActivityBasicInfoReqDTO.setApplyDepartment("");//活动所属事业群
        applyActivityConfigReqDTO.setActivityBasicInfoApplyReqDTO(applyActivityBasicInfoReqDTO);

        */
/*-----------------------------活动参与规则请求DTO-----------------------------*//*

        ApplyActivityRuleReqDTO activityRuleApplyReqDTO = new ApplyActivityRuleReqDTO();//
//        activityRuleApplyReqDTO.setDataCheckMark(DataCheckMark.ADD.getCode());//数据变动标记,新增
//        activityRuleApplyReqDTO.setDataCheckMark(DataCheckMark.MODIFY.getCode());//数据变动标记,变更
        activityRuleApplyReqDTO.setDataCheckMark(DataCheckMark.IGNORE.getCode());//数据变动标记,无需处理

        //活动场景
        Set activityScene = new HashSet();
        activityScene.add(ActivitySceneEnum.POS.getCode());//POS消费
        activityScene.add(ActivitySceneEnum.COLLECT_CODE.getCode());//收款码
        activityScene.add(ActivitySceneEnum.PAY_CODE.getCode());//付款码
        activityRuleApplyReqDTO.setActivityScene(activityScene);

        activityRuleApplyReqDTO.setActivityStartDate("");//活动开始时间
        activityRuleApplyReqDTO.setActivityEndDate("");//活动结束时间
        activityRuleApplyReqDTO.setActivityDateType(ActivityDateTypeEnum.DAY.getCode());//活动周期类型,每日
//        activityRuleApplyReqDTO.setActivityDateType(ActivityDateTypeEnum.WEEK.getCode());//活动周期类型,每周
//        activityRuleApplyReqDTO.setActivityDateType(ActivityDateTypeEnum.MONTH.getCode());//活动周期类型,每月

        //返利时间点
        Set activityDatePoint = new HashSet();//(活动周期类型为每日时可以不传)
        activityDatePoint.add("1");
        activityRuleApplyReqDTO.setActivityDatePoint(activityDatePoint);

        activityRuleApplyReqDTO.setDayStartTime("");//每日开始时间
        activityRuleApplyReqDTO.setDayEndTime("");//每日结束时间
        activityRuleApplyReqDTO.setAdaptAreaRange(AdaptAreaRangeEnum.COUNTRY.getCode());//活动适用地区,全国范围
        activityRuleApplyReqDTO.setAdaptAreaRange(AdaptAreaRangeEnum.PROVINCE.getCode());//活动适用地区,省范围
        activityRuleApplyReqDTO.setAdaptAreaRange(AdaptAreaRangeEnum.CITY.getCode());//活动适用地区,地市范围
        activityRuleApplyReqDTO.setAdaptProvince("");//活动省份

        //活动城市
        Set adaptCity = new HashSet();
        adaptCity.add("");
        activityRuleApplyReqDTO.setAdaptCity(adaptCity);

        activityRuleApplyReqDTO.setDesignateBankCard(SwitchEnum.N.getCode());//是否指定银行卡,不指定
//        activityRuleApplyReqDTO.setDesignateBankCard(SwitchEnum.Y.getCode());//是否指定银行卡,不指定

        //银行code码
        Set bankCode = new HashSet();
        bankCode.add("");
        activityRuleApplyReqDTO.setBankCode(bankCode);

        //活动适用用户
        Set carrier = new HashSet<>();
        carrier.add(CarrierEnum.DX.getCode());//电信
        carrier.add(CarrierEnum.YD.getCode());//移动
        carrier.add(CarrierEnum.LT.getCode());//联通
        activityRuleApplyReqDTO.setCarrier(carrier);

        //账户星级
        Set customerLevel = new HashSet();
        customerLevel.add(CustomerLevelEnum.GUEST.getCode());//游客
        customerLevel.add(CustomerLevelEnum.TWO.getCode());//二星用户
        customerLevel.add(CustomerLevelEnum.THREE.getCode());//三星用户
        activityRuleApplyReqDTO.setCustomerLevel(customerLevel);

        //用户维度
        Set userDimension = new HashSet();
        userDimension.add(UserDimensionEnum.PRODUCT_NO.getCode());//手机号
        userDimension.add(UserDimensionEnum.ID_CARD.getCode());//身份证
        userDimension.add(UserDimensionEnum.CONTROL_NO.getCode());//设备号
        activityRuleApplyReqDTO.setUserDimension(userDimension);//

        activityRuleApplyReqDTO.setNeedBindCard(SwitchEnum.N.getCode());//限制绑卡,不限制
//        activityRuleApplyReqDTO.setNeedBindCard(SwitchEnum.Y.getCode());//限制绑卡,限制

        //用户名单
        Set rosterType = new HashSet();
        rosterType.add(RosterTypeEnum.ROSTER_TYPE_BLACK);//黑名单规则校验
        rosterType.add(RosterTypeEnum.ROSTER_TYPE_WHITE);//白名单规则校验
        rosterType.add(RosterTypeEnum.ROSTER_TYPE_VIP);//vip返利规则校验
        rosterType.add(RosterTypeEnum.ROSTER_TYPE_CRM);//crm返利规则校验
        activityRuleApplyReqDTO.setRosterType(rosterType);

        activityRuleApplyReqDTO.setClmListNo("");//省名单编号
        activityRuleApplyReqDTO.setClmListFlag(SwitchEnum.N.getCode());//省名单参与标识,名单不参与
//        activityRuleApplyReqDTO.setClmListFlag(SwitchEnum.Y.getCode());//省名单参与标识,名单参与

        //活动参与商户列表(omp用)
        List<MerchantReqDTO> merchantReqDTOList = new ArrayList();
        MerchantReqDTO merchantReqDTO = new MerchantReqDTO();
        merchantReqDTO.setMerchantId("");//商户号
        merchantReqDTO.setMerchantName("");//商户名称
        merchantReqDTO.setMerchantSource("");//商户出处

        //门店列表
        List<StoreReqDTO> storeReqDTOList = new ArrayList();
        StoreReqDTO storeReqDTO = new StoreReqDTO();
        storeReqDTO.setStoreId("");//门店号
        storeReqDTO.setStoreName("");//门店名称
        storeReqDTOList.add(storeReqDTO);
        merchantReqDTO.setStoreReqDTOList(storeReqDTOList);

        //商品列表
        List<GoodsReqDTO> goodsReqDTOList = new ArrayList();
        GoodsReqDTO goodsReqDTO = new GoodsReqDTO();
        goodsReqDTO.setGoodsId("");//商品编码
        goodsReqDTO.setGoodsName("");//商品名称
        goodsReqDTOList.add(goodsReqDTO);
        merchantReqDTO.setGoodsReqDTOList(goodsReqDTOList);

        merchantReqDTOList.add(merchantReqDTO);
        activityRuleApplyReqDTO.setMerchantReqDTOList(merchantReqDTOList);

        activityRuleApplyReqDTO.setMarketPaidOrg("");//返利充值商户号(omp用)
        activityRuleApplyReqDTO.setUserRange("");//领取用户范围
        activityRuleApplyReqDTO.setBusinessCodeFlag(SwitchEnum.N.getCode());//是否有业务码,没有
//        activityRuleApplyReqDTO.setBusinessCodeFlag(SwitchEnum.Y.getCode());//是否有业务码,有

        //业务码
        Set businessCode = new HashSet();
        businessCode.add(BusinessTypeEnum.BILL_PAYMENT.getCode());//水电煤缴费
        businessCode.add(BusinessTypeEnum.PHONE_RECHARGE.getCode());//话费充值
        businessCode.add(BusinessTypeEnum.PAY_BACK_CREDIT.getCode());//还信用卡
        businessCode.add(BusinessTypeEnum.COUNTRY_FLOW.getCode());//全国流量
        businessCode.add(BusinessTypeEnum.LOCAL_FLOW.getCode());//本地流量
        activityRuleApplyReqDTO.setBusinessCode(businessCode);
        applyActivityConfigReqDTO.setActivityRuleApplyReqDTO(activityRuleApplyReqDTO);

        */
/*-----------------------------活动限额规则请求DTO-----------------------------*//*

        ApplyLimitRuleReqDTO applyLimitRuleReqDTO = new ApplyLimitRuleReqDTO();
//        applyLimitRuleReqDTO.setDataCheckMark(DataCheckMark.ADD.getCode());//数据变动标记,新增
//        applyLimitRuleReqDTO.setDataCheckMark(DataCheckMark.MODIFY.getCode());//数据变动标记,变更
        applyLimitRuleReqDTO.setDataCheckMark(DataCheckMark.IGNORE.getCode());//数据变动标记,无需处理
        applyLimitRuleReqDTO.setLimitCycle(LimitCycleEnum.DAY.getCode());//限制周期,日
//        applyLimitRuleReqDTO.setLimitCycle(LimitCycleEnum.WEEK.getCode());//限制周期,周
//        applyLimitRuleReqDTO.setLimitCycle(LimitCycleEnum.MONTH.getCode());//限制周期,月
//        applyLimitRuleReqDTO.setLimitCycle(LimitCycleEnum.CYCLE.getCode());//限制周期,周期
        applyLimitRuleReqDTO.setUserDayLimitNum(0L);//用户日限制笔数
        applyLimitRuleReqDTO.setActivityDayLimitNum(0L);//活动日限制笔数
        applyLimitRuleReqDTO.setUserWeekLimitNum(0L);//用户周限制笔数
        applyLimitRuleReqDTO.setActivityWeekLimitNum(0L);//活动周限制笔数
        applyLimitRuleReqDTO.setUserMonthLimitNum(0L);//用户月限制笔数
        applyLimitRuleReqDTO.setActivityMonthLimitNum(0L);//活动月限制笔数
        applyLimitRuleReqDTO.setUserCycLimitNum(0L);//用户活动期间内限制笔数
        applyLimitRuleReqDTO.setActivityCycLimitNum(0L);//活动期间内限制笔数
        applyLimitRuleReqDTO.setUserDayLimitAmt(0L);//用户日限制金额
        applyLimitRuleReqDTO.setActivityDayLimitAmt(0L);//活动日限制金额
        applyLimitRuleReqDTO.setUserWeekLimitAmt(0L);//用户周限制金额
        applyLimitRuleReqDTO.setActivityWeekLimitAmt(0L);//活动周限制金额
        applyLimitRuleReqDTO.setUserMonthLimitAmt(0L);//用户月限制金额
        applyLimitRuleReqDTO.setActivityMonthLimitAmt(0L);//活动月限制金额
        applyLimitRuleReqDTO.setUserCycLimitAmt(0L);//用户活动期间内限制金额
        applyLimitRuleReqDTO.setActivityCycLimitAmt(0L);//活动期间内限制金额
        applyActivityConfigReqDTO.setLimitRuleReqDTO(applyLimitRuleReqDTO);

        */
/*-----------------------------优惠规则请求DTO-----------------------------*//*

        ApplyPreferentialReqDTO applyPreferentialReqDTO = new ApplyPreferentialReqDTO();
//        applyPreferentialReqDTO.setDataCheckMark(DataCheckMark.ADD.getCode());//数据变动标记,新增
//        applyPreferentialReqDTO.setDataCheckMark(DataCheckMark.MODIFY.getCode());//数据变动标记,变更
        applyPreferentialReqDTO.setDataCheckMark(DataCheckMark.IGNORE.getCode());//数据变动标记,无需处理

        */
/*-----------------------------现金申请DTO-----------------------------*//*

        ApplyCashReqDTO applyCashReqDTO = new ApplyCashReqDTO();
        applyCashReqDTO.setEquityId("");//权益编号
        applyCashReqDTO.setEquityType("");//权益类型
        applyCashReqDTO.setCostAmt(0L);//总成本
        applyCashReqDTO.setTms("");//签报号
        applyCashReqDTO.setTmsFinance("");//账务回单号(omp)

        //成本分摊列表
        List<CostReqDTO> costReqDTOList = new ArrayList();
        CostReqDTO costReqDTO = new CostReqDTO();
        costReqDTO.setInvestorType(InvestorTypeEnum.PAYMENT_COMPANY.getCode());//出资方,支付公司
        costReqDTO.setInvestorType(InvestorTypeEnum.PROVINCE_COMPANY.getCode());//出资方,省公司
        costReqDTO.setInvestorType(InvestorTypeEnum.MERCHANT.getCode());//出资方,商户
        costReqDTO.setInvestorType(InvestorTypeEnum.TELECOM_GROUP.getCode());//出资方,集团公司
        costReqDTO.setInvestorType(InvestorTypeEnum.CITY_COMPANY.getCode());//出资方,地市公司
        costReqDTO.setInvestorType(InvestorTypeEnum.THIRD_PARTY.getCode());//出资方,第三方公司
        costReqDTO.setInvestorName("");//出资方名称
        costReqDTO.setInvestmentWay(InvestmentWayEnum.PROVINCE_PREPAYMENT.getCode());//出资方式,省公司预付
        costReqDTO.setInvestmentWay(InvestmentWayEnum.PAY_COMPANY_COST.getCode());//出资方式,支付公司成本
        costReqDTO.setInvestmentWay(InvestmentWayEnum.THIRD_PARTY_PREPAYMENT.getCode());//出资方式,第三方预付(打款凭证)
        costReqDTO.setInvestmentWay(InvestmentWayEnum.ONE_POINT_SETTLEMENT.getCode());//出资方式,一点结算
        costReqDTO.setInvestmentWay(InvestmentWayEnum.BALANCE_SETTLEMENT.getCode());//出资方式,差额结算(台账)
        costReqDTO.setInvestmentWay(InvestmentWayEnum.MERCHANT_PREPAYMENT.getCode());//出资方式,商户预付(台账)
        costReqDTO.setCostCfgPercentage("");//出资比例
        costReqDTO.setInvestmentOrgCode("");//出资机构编码
        costReqDTO.setInvestmentOrgName("");//出资机构名称
        costReqDTO.setInvestmentOrgAccount("");//出资账户编码
        costReqDTO.setInvestmentOrgAccountName("");//出资账户名称
        costReqDTO.setDueAmt(0L);//应付金额
        costReqDTO.setRealPayAmt(0L);//实付金额
        costReqDTO.setAdvanceFlag(SwitchEnum.N.getCode());//是否垫资,不垫资
//        costReqDTO.setAdvanceFlag(SwitchEnum.Y.getCode());//是否垫资,垫资
        costReqDTOList.add(costReqDTO);
        applyCashReqDTO.setCostReqDTOList(costReqDTOList);

        applyCashReqDTO.setSettleType("");//结算类型
        applyCashReqDTO.setApplyDepartment("");//所属部门
        applyCashReqDTO.setNeedInvoice(SwitchEnum.N.getCode());//是否开票,不开票
//        applyCashReqDTO.setNeedInvoice(SwitchEnum.Y.getCode());//是否开票,开票
        applyCashReqDTO.setRebateType("");//返利类型
        applyCashReqDTO.setRebateAmt(0L);//返利金额
        applyCashReqDTO.setMultiply(0);//倍数返利
        applyCashReqDTO.setPercentage("");//折扣返利
        applyCashReqDTO.setRandomLevel("");//随机等级
        applyCashReqDTO.setMinSpendThreshold(0L);//最小消费金额
        applyCashReqDTO.setMaxSpendThreshold(0L);//最大消费金额
        applyCashReqDTO.setMinRebateAmt(0L);//最小返利金额
        applyCashReqDTO.setMaxRebateAmt(0L);//最大返利金额
        applyPreferentialReqDTO.setCashApplyReqDTO(applyCashReqDTO);

        */
/*-----------------------------代金券申请DTO-----------------------------*//*

        ApplyVoucherReqDTO applyVoucherReqDTO = new ApplyVoucherReqDTO();
        applyVoucherReqDTO.setConfigCostType(ConfigCostTypeEnum.AMT.getCode());//成本配置方式,金额
//        applyVoucherReqDTO.setConfigCostType(ConfigCostTypeEnum.NUM.getCode());//成本配置方式,名额
//        applyVoucherReqDTO.setConfigCostType(ConfigCostTypeEnum.ALL.getCode());//成本配置方式,所有
        applyVoucherReqDTO.setCostAmt(0L);//总成本
        applyVoucherReqDTO.setCostNum(0L);//总名额

        //权益明细列表
        List<ApplyVoucherInfoReqDTO> voucherInfoApplyReqDTOList = new ArrayList();
        ApplyVoucherInfoReqDTO applyVoucherInfoReqDTO = new ApplyVoucherInfoReqDTO();
        applyVoucherInfoReqDTO.setEquityId("");//权益编号
        applyVoucherInfoReqDTO.setEquityName("");//权益名称
        applyVoucherInfoReqDTO.setEquityDesc("");//权益简介
        applyVoucherInfoReqDTO.setApplyUses(ApplyUsesEnum.REBATE_RECHARGE.getCode());//申请用途,活动返权益
//        applyVoucherInfoReqDTO.setApplyUses(ApplyUsesEnum.BATCH_RECHARGE.getCode());//申请用途,批充权益
        applyVoucherInfoReqDTO.setEquityCategory(EquityCategoryEnum.COMMON.getCode());//券类别,通用券
//        applyVoucherInfoReqDTO.setEquityCategory(EquityCategoryEnum.PRODUCT_CODE.getCode());//券类别,业务券
//        applyVoucherInfoReqDTO.setEquityCategory(EquityCategoryEnum.MERCHANT.getCode());//券类别,商户联名券
//        applyVoucherInfoReqDTO.setBusinessType(BusinessTypeEnum.BILL_PAYMENT.getCode());//业务类型,水电煤缴费
        applyVoucherInfoReqDTO.setBusinessType(BusinessTypeEnum.PHONE_RECHARGE.getCode());//业务类型,话费充值
//        applyVoucherInfoReqDTO.setBusinessType(BusinessTypeEnum.PAY_BACK_CREDIT.getCode());//业务类型,还信用卡
//        applyVoucherInfoReqDTO.setBusinessType(BusinessTypeEnum.COUNTRY_FLOW.getCode());//业务类型,全国流量
//        applyVoucherInfoReqDTO.setBusinessType(BusinessTypeEnum.LOCAL_FLOW.getCode());//业务类型,本地流量
        applyVoucherInfoReqDTO.setJumpApplication("");//跳转应用

        //使用渠道
        Set useChannel = new HashSet();
        useChannel.add(UseChannelEnum.POS.getCode());//POS
        useChannel.add(UseChannelEnum.WEB.getCode());//WEB
        useChannel.add(UseChannelEnum.SMS.getCode());//短信
        useChannel.add(UseChannelEnum.APP.getCode());//客户端
        useChannel.add(UseChannelEnum.PAYESU.getCode());//添益宝
        useChannel.add(UseChannelEnum.H5.getCode());//H5
        applyVoucherInfoReqDTO.setUseChannel(useChannel);

        applyVoucherInfoReqDTO.setEffectType(EffectTypeEnum.ASSIGN.getCode());//生效方式,指定
//        applyVoucherInfoReqDTO.setEffectType(EffectTypeEnum.CIRCLE.getCode());//生效方式,周期
        applyVoucherInfoReqDTO.setEffectStartTime(cal1.getTime());//生效时间
        applyVoucherInfoReqDTO.setEffectEndTime(cal2.getTime());//失效时间
        applyVoucherInfoReqDTO.setEffectInterval(0);//间隔天数
        applyVoucherInfoReqDTO.setEffectCircle(0);//生效周期
        applyVoucherInfoReqDTO.setEffectDateType("");//生效周期类型
        applyVoucherInfoReqDTO.setEffectDatePoint("");//生效周期点
        applyVoucherInfoReqDTO.setDayStartTime("");//每天开始时间
        applyVoucherInfoReqDTO.setDayEndTime("");//每天结束时间
        applyVoucherInfoReqDTO.setDenominationType(DenominationTypeEnum.FIXED.getCode());//面值类型,固定面值
//        applyVoucherInfoReqDTO.setDenominationType(DenominationTypeEnum.SPECIAL.getCode());//面值类型,指定面值
//        applyVoucherInfoReqDTO.setDenominationType(DenominationTypeEnum.PERCENTAGE.getCode());//面值类型,折扣
        applyVoucherInfoReqDTO.setDenomination(0L);//面值
        applyVoucherInfoReqDTO.setPercentage("");//折扣
        applyVoucherInfoReqDTO.setLowerLimit(0L);//最小消费限额
        applyVoucherInfoReqDTO.setUpperLimit(0L);//最大消费限额
        applyVoucherInfoReqDTO.setDistributeCount(0L);//人均返券张数
        applyVoucherInfoReqDTO.setCustomerLevel(customerLevel);//账户星级
        applyVoucherInfoReqDTO.setNeedBindCard(SwitchEnum.N.getCode());//限制绑卡,不限制
//        applyVoucherInfoReqDTO.setNeedBindCard(SwitchEnum.Y.getCode());//限制绑卡,限制
        applyVoucherInfoReqDTO.setContext("");//使用规则简述
        applyVoucherInfoReqDTO.setTms("");//签报号
        applyVoucherInfoReqDTO.setTmsFinance("");//账务回单号
        applyVoucherInfoReqDTO.setMerchantReqDTOList(merchantReqDTOList);//权益商户列表(omp用)
        applyVoucherInfoReqDTO.setCostReqDTOList(costReqDTOList);//成本分摊申请列表
        applyVoucherInfoReqDTO.setApplyUser("");//申请人
        applyVoucherInfoReqDTO.setSettleType("");//结算方式
        applyVoucherInfoReqDTO.setApplyDepartment("");//所属部门
        voucherInfoApplyReqDTOList.add(applyVoucherInfoReqDTO);
        applyVoucherReqDTO.setVoucherInfoApplyReqDTOList(voucherInfoApplyReqDTOList);

        applyVoucherReqDTO.setDistributeMsgType(MsgTemplateEnum.DEFAULT.getCode());//发券短信内容类型,默认短信模板
//        applyVoucherReqDTO.setDistributeMsgType(MsgTemplateEnum.CUSTOM.getCode());//发券短信内容类型,自定义短信模板
//        applyVoucherReqDTO.setDistributeMsgType(MsgTemplateEnum.NOSMS.getCode());//发券短信内容类型,不发送短信
        applyVoucherReqDTO.setDistributeTemplateId("");//短信模板id
        applyVoucherReqDTO.setConsumeMsgType(SwitchEnum.N.getCode());//是否触发消费短信,不触发
//        applyVoucherReqDTO.setConsumeMsgType(SwitchEnum.Y.getCode());//是否触发消费短信,触发
        applyVoucherReqDTO.setCustomContent("");//自定义内容
        applyVoucherReqDTO.setNeedInvoice("");//开票标识
        applyVoucherReqDTO.setRebateType("");//返利类型
        applyVoucherReqDTO.setRebateAmt(0L);//返利金额
        applyVoucherReqDTO.setMultiply(0);//倍数返利
        applyVoucherReqDTO.setPercentage("");//折扣返利
        applyVoucherReqDTO.setRandomLevel("");//随机等级
        applyVoucherReqDTO.setMinSpendThreshold(0L);//最小消费金额
        applyVoucherReqDTO.setMaxSpendThreshold(0L);//最大消费金额
        applyVoucherReqDTO.setMinRebateAmt(0L);//最小返利金额
        applyVoucherReqDTO.setMaxRebateAmt(0L);//最大返利金额
        applyPreferentialReqDTO.setVoucherApplyReqDTO(applyVoucherReqDTO);

        */
/*-----------------------------红包金申请DTO-----------------------------*//*

        ApplyCouponReqDTO applyCouponReqDTO = new ApplyCouponReqDTO();
        applyCouponReqDTO.setConfigCostType(ConfigCostTypeEnum.AMT.getCode());//成本配置方式,金额
//        applyCouponReqDTO.setConfigCostType(ConfigCostTypeEnum.NUM.getCode());//成本配置方式,名额
//        applyCouponReqDTO.setConfigCostType(ConfigCostTypeEnum.ALL.getCode());//成本配置方式,所有
        applyCouponReqDTO.setCostAmt(0L);//总成本
        applyCouponReqDTO.setCostNum(0L);//总名额

        //权益明细列表
        List<ApplyCouponInfoReqDTO> couponInfoApplyReqDTOList = new ArrayList();
        ApplyCouponInfoReqDTO applyCouponInfoReqDTO = new ApplyCouponInfoReqDTO();
        applyCouponInfoReqDTO.setEquityId("");//权益编号
        applyCouponInfoReqDTO.setApplyUses(ApplyUsesEnum.REBATE_RECHARGE.getCode());//申请用途,活动返权益
//        applyCouponInfoReqDTO.setApplyUses(ApplyUsesEnum.BATCH_RECHARGE.getCode());//申请用途,批充权益
        applyCouponInfoReqDTO.setEquityName("");//权益名称
        applyCouponInfoReqDTO.setEquityCategory(CouponTypeEnum.COMMON.getCode());//券类别,通用券
//        applyCouponInfoReqDTO.setEquityCategory(CouponTypeEnum.MERCHANT.getCode());//券类别,商户券
//        applyCouponInfoReqDTO.setEquityCategory(CouponTypeEnum.PRODUCT_CODE.getCode());//券类别,业务券
        applyCouponInfoReqDTO.setBusinessType(BusinessTypeEnum.PHONE_RECHARGE.getCode());//业务类型,话费充值
//        applyCouponInfoReqDTO.setBusinessType(BusinessTypeEnum.PAY_BACK_CREDIT.getCode());//业务类型,还信用卡
//        applyCouponInfoReqDTO.setBusinessType(BusinessTypeEnum.COUNTRY_FLOW.getCode());//业务类型,全国流量
//        applyCouponInfoReqDTO.setBusinessType(BusinessTypeEnum.LOCAL_FLOW.getCode());//业务类型,本地流量
        applyCouponInfoReqDTO.setEquityDesc("");//权益简介
        applyCouponInfoReqDTO.setUseChannel(useChannel);//使用渠道
        applyCouponInfoReqDTO.setEffectType("");//生效方式
        applyCouponInfoReqDTO.setEffectStartTime(cal1.getTime());//生效时间
        applyCouponInfoReqDTO.setEffectEndTime(cal2.getTime());//失效时间
        applyCouponInfoReqDTO.setEffectInterval(0);//间隔天数
        applyCouponInfoReqDTO.setEffectCircle(0);//生效周期
        applyCouponInfoReqDTO.setEffectDateType("");//生效周期类型
        applyCouponInfoReqDTO.setEffectDatePoint("");//生效周期点
        applyCouponInfoReqDTO.setDayStartTime("");//每天开始时间
        applyCouponInfoReqDTO.setDayEndTime("");//每天结束时间
        applyCouponInfoReqDTO.setDenominationType(DenominationTypeEnum.FIXED.getCode());//面值类型,固定面值
//        applyCouponInfoReqDTO.setDenominationType(DenominationTypeEnum.SPECIAL.getCode());//面值类型,指定面值
//        applyCouponInfoReqDTO.setDenominationType(DenominationTypeEnum.PERCENTAGE.getCode());//面值类型,折扣
        applyCouponInfoReqDTO.setDenomination(0L);//面值
        applyCouponInfoReqDTO.setMinDenomination(0L);//单张最小面额
        applyCouponInfoReqDTO.setMaxDenomination(0L);//单张最大面额
        applyCouponInfoReqDTO.setLowerLimit(0L);//最小消费门槛
        applyCouponInfoReqDTO.setDistributeCount(0L);//最大消费门槛
        applyCouponInfoReqDTO.setCustomerLevel(customerLevel);//账户星级
        applyCouponInfoReqDTO.setNeedBindCard(SwitchEnum.N.getCode());//限制绑卡,不限制
//        applyCouponInfoReqDTO.setNeedBindCard(SwitchEnum.Y.getCode());//限制绑卡,限制
        applyCouponInfoReqDTO.setContext("");//使用规则简述
        applyCouponInfoReqDTO.setTms("");//签报号
        applyCouponInfoReqDTO.setTmsFinance("");//账务回单号(omp用)
        applyCouponInfoReqDTO.setMerchantReqDTOList(merchantReqDTOList);//权益商户列表(omp用)
        applyCouponInfoReqDTO.setCostReqDTOList(costReqDTOList);//成本分摊申请列表
        applyCouponInfoReqDTO.setApplyUser("");//申请人
        applyCouponInfoReqDTO.setSettleType("");//结算方式
        applyCouponInfoReqDTO.setApplyDepartment("");//所属部门
        couponInfoApplyReqDTOList.add(applyCouponInfoReqDTO);
        applyCouponReqDTO.setCouponInfoApplyReqDTOList(couponInfoApplyReqDTOList);

        applyCouponReqDTO.setDistributeMsgType(MsgTemplateEnum.DEFAULT.getCode());//发券短信内容类型,默认短信模板
//        applyCouponReqDTO.setDistributeMsgType(MsgTemplateEnum.CUSTOM.getCode());//发券短信内容类型,自定义短信模板
//        applyCouponReqDTO.setDistributeMsgType(MsgTemplateEnum.NOSMS.getCode());//发券短信内容类型,不发送短信
        applyCouponReqDTO.setDistributeTemplateId("");//短信模板id
        applyCouponReqDTO.setConsumeMsgType(SwitchEnum.N.getCode());//是否触发消费短信,不触发
//        applyCouponReqDTO.setConsumeMsgType(SwitchEnum.Y.getCode());//是否触发消费短信,触发
        applyCouponReqDTO.setCustomContent("");//自定义内容
        applyCouponReqDTO.setNeedInvoice("");//开票标识
        applyCouponReqDTO.setRebateType("");//返利类型
        applyCouponReqDTO.setRebateAmt(0L);//返利金额
        applyCouponReqDTO.setMultiply(0);//倍数返利
        applyCouponReqDTO.setPercentage("");//折扣返利
        applyCouponReqDTO.setRandomLevel("");//随机等级
        applyCouponReqDTO.setMinSpendThreshold(0L);//最小消费金额
        applyCouponReqDTO.setMaxSpendThreshold(0L);//最大消费金额
        applyCouponReqDTO.setMinRebateAmt(0L);//最小返利金额
        applyCouponReqDTO.setMaxRebateAmt(0L);//最大返利金额
        applyPreferentialReqDTO.setCouponApplyReqDTO(applyCouponReqDTO);

        applyActivityConfigReqDTO.setPreferentialApplyReqDTO(applyPreferentialReqDTO);

        */
/*-----------------------------红包铺子信息-----------------------------*//*

        ApplyActivityShowReqDTO activityShowShopApplyReqDTO = new ApplyActivityShowReqDTO();
//        activityShowShopApplyReqDTO.setDataCheckMark(DataCheckMark.ADD.getCode());//数据变动标记,新增
//        activityShowShopApplyReqDTO.setDataCheckMark(DataCheckMark.MODIFY.getCode());//数据变动标记,变更
        activityShowShopApplyReqDTO.setDataCheckMark(DataCheckMark.IGNORE.getCode());//数据变动标记,无需处理
        activityShowShopApplyReqDTO.setShowName("");//红包铺子展示名称
        activityShowShopApplyReqDTO.setMerchantName("");//商户名称
        activityShowShopApplyReqDTO.setProvince("");//活动商户地区-省份
        activityShowShopApplyReqDTO.setCity(adaptCity);//活动商户地区-城市
        activityShowShopApplyReqDTO.setContext("");//规则
        activityShowShopApplyReqDTO.setProtocolId("");//协议id
        activityShowShopApplyReqDTO.setProtocolType("");//协议类型
        activityShowShopApplyReqDTO.setToUrl("");//URL活动跳转
        activityShowShopApplyReqDTO.setRuleGroupNo("");//规则组编号
        activityShowShopApplyReqDTO.setOptionalMerchant("");//可用商户
        activityShowShopApplyReqDTO.setActivityAbbreviation("");//活动简称
        activityShowShopApplyReqDTO.setActivityType("");//活动类型
        activityShowShopApplyReqDTO.setShowPicAddress("");//展示图片地址
        activityShowShopApplyReqDTO.setMenuCategory("");//分类菜单
        activityShowShopApplyReqDTO.setActivityPicAddress("");//活动图片地址(大图)
        applyActivityConfigReqDTO.setActivityShowShopApplyReqDTO(activityShowShopApplyReqDTO);

        */
/*-----------------------------附件页面DTO-----------------------------*//*

        ApplyAttachmentReqDTO applyAttachmentReqDTO = new ApplyAttachmentReqDTO();
//        applyAttachmentReqDTO.setDataCheckMark(DataCheckMark.ADD.getCode());//数据变动标记,新增
//        applyAttachmentReqDTO.setDataCheckMark(DataCheckMark.MODIFY.getCode());//数据变动标记,变更
        applyAttachmentReqDTO.setDataCheckMark(DataCheckMark.IGNORE.getCode());//数据变动标记,无需处理

        //附件信息列表
        List<ApplyAttachmentInfoReqDTO> applyAttachmentInfoReqDTOList = new ArrayList();
        ApplyAttachmentInfoReqDTO applyAttachmentInfoReqDTO = new ApplyAttachmentInfoReqDTO();
        applyAttachmentInfoReqDTO.setFileType("");//文件类型
        applyAttachmentInfoReqDTO.setFileId(0L);//文件id
        applyAttachmentInfoReqDTOList.add(applyAttachmentInfoReqDTO);
        applyAttachmentReqDTO.setApplyAttachmentInfoReqDTOList(applyAttachmentInfoReqDTOList);
        applyActivityConfigReqDTO.setApplyAttachmentReqDTO(applyAttachmentReqDTO);

        applyActivityConfigReqDTO.setRequestNo(sdf);//请求流水
        applyActivityConfigReqDTO.setRequestSystem("");//请求系统
        applyActivityConfigReqDTO.setRequestDate(now);//请求时间
        applyActivityConfigReqDTO.setTraceLogId(var);//日志号

        Result<String> result = ompActivityConfigService.effectActivity(applyActivityConfigReqDTO);
        System.out.println("*****************************************");
        System.out.println("请求流水:" + applyActivityConfigReqDTO.getRequestNo());
        System.out.println("日志号:" + applyActivityConfigReqDTO.getTraceLogId());
        System.out.println(result);

        if (result.getResult() != null) {
            System.out.println("*****************************************");
            System.out.println(result.getResult());
        }
    }
}
*/
