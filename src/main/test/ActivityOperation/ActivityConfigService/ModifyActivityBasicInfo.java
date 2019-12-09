package ActivityOperation.ActivityConfigService;

import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.activity.operation.api.ActivityConfigService;
import com.bestpay.marketing.activity.operation.api.enums.*;
import com.bestpay.marketing.activity.operation.api.models.GoodsDTO;
import com.bestpay.marketing.activity.operation.api.models.MerchantDTO;
import com.bestpay.marketing.activity.operation.api.models.request.ModifyActivityBasicInfoReqDTO;
import com.bestpay.marketing.activity.operation.api.models.response.TradeStatusResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: nerissa
 * @Date: 2019/6/17 15:02
 * @Description:
 *
 * 活动基本信息变更
 * <p>
 * Status-状态 VALID-有效, INVALID-无效, SUSPEND-暂停,*/


public class ModifyActivityBasicInfo {
    @Test
    public static void modifyActivityBasicInfoTest() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext( "applicationContext.xml" );
        ActivityConfigService activityConfigService = (ActivityConfigService) ac.getBean( "activityConfigService" );

        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyyMMddHHmmssSSSSSS" );
        String Time = dateFormat.format( now );
        ModifyActivityBasicInfoReqDTO modifyActivityBasicInfoReqDTO = new ModifyActivityBasicInfoReqDTO();

        //活动号
        modifyActivityBasicInfoReqDTO.setActivityId( "" );
        //申请人
        modifyActivityBasicInfoReqDTO.setApplyUser( "" );
        //申请渠道
        modifyActivityBasicInfoReqDTO.setApplyChannel( "" );
        //请求流水
        modifyActivityBasicInfoReqDTO.setRequestNo( Time );
        //请求系统
        modifyActivityBasicInfoReqDTO.setRequestSystem( "" );
        //活动结束时间 yyyyMMddHHmmss
        modifyActivityBasicInfoReqDTO.setActivityEndDate( "" );
        //活动市
        modifyActivityBasicInfoReqDTO.setAdaptCity( "" );

        //活动场景
        Set ActivitySceneSet = new HashSet();
        ActivitySceneSet.add( ActivitySceneEnum.PAY_CODE.getCode() );//付款码
        ActivitySceneSet.add( ActivitySceneEnum.COLLECT_CODE.getCode() );//收款码
        ActivitySceneSet.add( ActivitySceneEnum.POS.getCode() );
        modifyActivityBasicInfoReqDTO.setActivityScene( ActivitySceneSet );

        //客户星级
        Set CustomerLevelSet = new HashSet();
        CustomerLevelSet.add( CustomerLevelEnum.ONE.getCode() );//游客
        CustomerLevelSet.add( CustomerLevelEnum.TWO.getCode() );//二级
        CustomerLevelSet.add( CustomerLevelEnum.THREE.getCode() );//三级
        modifyActivityBasicInfoReqDTO.setCustomerLevel( CustomerLevelSet );

        //用户维度
        Set UserDimensionSet = new HashSet();
        UserDimensionSet.add( UserDimensionEnum.PRODUCT_NO.getCode() );//手机号
        UserDimensionSet.add( UserDimensionEnum.ID_CARD.getCode() );//身份证号
        UserDimensionSet.add( UserDimensionEnum.CONTROL_NO.getCode() );//设备号
        modifyActivityBasicInfoReqDTO.setUserDimension( UserDimensionSet );

        //限制绑卡 Y、N
        modifyActivityBasicInfoReqDTO.setNeedBindCard( SwitchEnum.Y.getCode() );

/*---------------------商品信息-----------------------------*/

        List<GoodsDTO> goodsDTOS = new ArrayList<>();
        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setGoodsId( "" );//商品ID
        goodsDTO.setGoodsName( "" );//商品名称
        goodsDTO.setStatus( StatusEnum.VALID.getCode() );
        goodsDTOS.add( goodsDTO );
/*---------------------商户信息-----------------------------*/

        List<MerchantDTO> MerchantDTOList = new ArrayList<>();
        MerchantDTO merchantDTO = new MerchantDTO();
        merchantDTO.setMerchantId( "" );//商户号
        merchantDTO.setMerchantName( "" );//商户名称
        merchantDTO.setGoodsDTOS( goodsDTOS );//商品
        merchantDTO.setStatus( StatusEnum.VALID.getCode() );
        modifyActivityBasicInfoReqDTO.setMerchantDTOList( MerchantDTOList );

        Result<TradeStatusResDTO> result = activityConfigService.modifyActivityBasicInfo( modifyActivityBasicInfoReqDTO );
        System.out.println( "********************************" );
        System.out.println( "是否成功:" + result.isSuccess() );
        System.out.println( "错误码:" + result.getErrorCode() );
        System.out.println( "错误描述:" + result.getErrorMsg() );
        System.out.println( "结果集:" + result.getResult() );
        System.out.println( "响应错误码:" + result.getPrimaryErrorCode() );
        System.out.println( "响应错误信息:" + result.getPrimaryErrorMsg() );
        System.out.println( "响应机器IP:" + result.getPrimaryErrorIP() );

        if (result.getResult() != null) {
            System.out.println( "***********************************" );
            System.out.println( "活动号：" + result.getResult().getActivityId() );
        }
    }
}
