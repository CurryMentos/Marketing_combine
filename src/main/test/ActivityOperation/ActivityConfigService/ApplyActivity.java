package ActivityOperation.ActivityConfigService;
import com.xx.marketing.activity.operation.api.models.response.TradeStatusResDTO;

import com.xx.dubbo.result.Result;
import com.xx.marketing.activity.operation.api.ActivityConfigService;
import com.xx.marketing.activity.operation.api.enums.*;
import com.xx.marketing.activity.operation.api.models.*;
import com.xx.marketing.activity.operation.api.models.request.ApplyActivityReqDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.*;

/**
 * @Author: nerissa
 * @Date: 2019/6/17 16:21
 * @Description: 立返活动配置接口(配置活动, 申请活动, 记录活动申请信息)
 */


public class ApplyActivity {
    @Test
    public static void applyActivityTest() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ActivityConfigService activityConfigService = (ActivityConfigService) ac.getBean("activityConfigService");

        String var = UUID.randomUUID().toString();
        ApplyActivityReqDTO applyActivityReqDTO = new ApplyActivityReqDTO();
        //请求流水
        applyActivityReqDTO.setRequestNo("");
        //请求系统
        applyActivityReqDTO.setRequestSystem("");
        //活动号
        applyActivityReqDTO.setActivityId("");
        //活动名称
        applyActivityReqDTO.setActivityName("");
        //活动类型("MINUS", "立减"), ("REBATE", "立返"), ("DIRECT", "直领");
        applyActivityReqDTO.setActivityType(ActivityTypeEnum.MINUS.getCode());
        //活动描述
        applyActivityReqDTO.setActivityDesc("");

        /*---------------------活动场景-----------------------------*/
        Set ActiveSceneSet = new HashSet();
        ActiveSceneSet.add(ActivitySceneEnum.PAY_CODE.getCode());//付款码
        ActiveSceneSet.add(ActivitySceneEnum.COLLECT_CODE.getCode());//收款码
        ActiveSceneSet.add(ActivitySceneEnum.POS.getCode());
        applyActivityReqDTO.setActiveScene(ActiveSceneSet);

        /*---------------------消费场景-----------------------------*/
        Set ExpandSceneSet = new HashSet();
        ExpandSceneSet.add("123");
        applyActivityReqDTO.setExpandScene(ExpandSceneSet);

        applyActivityReqDTO.setTotalCostAmt(100L);//总成本

        /*---------------------活动目的-----------------------------*/
        Set ActivityPurposeSet = new HashSet();
        ActivityPurposeSet.add(ActivityPurposeEnum.NEW_CUSTOMER.getCode());//用户拉新
        ActivityPurposeSet.add(ActivityPurposeEnum.INCREASE_ACTIVITY.getCode());//用户促活
        ActivityPurposeSet.add(ActivityPurposeEnum.INCREASE_INCOME.getCode());//拉动收入
        ActivityPurposeSet.add(ActivityPurposeEnum.NOTHING.getCode());//无
        applyActivityReqDTO.setActivityPurpose(ActivityPurposeSet);

        //活动开始、结束时间，每日开始、结束时间
        applyActivityReqDTO.setActivityStartDate("20190430235959");
        applyActivityReqDTO.setActivityEndDate("");
        applyActivityReqDTO.setDayStartTime("");
        applyActivityReqDTO.setDayEndTime("");

        //当返利区域范围为COUNTRY-全国时，省市可为空; PROVINCE、CITY
        applyActivityReqDTO.setAdaptAreaRange(AdaptAreaRangeEnum.COUNTRY.getCode());
        applyActivityReqDTO.setAdaptProvince("");
        applyActivityReqDTO.setAdaptCity("");
        //是否绑卡
        applyActivityReqDTO.setNeedBindCard(SwitchEnum.Y.getCode());

        /*---------------------运营商信息-----------------------------*/

        Set CarrierSet = new HashSet();
        CarrierSet.add(CarrierEnum.dx.getCode());
        CarrierSet.add(CarrierEnum.yd.getCode());
        CarrierSet.add(CarrierEnum.lt.getCode());
        applyActivityReqDTO.setCarrier(CarrierSet);

        /*---------------------账户星级-----------------------------*/

        Set CustomerLevelSet = new HashSet();
        CustomerLevelSet.add(CustomerLevelEnum.ONE.getCode());
        CustomerLevelSet.add(CustomerLevelEnum.TWO.getCode());
        CustomerLevelSet.add(CustomerLevelEnum.THREE.getCode());
        applyActivityReqDTO.setCustomerLevel(CustomerLevelSet);

        //活动周期 ("DAY", "每天"),("WEEK", "每周"),("MONTH", "每月");
        applyActivityReqDTO.setRebateDateType(RebateDateTypeEnum.DAY.getCode());

        /*---------------------活动周期点----------------------------*/

        Set RebateDatePointSet = new HashSet();
        RebateDatePointSet.add(1);
        applyActivityReqDTO.setRebateDatePoint(RebateDatePointSet);

        /*---------------------返利信息列表-----------------------------*/

        List<RebateDTO> RebateDTOList = new ArrayList<>();
        RebateDTO rebateDTO = new RebateDTO();
        //返利物品 CASH-返现金,VOUCHER-返代金券,COUPON-红包金,FLOW-流量,CARD-发卡
        rebateDTO.setRebateItem(RebateItemEnum.COUPON.getCode());
        // FIXED-固返,DISCOUNT-折扣,RANDOM-随机,GAMMARANDOM-gamma随机,
        // RANDOMFIXED-随机固定,SPECIFIED-指定权益
        rebateDTO.setRebateType(RebateTypeEnum.FIXED.getCode());//返利方式
        rebateDTO.setRebateItemNo("");//返利物品编号

        /*---------------------返利方式为指定权益-----------------------------*/

        //返利数量
        rebateDTO.setRebateItemCount(1L);
        rebateDTO.setMinSpendThreshold(1L);//最低消费金额
        rebateDTO.setMaxSpendThreshold(1L);//最高消费金额
        rebateDTO.setFixedDeductionAmt(1L);
        /*---------------------返利方式为固返-----------------------------*/

        //固返金额
        rebateDTO.setFixedDeductionAmt(1L);
        //是否翻倍
        rebateDTO.setNeedMultiply(SwitchEnum.Y.getCode());
    /*---------------------返利方式为折扣-----------------------------*/

        ////折扣比例
        rebateDTO.setPercentage("");
        /*---------------------返利方式为随机-----------------------------*/

        //随机等级 LOW-低,MIDDLE-中,HIGH-高
        rebateDTO.setRandomLevel(RandomLevelEnum.LOW.getCode());
        rebateDTO.setMaxRebateAmt(1L);//返利最大金额
        rebateDTO.setMinRebateAmt(1L);//返利最小金额
        applyActivityReqDTO.setRebateDTOList(RebateDTOList);

        /*---------------------活动限额信息-----------------------------*/

        LimitDTO limitDTO = new LimitDTO();
        limitDTO.setCycleNum(1L);//整个活动周期总返利名额
        limitDTO.setMonNum(1L);//整个活动周期月返利名额
        limitDTO.setDayNum(1L);//整个活动周期日返利名额
        limitDTO.setCycleAmt(1L);//整个活动周期总返利金额
        limitDTO.setMonAmt(1L);//整个活动周期月返利金额
        limitDTO.setDayAmt(1L);//整个活动周期日返利金额
        limitDTO.setProductNum(1L);//单用户活动期间返利最大笔数
        limitDTO.setProductMonNum(1L);//单用户活动期间月返利最大笔数
        limitDTO.setProductDayNum(1L);//单用户活动期间日返利最大笔数
        limitDTO.setProductAmt(1L);//单用户活动期间返利最大金额
        limitDTO.setProductMonAmt(1L);//单用户活动期间月返利最大金额
        limitDTO.setProductDayAmt(1L);//单用户活动期间日返利最大金额
        applyActivityReqDTO.setLimitDTO(limitDTO);

        /*---------------------活动成本信息-----------------------------*/

        List<CostDTO> CostDTOList = new ArrayList<>();
        CostDTO costDTO = new CostDTO();
        costDTO.setCostPtcptCode("");//出资方编码
        costDTO.setCostPtcptName("");//出资方名称
        costDTO.setCostTypeCode("");//出资方式编码
        costDTO.setCostTypeName("");//出资方式名称
        costDTO.setCostPercentage("");//出资比例
        costDTO.setCostMerchantId("");//出资商户号
        costDTO.setCostMerchantName("");//出资商户名称
        costDTO.setCostAccountCode("");//出资账户
        costDTO.setCostAccountName("");//出资账户名称
        costDTO.setActualCostAmt(1L);//实付金额
        applyActivityReqDTO.setCostDTOList(CostDTOList);

        /*---------------------门店信息-----------------------------*/

        List<StoreDTO> storeDTOS = new ArrayList<>();
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setStoreId("");
        storeDTO.setStoreName("");
        storeDTO.setStatus(StatusEnum.VALID.getCode());
        storeDTOS.add(storeDTO);

        /*---------------------商品信息-----------------------------*/

        List<GoodsDTO> goodsDTOS = new ArrayList<>();
        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setGoodsId("");
        goodsDTO.setGoodsName("");
        goodsDTO.setStatus(StatusEnum.VALID.getCode());
        goodsDTOS.add(goodsDTO);

        /*---------------------商户信息-----------------------------*/

        List<MerchantDTO> MerchantDTOList = new ArrayList<>();
        MerchantDTO merchantDTO = new MerchantDTO();
        merchantDTO.setMerchantId("");//商户号
        merchantDTO.setMerchantName("");//商户名称
        //0-场景商户;1-个账;2-网关;3-客户端;4-企管商户;5-商服商户
        merchantDTO.setMerchantSource("");//商户类型
        merchantDTO.setToolCode("");
        merchantDTO.setToolType("");
        merchantDTO.setStoreDTOS(storeDTOS);
        merchantDTO.setGoodsDTOS(goodsDTOS);
        //状态 VALID,INVALID,SUSPEND
        merchantDTO.setStatus(StatusEnum.VALID.getCode());
        applyActivityReqDTO.setMerchantDTOList(MerchantDTOList);

        /*---------------------用户维度-----------------------------*/

        Set UserDimensionSet = new HashSet();
        UserDimensionSet.add(UserDimensionEnum.CONTROL_NO.getCode());//设备号
        UserDimensionSet.add(UserDimensionEnum.ID_CARD.getCode());//身份证号
        UserDimensionSet.add(UserDimensionEnum.PRODUCT_NO.getCode());//手机号
        applyActivityReqDTO.setUserDimension(UserDimensionSet);

        /*---------------------发布渠道-----------------------------*/

        Set PublishChannelSet = new HashSet();
        PublishChannelSet.add(PublishChannelEnum.ALL.getCode());//所有投放渠道
        PublishChannelSet.add(PublishChannelEnum.NEARBY.getCode());//附近
        PublishChannelSet.add(PublishChannelEnum.PREFERENTIAL.getCode());//优惠
        PublishChannelSet.add(PublishChannelEnum.QDL_APP_QR_CODE.getCode());//钱到啦APP_二维码
        applyActivityReqDTO.setPublishChannel(PublishChannelSet);

        //是否开票
        applyActivityReqDTO.setNeedInvoice(SwitchEnum.Y.getCode());

        /*---------------------申请人信息-----------------------------*/

        applyActivityReqDTO.setApplyUser("");//申请人
        applyActivityReqDTO.setApplyProvince("");//申请人省份
        applyActivityReqDTO.setApplyCity("");//申请人地市
        //申请部门/事业群/子公司 跟运营要详细的
        applyActivityReqDTO.setApplyDepartment(ApplyDepartmentEnum.GJ.getCode());
        applyActivityReqDTO.setApplyEmail("");//申请人邮箱
        applyActivityReqDTO.setApplyPhone("");//申请人手机号
        //申请渠道 MIS、OMP、QDL_APP_H5
        applyActivityReqDTO.setApplyChannel(SourceEnum.MIS.getCode());
        applyActivityReqDTO.setMemo("");//备注
        applyActivityReqDTO.setTraceLogId(var);

        Result<TradeStatusResDTO> result = activityConfigService.applyActivity(applyActivityReqDTO);
        System.out.println("********************************");
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误描述:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
        System.out.println("响应错误码:" + result.getPrimaryErrorCode());
        System.out.println("响应错误信息:" + result.getPrimaryErrorMsg());
        System.out.println("响应机器IP:" + result.getPrimaryErrorIP());

        if (result.getResult() != null) {
            System.out.println("***********************************");
            System.out.println("活动号：" + result.getResult().getActivityId());
        }
    }
}
