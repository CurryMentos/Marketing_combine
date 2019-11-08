package Portal.tools.ToolApplyService;//package tools.ToolApplyService;
//import com.xx.marketing.config.api.activity.models.request.ApplyCashReqDTO;
//import com.xx.marketing.config.api.activity.models.request.ApplyVoucherReqDTO;
//import com.xx.marketing.config.api.activity.models.request.ApplyCouponReqDTO;
//import com.google.common.collect.Lists;
//import java.util.Date;
//
//import com.xx.dubbo.result.Result;
//import com.xx.marketing.config.api.activity.models.request.*;
//import com.xx.marketing.config.api.enums.*;
//import com.xx.marketing.config.api.tools.ToolApplyService;
//import com.xx.marketing.config.api.tools.request.ApplyToolBasicInfoReqDTO;
//import com.xx.marketing.config.api.tools.request.ApplyToolConfigReqDTO;
//import com.google.common.collect.Sets;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.testng.annotations.Test;
//
//import java.text.SimpleDateFormat;
//import java.util.*;
//
///**
// * @Author: nerissa
// * @Date: 2019/6/18 17:05
// * @Description:
// *
// * 营销工具草稿保存提交接口
// */
//public class AddApplyTool {
//    @Test
//    public static void addApplyToolTest() throws Exception {
//        ApplicationContext ac = new ClassPathXmlApplicationContext( "classpath:applicationContext.xml" );
//        ToolApplyService toolApplyService = (ToolApplyService) ac.getBean( "toolApplyService" );
//
//        SimpleDateFormat sdf = new SimpleDateFormat( "yyyyMMddHHmmss" );
//        Date now = new Date();
//        String str = sdf.format( now );
//        SimpleDateFormat sdfCalendar = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
//        Date dBefore, dAfter;
//        Calendar BeforeCalendar = Calendar.getInstance();//得到日历
//        BeforeCalendar.add( Calendar.DAY_OF_MONTH, -2 );//设置为前XX天
//        dBefore = BeforeCalendar.getTime();
//        Calendar AfterCalendar = Calendar.getInstance();//得到日历
//        AfterCalendar.add( Calendar.DAY_OF_MONTH, +10 );//设置为后XX天
//        dAfter = AfterCalendar.getTime();
//        String var = UUID.randomUUID().toString();
//         /*---------------------门店信息-----------------------------*/
//        List<StoreReqDTO> StoreReqDTOList = new ArrayList<>();
//        StoreReqDTO storeReqDTO = new StoreReqDTO();
//        storeReqDTO.setStoreId( "" );
//        storeReqDTO.setStoreName( "" );
//        /*---------------------商品信息-----------------------------*/
//        List<GoodsReqDTO> GoodsReqDTOList = new ArrayList<>();
//        GoodsReqDTO goodsReqDTO = new GoodsReqDTO();
//        goodsReqDTO.setGoodsId( "" );
//        goodsReqDTO.setGoodsName( "" );
//        /*---------------------商户信息-----------------------------*/
//        List<MerchantReqDTO> MerchantReqDTOList = new ArrayList();
//        MerchantReqDTO merchantReqDTO = new MerchantReqDTO();
//        merchantReqDTO.setMerchantId( "" );//商户号
//        merchantReqDTO.setMerchantName( "" );//商户名称
//        merchantReqDTO.setMerchantSource( "" );//商户出处
//        merchantReqDTO.setStoreReqDTOList( StoreReqDTOList );//门店列表
//        merchantReqDTO.setGoodsReqDTOList( GoodsReqDTOList );//商品列表
//
//
//
//        ApplyToolConfigReqDTO applyToolConfigReqDTO = new ApplyToolConfigReqDTO();
//        applyToolConfigReqDTO.setApplyId( "" );//申请编号
//        //SAVE：保存，不用走工作流 SUBMIT：提交，要走工作流
//        applyToolConfigReqDTO.setActionType( ActionTypeEnum.SAVE.getCode() );//操作类型
//        applyToolConfigReqDTO.setApplyUser( "" );//申请人
//        applyToolConfigReqDTO.setApplyUserArea( "" );//申请人所属区域
//        // CASH_REDBAG MERCHANT_REDBAG
//        applyToolConfigReqDTO.setToolType( ToolTypeEnum.MERCHANT_REDBAG.getCode() );//工具类型
//        //MIS-综管台, OMP-自助平台, H5-前后端分离H5, QDL_APP_H5-钱到啦APP_H5
//        applyToolConfigReqDTO.setApplyChannel( ApplyChannelEnum.MIS.getCode() );//申请渠道
//        //LEDGER-台账, NO_LEDGER-非台账
//        applyToolConfigReqDTO.setSettleType( SettleTypeEnum.LEDGER.getCode() );//结算标识
//        applyToolConfigReqDTO.setToolId( "" );//工具编号
//
//        /*---------------------工具基本信息DTO-----------------------------*/
//        ApplyToolBasicInfoReqDTO applyToolBasicInfoReqDTO = new ApplyToolBasicInfoReqDTO();
//        applyToolBasicInfoReqDTO.setDataCheckMark( "" );//数据变动标记
//        applyToolBasicInfoReqDTO.setToolName( "" );//工具名称
//        applyToolBasicInfoReqDTO.setMerchantName( "" );//商户简称
//        applyToolBasicInfoReqDTO.setLandingPage( "" );//领取页面图片
//        applyToolBasicInfoReqDTO.setBlessing( "" );//领取页面祝福语
//        applyToolBasicInfoReqDTO.setActivityDesc( "" );//活动简介
//        applyToolBasicInfoReqDTO.setNeedInvoice( SwitchEnum.Y.getCode() );//是否开票
//        /*---------------------活动目的枚举-----------------------------*/
//        Set Purpose = new HashSet();
//        Purpose.add( ActivityPurposeEnum.CONTRACT_PAN_CHANNEL_CARD.getCode() );
//        Purpose.add( ActivityPurposeEnum.INCREASE_INCOME.getCode() );
//        Purpose.add( ActivityPurposeEnum.MARKETING_EQUITY_RED_ENVELOPE.getCode() );
//        applyToolBasicInfoReqDTO.setPurpose( Purpose );
//        applyToolBasicInfoReqDTO.setApplyEmail( "" );//申请人邮箱
//        applyToolBasicInfoReqDTO.setApplyPhone( "" );//申请人手机号
//        applyToolBasicInfoReqDTO.setApplyDepartment( "" );//所属事业群
//
//        /*----------------活动参与规则请求DTO-----------------------*/
//        ApplyActivityRuleReqDTO applyActivityRuleReqDTO = new ApplyActivityRuleReqDTO();
//        applyActivityRuleReqDTO.setDataCheckMark("");//数据变动标记
//        /*-----以下场景不全，自己再调用一下----------------活动场景-----------------------------*/
//        Set ActivitySceneSet = new HashSet();
//        ActivitySceneSet.add( ActivitySceneEnum.APPLETS_WITHHOLD.getCode() );
//        ActivitySceneSet.add( ActivitySceneEnum.BILL_PAYMENT.getCode() );
//        ActivitySceneSet.add( ActivitySceneEnum.BIND_CARD.getCode() );
//        ActivitySceneSet.add( ActivitySceneEnum.BUS_CARD_RECHARGE.getCode() );
//        ActivitySceneSet.add( ActivitySceneEnum.BUS_CODE_WITHHOLD.getCode() );
//        ActivitySceneSet.add( ActivitySceneEnum.CAMPUS_CARD_RECHARGE.getCode() );
//        ActivitySceneSet.add( ActivitySceneEnum.COLLECT_CODE.getCode() );
//        ActivitySceneSet.add( ActivitySceneEnum.OPEN_ACCOUNT.getCode() );
//        ActivitySceneSet.add( ActivitySceneEnum.DIDI_TAXI_WITHHOLD.getCode() );
//        ActivitySceneSet.add( ActivitySceneEnum.DIRECT_GET.getCode() );
//        ActivitySceneSet.add( ActivitySceneEnum.ELECTRON_CHANNEL.getCode() );
//        ActivitySceneSet.add( ActivitySceneEnum.ONLINE_MERCHANT_CONSUME.getCode() );
//        ActivitySceneSet.add( ActivitySceneEnum.ORANGE_STAGES.getCode() );
//        ActivitySceneSet.add( ActivitySceneEnum.OUTSIDE_BUSINESS_COUPON.getCode() );
//        ActivitySceneSet.add( ActivitySceneEnum.OUTSIDE_BUSINESS_MARKETING.getCode() );
//        ActivitySceneSet.add( ActivitySceneEnum.OUTSIDE_BUSINESS_RED_ENVELOPE_CARD.getCode() );
//        ActivitySceneSet.add( ActivitySceneEnum.OWN_BUSINESS_PAY_COMPANY.getCode() );
//        ActivitySceneSet.add( ActivitySceneEnum.PAY_BACK_CREDIT.getCode() );
//        ActivitySceneSet.add( ActivitySceneEnum.PAY_CODE.getCode() );
//        ActivitySceneSet.add( ActivitySceneEnum.PAYMENT_ASSISTANT_WITHHOLD.getCode() );
//        applyActivityRuleReqDTO.setActivityScene(ActivitySceneSet);
//        /*---------------------自有业务-外部交易类型列表-----------------------------*/
//        Set OwnProductCodeSet = new HashSet();
//        applyActivityRuleReqDTO.setOwnProductCode(OwnProductCodeSet);
//        applyActivityRuleReqDTO.setActivityStartDate(new Date());//活动开始时间(yyyyMMdd)
//        applyActivityRuleReqDTO.setActivityEndDate(new Date());//活动结束时间(yyyyMMdd)
//        //活动周期类型 每天、每周、每月
//        applyActivityRuleReqDTO.setActivityDateType(ActivityDateTypeEnum.DAY.getCode());
//        /*-返利时间点(返利周期为每日，不传；返利周期为每周，如：每周三，周日：传3、7；每月1号，2号：传1、2)-*/
//        Set ActivityDatePointSet = new HashSet();
//        applyActivityRuleReqDTO.setActivityDatePoint(ActivityDatePointSet);
//        applyActivityRuleReqDTO.setDayStartTime("");//每日开始时间 如：HHmmss
//        applyActivityRuleReqDTO.setDayEndTime("");//每日结束时间 如：HHmmss
//        //COUNTRY-全国范围, PROVINCE-省范围, CITY-地市范围
//        applyActivityRuleReqDTO.setAdaptAreaRange(AdaptAreaRangeEnum.COUNTRY.getCode());//活动适用地区
//        applyActivityRuleReqDTO.setAdaptProvince("");
//        /*---------------------活动城市-----------------------------*/
//        Set AdaptCitySet = new HashSet();
//        AdaptCitySet.add( 350100 | 350200 );
//        applyActivityRuleReqDTO.setAdaptCity( AdaptCitySet );
//        applyActivityRuleReqDTO.setDesignateBankCard(SwitchEnum.Y.getCode());//是否指定银行卡
//        /*-----------------银行code码--------------------*/
//        Set BankCodeSet = new HashSet();
//        BankCodeSet.add( 18594563262945f );
//        applyActivityRuleReqDTO.setBankCode( BankCodeSet );
//        /*----------活动适用用户(运营商)--------------*/
//        Set CarrierSet = new HashSet();
//        CarrierSet.add( CarrierEnum.DX.getCode() );
//        CarrierSet.add( CarrierEnum.LT.getCode() );
//        CarrierSet.add( CarrierEnum.YD.getCode() );
//        applyActivityRuleReqDTO.setCarrier( CarrierSet );
//         /*---------------------账户星级-----------------------------*/
//        Set CustomerLevelSet = new HashSet();
//        CustomerLevelSet.add( CustomerLevelEnum.GUEST.getCode() );
//        CustomerLevelSet.add( CustomerLevelEnum.TWO.getCode() );
//        CustomerLevelSet.add( CustomerLevelEnum.THREE.getCode() );
//        applyActivityRuleReqDTO.setCustomerLevel( CustomerLevelSet );
//        /*---------------------用户维度-----------------------------*/
//        Set UserDimensionSet = new HashSet();
//        UserDimensionSet.add( UserDimensionEnum.PRODUCT_NO.getCode() );//手机号
//        UserDimensionSet.add( UserDimensionEnum.ID_CARD.getCode() );//身份证号
//        UserDimensionSet.add( UserDimensionEnum.CONTROL_NO.getCode() );//设备号
//        applyActivityRuleReqDTO.setUserDimension( UserDimensionSet );
//        applyActivityRuleReqDTO.setNeedBindCard( SwitchEnum.Y.getCode() );//限制绑卡
//        /*---------------------用户名单-----------------------------*/
//        Set RosterTypeSet = new HashSet();
//        RosterTypeSet.add( RosterTypeEnum.ROSTER_TYPE_BLACK.getCode() );
//        applyActivityRuleReqDTO.setRosterType( RosterTypeSet );
//        applyActivityRuleReqDTO.setClmListNo("");//省名单编号
//        applyActivityRuleReqDTO.setClmListFlag(SwitchEnum.N.getCode());//省名单参与标识
//        applyActivityRuleReqDTO.setMerchantReqDTOList( MerchantReqDTOList );//活动参与商户列表(omp用)
//        applyActivityRuleReqDTO.setMarketPaidOrg("");//返利充值商户号(omp用)
//        Set UserRangeSet = new HashSet();
//        UserRangeSet.add( "" );
//        applyActivityRuleReqDTO.setUserRange( UserRangeSet );//领取用户范围
//        applyActivityRuleReqDTO.setBusinessCodeFlag( SwitchEnum.N.getCode() );//是否有业务码
//
//
//        /*---------------------活动限额规则请求DTO-----------------------------*/
//        ApplyLimitRuleReqDTO applyLimitRuleReqDTO = new ApplyLimitRuleReqDTO();
//        applyLimitRuleReqDTO.setDataCheckMark("");//数据变动标记
//        //DAY-日, WEEK-周, MONTH-月, CYCLE-周期
//        applyLimitRuleReqDTO.setLimitCycle(LimitCycleEnum.DAY.getCode());//限制周期
//        applyLimitRuleReqDTO.setUserDayLimitNum(0L);//用户日限制笔数
//        applyLimitRuleReqDTO.setActivityDayLimitNum(0L);//活动日限制笔数
//        applyLimitRuleReqDTO.setUserWeekLimitNum(0L);//用户周限制笔数
//        applyLimitRuleReqDTO.setActivityWeekLimitNum(0L);//活动周限制笔数
//        applyLimitRuleReqDTO.setUserMonthLimitNum(0L);//用户月限制笔数
//        applyLimitRuleReqDTO.setActivityMonthLimitNum(0L);//活动月限制笔数
//        applyLimitRuleReqDTO.setUserCycLimitNum(0L);//用户活动期间内限制笔数
//        applyLimitRuleReqDTO.setActivityCycLimitNum(0L);//活动期间内限制笔数
//        applyLimitRuleReqDTO.setUserDayLimitAmt(0L);//用户日限制金额
//        applyLimitRuleReqDTO.setActivityDayLimitAmt(0L);//活动日限制金额
//        applyLimitRuleReqDTO.setUserWeekLimitAmt(0L);//用户周限制金额
//        applyLimitRuleReqDTO.setActivityWeekLimitAmt(0L);//活动周限制金额
//        applyLimitRuleReqDTO.setUserMonthLimitAmt(0L);//用户月限制金额
//        applyLimitRuleReqDTO.setActivityMonthLimitAmt(0L);//活动月限制金额
//        applyLimitRuleReqDTO.setUserCycLimitAmt(0L);//用户活动期间内限制金额
//        applyLimitRuleReqDTO.setActivityCycLimitAmt(0L);//活动期间内限制金额
//
//
//        /*---------------------优惠规则请求DTO-----------------------------*/
//        ApplyPreferentialReqDTO applyPreferentialReqDTO = new ApplyPreferentialReqDTO();
//        applyPreferentialReqDTO.setDataCheckMark("");//数据变动标记
//        applyPreferentialReqDTO.setCashApplyReqDTO(new ApplyCashReqDTO());//
//        applyPreferentialReqDTO.setVoucherApplyReqDTO(new ApplyVoucherReqDTO());//代金券申请DTO
//        applyPreferentialReqDTO.setCouponApplyReqDTO(new ApplyCouponReqDTO());//红包金申请DTO
//
//
//
//        /*------------现金申请DTO---------------------*/
//        ApplyCashReqDTO applyCashReqDTO = new ApplyCashReqDTO();
//        applyCashReqDTO.setEquityId( "" );//权益编号
//        applyCashReqDTO.setEquityType( "" );//权益类型
//        applyCashReqDTO.setCostAmt( 1L );//总成本
//        applyCashReqDTO.setTms( "" );//签报号
//        applyCashReqDTO.setTmsFinance( "" );//账务回单号(omp)
//        /*------成本分摊列表-------------*/
//        List<CostReqDTO> costReqDTOList = new ArrayList();
//        CostReqDTO costReqDTO = new CostReqDTO();
//        //出资方 枚举
//        costReqDTO.setInvestorType( InvestorTypeEnum.PAYMENT_COMPANY.getCode() );
//        costReqDTO.setInvestorName( "" );//出资方名称
//        //出资方式 请根据需要自行调用
//        costReqDTO.setInvestmentWay( InvestmentWayEnum.PAY_COMPANY_TEST.getCode() );
//        costReqDTO.setInvestmentWayName( "" );//出资方式名称
//        costReqDTO.setCostCfgPercentage( "" );//出资比例
//        costReqDTO.setInvestmentOrgCode( "" );//出资机构编码
//        costReqDTO.setInvestmentOrgName( "" );//出资机构名称
//        costReqDTO.setInvestmentOrgAccount( "" );//出资账户编码
//        costReqDTO.setInvestmentOrgAccountName( "" );//出资账户名称
//        costReqDTO.setDueAmt( 1L );//应付金额
//        costReqDTO.setRealPayAmt( 1L );//实付金额
//        costReqDTO.setAdvanceFlag( SwitchEnum.Y.getCode() );//是否垫资
//        applyCashReqDTO.setCostReqDTOList( costReqDTOList );//成本分摊列表
//        applyCashReqDTO.setSettleType( "" );//结算类型
//        applyCashReqDTO.setApplyDepartment( "" );//所属部门
//        applyCashReqDTO.setNeedInvoice( SwitchEnum.N.getCode() );//是否开票
//
//
//
//        /*-----------代金券申请DTO---------------------*/
//        ApplyVoucherReqDTO applyVoucherReqDTO = new ApplyVoucherReqDTO();
//        //AMT-金额, NUM-名额, ALL-所有
//        applyVoucherReqDTO.setConfigCostType( ConfigCostTypeEnum.AMT.getCode() );//成本配置方式
//        applyVoucherReqDTO.setCostAmt( 0L );//总成本
//        applyVoucherReqDTO.setCostNum( 0L );//总名额
//
//        /*------权益明细列表----------*/
//        List<ApplyVoucherInfoReqDTO> voucherInfoApplyReqDTOList = new ArrayList();
//        ApplyVoucherInfoReqDTO applyVoucherInfoReqDTO = new ApplyVoucherInfoReqDTO();
//        applyVoucherInfoReqDTO.setApplyDepartment( "" );
//        applyVoucherInfoReqDTO.setEquityId( "" );//权益编号
//        applyVoucherInfoReqDTO.setEquityName( "" );//权益名称
//        applyVoucherInfoReqDTO.setEquityDesc( "" );//权益简介
//        //BATCH_RECHARGE-批充权益, REBATE_RECHARGE-活动返权益
//        applyVoucherInfoReqDTO.setApplyUses( ApplyUsesEnum.BATCH_RECHARGE.getCode() );//申请用途
//        //COMMON-通用券, PRODUCT_CODE-业务券, MERCHANT-商户联名券
//        applyVoucherInfoReqDTO.setEquityCategory( EquityCategoryEnum.COMMON.getCode() );//券类别
//        //业务类型 自行看枚举
//        applyVoucherInfoReqDTO.setBusinessType( BusinessTypeEnum.LOCAL_FLOW.getCode() );
//        applyVoucherInfoReqDTO.setJumpApplication( "" );//跳转应用
//        /*---有多个----使用渠道-----*/
//        Set UseChannel = new HashSet<>();
//        UseChannel.add( UseChannelEnum.ALL.getCode() );
//        applyVoucherInfoReqDTO.setUseChannel( UseChannel );//使用渠道
//        //ASSIGN-指定, CIRCLE-周期
//        applyVoucherInfoReqDTO.setEffectType( EffectTypeEnum.ASSIGN.getCode() );//生效方式
//        applyVoucherInfoReqDTO.setEffectStartTime( dBefore );//生效时间
//        applyVoucherInfoReqDTO.setEffectEndTime( dBefore );//失效时间
//        applyVoucherInfoReqDTO.setEffectInterval( 0 );//间隔天数
//        applyVoucherInfoReqDTO.setEffectCircle( 0 );//生效周期
//        applyVoucherInfoReqDTO.setEffectDateType( "" );//生效周期类型(日月周)
//        applyVoucherInfoReqDTO.setEffectDatePoint( "" );//生效周期点
//        applyVoucherInfoReqDTO.setDayStartTime( "" );//每天开始时间
//        applyVoucherInfoReqDTO.setDayEndTime( "" );//每天结束时间
//        //FIXED-固定面值, SPECIAL-指定面值, PERCENTAGE-折扣
//        applyVoucherInfoReqDTO.setDenominationType( DenominationTypeEnum.FIXED.getCode() );//面值类型
//        applyVoucherInfoReqDTO.setDenomination( 0L );//面值
//        applyVoucherInfoReqDTO.setPercentage( "" );//折扣
//        applyVoucherInfoReqDTO.setLowerLimit( 0L );//消费限额(最小)
//        applyVoucherInfoReqDTO.setUpperLimit( 0L );//消费限额(最大)
//        applyVoucherInfoReqDTO.setDistributeCount( 1L );//人均返券张数
//        applyVoucherInfoReqDTO.setCustomerLevel( CustomerLevelSet );//账户星级
//        applyVoucherInfoReqDTO.setNeedBindCard( SwitchEnum.N.getCode() );//限制绑卡
//        applyVoucherInfoReqDTO.setContext( "" );//使用规则简述
//        applyVoucherInfoReqDTO.setTms( "" );//签报号
//        applyVoucherInfoReqDTO.setTmsFinance( "" );//账务回单号
//        applyVoucherInfoReqDTO.setMerchantReqDTOList( MerchantReqDTOList );//权益商户列表(omp用)
//        applyVoucherInfoReqDTO.setCostReqDTOList( costReqDTOList );//成本分摊申请列表
//        applyVoucherInfoReqDTO.setApplyUser( "" );//申请人
//        applyVoucherInfoReqDTO.setSettleType( "" );//结算方式
//        applyVoucherInfoReqDTO.setApplyDepartment( "" );//所属部门
//        applyVoucherReqDTO.setVoucherInfoApplyReqDTOList( voucherInfoApplyReqDTOList );//权益明细列表
//        /*---------权益明细列表-----------*/
//        //DEFAULT-默认短信模板, CUSTOM-自定义短信模板, NOSMS-不发送短信
//        applyVoucherReqDTO.setDistributeMsgType( MsgTemplateEnum.CUSTOM.getCode() );//发券短信内容(类型)
//        applyVoucherReqDTO.setDistributeTemplateId( "" );//短信模板id
//        applyVoucherReqDTO.setConsumeMsgType( SwitchEnum.N.getCode() );//是否触发消费短信
//        applyVoucherReqDTO.setCustomContent( "" );//自定义内容
//        applyVoucherReqDTO.setNeedInvoice( SwitchEnum.Y.getCode() );//开票标识
//
//
//
//        /*-------------------红包金申请DTO--------------------------*/
//        ApplyCouponReqDTO applyCouponReqDTO = new ApplyCouponReqDTO();
//        //AMT-金额, NUM-名额, ALL-所有
//        applyCouponReqDTO.setConfigCostType( ConfigCostTypeEnum.AMT.getCode() );//成本配置方式
//        applyCouponReqDTO.setCostAmt(0L);//总成本
//        applyCouponReqDTO.setCostNum(0L);//总名额
//        /*---------权益明细列表-----------*/
//        List<ApplyCouponInfoReqDTO> couponInfoApplyReqDTOList = new ArrayList();
//        ApplyCouponInfoReqDTO applyCouponInfoReqDTO = new ApplyCouponInfoReqDTO();//
//        applyCouponInfoReqDTO.setEquityId( "" );//权益编号
//        //BATCH_RECHARGE-批充权益, REBATE_RECHARGE-活动返权益
//        applyCouponInfoReqDTO.setApplyUses( ApplyUsesEnum.BATCH_RECHARGE.getCode() );//申请用途
//        applyCouponInfoReqDTO.setEquityName("");//权益名称
//        //COMMON-通用券, PRODUCT_CODE-业务券, MERCHANT-商户联名券
//        applyCouponInfoReqDTO.setEquityCategory( EquityCategoryEnum.COMMON.getCode() );//券类别
//        applyCouponInfoReqDTO.setBusinessType(BusinessTypeEnum.LOCAL_FLOW.getCode());//业务类型
//        applyCouponInfoReqDTO.setEquityDesc("");//权益简介
//        applyCouponInfoReqDTO.setUseChannel(UseChannel);//使用渠道
//        applyCouponInfoReqDTO.setEffectType(EffectTypeEnum.ASSIGN.getCode());//生效方式
//        applyCouponInfoReqDTO.setEffectStartTime(new Date());//生效时间
//        applyCouponInfoReqDTO.setEffectEndTime(new Date());//失效时间
//        applyCouponInfoReqDTO.setEffectInterval(0);//间隔天数
//        applyCouponInfoReqDTO.setEffectCircle(0);//生效周期
//        applyCouponInfoReqDTO.setEffectDateType("");//生效周期类型(日月周)
//        applyCouponInfoReqDTO.setEffectDatePoint("");//生效周期点
//        applyCouponInfoReqDTO.setDayStartTime("");//每天开始时间
//        applyCouponInfoReqDTO.setDayEndTime("");//每天结束时间
//        //FIXED-固定面值, SPECIAL-指定面值, PERCENTAGE-折扣
//        applyCouponInfoReqDTO.setDenominationType( DenominationTypeEnum.FIXED.getCode() );//面值类型
//        applyCouponInfoReqDTO.setDenomination(0L);//面值
//        applyCouponInfoReqDTO.setMinDenomination(0L);//单张最小面额
//        applyCouponInfoReqDTO.setMaxDenomination(0L);//单张最大面额
//        applyCouponInfoReqDTO.setLowerLimit(0L);//消费限额(最小)/门槛
//        applyCouponInfoReqDTO.setDistributeCount(0L);//人均返券张数
//        applyCouponInfoReqDTO.setCustomerLevel(CustomerLevelSet);//账户星级
//        applyCouponInfoReqDTO.setNeedBindCard(SwitchEnum.N.getCode());//限制绑卡
//        applyCouponInfoReqDTO.setContext("");//使用规则简述
//        applyCouponInfoReqDTO.setTms("");//签报号
//        applyCouponInfoReqDTO.setTmsFinance("");//账务回单号(omp用)
//        applyCouponInfoReqDTO.setMerchantReqDTOList(MerchantReqDTOList);//权益商户列表(omp用)
//        applyCouponInfoReqDTO.setCostReqDTOList(costReqDTOList);//成本分摊申请列表
//        applyCouponInfoReqDTO.setApplyUser("");//申请人
//        applyCouponInfoReqDTO.setSettleType("");//结算方式
//        applyCouponInfoReqDTO.setApplyDepartment("");//所属部门
//        applyCouponInfoReqDTO.setRequestNo("");
//        applyCouponInfoReqDTO.setRequestSystem("");
//        applyCouponInfoReqDTO.setRequestDate(new Date());
//        applyCouponInfoReqDTO.setTraceLogId("");
//        /*---------权益明细列表-----------*/
//        applyCouponReqDTO.setDistributeMsgType(MsgTemplateEnum.CUSTOM.getCode());//发券短信内容(类型)
//        applyCouponReqDTO.setDistributeTemplateId("");//短信模板id
//        applyCouponReqDTO.setConsumeMsgType(SwitchEnum.N.getCode());//是否触发消费短信
//        applyCouponReqDTO.setCustomContent("");//自定义内容
//        applyCouponReqDTO.setNeedInvoice("");//开票标识
//        applyCouponReqDTO.setRebateType("");
//        applyCouponReqDTO.setRebateAmt(0L);
//        applyCouponReqDTO.setMultiply(0);
//        applyCouponReqDTO.setPercentage("");
//        applyCouponReqDTO.setRandomLevel("");
//        applyCouponReqDTO.setMinSpendThreshold(0L);
//        applyCouponReqDTO.setMaxSpendThreshold(0L);
//        applyCouponReqDTO.setMinRebateAmt(0L);
//        applyCouponReqDTO.setMaxRebateAmt(0L);
//        applyCouponReqDTO.setRequestNo("");
//        applyCouponReqDTO.setRequestSystem("");
//        applyCouponReqDTO.setRequestDate(new Date());
//        applyCouponReqDTO.setTraceLogId("");
//
//
//        /*-------------------红包铺子展示信息DTO--------------------------*/
//        ApplyActivityShowReqDTO applyActivityShowReqDTO = new ApplyActivityShowReqDTO();
//        applyActivityShowReqDTO.setDataCheckMark("");//数据变动标记
//        applyActivityShowReqDTO.setShowName("");//红包铺子展示名称
//        applyActivityShowReqDTO.setMerchantName("");//商户名称
//        applyActivityShowReqDTO.setProvince("");//活动商户地区-省份
//        applyActivityShowReqDTO.setCity(Sets.newHashSet());//活动商户地区-城市
//        applyActivityShowReqDTO.setContext("");//规则
//        applyActivityShowReqDTO.setProtocolId("");//协议ID
//        applyActivityShowReqDTO.setProtocolType("");//协议类型
//        applyActivityShowReqDTO.setToUrl("");//URL活动跳转
//        applyActivityShowReqDTO.setRuleGroupNo("");//规则组编号
//        applyActivityShowReqDTO.setOptionalMerchant("");//可用商户
//        applyActivityShowReqDTO.setActivityAbbreviation("");//活动简称
//        applyActivityShowReqDTO.setActivityType("");//活动类型
//        applyActivityShowReqDTO.setShowPicAddress("");//展示图片地址
//        applyActivityShowReqDTO.setMenuCategory("");//分类菜单
//        applyActivityShowReqDTO.setActivityPicAddress("");//活动图片地址(大图)
//
//
//        /*-------------------附件列表--------------------------*/
//        ApplyAttachmentReqDTO applyAttachmentReqDTO = new ApplyAttachmentReqDTO();
//        applyAttachmentReqDTO.setDataCheckMark("");//数据变动标记
//        /*---------附件信息列表-----------*/
//        List<ApplyAttachmentInfoReqDTO> applyAttachmentInfoReqDTOList = new ArrayList();
//        ApplyAttachmentInfoReqDTO attachmentInfoReqDTO = new ApplyAttachmentInfoReqDTO();
//        attachmentInfoReqDTO.setFileType("");//文件类型
//        attachmentInfoReqDTO.setFileId(0L);//文件ID
//        applyAttachmentReqDTO.setApplyAttachmentInfoReqDTOList(applyAttachmentInfoReqDTOList);//附件信息列表
//
//
//        Result<String> result = toolApplyService.addApplyTool( applyToolConfigReqDTO );
//        System.out.println( "****************************************" );
//        System.out.println( "是否成功:" + result.isSuccess() );
//        System.out.println( "错误码:" + result.getErrorCode() );
//        System.out.println( "错误描述:" + result.getErrorMsg() );
//        System.out.println( "结果集:" + result.getResult() );
//        System.out.println( "响应错误码:" + result.getPrimaryErrorCode() );
//        System.out.println( "响应错误信息:" + result.getPrimaryErrorMsg() );
//        System.out.println( "响应机器IP:" + result.getPrimaryErrorIP() );
//
//
//    }
//}
//
//
//
//
