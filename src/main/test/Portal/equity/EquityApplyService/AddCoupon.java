package Portal.equity.EquityApplyService;

import com.xx.dubbo.result.Result;
import com.xx.marketing.config.api.activity.models.request.*;
import com.xx.marketing.config.api.activity.models.response.EquityInfoAddResDTO;
import com.xx.marketing.config.api.enums.*;
import com.google.common.collect.Lists;

import java.util.*;

import com.google.common.collect.Sets;

import com.xx.marketing.config.api.equity.EquityApplyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by gaowenpei on 2019/6/19.
 * <p>
 * 新增红包金
 * <p>
 * 枚举值请自行补充
 */

public class AddCoupon {
    @Test
    public static void removeVoucher() throws Exception {

        ApplicationContext ac = new ClassPathXmlApplicationContext( "classpath:applicationContext.xml" );
        EquityApplyService equityApplyService = (EquityApplyService) ac.getBean( "equityApplyService" );
        String var = UUID.randomUUID().toString();
         /*---------------------门店信息-----------------------------*/
        List<StoreReqDTO> StoreReqDTOList = new ArrayList<>();
        StoreReqDTO storeReqDTO = new StoreReqDTO();
        storeReqDTO.setStoreId( "" );
        storeReqDTO.setStoreName( "" );
        /*---------------------商品信息-----------------------------*/
        List<GoodsReqDTO> GoodsReqDTOList = new ArrayList<>();
        GoodsReqDTO goodsReqDTO = new GoodsReqDTO();
        goodsReqDTO.setGoodsId( "" );
        goodsReqDTO.setGoodsName( "" );
        /*---------------------商户信息-----------------------------*/
        List<MerchantReqDTO> MerchantReqDTOList = new ArrayList();
        MerchantReqDTO merchantReqDTO = new MerchantReqDTO();
        merchantReqDTO.setMerchantId( "" );//商户号
        merchantReqDTO.setMerchantName( "" );//商户名称
        merchantReqDTO.setMerchantSource( "" );//商户出处
        merchantReqDTO.setStoreReqDTOList( StoreReqDTOList );//门店列表
        merchantReqDTO.setGoodsReqDTOList( GoodsReqDTOList );//商品列表

        /*------成本分摊列表-------------*/
        List<CostReqDTO> costReqDTOList = new ArrayList();
        CostReqDTO costReqDTO = new CostReqDTO();
        //出资方 枚举
        costReqDTO.setInvestorType(InvestorTypeEnum.xx.getCode() );
        costReqDTO.setInvestorName( "" );//出资方名称
        //出资方式 请根据需要自行调用
        costReqDTO.setInvestmentWay( InvestmentWayEnum.PAY_COMPANY_TEST.getCode() );
        costReqDTO.setInvestmentWayName( "" );//出资方式名称
        costReqDTO.setCostCfgPercentage( "" );//出资比例
        costReqDTO.setInvestmentOrgCode( "" );//出资机构编码
        costReqDTO.setInvestmentOrgName( "" );//出资机构名称
        costReqDTO.setInvestmentOrgAccount( "" );//出资账户编码
        costReqDTO.setInvestmentOrgAccountName( "" );//出资账户名称
        costReqDTO.setDueAmt( 1L );//应付金额
        costReqDTO.setRealPayAmt( 1L );//实付金额
        costReqDTO.setAdvanceFlag( SwitchEnum.Y.getCode() );//是否垫资


        ApplyCouponInfoReqDTO applyCouponInfoReqDTO = new ApplyCouponInfoReqDTO();
        applyCouponInfoReqDTO.setEquityId( "" );//权益编号
        //申请用途 REBATE_RECHARGE-活动返权益, BATCH_RECHARGE-批充权益
        applyCouponInfoReqDTO.setApplyUses( ApplyUsesEnum.BATCH_RECHARGE.getCode() );
        applyCouponInfoReqDTO.setEquityName( "" );//权益名称
        applyCouponInfoReqDTO.setEquityCategory( CouponTypeEnum.COMMON.getCode() );//券类别
        applyCouponInfoReqDTO.setBusinessType( BusinessTypeEnum.PAY_BACK_CREDIT.getCode() );//业务类型
        applyCouponInfoReqDTO.setEquityDesc( "" );//权益简介
        //使用渠道
        Set UseChannel = new HashSet<>();
        UseChannel.add( UseChannelEnum.ALL.getCode() );
        applyCouponInfoReqDTO.setUseChannel( UseChannel );
        applyCouponInfoReqDTO.setEffectType( EffectTypeEnum.ASSIGN.getCode() );//生效方式
        applyCouponInfoReqDTO.setEffectStartTime( new Date() );//生效时间
        applyCouponInfoReqDTO.setEffectEndTime( new Date() );//失效时间
        applyCouponInfoReqDTO.setEffectInterval( 0 );//间隔天数
        applyCouponInfoReqDTO.setEffectCircle( 0 );//生效周期
        applyCouponInfoReqDTO.setEffectDateType( "" );//生效周期类型(日月周)
        applyCouponInfoReqDTO.setEffectDatePoint(new HashSet<>());//生效周期点
        applyCouponInfoReqDTO.setDayStartTime( "" );//每天开始时间
        applyCouponInfoReqDTO.setDayEndTime( "" );//每天结束时间
        applyCouponInfoReqDTO.setDenominationType( DenominationTypeEnum.FIXED.getCode() );//面值类型
        applyCouponInfoReqDTO.setDenomination( 0L );//面值
        applyCouponInfoReqDTO.setMinDenomination( 0L );//单张最小面额
        applyCouponInfoReqDTO.setMaxDenomination( 0L );//单张最大面额
        applyCouponInfoReqDTO.setLowerLimit( 0L );//消费限额(最小)/门槛
        applyCouponInfoReqDTO.setDistributeCount( 0L );//人均返券张数
         /*---------------------账户星级-----------------------------*/
        Set CustomerLevelSet = new HashSet();
        CustomerLevelSet.add( CustomerLevelEnum.GUEST.getCode() );
        CustomerLevelSet.add( CustomerLevelEnum.TWO.getCode() );
        CustomerLevelSet.add( CustomerLevelEnum.THREE.getCode() );
        applyCouponInfoReqDTO.setCustomerLevel( CustomerLevelSet );//账户星级
        applyCouponInfoReqDTO.setNeedBindCard( SwitchEnum.N.getCode() );//限制绑卡
        applyCouponInfoReqDTO.setContext( "" );//使用规则简述
        applyCouponInfoReqDTO.setTms( "" );//签报号
        applyCouponInfoReqDTO.setTmsFinance( "" );//账务回单号(omp用)
        applyCouponInfoReqDTO.setMerchantReqDTOList( MerchantReqDTOList );//权益商户列表(omp用)
        applyCouponInfoReqDTO.setCostReqDTOList( costReqDTOList );//成本分摊申请列表
        applyCouponInfoReqDTO.setApplyUser( "" );//申请人
        applyCouponInfoReqDTO.setSettleType( "" );//结算方式
        applyCouponInfoReqDTO.setApplyDepartment( "" );//所属部门
        applyCouponInfoReqDTO.setRequestNo( "" );
        applyCouponInfoReqDTO.setRequestSystem( "" );
        applyCouponInfoReqDTO.setRequestDate( new Date() );
        applyCouponInfoReqDTO.setTraceLogId( var );

        Result<EquityInfoAddResDTO> result = equityApplyService.addCoupon( applyCouponInfoReqDTO );
        System.out.println( "是否成功:" + result.isSuccess() );
        System.out.println( "错误码:" + result.getErrorCode() );
        System.out.println( "错误信息:" + result.getErrorMsg() );
        System.out.println( "错误码:" + result.getPrimaryErrorCode() );
        System.out.println( "错误信息:" + result.getPrimaryErrorMsg() );
        System.out.println( "测试服务器:" + result.getPrimaryErrorIP() );

        if (result.getResult() != null) {
            System.out.println( "*********************************" );
            System.out.println( "权益编号" + result.getResult().getEquityId() );
            System.out.println( "权益名称" + result.getResult().getEquityName() );
            System.out.println( "面值" + result.getResult().getDenomination() );
            System.out.println( "人均返券张数" + result.getResult().getDistributeCount() );
            System.out.println( "到期日" + result.getResult().getEffectEndTime() );

        }
    }
}
