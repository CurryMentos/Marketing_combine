package ActivityOperation.ActivityConfigService;

import Customize.DataGenerate;
import Customize.UserList;
import com.alibaba.fastjson.JSON;
import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.activity.operation.api.ActivityConfigService;
import com.bestpay.marketing.activity.operation.api.enums.*;
import com.bestpay.marketing.activity.operation.api.enums.ActivityPurposeEnum;
import com.bestpay.marketing.activity.operation.api.enums.ActivitySceneEnum;
import com.bestpay.marketing.activity.operation.api.enums.ActivityTypeEnum;
import com.bestpay.marketing.activity.operation.api.enums.AdaptAreaRangeEnum;
import com.bestpay.marketing.activity.operation.api.enums.CarrierEnum;
import com.bestpay.marketing.activity.operation.api.enums.CustomerLevelEnum;
import com.bestpay.marketing.activity.operation.api.enums.PublishChannelEnum;
import com.bestpay.marketing.activity.operation.api.enums.RebateDateTypeEnum;
import com.bestpay.marketing.activity.operation.api.enums.RebateTypeEnum;
import com.bestpay.marketing.activity.operation.api.enums.SwitchEnum;
import com.bestpay.marketing.activity.operation.api.enums.UserDimensionEnum;
import com.bestpay.marketing.activity.operation.api.models.*;
import com.bestpay.marketing.activity.operation.api.models.request.AddActivityReqDTO;
import com.bestpay.marketing.activity.operation.api.models.response.AddActivityResDTO;
import com.bestpay.marketing.config.api.enums.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.*;

/**
 * @Author: nerissa
 * @Date: 2019/6/3 12:34
 * @Description:
 */
public class AddActivity extends DataGenerate {
    @Test
    public static void addActivityTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ActivityConfigService activityConfigService = (ActivityConfigService) ac.getBean("activityConfigService");

        String var = UUID.randomUUID().toString();

        AddActivityReqDTO addActivityReqDTO = new AddActivityReqDTO();
        addActivityReqDTO.setRequestNo("Req" + RandomStringNo());//
        addActivityReqDTO.setRequestSystem("test");//请求系统
        addActivityReqDTO.setActivityType(ActivityTypeEnum.REBATE.getCode());//活动类型("MINUS", "立减"), ("REBATE", "立返"), ("DIRECT", "直领");
        addActivityReqDTO.setActivityName(ActivityTypeEnum.REBATE.getDesc() + addActivityReqDTO.getRequestNo());//活动名称
        addActivityReqDTO.setActivityDesc("");

        /*---------------------活动场景-----------------------------*/
        Set ActiveSceneSet = new HashSet();
        ActiveSceneSet.add(ActivitySceneEnum.POS.getCode());
        addActivityReqDTO.setActiveScene(ActiveSceneSet);
        addActivityReqDTO.setTotalCostAmt(100L);//总成本

        /*---------------------活动目的-----------------------------*/
        Set PurposeSet = new HashSet();
        PurposeSet.add(ActivityPurposeEnum.NOTHING.getCode());
        addActivityReqDTO.setPurpose(PurposeSet);

        addActivityReqDTO.setActivityStartDate(ActivityStart);
        addActivityReqDTO.setActivityEndDate(ActivityEnd);
        addActivityReqDTO.setDayStartTime(DayStart);
        addActivityReqDTO.setDayEndTime(DayEnd);
        addActivityReqDTO.setAdaptAreaRange(AdaptAreaRangeEnum.COUNTRY.getCode());
//        addActivityReqDTO.setAdaptProvince("");
//        addActivityReqDTO.setAdaptCity("");
        addActivityReqDTO.setNeedBindCard(SwitchEnum.N.getCode());//是否绑卡

        /*---------------------运营商信息-----------------------------*/
        Set CarrierSet = new HashSet();
        CarrierSet.add(CarrierEnum.dx.getCode());
        CarrierSet.add(CarrierEnum.yd.getCode());
        CarrierSet.add(CarrierEnum.lt.getCode());
        addActivityReqDTO.setCarrier(CarrierSet);

        /*---------------------账户星级-----------------------------*/
        Set CustomerLevelSet = new HashSet();
        CustomerLevelSet.add(CustomerLevelEnum.ONE.getCode());
        CustomerLevelSet.add(CustomerLevelEnum.TWO.getCode());
        CustomerLevelSet.add(CustomerLevelEnum.THREE.getCode());
        addActivityReqDTO.setCustomerLevel(CustomerLevelSet);

        //活动周期 ("DAY", "每天"),("WEEK", "每周"),("MONTH", "每月");
        addActivityReqDTO.setRebateDateType(RebateDateTypeEnum.DAY.getCode());

        /*---------------------活动周期点-----------------------------*/
        Set RebateDatePointSet = new HashSet();
//        addActivityReqDTO.setRebateDatePoint(RebateDatePointSet);

        /*---------------------返利规则-----------------------------*/
        List<RebateDTO> RebateDTOList = new ArrayList<>();
        RebateDTO rebateDTO = new RebateDTO();
        rebateDTO.setRebateItem(RebateItemEnum.CASH.getCode());
        rebateDTO.setRebateType(RebateTypeEnum.FIXED.getCode());
        rebateDTO.setRebateItemNo("RI" + RandomStringNo());
        rebateDTO.setRebateItemCount(1L);
        rebateDTO.setMinSpendThreshold(1L);
        rebateDTO.setMaxSpendThreshold(1000L);
        rebateDTO.setFixedDeductionAmt(1L);
        rebateDTO.setNeedMultiply(SwitchEnum.N.getCode());
//        rebateDTO.setPercentage("");
//        rebateDTO.setRandomLevel("");
//        rebateDTO.setMaxRebateAmt(1L);
//        rebateDTO.setMinRebateAmt(1L);
        RebateDTOList.add(rebateDTO);
        addActivityReqDTO.setRebateDTOList(RebateDTOList);

        /*---------------------活动限额信息-----------------------------*/
        LimitDTO limitDTO = new LimitDTO();
        limitDTO.setCycleNum(-1L);
        limitDTO.setMonNum(-1L);
        limitDTO.setDayNum(-1L);
        limitDTO.setCycleAmt(-1L);
        limitDTO.setMonAmt(-1L);
        limitDTO.setDayAmt(-1L);
        limitDTO.setProductNum(-1L);
        limitDTO.setProductMonNum(-1L);
        limitDTO.setProductDayNum(-1L);
        limitDTO.setProductAmt(-1L);
        limitDTO.setProductMonAmt(-1L);
        limitDTO.setProductDayAmt(-1L);
        addActivityReqDTO.setLimitDTO(limitDTO);

        /*---------------------成本分摊信息-----------------------------*/
        List<CostDTO> CostDTOList = new ArrayList<>();
        CostDTO costDTO = new CostDTO();
        costDTO.setCostPtcptCode(CostPtcptEnum.PAYMENT_COMPANY.getCode());
        costDTO.setCostPtcptName(CostPtcptEnum.PAYMENT_COMPANY.getDesc());
//        costDTO.setCostTypeCode("");
//        costDTO.setCostTypeName("");
        costDTO.setCostPercentage("100");
        costDTO.setCostMerchantId("3178002076347019");
        costDTO.setCostMerchantName("天翼电子商务有限公司（台账）");
        costDTO.setCostAccountCode("7100848511511156");
        costDTO.setCostAccountName("天翼电子商务有限公司（台账）");
        costDTO.setActualCostAmt(100000L);
        addActivityReqDTO.setCostDTOList(CostDTOList);

         /*---------------------门店信息-----------------------------*/
        List<StoreDTO> storeDTOS = new ArrayList<>();
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setStatus("");
        storeDTO.setStoreId("");
        storeDTO.setStoreName("");
        storeDTOS.add(storeDTO);

        /*---------------------商品信息-----------------------------*/
        List<GoodsDTO> goodsDTOS = new ArrayList<>();
        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setGoodsId("");
        goodsDTO.setGoodsName("");
        goodsDTO.setStatus("");
        goodsDTOS.add(goodsDTO);

        /*---------------------商户信息-----------------------------*/
        List<MerchantDTO> MerchantDTOList = new ArrayList<>();
        MerchantDTO merchantDTO = new MerchantDTO();
        merchantDTO.setMerchantId("");
        merchantDTO.setMerchantName("");
//        merchantDTO.setStoreDTOS(storeDTOS);
//        merchantDTO.setGoodsDTOS(goodsDTOS);
        merchantDTO.setStatus("");
        addActivityReqDTO.setMerchantDTOList(MerchantDTOList);

        /*---------------------用户维度-----------------------------*/
        Set UserDimensionSet = new HashSet();
        UserDimensionSet.add(UserDimensionEnum.CONTROL_NO.getCode());
        UserDimensionSet.add(UserDimensionEnum.ID_CARD.getCode());
        UserDimensionSet.add(UserDimensionEnum.PRODUCT_NO.getCode());
        addActivityReqDTO.setUserDimension(UserDimensionSet);

        /*---------------------投放渠道-----------------------------*/
        Set PublishChannelSet = new HashSet();
        PublishChannelSet.add(PublishChannelEnum.NEARBY.getCode());
        PublishChannelSet.add(PublishChannelEnum.PREFERENTIAL.getCode());
        PublishChannelSet.add(PublishChannelEnum.QDL_APP_QR_CODE.getCode());
        PublishChannelSet.add(PublishChannelEnum.ALL.getCode());
        addActivityReqDTO.setPublishChannel(PublishChannelSet);

        addActivityReqDTO.setNeedInvoice("");//是否开票
        addActivityReqDTO.setTms("");

        /*---------------------申请人信息-----------------------------*/
        addActivityReqDTO.setApplyUser("DZHB_apply1");//申请人
        addActivityReqDTO.setApplyProvince("999900");//申请人省份
        addActivityReqDTO.setApplyCity("999901");//申请人城市
        addActivityReqDTO.setApplyDepartment("");//
        addActivityReqDTO.setApplyEmail("");//申请人邮箱
        addActivityReqDTO.setApplyPhone(UserList.ContralNo());//申请人手机号
        addActivityReqDTO.setApplyChannel(ApplyChannelEnum.OMP.getCode());
        addActivityReqDTO.setMemo("");
        addActivityReqDTO.setTraceLogId(var);

        Result<AddActivityResDTO> result = activityConfigService.addActivity(addActivityReqDTO);
        String json = JSON.toJSONString(result.getResult(), true);
        System.out.println("***********************************");
        System.out.println("日志号：" + addActivityReqDTO.getTraceLogId());
        System.out.println("是否成功" + result.isSuccess());
        System.out.println("错误码：" + result.getErrorCode());
        System.out.println("错误信息：" + result.getErrorMsg());
        System.out.println("结果集：" + json);

    }
}
