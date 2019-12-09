package Portal;

import com.google.common.collect.Sets;

import Customize.DataGenerate;
import Customize.UserList;
import com.google.common.collect.Lists;

import com.bestpay.marketing.config.api.tools.request.ApplyRecConsumeRebateRuleReqDTO;
import com.bestpay.marketing.config.api.activity.models.request.ApplyCashReqDTO;
import com.bestpay.marketing.config.api.activity.models.request.ApplyCouponReqDTO;
import com.bestpay.marketing.config.api.tools.request.ApplyRecommendPreferentialReqDTO;
import com.bestpay.marketing.config.api.tools.request.ApplyRecommendRuleReqDTO;
import com.bestpay.marketing.config.api.tools.request.ApplyRecommendedRuleReqDTO;

import com.bestpay.marketing.config.api.activity.models.request.*;
import com.bestpay.marketing.config.api.enums.*;
import com.bestpay.marketing.config.api.tools.request.ApplyToolRecommendBasicInfoReqDTO;
import org.yaml.snakeyaml.util.UriEncoder;

import java.io.*;
import java.util.*;

/**
 * Created by zengyouzu on 2019/8/20.
 * 活动工具预设类
 */
public class Preset extends DataGenerate {
    static CustomizedService customizedService = new CustomizedService();
    static List<ActivityDTO> activityDTOList = new ArrayList<>();
    static ActivityDTO activityDTO = new ActivityDTO();
    static List<ToolDTO> toolList = new ArrayList<>();
    static ToolDTO toolDTO = new ToolDTO();

    //活动
    public static CustomizedService PresetActivity() {
        /*-----------------------------活动基本信息DTO-----------------------------*/
        activityDTO.setActivityBasicInfoApplyReqDTO(getApplyActivityBasicInfoReqDTO());
        /*-----------------------------活动参与规则请求DTO-----------------------------*/
        activityDTO.setActivityRuleApplyReqDTO(getApplyActivityRuleReqDTO());
        /*-----------------------------活动限额规则请求DTO-----------------------------*/
        activityDTO.setLimitRuleReqDTO(getApplyLimitRuleReqDTO());
        /*-----------------------------优惠规则请求DTO-----------------------------*/
        activityDTO.setPreferentialApplyReqDTO(getApplyPreferentialReqDTO());
        /*-----------------------------红包铺子信息-----------------------------*/
        activityDTO.setActivityShowShopApplyReqDTO(getApplyActivityShowReqDTO());
        /*-----------------------------附件页面DTO-----------------------------*/
        activityDTO.setApplyAttachmentReqDTO(getApplyAttachmentReqDTO());
        activityDTOList.add(activityDTO);
        customizedService.setActivityDTOList(activityDTOList);

        return customizedService;
    }

    //活动基本信息DTO
    public static ApplyActivityBasicInfoReqDTO getApplyActivityBasicInfoReqDTO() {
        ApplyActivityBasicInfoReqDTO applyActivityBasicInfoReqDTO = new ApplyActivityBasicInfoReqDTO();
        applyActivityBasicInfoReqDTO.setDataCheckMark(DataCheckMark.ADD.getCode());//数据变动标记,新增
//        applyActivityBasicInfoReqDTO.setDataCheckMark(DataCheckMark.MODIFY.getCode());//数据变动标记,变更
//        applyActivityBasicInfoReqDTO.setDataCheckMark(DataCheckMark.IGNORE.getCode());//数据变动标记,无需处理
        applyActivityBasicInfoReqDTO.setActivityName(sdf + ActivityTypeEnum.BUSINESS_REBATE.getDesc());//活动名称
        applyActivityBasicInfoReqDTO.setActivityDesc(ActivityTypeEnum.BUSINESS_REBATE.getDesc());//活动简介
        applyActivityBasicInfoReqDTO.setNeedInvoice(SwitchEnum.N.getCode());//是否开票,不开票
//        applyActivityBasicInfoReqDTO.setNeedInvoice(SwitchEnum.Y.getCode());//是否开票,开票

        //活动目的
        Set purposeSet = new HashSet();
//        purposeSet.add(ActivityPurposeEnum.NEW_CUSTOMER.getCode());//用户拉新
//        purposeSet.add(ActivityPurposeEnum.INCREASE_ACTIVITY.getCode());//用户促活
//        purposeSet.add(ActivityPurposeEnum.INCREASE_INCOME.getCode());//拉动收入
        purposeSet.add(ActivityPurposeEnum.NOTHING.getCode());//无
        applyActivityBasicInfoReqDTO.setPurpose(purposeSet);

        applyActivityBasicInfoReqDTO.setApplyEmail("123@qq.com@qq.com");//申请人邮箱
        applyActivityBasicInfoReqDTO.setLoginNumber(UserList.ContralNo());//申请人手机号
        applyActivityBasicInfoReqDTO.setApplyDepartment(ApplyDepartmentEnum.O2O.getOldCode());//活动所属事业群

        return applyActivityBasicInfoReqDTO;
    }

    //活动参与规则请求DTO
    public static ApplyActivityRuleReqDTO getApplyActivityRuleReqDTO() {
        ApplyActivityRuleReqDTO activityRuleApplyReqDTO = new ApplyActivityRuleReqDTO();//
        activityRuleApplyReqDTO.setDataCheckMark(DataCheckMark.ADD.getCode());//数据变动标记,新增
//        activityRuleApplyReqDTO.setDataCheckMark(DataCheckMark.MODIFY.getCode());//数据变动标记,变更
//        activityRuleApplyReqDTO.setDataCheckMark(DataCheckMark.IGNORE.getCode());//数据变动标记,无需处理

        //活动场景
        Set activitySceneSet = new HashSet();
        activitySceneSet.add(ActivitySceneEnum.POS.getCode());//POS消费
        activitySceneSet.add(ActivitySceneEnum.COLLECT_CODE.getCode());//收款码
        activitySceneSet.add(ActivitySceneEnum.PAY_CODE.getCode());//付款码
        activityRuleApplyReqDTO.setActivityScene(activitySceneSet);

        //消费场景
        Set expandSceneSet = new HashSet();
        expandSceneSet.add("123");
//        activityRuleApplyReqDTO.setExpandScene(activitySceneSet);

        activityRuleApplyReqDTO.setActivityStartDate(ActivityStart);//活动开始时间
        activityRuleApplyReqDTO.setActivityEndDate(ActivityEnd);//活动结束时间
        activityRuleApplyReqDTO.setActivityDateType(ActivityDateTypeEnum.DAY.getCode());//活动周期类型,每日
//        activityRuleApplyReqDTO.setActivityDateType(ActivityDateTypeEnum.WEEK.getCode());//活动周期类型,每周
//        activityRuleApplyReqDTO.setActivityDateType(ActivityDateTypeEnum.MONTH.getCode());//活动周期类型,每月

        //返利时间点
        Set activityDatePointSet = new HashSet();//(活动周期类型为每日时可以不传)
        activityDatePointSet.add("1");
//        activityRuleApplyReqDTO.setActivityDatePoint(activityDatePointSet);

        activityRuleApplyReqDTO.setDayStartTime(DayStart);//每日开始时间
        activityRuleApplyReqDTO.setDayEndTime(DayEnd);//每日结束时间
        activityRuleApplyReqDTO.setAdaptAreaRange(AdaptAreaRangeEnum.COUNTRY.getCode());//活动适用地区,全国范围
//        activityRuleApplyReqDTO.setAdaptAreaRange(AdaptAreaRangeEnum.PROVINCE.getCode());//活动适用地区,省范围
//        activityRuleApplyReqDTO.setAdaptAreaRange(AdaptAreaRangeEnum.CITY.getCode());//活动适用地区,地市范围
//        activityRuleApplyReqDTO.setAdaptProvince("");//活动省份

        //活动城市
        Set adaptCitySet = new HashSet();
        adaptCitySet.add("");
//        activityRuleApplyReqDTO.setAdaptCity(adaptCitySet);

        activityRuleApplyReqDTO.setDesignateBankCard(SwitchEnum.N.getCode());//是否指定银行卡,不指定
//        activityRuleApplyReqDTO.setDesignateBankCard(SwitchEnum.Y.getCode());//是否指定银行卡,不指定

        //银行code码
        Set bankCodeSet = new HashSet();
        bankCodeSet.add("");
//        activityRuleApplyReqDTO.setBankCode(bankCodeSet);

//        activityRuleApplyReqDTO.setDesignateBankCard("");

        //活动适用用户
        Set carrierSet = new HashSet<>();
        carrierSet.add(CarrierEnum.DX.getCode());//电信
        carrierSet.add(CarrierEnum.YD.getCode());//移动
        carrierSet.add(CarrierEnum.LT.getCode());//联通
        activityRuleApplyReqDTO.setCarrier(carrierSet);

        //账户星级
        Set customerLevelSet = new HashSet();
        customerLevelSet.add(CustomerLevelEnum.GUEST.getCode());//游客
        customerLevelSet.add(CustomerLevelEnum.TWO.getCode());//二星用户
        customerLevelSet.add(CustomerLevelEnum.THREE.getCode());//三星用户
        activityRuleApplyReqDTO.setCustomerLevel(customerLevelSet);

        //用户维度
        Set userDimensionSet = new HashSet();
        userDimensionSet.add(UserDimensionEnum.CONTRAL_NO.getCode());//手机号
        userDimensionSet.add(UserDimensionEnum.CUSTOMER_NO.getCode());//身份证
        userDimensionSet.add(UserDimensionEnum.DEVICE_NO.getCode());//设备号
        activityRuleApplyReqDTO.setUserDimension(userDimensionSet);

        activityRuleApplyReqDTO.setNeedBindCard(SwitchEnum.N.getCode());//限制绑卡,不限制
//        activityRuleApplyReqDTO.setNeedBindCard(SwitchEnum.Y.getCode());//限制绑卡,限制

        //用户名单
        Set rosterTypeSet = new HashSet();
        rosterTypeSet.add(RosterTypeEnum.BLACK_LIST.getCode());//黑名单规则校验
        rosterTypeSet.add(RosterTypeEnum.WHITE_LIST.getCode());//白名单规则校验
        rosterTypeSet.add(RosterTypeEnum.CRM_LIST.getCode());//CRM返利规则校验
        rosterTypeSet.add(RosterTypeEnum.CRM_BLACK_LIST);//外部黑名单校验
        //activityRuleApplyReqDTO.setRosterType(rosterTypeSet);

        //activityRuleApplyReqDTO.setClmListNo("");//省名单编号
        //activityRuleApplyReqDTO.setClmListFlag(SwitchEnum.N.getCode());//省名单参与标识,名单不参与
        //activityRuleApplyReqDTO.setClmListFlag(SwitchEnum.Y.getCode());//省名单参与标识,名单参与

        //活动参与商户列表(omp用)
        List<MerchantReqDTO> merchantReqDTOList = new ArrayList();
        MerchantReqDTO merchantReqDTO = new MerchantReqDTO();
        merchantReqDTO.setMerchantId("043101180050000");//商户号
        merchantReqDTO.setMerchantName("AAAA");//商户名称
        merchantReqDTO.setMerchantSource(MerchantSourceEnum.WEB_GATE.getCode());//商户出处

        //门店列表
        List<StoreReqDTO> storeReqDTOList = new ArrayList();
        StoreReqDTO storeReqDTO = new StoreReqDTO();
        storeReqDTO.setStoreId("");//门店号
        storeReqDTO.setStoreName("");//门店名称
        storeReqDTOList.add(storeReqDTO);
//        merchantReqDTO.setStoreReqDTOList(storeReqDTOList);

        //商品列表
        List<GoodsReqDTO> goodsReqDTOList = new ArrayList();
        GoodsReqDTO goodsReqDTO = new GoodsReqDTO();
        goodsReqDTO.setGoodsId("");//商品编码
        goodsReqDTO.setGoodsName("");//商品名称
        goodsReqDTOList.add(goodsReqDTO);
//        merchantReqDTO.setGoodsReqDTOList(goodsReqDTOList);

        merchantReqDTOList.add(merchantReqDTO);
        activityRuleApplyReqDTO.setMerchantReqDTOList(merchantReqDTOList);

        activityRuleApplyReqDTO.setMarketPaidOrg("");//返利充值商户号(omp用)

        Set userRangeSet = new HashSet();
        userRangeSet.add("");
        activityRuleApplyReqDTO.setUserRange(userRangeSet);//领取用户范围

        activityRuleApplyReqDTO.setBusinessCodeFlag(SwitchEnum.N.getCode());//是否有业务码,没有
//        activityRuleApplyReqDTO.setBusinessCodeFlag(SwitchEnum.Y.getCode());//是否有业务码,有

        return activityRuleApplyReqDTO;
    }

    //活动限额规则请求DTO
    public static ApplyLimitRuleReqDTO getApplyLimitRuleReqDTO() {
        ApplyLimitRuleReqDTO applyLimitRuleReqDTO = new ApplyLimitRuleReqDTO();
        applyLimitRuleReqDTO.setDataCheckMark(DataCheckMark.ADD.getCode());//数据变动标记,新增
//        applyLimitRuleReqDTO.setDataCheckMark(DataCheckMark.MODIFY.getCode());//数据变动标记,变更
//        applyLimitRuleReqDTO.setDataCheckMark(DataCheckMark.IGNORE.getCode());//数据变动标记,无需处理
        applyLimitRuleReqDTO.setLimitCycle(LimitCycleEnum.DAY.getCode());//限制周期,日
//        applyLimitRuleReqDTO.setLimitCycle(LimitCycleEnum.WEEK.getCode());//限制周期,周
//        applyLimitRuleReqDTO.setLimitCycle(LimitCycleEnum.MONTH.getCode());//限制周期,月
//        applyLimitRuleReqDTO.setLimitCycle(LimitCycleEnum.CYCLE.getCode());//限制周期,周期
        applyLimitRuleReqDTO.setUserDayLimitNum(-1L);//用户日限制笔数
        applyLimitRuleReqDTO.setActivityDayLimitNum(-1L);//活动日限制笔数
        applyLimitRuleReqDTO.setUserWeekLimitNum(-1L);//用户周限制笔数
        applyLimitRuleReqDTO.setActivityWeekLimitNum(-1L);//活动周限制笔数
        applyLimitRuleReqDTO.setUserMonthLimitNum(-1L);//用户月限制笔数
        applyLimitRuleReqDTO.setActivityMonthLimitNum(-1L);//活动月限制笔数
        applyLimitRuleReqDTO.setUserCycLimitNum(-1L);//用户活动期间内限制笔数
        applyLimitRuleReqDTO.setActivityCycLimitNum(-1L);//活动期间内限制笔数
        applyLimitRuleReqDTO.setUserDayLimitAmt(-1L);//用户日限制金额
        applyLimitRuleReqDTO.setActivityDayLimitAmt(-1L);//活动日限制金额
        applyLimitRuleReqDTO.setUserWeekLimitAmt(-1L);//用户周限制金额
        applyLimitRuleReqDTO.setActivityWeekLimitAmt(-1L);//活动周限制金额
        applyLimitRuleReqDTO.setUserMonthLimitAmt(-1L);//用户月限制金额
        applyLimitRuleReqDTO.setActivityMonthLimitAmt(-1L);//活动月限制金额
        applyLimitRuleReqDTO.setUserCycLimitAmt(-1L);//用户活动期间内限制金额
        applyLimitRuleReqDTO.setActivityCycLimitAmt(-1L);//活动期间内限制金额

        return applyLimitRuleReqDTO;
    }

    public static ApplyPreferentialReqDTO getApplyPreferentialReqDTO() {
        ApplyPreferentialReqDTO applyPreferentialReqDTO = new ApplyPreferentialReqDTO();
        applyPreferentialReqDTO.setDataCheckMark(DataCheckMark.ADD.getCode());//数据变动标记,新增
//        applyPreferentialReqDTO.setDataCheckMark(DataCheckMark.MODIFY.getCode());//数据变动标记,变更
//        applyPreferentialReqDTO.setDataCheckMark(DataCheckMark.IGNORE.getCode());//数据变动标记,无需处理

        /*-----------------------------现金申请DTO-----------------------------*/
//        applyPreferentialReqDTO.setCashApplyReqDTO(getActivityApplyCashReqDTO());
        /*-----------------------------代金券申请DTO-----------------------------*/
//        applyPreferentialReqDTO.setVoucherApplyReqDTO(getActivityApplyVoucherReqDTO();
        /*-----------------------------红包金申请DTO-----------------------------*/
        applyPreferentialReqDTO.setCouponApplyReqDTO(getActivityApplyCouponReqDTO());
        return applyPreferentialReqDTO;
    }

    //现金申请DTO
    public static ApplyCashReqDTO getActivityApplyCashReqDTO(){
        ApplyCashReqDTO applyCashReqDTO = new ApplyCashReqDTO();
        applyCashReqDTO.setEquityId("E" + RandomStringNo());//权益编号
        applyCashReqDTO.setEquityType(EquityTypeEnum.CASH.getCode());//权益类型
        applyCashReqDTO.setCostAmt(100000L);//总成本
        applyCashReqDTO.setTms("123");//签报号
        applyCashReqDTO.setTmsFinance("");//账务回单号(omp)

        //成本分摊列表
        List<CostReqDTO> costReqDTOList = new ArrayList();
        CostReqDTO costReqDTO = new CostReqDTO();
        costReqDTO.setInvestorType(InvestorTypeEnum.BESTPAY.getCode());//出资方,支付公司
//        costReqDTO.setInvestorType(InvestorTypeEnum.PROVINCE.getCode());//出资方,省公司
//        costReqDTO.setInvestorType(InvestorTypeEnum.MERCHANT.getCode());//出资方,商户
//        costReqDTO.setInvestorType(InvestorTypeEnum.GROUP.getCode());//出资方,集团公司
//        costReqDTO.setInvestorType(InvestorTypeEnum.DISTRICT.getCode());//出资方,地市公司
//        costReqDTO.setInvestorType(InvestorTypeEnum.THIRD_PARTY.getCode());//出资方,第三方公司
        costReqDTO.setInvestorName("");//出资方名称
//        costReqDTO.setInvestmentWay(InvestmentWayEnum.PROVINCE_PREPAYMENT.getCode());//出资方式,省公司预付
        costReqDTO.setInvestmentWay(InvestmentWayEnum.PAY_COMPANY_COST.getCode());//出资方式,支付公司成本
//        costReqDTO.setInvestmentWay(InvestmentWayEnum.THIRD_PARTY_PREPAYMENT.getCode());//出资方式,第三方预付(打款凭证)
//        costReqDTO.setInvestmentWay(InvestmentWayEnum.ONE_POINT_SETTLEMENT.getCode());//出资方式,一点结算
//        costReqDTO.setInvestmentWay(InvestmentWayEnum.BALANCE_SETTLEMENT.getCode());//出资方式,差额结算(台账)
//        costReqDTO.setInvestmentWay(InvestmentWayEnum.MERCHANT_PREPAYMENT.getCode());//出资方式,商户预付(台账)
        costReqDTO.setInvestmentWayName("支付公司成本");//出资方式名称
        costReqDTO.setCostCfgPercentage("100");//出资比例
        costReqDTO.setInvestmentOrgCode("3178002070268402");//出资机构编码
        costReqDTO.setInvestmentOrgName("天翼电子商务有限公司");//出资机构名称
        costReqDTO.setInvestmentOrgAccount("7100843865112156");//出资账户编码
        costReqDTO.setInvestmentOrgAccountName("天翼电子商务有限公司");//出资账户名称
        costReqDTO.setDueAmt(100000L);//应付金额
        costReqDTO.setRealPayAmt(100000L);//实付金额
        costReqDTO.setAdvanceFlag(SwitchEnum.N.getCode());//是否垫资,不垫资
//        costReqDTO.setAdvanceFlag(SwitchEnum.Y.getCode());//是否垫资,垫资
        costReqDTOList.add(costReqDTO);
        applyCashReqDTO.setCostReqDTOList(costReqDTOList);

        applyCashReqDTO.setSettleType("");//结算类型
        applyCashReqDTO.setApplyDepartment(ApplyDepartmentEnum.O2O.getOldCode());//所属部门
        applyCashReqDTO.setNeedInvoice(SwitchEnum.N.getCode());//是否开票,不开票
//        applyCashReqDTO.setNeedInvoice(SwitchEnum.Y.getCode());//是否开票,开票
        applyCashReqDTO.setRebateType(RebateTypeEnum.FIXED.getCode());//返利类型
        applyCashReqDTO.setRebateAmt(100L);//返利金额
        applyCashReqDTO.setNeedMultiply("Y");//是否倍数返利
        applyCashReqDTO.setPercentage("");//折扣返利
        applyCashReqDTO.setRandomLevel("");//随机等级
        applyCashReqDTO.setMinSpendThreshold(500L);//最小消费金额
//        applyCashReqDTO.setMaxSpendThreshold(-1L);//最大消费金额
//        applyCashReqDTO.setMinRebateAmt(0L);//最小返利金额
//        applyCashReqDTO.setMaxRebateAmt(0L);//最大返利金额
        return applyCashReqDTO;
    }

    //代金券申请DTO
    public static ApplyVoucherReqDTO getActivityApplyVoucherReqDTO(){
        ApplyVoucherReqDTO applyVoucherReqDTO = new ApplyVoucherReqDTO();
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
        Set useChannelSet = new HashSet();
        useChannelSet.add(UseChannelEnum.POS.getCode());//POS
        useChannelSet.add(UseChannelEnum.WEB.getCode());//WEB
        useChannelSet.add(UseChannelEnum.SMS.getCode());//短信
        useChannelSet.add(UseChannelEnum.APP.getCode());//客户端
        useChannelSet.add(UseChannelEnum.PAYESU.getCode());//添益宝
        useChannelSet.add(UseChannelEnum.H5.getCode());//H5
        applyVoucherInfoReqDTO.setUseChannel(useChannelSet);

        applyVoucherInfoReqDTO.setEffectType(EffectTypeEnum.ASSIGN.getCode());//生效方式,指定
//        applyVoucherInfoReqDTO.setEffectType(EffectTypeEnum.CIRCLE.getCode());//生效方式,周期
        applyVoucherInfoReqDTO.setEffectStartTime(Start);//生效时间
        applyVoucherInfoReqDTO.setEffectEndTime(End);//失效时间
        applyVoucherInfoReqDTO.setEffectInterval(0);//间隔天数
        applyVoucherInfoReqDTO.setEffectCircle(0);//生效周期
        applyVoucherInfoReqDTO.setEffectDateType("");//生效周期类型

        Set effectDatePointSet = new HashSet();
        effectDatePointSet.add("");
        applyVoucherInfoReqDTO.setEffectDatePoint(effectDatePointSet);//生效周期点

        applyVoucherInfoReqDTO.setDayStartTime("");//每天开始时间
        applyVoucherInfoReqDTO.setDayEndTime("");//每天结束时间
        applyVoucherInfoReqDTO.setDenominationType(DenominationTypeEnum.FIXED.getCode());//面值类型,固定面值
//        applyVoucherInfoReqDTO.setDenominationType(DenominationTypeEnum.SPECIAL.getCode());//面值类型,指定面值
//        applyVoucherInfoReqDTO.setDenominationType(DenominationTypeEnum.PERCENTAGE.getCode());//面值类型,折扣
        applyVoucherInfoReqDTO.setDenomination(0L);//面值
        applyVoucherInfoReqDTO.setMaxDenomination(0L);//最大面值
        applyVoucherInfoReqDTO.setPercentage("");//折扣
        applyVoucherInfoReqDTO.setLowerLimit(0L);//最小消费限额
        applyVoucherInfoReqDTO.setUpperLimit(0L);//最大消费限额
        applyVoucherInfoReqDTO.setDistributeCount(0L);//人均返券张数

        Set customerLevelSet = new HashSet();
//        customerLevelSet.add(CustomerLevelEnum.GUEST.getCode());//游客
        customerLevelSet.add(CustomerLevelEnum.TWO.getCode());//二星用户
        customerLevelSet.add(CustomerLevelEnum.THREE.getCode());//三星用户
        applyVoucherInfoReqDTO.setCustomerLevel(customerLevelSet);//账户星级
        applyVoucherInfoReqDTO.setNeedBindCard(SwitchEnum.N.getCode());//限制绑卡,不限制
//        applyVoucherInfoReqDTO.setNeedBindCard(SwitchEnum.Y.getCode());//限制绑卡,限制
        applyVoucherInfoReqDTO.setContext("");//使用规则简述
        applyVoucherInfoReqDTO.setTms("");//签报号
        applyVoucherInfoReqDTO.setTmsFinance("");//账务回单号

        List<MerchantReqDTO> merchantReqDTOList = new ArrayList();
        MerchantReqDTO merchantReqDTO = new MerchantReqDTO();
        merchantReqDTO.setMerchantId("043101180050000");//商户号
        merchantReqDTO.setMerchantName("AAAA");//商户名称
        merchantReqDTO.setMerchantSource(MerchantSourceEnum.WEB_GATE.getCode());//商户出处

        //门店列表
        List<StoreReqDTO> storeReqDTOList = new ArrayList();
        StoreReqDTO storeReqDTO = new StoreReqDTO();
        storeReqDTO.setStoreId("");//门店号
        storeReqDTO.setStoreName("");//门店名称
        storeReqDTOList.add(storeReqDTO);
//        merchantReqDTO.setStoreReqDTOList(storeReqDTOList);

        //商品列表
        List<GoodsReqDTO> goodsReqDTOList = new ArrayList();
        GoodsReqDTO goodsReqDTO = new GoodsReqDTO();
        goodsReqDTO.setGoodsId("");//商品编码
        goodsReqDTO.setGoodsName("");//商品名称
        goodsReqDTOList.add(goodsReqDTO);
//        merchantReqDTO.setGoodsReqDTOList(goodsReqDTOList);

        merchantReqDTOList.add(merchantReqDTO);
        applyVoucherInfoReqDTO.setMerchantReqDTOList(merchantReqDTOList);//权益商户列表(omp用)

        List<CostReqDTO> costReqDTOList = new ArrayList();
        CostReqDTO costReqDTO = new CostReqDTO();
        costReqDTO.setInvestorType(InvestorTypeEnum.BESTPAY.getCode());//出资方,支付公司
//        costReqDTO.setInvestorType(InvestorTypeEnum.PROVINCE.getCode());//出资方,省公司
//        costReqDTO.setInvestorType(InvestorTypeEnum.MERCHANT.getCode());//出资方,商户
//        costReqDTO.setInvestorType(InvestorTypeEnum.GROUP.getCode());//出资方,集团公司
//        costReqDTO.setInvestorType(InvestorTypeEnum.DISTRICT.getCode());//出资方,地市公司
//        costReqDTO.setInvestorType(InvestorTypeEnum.THIRD_PARTY.getCode());//出资方,第三方公司
        costReqDTO.setInvestorName(InvestorTypeEnum.BESTPAY.getDesc());//出资方名称
//        costReqDTO.setInvestmentWay(InvestmentWayEnum.PROVINCE_PREPAYMENT.getCode());//出资方式,省公司预付
        costReqDTO.setInvestmentWay(InvestmentWayEnum.PAY_COMPANY_COST.getCode());//出资方式,支付公司成本
//        costReqDTO.setInvestmentWay(InvestmentWayEnum.THIRD_PARTY_PREPAYMENT.getCode());//出资方式,第三方预付(打款凭证)
//        costReqDTO.setInvestmentWay(InvestmentWayEnum.ONE_POINT_SETTLEMENT.getCode());//出资方式,一点结算
//        costReqDTO.setInvestmentWay(InvestmentWayEnum.BALANCE_SETTLEMENT.getCode());//出资方式,差额结算(台账)
//        costReqDTO.setInvestmentWay(InvestmentWayEnum.MERCHANT_PREPAYMENT.getCode());//出资方式,商户预付(台账)
        costReqDTO.setInvestmentWayName(InvestmentWayEnum.PAY_COMPANY_COST.getDesc());//出资方式名称
        costReqDTO.setCostCfgPercentage("100");//出资比例
        costReqDTO.setInvestmentOrgCode("3178002076347019");//出资机构编码 3178002070088068(沙箱)
        costReqDTO.setInvestmentOrgName("天翼电子商务有限公司（台账）");//出资机构名称
        costReqDTO.setInvestmentOrgAccount("7100848511511156");//出资账户编码 7102227752829156(沙箱)
        costReqDTO.setInvestmentOrgAccountName("天翼电子商务有限公司（台账）");//出资账户名称
//        costReqDTO.setDueAmt(100000L);//应付金额
        costReqDTO.setRealPayAmt(100000L);//实付金额
//        costReqDTO.setModifyRealPayAmt(0L);//变更实付金额
        costReqDTO.setAdvanceFlag(SwitchEnum.N.getCode());//是否垫资,不垫资
//        costReqDTO.setAdvanceFlag(SwitchEnum.Y.getCode());//是否垫资,垫资
        costReqDTOList.add(costReqDTO);
        applyVoucherInfoReqDTO.setCostReqDTOList(costReqDTOList);//成本分摊申请列表
        applyVoucherInfoReqDTO.setApplyUser("");//申请人
        applyVoucherInfoReqDTO.setSettleType("");//结算方式
        applyVoucherInfoReqDTO.setApplyDepartment("");//所属部门
        applyVoucherInfoReqDTO.setApplyProvince("");
        applyVoucherInfoReqDTO.setApplyCity("");
        applyVoucherInfoReqDTO.setOwnMerchantFlag("Y");
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
        applyVoucherReqDTO.setNeedMultiply("Y");//是否倍数返利
        applyVoucherReqDTO.setPercentage("");//折扣返利
        applyVoucherReqDTO.setRandomLevel("");//随机等级
        applyVoucherReqDTO.setMinSpendThreshold(0L);//最小消费金额
        applyVoucherReqDTO.setMaxSpendThreshold(0L);//最大消费金额
        applyVoucherReqDTO.setMinRebateAmt(0L);//最小返利金额
        applyVoucherReqDTO.setMaxRebateAmt(0L);//最大返利金额

        return applyVoucherReqDTO;
    }

    //红包金申请DTO
    public static ApplyCouponReqDTO getActivityApplyCouponReqDTO(){
        ApplyCouponReqDTO applyCouponReqDTO = new ApplyCouponReqDTO();
        applyCouponReqDTO.setConfigCostType(ConfigCostTypeEnum.AMT.getCode());//成本配置方式,金额
//        applyCouponReqDTO.setConfigCostType(ConfigCostTypeEnum.NUM.getCode());//成本配置方式,名额
//        applyCouponReqDTO.setConfigCostType(ConfigCostTypeEnum.ALL.getCode());//成本配置方式,所有
        applyCouponReqDTO.setCostAmt(100000L);//总成本
//        applyCouponReqDTO.setCostNum(0L);//总名额

        //权益明细列表
        List<ApplyCouponInfoReqDTO> couponInfoApplyReqDTOList = new ArrayList();
        ApplyCouponInfoReqDTO applyCouponInfoReqDTO = new ApplyCouponInfoReqDTO();
        applyCouponInfoReqDTO.setEquityId("");//权益编号
        applyCouponInfoReqDTO.setApplyUses(ApplyUsesEnum.REBATE_RECHARGE.getCode());//申请用途,活动返权益
//        applyCouponInfoReqDTO.setApplyUses(ApplyUsesEnum.BATCH_RECHARGE.getCode());//申请用途,批充权益
        applyCouponInfoReqDTO.setEquityName("");//权益名称
//        applyCouponInfoReqDTO.setEquityCategory(EquityCategoryEnum.COMMON.getCode());//券类别,通用券
//        applyCouponInfoReqDTO.setEquityCategory(EquityCategoryEnum.MERCHANT.getCode());//券类别,商户券
        applyCouponInfoReqDTO.setEquityCategory(EquityCategoryEnum.PRODUCT_CODE.getCode());//券类别,业务券
        applyCouponInfoReqDTO.setBusinessType(BusinessTypeEnum.PHONE_RECHARGE.getCode());//业务类型,话费充值
//        applyCouponInfoReqDTO.setBusinessType(BusinessTypeEnum.PAY_BACK_CREDIT.getCode());//业务类型,还信用卡
//        applyCouponInfoReqDTO.setBusinessType(BusinessTypeEnum.COUNTRY_FLOW.getCode());//业务类型,全国流量
//        applyCouponInfoReqDTO.setBusinessType(BusinessTypeEnum.LOCAL_FLOW.getCode());//业务类型,本地流量
        applyCouponInfoReqDTO.setEquityDesc("");//权益简介

        //使用渠道
        Set useChannelSet = new HashSet();
        useChannelSet.add(UseChannelEnum.POS.getCode());//POS
        useChannelSet.add(UseChannelEnum.WEB.getCode());//WEB
        useChannelSet.add(UseChannelEnum.SMS.getCode());//短信
        useChannelSet.add(UseChannelEnum.APP.getCode());//客户端
        useChannelSet.add(UseChannelEnum.PAYESU.getCode());//添益宝
        useChannelSet.add(UseChannelEnum.H5.getCode());//H5
        applyCouponInfoReqDTO.setUseChannel(useChannelSet);
        applyCouponInfoReqDTO.setEffectType("");//生效方式
        applyCouponInfoReqDTO.setEffectStartTime(Start);//生效时间
        applyCouponInfoReqDTO.setEffectEndTime(End);//失效时间
//        applyCouponInfoReqDTO.setEffectInterval(0);//间隔天数
//        applyCouponInfoReqDTO.setEffectCircle(0);//生效周期
        applyCouponInfoReqDTO.setEffectDateType("");//生效周期类型

        Set effectDatePointSet = new HashSet();
        effectDatePointSet.add("");
        applyCouponInfoReqDTO.setEffectDatePoint(effectDatePointSet);//生效周期点
        applyCouponInfoReqDTO.setDayStartTime("");//每天开始时间
        applyCouponInfoReqDTO.setDayEndTime("");//每天结束时间
//        applyCouponInfoReqDTO.setDenominationType(DenominationTypeEnum.FIXED.getCode());//面值类型,固定面值
//        applyCouponInfoReqDTO.setDenominationType(DenominationTypeEnum.SPECIAL.getCode());//面值类型,指定面值
        applyCouponInfoReqDTO.setDenominationType(DenominationTypeEnum.PERCENTAGE.getCode());//面值类型,折扣
        applyCouponInfoReqDTO.setDenomination(100L);//面值
//        applyCouponInfoReqDTO.setMinDenomination(0L);//单张最小面额
//        applyCouponInfoReqDTO.setMaxDenomination(0L);//单张最大面额
        applyCouponInfoReqDTO.setLowerLimit(5000L);//最小消费门槛
        applyCouponInfoReqDTO.setDistributeCount(1L);//人均返券张数

        Set customerLevelSet = new HashSet();
        customerLevelSet.add(CustomerLevelEnum.GUEST.getCode());//游客
        customerLevelSet.add(CustomerLevelEnum.TWO.getCode());//二星用户
        customerLevelSet.add(CustomerLevelEnum.THREE.getCode());//三星用户
        applyCouponInfoReqDTO.setCustomerLevel(customerLevelSet);//账户星级
        applyCouponInfoReqDTO.setNeedBindCard(SwitchEnum.N.getCode());//限制绑卡,不限制
//        applyCouponInfoReqDTO.setNeedBindCard(SwitchEnum.Y.getCode());//限制绑卡,限制
        applyCouponInfoReqDTO.setContext("");//使用规则简述
        applyCouponInfoReqDTO.setTms("");//签报号
        applyCouponInfoReqDTO.setTmsFinance("");//账务回单号(omp用)

        //活动参与商户列表(omp用)
        List<MerchantReqDTO> merchantReqDTOList = new ArrayList();
        MerchantReqDTO merchantReqDTO = new MerchantReqDTO();
        merchantReqDTO.setMerchantId("043101180050000");//商户号
        merchantReqDTO.setMerchantName("AAAA");//商户名称
        merchantReqDTO.setMerchantSource(MerchantSourceEnum.WEB_GATE.getCode());//商户出处

        //门店列表
        List<StoreReqDTO> storeReqDTOList = new ArrayList();
        StoreReqDTO storeReqDTO = new StoreReqDTO();
        storeReqDTO.setStoreId("");//门店号
        storeReqDTO.setStoreName("");//门店名称
        storeReqDTOList.add(storeReqDTO);
//        merchantReqDTO.setStoreReqDTOList(storeReqDTOList);

        //商品列表
        List<GoodsReqDTO> goodsReqDTOList = new ArrayList();
        GoodsReqDTO goodsReqDTO = new GoodsReqDTO();
        goodsReqDTO.setGoodsId("");//商品编码
        goodsReqDTO.setGoodsName("");//商品名称
        goodsReqDTOList.add(goodsReqDTO);
//        merchantReqDTO.setGoodsReqDTOList(goodsReqDTOList);

        merchantReqDTOList.add(merchantReqDTO);
        applyCouponInfoReqDTO.setMerchantReqDTOList(merchantReqDTOList);//权益商户列表(omp用)

        List<CostReqDTO> costReqDTOList = new ArrayList();
        CostReqDTO costReqDTO = new CostReqDTO();
        costReqDTO.setInvestorType(InvestorTypeEnum.BESTPAY.getCode());//出资方,支付公司
//        costReqDTO.setInvestorType(InvestorTypeEnum.PROVINCE.getCode());//出资方,省公司
//        costReqDTO.setInvestorType(InvestorTypeEnum.MERCHANT.getCode());//出资方,商户
//        costReqDTO.setInvestorType(InvestorTypeEnum.GROUP.getCode());//出资方,集团公司
//        costReqDTO.setInvestorType(InvestorTypeEnum.DISTRICT.getCode());//出资方,地市公司
//        costReqDTO.setInvestorType(InvestorTypeEnum.THIRD_PARTY.getCode());//出资方,第三方公司
        costReqDTO.setInvestorName(InvestorTypeEnum.BESTPAY.getDesc());//出资方名称
//        costReqDTO.setInvestmentWay(InvestmentWayEnum.PROVINCE_PREPAYMENT.getCode());//出资方式,省公司预付
        costReqDTO.setInvestmentWay(InvestmentWayEnum.PAY_COMPANY_COST.getCode());//出资方式,支付公司成本
//        costReqDTO.setInvestmentWay(InvestmentWayEnum.THIRD_PARTY_PREPAYMENT.getCode());//出资方式,第三方预付(打款凭证)
//        costReqDTO.setInvestmentWay(InvestmentWayEnum.ONE_POINT_SETTLEMENT.getCode());//出资方式,一点结算
//        costReqDTO.setInvestmentWay(InvestmentWayEnum.BALANCE_SETTLEMENT.getCode());//出资方式,差额结算(台账)
//        costReqDTO.setInvestmentWay(InvestmentWayEnum.MERCHANT_PREPAYMENT.getCode());//出资方式,商户预付(台账)
        costReqDTO.setInvestmentWayName(InvestmentWayEnum.PAY_COMPANY_COST.getDesc());//出资方式名称
        costReqDTO.setCostCfgPercentage("100");//出资比例
        costReqDTO.setInvestmentOrgCode("3178002076347019");//出资机构编码 3178002070088068(沙箱)
        costReqDTO.setInvestmentOrgName("天翼电子商务有限公司（台账）");//出资机构名称
        costReqDTO.setInvestmentOrgAccount("7100848511511156");//出资账户编码 7102227752829156(沙箱)
        costReqDTO.setInvestmentOrgAccountName("天翼电子商务有限公司（台账）");//出资账户名称
//        costReqDTO.setDueAmt(100000L);//应付金额
        costReqDTO.setRealPayAmt(100000L);//实付金额
//        costReqDTO.setModifyRealPayAmt(0L);//变更实付金额
        costReqDTO.setAdvanceFlag(SwitchEnum.N.getCode());//是否垫资,不垫资
//        costReqDTO.setAdvanceFlag(SwitchEnum.Y.getCode());//是否垫资,垫资
        costReqDTOList.add(costReqDTO);
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
        applyCouponReqDTO.setNeedMultiply("Y");//是否倍数返利
        applyCouponReqDTO.setPercentage("");//折扣返利
        applyCouponReqDTO.setRandomLevel("");//随机等级
        applyCouponReqDTO.setMinSpendThreshold(0L);//最小消费金额
        applyCouponReqDTO.setMaxSpendThreshold(0L);//最大消费金额
        applyCouponReqDTO.setMinRebateAmt(0L);//最小返利金额
        applyCouponReqDTO.setMaxRebateAmt(0L);//最大返利金额

        return applyCouponReqDTO;
    }

    public static ApplyActivityShowReqDTO getApplyActivityShowReqDTO() {
        ApplyActivityShowReqDTO activityShowShopApplyReqDTO = new ApplyActivityShowReqDTO();
        activityShowShopApplyReqDTO.setDataCheckMark(DataCheckMark.ADD.getCode());//数据变动标记,新增
//        activityShowShopApplyReqDTO.setDataCheckMark(DataCheckMark.MODIFY.getCode());//数据变动标记,变更
//        activityShowShopApplyReqDTO.setDataCheckMark(DataCheckMark.IGNORE.getCode());//数据变动标记,无需处理
        activityShowShopApplyReqDTO.setShowName("红包铺子展示名称");//红包铺子展示名称
        activityShowShopApplyReqDTO.setMerchantName("商户名称");//商户名称
        activityShowShopApplyReqDTO.setProvince("999900");//活动商户地区-省份

        Set adaptCitySet = new HashSet();
        adaptCitySet.add("");
        activityShowShopApplyReqDTO.setCity(adaptCitySet);//活动商户地区-城市
        activityShowShopApplyReqDTO.setContext("规则");//规则
        activityShowShopApplyReqDTO.setProtocolId("");//协议id
        activityShowShopApplyReqDTO.setProtocolType("");//协议类型
        activityShowShopApplyReqDTO.setToUrl("");//URL活动跳转
        activityShowShopApplyReqDTO.setRuleGroupNo("");//规则组编号
        activityShowShopApplyReqDTO.setOptionalMerchant("");//可用商户
        activityShowShopApplyReqDTO.setActivityAbbreviation("");//活动简称
        activityShowShopApplyReqDTO.setActivityType("");//活动类型
        activityShowShopApplyReqDTO.setShowPicAddress("");//展示图片地址
        activityShowShopApplyReqDTO.setMenuCategory("分类菜单");//分类菜单
        activityShowShopApplyReqDTO.setActivityScene("活动场景");//活动场景
        activityShowShopApplyReqDTO.setActivityPicAddress("");//活动图片地址(大图)

        return activityShowShopApplyReqDTO;
    }

    //推荐人工具
    public static CustomizedService PresetTool() {
        /*-----------------------------推荐人工具基本信息DTO-----------------------------*/
        toolDTO.setApplyToolRecommendBasicInfoReqDTO(getApplyToolRecommendBasicInfoReqDTO());
        /*-----------------------------推荐人工具规则DTO-----------------------------*/
        toolDTO.setApplyRecommendRuleReqDTO(getApplyRecommendRuleReqDTO());
        /*-----------------------------推荐人工具优惠信息DTO-----------------------------*/
        toolDTO.setApplyRecommendPreferentialReqDTO(getApplyRecommendPreferentialReqDTO());
        /*-----------------------------被推荐人规则DTO-----------------------------*/
        toolDTO.setApplyRecommendedRuleReqDTO(getApplyRecommendedRuleReqDTO());
        /*-----------------------------附件页面DTO-----------------------------*/
        toolDTO.setApplyAttachmentReqDTO(getApplyAttachmentReqDTO());
        toolList.add(toolDTO);
        customizedService.setToolDTOList(toolList);

        return customizedService;
    }

    //推荐人工具基本信息DTO
    private static ApplyToolRecommendBasicInfoReqDTO getApplyToolRecommendBasicInfoReqDTO() {
        String str = sdf + "推荐人工具";

        ApplyToolRecommendBasicInfoReqDTO applyToolRecommendBasicInfoReqDTO = new ApplyToolRecommendBasicInfoReqDTO();
        applyToolRecommendBasicInfoReqDTO.setDataCheckMark(DataCheckMark.ADD.getCode());//数据变动标记,新增
//        applyToolRecommendBasicInfoReqDTO.setDataCheckMark(DataCheckMark.MODIFY.getCode());//数据变动标记,变更
//        applyToolRecommendBasicInfoReqDTO.setDataCheckMark(DataCheckMark.IGNORE.getCode());//数据变动标记,无需处理
        applyToolRecommendBasicInfoReqDTO.setToolName(str);
        applyToolRecommendBasicInfoReqDTO.setToolDesc(str);
        applyToolRecommendBasicInfoReqDTO.setTitle(str);
        applyToolRecommendBasicInfoReqDTO.setTitleDesc(str);
        applyToolRecommendBasicInfoReqDTO.setThemeType("DEFAULT");
        applyToolRecommendBasicInfoReqDTO.setSubThemeType(RecSubThemeTypeEnum.GENERAL.getCode());
        applyToolRecommendBasicInfoReqDTO.setBackgroundPictureAddress(0L);
        applyToolRecommendBasicInfoReqDTO.setButtonPictureAddress(0L);
        applyToolRecommendBasicInfoReqDTO.setButtonName(str);
        applyToolRecommendBasicInfoReqDTO.setJumpType(RecJumpTypeEnum.CHAINING.getCode());
        applyToolRecommendBasicInfoReqDTO.setJumpUrl("http://www.baidu.com");
//        applyToolRecommendBasicInfoReqDTO.setPosterPictureAddress(address);

        //活动目的
        Set purposeSet = new HashSet();
//        purposeSet.add(ActivityPurposeEnum.NEW_CUSTOMER.getCode());//用户拉新
//        purposeSet.add(ActivityPurposeEnum.INCREASE_ACTIVITY.getCode());//用户促活
//        purposeSet.add(ActivityPurposeEnum.INCREASE_INCOME.getCode());//拉动收入
        purposeSet.add(ActivityPurposeEnum.NOTHING.getCode());//无
        applyToolRecommendBasicInfoReqDTO.setPurpose(purposeSet);

        applyToolRecommendBasicInfoReqDTO.setApplyEmail("123@qq.com");//申请人邮箱
        applyToolRecommendBasicInfoReqDTO.setLoginNumber(UserList.ContralNo());//申请人手机号
        applyToolRecommendBasicInfoReqDTO.setApplyDepartment(ApplyDepartmentEnum.O2O.getOldCode());//活动所属事业群

        return applyToolRecommendBasicInfoReqDTO;
    }

    //推荐人工具规则DTO
    public static ApplyRecommendRuleReqDTO getApplyRecommendRuleReqDTO() {
        ApplyRecommendRuleReqDTO applyRecommendRuleReqDTO = new ApplyRecommendRuleReqDTO();
        applyRecommendRuleReqDTO.setDataCheckMark(DataCheckMark.ADD.getCode());//数据变动标记,新增
//        applyRecommendRuleReqDTO.setDataCheckMark(DataCheckMark.MODIFY.getCode());//数据变动标记,变更
//        applyRecommendRuleReqDTO.setDataCheckMark(DataCheckMark.IGNORE.getCode());//数据变动标记,无需处理
        applyRecommendRuleReqDTO.setActivityStartDate(ActivityStart);
        applyRecommendRuleReqDTO.setActivityEndDate(ActivityEnd);
        applyRecommendRuleReqDTO.setAdaptAreaRange(AdaptAreaRangeEnum.COUNTRY.getCode());//活动适用地区,全国范围
//        applyRecommendRuleReqDTO.setAdaptAreaRange(AdaptAreaRangeEnum.PROVINCE.getCode());//活动适用地区,省范围
//        applyRecommendRuleReqDTO.setAdaptAreaRange(AdaptAreaRangeEnum.CITY.getCode());//活动适用地区,地市范围
//        applyRecommendRuleReqDTO.setAdaptProvince("");//活动适用省份

        Set adaptCitySet = new HashSet();
        adaptCitySet.add("");
//        applyRecommendRuleReqDTO.setAdaptCity(adaptCitySet);

        Set carrierSet = new HashSet<>();
        carrierSet.add(CarrierEnum.DX.getCode());//电信
        carrierSet.add(CarrierEnum.YD.getCode());//移动
        carrierSet.add(CarrierEnum.LT.getCode());//联通
        applyRecommendRuleReqDTO.setCarrier(carrierSet);

        Set customerLevelSet = new HashSet();
//        customerLevelSet.add(CustomerLevelEnum.GUEST.getCode());//游客
        customerLevelSet.add(CustomerLevelEnum.TWO.getCode());//二星用户
        customerLevelSet.add(CustomerLevelEnum.THREE.getCode());//三星用户
        applyRecommendRuleReqDTO.setCustomerLevel(customerLevelSet);

        Set userDimensionSet = new HashSet();
        userDimensionSet.add(UserDimensionEnum.CONTRAL_NO.getCode());//手机号
        userDimensionSet.add(UserDimensionEnum.CUSTOMER_NO.getCode());//身份证
        userDimensionSet.add(UserDimensionEnum.DEVICE_NO.getCode());//设备号
        applyRecommendRuleReqDTO.setUserDimension(userDimensionSet);

        applyRecommendRuleReqDTO.setNeedBindCard(SwitchEnum.N.getCode());
//        applyRecommendRuleReqDTO.setClmListNo("");
//        applyRecommendRuleReqDTO.setClmListFlag(SwitchEnum.N.getCode());

        return applyRecommendRuleReqDTO;
    }

    //推荐人工具优惠信息DTO
    public static ApplyRecommendPreferentialReqDTO getApplyRecommendPreferentialReqDTO() {
        ApplyRecommendPreferentialReqDTO applyRecommendPreferentialReqDTO = new ApplyRecommendPreferentialReqDTO();
        applyRecommendPreferentialReqDTO.setDataCheckMark(DataCheckMark.ADD.getCode());//数据变动标记,新增
//        applyRecommendPreferentialReqDTO.setDataCheckMark(DataCheckMark.MODIFY.getCode());//数据变动标记,变更
//        applyRecommendPreferentialReqDTO.setDataCheckMark(DataCheckMark.IGNORE.getCode());//数据变动标记,无需处理
//        applyRecommendPreferentialReqDTO.setCashApplyReqDTO(getToolApplyCashReqDTO());
        applyRecommendPreferentialReqDTO.setCouponApplyReqDTO(getToolApplyCouponReqDTO());
        return applyRecommendPreferentialReqDTO;
    }

    //现金申请DTO
    public static ApplyCashReqDTO getToolApplyCashReqDTO() {
        ApplyCashReqDTO applyCashReqDTO = new ApplyCashReqDTO();
//        applyCashReqDTO.setEquityId("E" + RandomStringNo());//权益编号
        applyCashReqDTO.setEquityType(EquityTypeEnum.CASH.getCode());//权益类型
        applyCashReqDTO.setCostAmt(100000L);//总成本
        applyCashReqDTO.setTms("123");//签报号
        applyCashReqDTO.setTmsFinance("");//账务回单号(omp)

        //成本分摊列表
        List<CostReqDTO> costReqDTOList = new ArrayList();
        CostReqDTO costReqDTO = new CostReqDTO();
        costReqDTO.setInvestorType(InvestorTypeEnum.BESTPAY.getCode());//出资方,支付公司
//        costReqDTO.setInvestorType(InvestorTypeEnum.PROVINCE.getCode());//出资方,省公司
//        costReqDTO.setInvestorType(InvestorTypeEnum.MERCHANT.getCode());//出资方,商户
//        costReqDTO.setInvestorType(InvestorTypeEnum.GROUP.getCode());//出资方,集团公司
//        costReqDTO.setInvestorType(InvestorTypeEnum.DISTRICT.getCode());//出资方,地市公司
//        costReqDTO.setInvestorType(InvestorTypeEnum.THIRD_PARTY.getCode());//出资方,第三方公司
        costReqDTO.setInvestorName(InvestorTypeEnum.BESTPAY.getDesc());//出资方名称
//        costReqDTO.setInvestmentWay(InvestmentWayEnum.PROVINCE_PREPAYMENT.getCode());//出资方式,省公司预付
        costReqDTO.setInvestmentWay(InvestmentWayEnum.PAY_COMPANY_COST.getCode());//出资方式,支付公司成本
//        costReqDTO.setInvestmentWay(InvestmentWayEnum.THIRD_PARTY_PREPAYMENT.getCode());//出资方式,第三方预付(打款凭证)
//        costReqDTO.setInvestmentWay(InvestmentWayEnum.ONE_POINT_SETTLEMENT.getCode());//出资方式,一点结算
//        costReqDTO.setInvestmentWay(InvestmentWayEnum.BALANCE_SETTLEMENT.getCode());//出资方式,差额结算(台账)
//        costReqDTO.setInvestmentWay(InvestmentWayEnum.MERCHANT_PREPAYMENT.getCode());//出资方式,商户预付(台账)
        costReqDTO.setInvestmentWayName(InvestmentWayEnum.PAY_COMPANY_COST.getDesc());//出资方式名称
        costReqDTO.setCostCfgPercentage("100");//出资比例
        costReqDTO.setInvestmentOrgCode("3178002076347019");//出资机构编码 3178002070088068(沙箱)
        costReqDTO.setInvestmentOrgName("天翼电子商务有限公司（台账）");//出资机构名称
        costReqDTO.setInvestmentOrgAccount("7100848511511156");//出资账户编码 7102227752829156(沙箱)
        costReqDTO.setInvestmentOrgAccountName("天翼电子商务有限公司（台账）");//出资账户名称
//        costReqDTO.setDueAmt(100000L);//应付金额
        costReqDTO.setRealPayAmt(100000L);//实付金额
//        costReqDTO.setModifyRealPayAmt(0L);//变更实付金额
        costReqDTO.setAdvanceFlag(SwitchEnum.N.getCode());//是否垫资,不垫资
//        costReqDTO.setAdvanceFlag(SwitchEnum.Y.getCode());//是否垫资,垫资
        costReqDTOList.add(costReqDTO);
        applyCashReqDTO.setCostReqDTOList(costReqDTOList);

        applyCashReqDTO.setSettleType(SettleTypeEnum.LEDGER.getCode());//结算类型
        applyCashReqDTO.setApplyDepartment(ApplyDepartmentEnum.SZHB.getOldCode());//所属部门
        applyCashReqDTO.setNeedInvoice(SwitchEnum.N.getCode());//是否开票,不开票
//        applyCashReqDTO.setNeedInvoice(SwitchEnum.Y.getCode());//是否开票,开票
        applyCashReqDTO.setRebateType(RebateTypeEnum.FIXED.getCode());//返利类型
        applyCashReqDTO.setRebateAmt(-1L);//返利金额
        applyCashReqDTO.setInvitationNumber(1L);//每邀请人数
        applyCashReqDTO.setInvitedNumber(1000L);//最多邀请人数
        applyCashReqDTO.setNeedMultiply(SwitchEnum.N.getCode());//是否倍数返利
        applyCashReqDTO.setPercentage("");//折扣返利
        applyCashReqDTO.setRandomLevel("");//随机等级
        applyCashReqDTO.setMinSpendThreshold(1L);//最小消费金额
//        applyCashReqDTO.setMaxSpendThreshold(10000L);//最大消费金额
//        applyCashReqDTO.setMinRebateAmt(0L);//最小返利金额
//        applyCashReqDTO.setMaxRebateAmt(0L);//最大返利金额

        return applyCashReqDTO;
    }

    //红包金申请DTO
    public static ApplyCouponReqDTO getToolApplyCouponReqDTO() {
        ApplyCouponReqDTO applyCouponReqDTO = new ApplyCouponReqDTO();
        applyCouponReqDTO.setConfigCostType(ConfigCostTypeEnum.AMT.getCode());//成本配置方式,金额
//        applyCouponReqDTO.setConfigCostType(ConfigCostTypeEnum.NUM.getCode());//成本配置方式,名额
//        applyCouponReqDTO.setConfigCostType(ConfigCostTypeEnum.ALL.getCode());//成本配置方式,所有
        applyCouponReqDTO.setCostAmt(1000000L);//总成本
        applyCouponReqDTO.setCostNum(1000000L);//总名额

        //权益明细列表
        List<ApplyCouponInfoReqDTO> couponInfoApplyReqDTOList = new ArrayList();
        ApplyCouponInfoReqDTO applyCouponInfoReqDTO = new ApplyCouponInfoReqDTO();
        applyCouponInfoReqDTO.setEquityId("E" + RandomStringNo());//权益编号
        applyCouponInfoReqDTO.setApplyUses(ApplyUsesEnum.REBATE_RECHARGE.getCode());//申请用途,活动返权益
//        applyCouponInfoReqDTO.setApplyUses(ApplyUsesEnum.BATCH_RECHARGE.getCode());//申请用途,批充权益
        applyCouponInfoReqDTO.setEquityName("");//权益名称
        applyCouponInfoReqDTO.setEquityCategory(EquityCategoryEnum.COMMON.getCode());//券类别,通用券
//        applyCouponInfoReqDTO.setEquityCategory(EquityCategoryEnum.MERCHANT.getCode());//券类别,商户券
//        applyCouponInfoReqDTO.setEquityCategory(EquityCategoryEnum.PRODUCT_CODE.getCode());//券类别,业务券
        applyCouponInfoReqDTO.setBusinessType(BusinessTypeEnum.PHONE_RECHARGE.getCode());//业务类型,话费充值
//        applyCouponInfoReqDTO.setBusinessType(BusinessTypeEnum.PAY_BACK_CREDIT.getCode());//业务类型,还信用卡
//        applyCouponInfoReqDTO.setBusinessType(BusinessTypeEnum.COUNTRY_FLOW.getCode());//业务类型,全国流量
//        applyCouponInfoReqDTO.setBusinessType(BusinessTypeEnum.LOCAL_FLOW.getCode());//业务类型,本地流量
        applyCouponInfoReqDTO.setEquityDesc("");//权益简介

        //使用渠道
        Set useChannelSet = new HashSet();
        useChannelSet.add(UseChannelEnum.POS.getCode());//POS
        useChannelSet.add(UseChannelEnum.WEB.getCode());//WEB
        useChannelSet.add(UseChannelEnum.SMS.getCode());//短信
        useChannelSet.add(UseChannelEnum.APP.getCode());//客户端
        useChannelSet.add(UseChannelEnum.PAYESU.getCode());//添益宝
        useChannelSet.add(UseChannelEnum.H5.getCode());//H5
        applyCouponInfoReqDTO.setUseChannel(useChannelSet);//使用渠道

        applyCouponInfoReqDTO.setEffectType("");//生效方式
        applyCouponInfoReqDTO.setEffectStartTime(Start);//生效时间
        applyCouponInfoReqDTO.setEffectEndTime(End);//失效时间
        applyCouponInfoReqDTO.setEffectInterval(0);//间隔天数
        applyCouponInfoReqDTO.setEffectCircle(0);//生效周期
        applyCouponInfoReqDTO.setEffectDateType("");//生效周期类型

        Set effectDatePointSet = new HashSet();
        effectDatePointSet.add("");
        applyCouponInfoReqDTO.setEffectDatePoint(effectDatePointSet);//生效周期点

        applyCouponInfoReqDTO.setDayStartTime("");//每天开始时间
        applyCouponInfoReqDTO.setDayEndTime("");//每天结束时间
        applyCouponInfoReqDTO.setDenominationType(DenominationTypeEnum.FIXED.getCode());//面值类型,固定面值
//        applyCouponInfoReqDTO.setDenominationType(DenominationTypeEnum.SPECIAL.getCode());//面值类型,指定面值
//        applyCouponInfoReqDTO.setDenominationType(DenominationTypeEnum.PERCENTAGE.getCode());//面值类型,折扣
        applyCouponInfoReqDTO.setDenomination(1000L);//面值
        applyCouponInfoReqDTO.setMinDenomination(0L);//单张最小面额
        applyCouponInfoReqDTO.setMaxDenomination(0L);//单张最大面额
        applyCouponInfoReqDTO.setLowerLimit(0L);//最小消费门槛
        applyCouponInfoReqDTO.setDistributeCount(0L);//最大消费门槛

        Set customerLevelSet = new HashSet();
//        customerLevelSet.add(CustomerLevelEnum.GUEST.getCode());//游客
        customerLevelSet.add(CustomerLevelEnum.TWO.getCode());//二星用户
        customerLevelSet.add(CustomerLevelEnum.THREE.getCode());//三星用户
        applyCouponInfoReqDTO.setCustomerLevel(customerLevelSet);//账户星级

        applyCouponInfoReqDTO.setNeedBindCard(SwitchEnum.N.getCode());//限制绑卡,不限制
//        applyCouponInfoReqDTO.setNeedBindCard(SwitchEnum.Y.getCode());//限制绑卡,限制
        applyCouponInfoReqDTO.setContext("");//使用规则简述
        applyCouponInfoReqDTO.setTms("");//签报号
        applyCouponInfoReqDTO.setTmsFinance("");//账务回单号(omp用)

        //活动参与商户列表(omp用)
        List<MerchantReqDTO> merchantReqDTOList = new ArrayList();
        MerchantReqDTO merchantReqDTO = new MerchantReqDTO();
        merchantReqDTO.setMerchantId("043101180050000");//商户号
        merchantReqDTO.setMerchantName("AAAA");//商户名称
        merchantReqDTO.setMerchantSource(MerchantSourceEnum.WEB_GATE.getCode());//商户出处

        //门店列表
        List<StoreReqDTO> storeReqDTOList = new ArrayList();
        StoreReqDTO storeReqDTO = new StoreReqDTO();
        storeReqDTO.setStoreId("");//门店号
        storeReqDTO.setStoreName("");//门店名称
        storeReqDTOList.add(storeReqDTO);
//        merchantReqDTO.setStoreReqDTOList(storeReqDTOList);

        //商品列表
        List<GoodsReqDTO> goodsReqDTOList = new ArrayList();
        GoodsReqDTO goodsReqDTO = new GoodsReqDTO();
        goodsReqDTO.setGoodsId("");//商品编码
        goodsReqDTO.setGoodsName("");//商品名称
        goodsReqDTOList.add(goodsReqDTO);
//        merchantReqDTO.setGoodsReqDTOList(goodsReqDTOList);

        merchantReqDTOList.add(merchantReqDTO);
        applyCouponInfoReqDTO.setMerchantReqDTOList(merchantReqDTOList);//权益商户列表(omp用)

        //成本分摊列表
        List<CostReqDTO> costReqDTOList = new ArrayList();
        CostReqDTO costReqDTO = new CostReqDTO();
        costReqDTO.setInvestorType(InvestorTypeEnum.BESTPAY.getCode());//出资方,支付公司
//        costReqDTO.setInvestorType(InvestorTypeEnum.PROVINCE.getCode());//出资方,省公司
//        costReqDTO.setInvestorType(InvestorTypeEnum.MERCHANT.getCode());//出资方,商户
//        costReqDTO.setInvestorType(InvestorTypeEnum.GROUP.getCode());//出资方,集团公司
//        costReqDTO.setInvestorType(InvestorTypeEnum.DISTRICT.getCode());//出资方,地市公司
//        costReqDTO.setInvestorType(InvestorTypeEnum.THIRD_PARTY.getCode());//出资方,第三方公司
        costReqDTO.setInvestorName(InvestorTypeEnum.BESTPAY.getDesc());//出资方名称
//        costReqDTO.setInvestmentWay(InvestmentWayEnum.PROVINCE_PREPAYMENT.getCode());//出资方式,省公司预付
        costReqDTO.setInvestmentWay(InvestmentWayEnum.PAY_COMPANY_COST.getCode());//出资方式,支付公司成本
//        costReqDTO.setInvestmentWay(InvestmentWayEnum.THIRD_PARTY_PREPAYMENT.getCode());//出资方式,第三方预付(打款凭证)
//        costReqDTO.setInvestmentWay(InvestmentWayEnum.ONE_POINT_SETTLEMENT.getCode());//出资方式,一点结算
//        costReqDTO.setInvestmentWay(InvestmentWayEnum.BALANCE_SETTLEMENT.getCode());//出资方式,差额结算(台账)
//        costReqDTO.setInvestmentWay(InvestmentWayEnum.MERCHANT_PREPAYMENT.getCode());//出资方式,商户预付(台账)
        costReqDTO.setInvestmentWayName(InvestmentWayEnum.PAY_COMPANY_COST.getDesc());//出资方式名称
        costReqDTO.setCostCfgPercentage("100");//出资比例
        costReqDTO.setInvestmentOrgCode("3178002070268402");//出资机构编码 3178002070088068(台账)
        costReqDTO.setInvestmentOrgName("天翼电子商务有限公司");//出资机构名称
        costReqDTO.setInvestmentOrgAccount("7100843865112156");//出资账户编码 7102227752829156(台账)
        costReqDTO.setInvestmentOrgAccountName("天翼电子商务有限公司");//出资账户名称
        costReqDTO.setDueAmt(100000L);//应付金额
        costReqDTO.setRealPayAmt(100000L);//实付金额
        costReqDTO.setModifyRealPayAmt(0L);//变更实付金额
        costReqDTO.setAdvanceFlag(SwitchEnum.N.getCode());//是否垫资,不垫资
//        costReqDTO.setAdvanceFlag(SwitchEnum.Y.getCode());//是否垫资,垫资
        costReqDTOList.add(costReqDTO);
        applyCouponInfoReqDTO.setCostReqDTOList(costReqDTOList);//成本分摊申请列表

        /*applyCouponInfoReqDTO.setApplyUser("");//申请人
        applyCouponInfoReqDTO.setSettleType(SettleTypeEnum.LEDGER.getCode());//结算方式
        applyCouponInfoReqDTO.setApplyDepartment(ApplyDepartmentEnum.O2O.getOldCode());//所属部门
        applyCouponInfoReqDTO.setOwnMerchantFlag("");
        applyCouponInfoReqDTO.setApplyProvince("");
        applyCouponInfoReqDTO.setApplyCity("");
        applyCouponInfoReqDTO.setRequestNo("Req" + RandomStringNo());
        applyCouponInfoReqDTO.setRequestSystem("test");
        applyCouponInfoReqDTO.setRequestDate(new Date());
        applyCouponInfoReqDTO.setTraceLogId(TraceLogId());*/

        couponInfoApplyReqDTOList.add(applyCouponInfoReqDTO);
        applyCouponReqDTO.setCouponInfoApplyReqDTOList(couponInfoApplyReqDTOList);

        applyCouponReqDTO.setDistributeMsgType(MsgTemplateEnum.DEFAULT.getCode());//发券短信内容类型,默认短信模板
//        applyCouponReqDTO.setDistributeMsgType(MsgTemplateEnum.CUSTOM.getCode());//发券短信内容类型,自定义短信模板
//        applyCouponReqDTO.setDistributeMsgType(MsgTemplateEnum.NOSMS.getCode());//发券短信内容类型,不发送短信
//        applyCouponReqDTO.setDistributeTemplateId("");//短信模板id
        applyCouponReqDTO.setCustomContent("您可以登录翼支付APP查询返利");//自定义内容
        applyCouponReqDTO.setConsumeMsgType("NOSMS");//不发送短信
//        applyCouponReqDTO.setConsumeMsgType("DEFAULT");//默认短信
        applyCouponReqDTO.setNeedInvoice(SwitchEnum.N.getCode());//开票标识
        applyCouponReqDTO.setRebateType(RebateTypeEnum.FIXED.getCode());//返利类型
        applyCouponReqDTO.setRebateAmt(-1L);//返利金额
        applyCouponReqDTO.setInvitationNumber(1L);//每邀请人数
        applyCouponReqDTO.setInvitedNumber(10L);//最多邀请人数
        applyCouponReqDTO.setNeedMultiply("Y");//是否倍数返利
//        applyCouponReqDTO.setPercentage("");//折扣返利
//        applyCouponReqDTO.setRandomLevel("");//随机等级
//        applyCouponReqDTO.setMinSpendThreshold(1L);//最小消费金额
//        applyCouponReqDTO.setMaxSpendThreshold(0L);//最大消费金额
//        applyCouponReqDTO.setMinRebateAmt(0L);//最小返利金额
//        applyCouponReqDTO.setMaxRebateAmt(0L);//最大返利金额

        return applyCouponReqDTO;
    }

    //被推荐人规则DTO
    public static ApplyRecommendedRuleReqDTO getApplyRecommendedRuleReqDTO() {
        String str = sdf + "推荐人工具";

        ApplyRecommendedRuleReqDTO applyRecommendedRuleReqDTO = new ApplyRecommendedRuleReqDTO();
        applyRecommendedRuleReqDTO.setDataCheckMark(DataCheckMark.ADD.getCode());//数据变动标记,新增
//        applyRecommendedRuleReqDTO.setDataCheckMark(DataCheckMark.MODIFY.getCode());//数据变动标记,变更
//        applyRecommendedRuleReqDTO.setDataCheckMark(DataCheckMark.IGNORE.getCode());//数据变动标记,无需处理
        applyRecommendedRuleReqDTO.setRebateTriggerType(RebateTriggerTypeEnum.USER_CONSUME_REBATE.getCode());

        ApplyRecConsumeRebateRuleReqDTO applyRecConsumeRebateRuleReqDTO = new ApplyRecConsumeRebateRuleReqDTO();
        applyRecConsumeRebateRuleReqDTO.setMinSpendThreshold(1L);
        applyRecConsumeRebateRuleReqDTO.setConsumeDesc(str);

        //活动场景
        Set activitySceneSet = new HashSet();
        activitySceneSet.add(ActivitySceneEnum.POS.getCode());//POS消费
        activitySceneSet.add(ActivitySceneEnum.COLLECT_CODE.getCode());//收款码
        activitySceneSet.add(ActivitySceneEnum.PAY_CODE.getCode());//付款码
        applyRecConsumeRebateRuleReqDTO.setActivityScene(activitySceneSet);

        applyRecConsumeRebateRuleReqDTO.setCarrier(getApplyRecommendRuleReqDTO().getCarrier());
        applyRecConsumeRebateRuleReqDTO.setCustomerLevel(getApplyRecommendRuleReqDTO().getCustomerLevel());
        applyRecConsumeRebateRuleReqDTO.setUserDimension(getApplyRecommendRuleReqDTO().getUserDimension());
        applyRecConsumeRebateRuleReqDTO.setNeedBindCard(SwitchEnum.N.getCode());
//        applyRecConsumeRebateRuleReqDTO.setClmListNo("");
//        applyRecConsumeRebateRuleReqDTO.setClmListFlag(SwitchEnum.N.getCode());

        applyRecommendedRuleReqDTO.setApplyRecConsumeRebateRuleReqDTO(applyRecConsumeRebateRuleReqDTO);
        return applyRecommendedRuleReqDTO;
    }

    public static ApplyAttachmentReqDTO getApplyAttachmentReqDTO() {
        ApplyAttachmentReqDTO applyAttachmentReqDTO = new ApplyAttachmentReqDTO();
        applyAttachmentReqDTO.setDataCheckMark(DataCheckMark.ADD.getCode());//数据变动标记,新增
//        applyAttachmentReqDTO.setDataCheckMark(DataCheckMark.MODIFY.getCode());//数据变动标记,变更
//        applyAttachmentReqDTO.setDataCheckMark(DataCheckMark.IGNORE.getCode());//数据变动标记,无需处理

        //附件信息列表
        List<ApplyAttachmentInfoReqDTO> applyAttachmentInfoReqDTOList = new ArrayList();
        ApplyAttachmentInfoReqDTO applyAttachmentInfoReqDTO = new ApplyAttachmentInfoReqDTO();

        Set FileTypeSet = new HashSet();
//        FileTypeSet.add(FileTypeEnum.APPENDIX.getCode());
        FileTypeSet.add(FileTypeEnum.BACKGROUND_PICTURE.getCode());
        FileTypeSet.add(FileTypeEnum.BUTTON_PICTURE.getCode());
        FileTypeSet.add(FileTypeEnum.POSTER_PICTURE.getCode());
        applyAttachmentInfoReqDTO.setFileType(FileTypeSet.toString());//文件类型

        List<Long> fileIdList = new ArrayList<>();
        fileIdList.add(1L);
        applyAttachmentInfoReqDTO.setFileIdList(fileIdList);
        applyAttachmentInfoReqDTOList.add(applyAttachmentInfoReqDTO);
        applyAttachmentReqDTO.setApplyAttachmentInfoReqDTOList(applyAttachmentInfoReqDTOList);

        return applyAttachmentReqDTO;
    }
}
