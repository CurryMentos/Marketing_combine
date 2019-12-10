package Portal.equity.EquityApplyService;

import java.util.*;

import com.xx.dubbo.result.Result;
import com.xx.marketing.config.api.activity.models.request.*;
import com.xx.marketing.config.api.activity.models.response.EquityInfoAddResDTO;
import com.xx.marketing.config.api.enums.*;
import com.xx.marketing.config.api.equity.EquityApplyService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/6/18.
 * <p>
 * 浠ｉ噾鍒告柊澧?
 */
public class AddVoucher {
    @Test
    public static void Modify() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext( "classpath:applicationContext.xml" );
        EquityApplyService equityApplyService = (EquityApplyService) ac.getBean( "equityApplyService" );
        String var = UUID.randomUUID().toString();

         /*---------------------闂ㄥ簵淇℃伅-----------------------------*/
        List<StoreReqDTO> StoreReqDTOList = new ArrayList<>();
        StoreReqDTO storeReqDTO = new StoreReqDTO();
        storeReqDTO.setStoreId( "" );
        storeReqDTO.setStoreName( "" );
        /*---------------------鍟嗗搧淇℃伅-----------------------------*/
        List<GoodsReqDTO> GoodsReqDTOList = new ArrayList<>();
        GoodsReqDTO goodsReqDTO = new GoodsReqDTO();
        goodsReqDTO.setGoodsId( "" );
        goodsReqDTO.setGoodsName( "" );
        /*---------------------鍟嗘埛淇℃伅-----------------------------*/
        List<MerchantReqDTO> MerchantReqDTOList = new ArrayList();
        MerchantReqDTO merchantReqDTO = new MerchantReqDTO();
        merchantReqDTO.setMerchantId( "" );//鍟嗘埛鍙?
        merchantReqDTO.setMerchantName( "" );//鍟嗘埛鍚嶇О
        merchantReqDTO.setMerchantSource( "" );//鍟嗘埛鍑哄
        merchantReqDTO.setStoreReqDTOList( StoreReqDTOList );//闂ㄥ簵鍒楄〃
        merchantReqDTO.setGoodsReqDTOList( GoodsReqDTOList );//鍟嗗搧鍒楄〃

        /*------鎴愭湰鍒嗘憡鍒楄〃-------------*/
        List<CostReqDTO> costReqDTOList = new ArrayList();
        CostReqDTO costReqDTO = new CostReqDTO();
        //鍑鸿祫鏂? 鏋氫妇
        costReqDTO.setInvestorType( InvestorTypeEnum.xx.getCode() );
        costReqDTO.setInvestorName( "" );//鍑鸿祫鏂瑰悕绉?
        //鍑鸿祫鏂瑰紡 璇锋牴鎹渶瑕佽嚜琛岃皟鐢?
        costReqDTO.setInvestmentWay( InvestmentWayEnum.PAY_COMPANY_TEST.getCode() );
        costReqDTO.setInvestmentWayName( "" );//鍑鸿祫鏂瑰紡鍚嶇О
        costReqDTO.setCostCfgPercentage( "" );//鍑鸿祫姣斾緥
        costReqDTO.setInvestmentOrgCode( "" );//鍑鸿祫鏈烘瀯缂栫爜
        costReqDTO.setInvestmentOrgName( "" );//鍑鸿祫鏈烘瀯鍚嶇О
        costReqDTO.setInvestmentOrgAccount( "" );//鍑鸿祫璐︽埛缂栫爜
        costReqDTO.setInvestmentOrgAccountName( "" );//鍑鸿祫璐︽埛鍚嶇О
        costReqDTO.setDueAmt( 1L );//搴斾粯閲戦
        costReqDTO.setRealPayAmt( 1L );//瀹炰粯閲戦
        costReqDTO.setAdvanceFlag( SwitchEnum.Y.getCode() );//鏄惁鍨祫

        ApplyVoucherInfoReqDTO applyVoucherInfoReqDTO = new ApplyVoucherInfoReqDTO();
        applyVoucherInfoReqDTO.setEquityId( "" );//鏉冪泭缂栧彿
        applyVoucherInfoReqDTO.setEquityName( "" );//鏉冪泭鍚嶇О
        applyVoucherInfoReqDTO.setEquityDesc( "" );//鏉冪泭绠?浠?
        //鐢宠鐢ㄩ?? REBATE_RECHARGE-娲诲姩杩旀潈鐩?, BATCH_RECHARGE-鎵瑰厖鏉冪泭
        applyVoucherInfoReqDTO.setApplyUses( ApplyUsesEnum.BATCH_RECHARGE.getCode() );
        applyVoucherInfoReqDTO.setEquityCategory( CouponTypeEnum.COMMON.getCode() );//鍒哥被鍒?
        applyVoucherInfoReqDTO.setBusinessType( BusinessTypeEnum.PAY_BACK_CREDIT.getCode() );//涓氬姟绫诲瀷
        applyVoucherInfoReqDTO.setJumpApplication( "" );//璺宠浆搴旂敤
        //浣跨敤娓犻亾
        Set UseChannel = new HashSet<>();
        UseChannel.add( UseChannelEnum.ALL.getCode() );
        applyVoucherInfoReqDTO.setUseChannel( UseChannel );
        applyVoucherInfoReqDTO.setEffectType( EffectTypeEnum.ASSIGN.getCode() );//鐢熸晥鏂瑰紡
        applyVoucherInfoReqDTO.setEffectStartTime( new Date() );//鐢熸晥鏃堕棿
        applyVoucherInfoReqDTO.setEffectEndTime( new Date() );//澶辨晥鏃堕棿
        applyVoucherInfoReqDTO.setEffectInterval( 0 );//闂撮殧澶╂暟
        applyVoucherInfoReqDTO.setEffectCircle( 0 );//鐢熸晥鍛ㄦ湡
        applyVoucherInfoReqDTO.setEffectDateType( "" );//鐢熸晥鍛ㄦ湡绫诲瀷(鏃ユ湀鍛?)
        applyVoucherInfoReqDTO.setEffectDatePoint(new HashSet<>());//鐢熸晥鍛ㄦ湡鐐?
        applyVoucherInfoReqDTO.setDayStartTime( "" );//姣忓ぉ寮?濮嬫椂闂?
        applyVoucherInfoReqDTO.setDayEndTime( "" );//姣忓ぉ缁撴潫鏃堕棿
        applyVoucherInfoReqDTO.setDenominationType( DenominationTypeEnum.FIXED.getCode() );//闈㈠?肩被鍨?
        applyVoucherInfoReqDTO.setDenomination( 0L );//闈㈠??
        applyVoucherInfoReqDTO.setPercentage( "" );//鎶樻墸
        applyVoucherInfoReqDTO.setLowerLimit( 0L );//娑堣垂闄愰(鏈?灏?)
        applyVoucherInfoReqDTO.setUpperLimit( 0L );//娑堣垂闄愰(鏈?澶?)
        applyVoucherInfoReqDTO.setDistributeCount( 0L );//浜哄潎杩斿埜寮犳暟
         /*---------------------璐︽埛鏄熺骇-----------------------------*/
        Set CustomerLevelSet = new HashSet();
        CustomerLevelSet.add( CustomerLevelEnum.GUEST.getCode() );
        CustomerLevelSet.add( CustomerLevelEnum.TWO.getCode() );
        CustomerLevelSet.add( CustomerLevelEnum.THREE.getCode() );
        applyVoucherInfoReqDTO.setCustomerLevel( CustomerLevelSet );//璐︽埛鏄熺骇
        applyVoucherInfoReqDTO.setNeedBindCard( SwitchEnum.N.getCode() );//闄愬埗缁戝崱
        applyVoucherInfoReqDTO.setContext( "" );//浣跨敤瑙勫垯绠?杩?
        applyVoucherInfoReqDTO.setTms( "" );//绛炬姤鍙?
        applyVoucherInfoReqDTO.setTmsFinance( "" );//璐﹀姟鍥炲崟鍙?(omp鐢?)
        applyVoucherInfoReqDTO.setMerchantReqDTOList( MerchantReqDTOList );//鏉冪泭鍟嗘埛鍒楄〃(omp鐢?)
        applyVoucherInfoReqDTO.setCostReqDTOList( costReqDTOList );//鎴愭湰鍒嗘憡鐢宠鍒楄〃
        applyVoucherInfoReqDTO.setApplyUser( "" );//鐢宠浜?
        applyVoucherInfoReqDTO.setSettleType( "" );//缁撶畻鏂瑰紡
        applyVoucherInfoReqDTO.setApplyDepartment( "" );//鎵?灞為儴闂?
        applyVoucherInfoReqDTO.setRequestNo( "" );
        applyVoucherInfoReqDTO.setRequestSystem( "" );
        applyVoucherInfoReqDTO.setRequestDate( new Date() );
        applyVoucherInfoReqDTO.setTraceLogId( var );


        Result<EquityInfoAddResDTO> result = equityApplyService.addVoucher( applyVoucherInfoReqDTO );
        System.out.println( "鏄惁鎴愬姛:" + result.isSuccess() );
        System.out.println( "閿欒鐮?:" + result.getErrorCode() );
        System.out.println( "閿欒淇℃伅:" + result.getErrorMsg() );
        System.out.println( "閿欒鐮?:" + result.getPrimaryErrorCode() );
        System.out.println( "閿欒淇℃伅:" + result.getPrimaryErrorMsg() );
        System.out.println( "娴嬭瘯鏈嶅姟鍣?:" + result.getPrimaryErrorIP() );

        if (result.getResult() != null) {
            System.out.println( "*********************************" );
            System.out.println( "鏉冪泭缂栧彿" + result.getResult().getEquityId() );
            System.out.println( "鏉冪泭鍚嶇О" + result.getResult().getEquityName() );
            System.out.println( "闈㈠??" + result.getResult().getDenomination() );
            System.out.println( "浜哄潎杩斿埜寮犳暟" + result.getResult().getDistributeCount() );
            System.out.println( "鍒版湡鏃?" + result.getResult().getEffectEndTime() );

        }
    }
}
