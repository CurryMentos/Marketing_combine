package Portal.tools.ToolEncourageService;//package config.tools.ToolEncourageService;
//
//import java.util.Date;
//
//import com.xx.marketing.config.api.activity.models.*;
//import com.xx.dubbo.result.Result;
//import com.xx.marketing.config.api.activity.models.request.GoodsReqDTO;
//import com.xx.marketing.config.api.activity.models.request.MerchantReqDTO;
//import com.xx.marketing.config.api.activity.models.request.StoreReqDTO;
//import com.xx.marketing.config.api.activity.models.response.ModifyActivityResDTO;
//import com.xx.marketing.config.api.tools.request.ModifyEncourageBasicInfoReqDTO;
//import com.google.common.collect.Lists;
//
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//import com.google.common.collect.Sets;
//
//import com.xx.marketing.config.api.tools.ToolEncourageService;
//import com.xx.marketing.config.api.tools.request.ModifyToolEncourageBasicInfoReqDTO;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.testng.annotations.Test;
//
///**
// * 营销工具双向激励基本信息变更接口
// * Created by yangwei on 2019/8/27.
// */
//public class ModifyToolEncourageBasicInfo {
//    @Test
//    public static void ModifyToolEncourageBasicInfo() throws Exception {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        ToolEncourageService toolEncourageService = (ToolEncourageService) ac.getBean("ToolEncourageService");
//        String traceLogId = UUID.randomUUID().toString().replaceAll("-", "");
//        Date date = new Date();
//        String str = "YS" + new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(date);
//
//        ModifyToolEncourageBasicInfoReqDTO modifyToolEncourageBasicInfoReqDTO = new ModifyToolEncourageBasicInfoReqDTO();
//        modifyToolEncourageBasicInfoReqDTO.setToolId("");
//        modifyToolEncourageBasicInfoReqDTO.setOrderFile(Sets.newHashSet());   //  省活动配置变更单
//        modifyToolEncourageBasicInfoReqDTO.setRiskFile(Sets.newHashSet());   //  营销风险承诺函
//        modifyToolEncourageBasicInfoReqDTO.setApplyChannel("");   //  申请渠道
//        modifyToolEncourageBasicInfoReqDTO.setApplyUser("");   //  申请人
//
//        List<ModifyEncourageBasicInfoReqDTO> modifyEncourageBasicInfoReqDTOList = new ArrayList<>();
//        ModifyEncourageBasicInfoReqDTO modifyEncourageBasicInfoReqDTO = new ModifyEncourageBasicInfoReqDTO();
//        modifyEncourageBasicInfoReqDTO.setActivityId("");
//        modifyEncourageBasicInfoReqDTO.setActivityName("");
//        modifyEncourageBasicInfoReqDTO.setRelationType("");   //  关联类型
//        modifyEncourageBasicInfoReqDTO.setActivityEndDate("");   //  活动结束时间
//        modifyEncourageBasicInfoReqDTO.setAdaptCity(Sets.newHashSet());   //  活动城市
//        modifyEncourageBasicInfoReqDTO.setCustomerLevel(Sets.newHashSet());   //  账户星级
//        modifyEncourageBasicInfoReqDTO.setUserDimension(Sets.newHashSet());   //  用户维度
//        modifyEncourageBasicInfoReqDTO.setNeedBindCard("");   //  限制绑卡(Y 绑卡  N 不绑卡)
////        Set activityScene = new HashSet<>();
////        activityScene.add(ActivitySceneEnum.COLLECT_CODE.getCode());
////        modifyEncourageBasicInfoReqDTO.setActivityScene(activityScene);   //  活动场景
//        Set ownProductCode = new HashSet<>();
//        ownProductCode.add("");
//        modifyEncourageBasicInfoReqDTO.setOwnProductCode(Sets.newHashSet());   //  自有业务-外部交易类型
//
//        List<MerchantReqDTO> merchantReqDTOList = new ArrayList<>();
//        MerchantReqDTO merchantReqDTO = new MerchantReqDTO();
//        merchantReqDTO.setMerchantId("");
//        merchantReqDTO.setMerchantName("");
//        merchantReqDTO.setMerchantSource("");
//        merchantReqDTO.setSubMerchantSource("");
//        List<StoreReqDTO> storeReqDTOList = new ArrayList<>();
//        StoreReqDTO storeReqDTO = new StoreReqDTO();
//        storeReqDTO.setStoreId("");
//        storeReqDTO.setStoreName("");
//        storeReqDTO.setRequestNo("");
//        storeReqDTO.setRequestSystem("");
//        storeReqDTO.setRequestDate(new Date());
//        storeReqDTO.setTraceLogId("");
//        storeReqDTOList.add(storeReqDTO);
//        merchantReqDTO.setStoreReqDTOList(storeReqDTOList);   //  门店列表
//        List<GoodsReqDTO> goodsReqDTOList = new ArrayList<>();
//        GoodsReqDTO goodsReqDTO = new GoodsReqDTO();
//        goodsReqDTO.setGoodsId("");
//        goodsReqDTO.setGoodsName("");
//        goodsReqDTO.setRequestNo("");
//        goodsReqDTO.setRequestSystem("");
//        goodsReqDTO.setRequestDate(new Date());
//        goodsReqDTO.setTraceLogId("");
//        goodsReqDTOList.add(goodsReqDTO);
//        merchantReqDTO.setGoodsReqDTOList(goodsReqDTOList);   //  商品列表
//        merchantReqDTOList.add(merchantReqDTO);
//        modifyEncourageBasicInfoReqDTO.setMerchantReqDTOList(merchantReqDTOList);   //  活动参与商户列表(omp，H5常场景商户用)
//        ModifyActivityLimitRuleDTO modifyActivityLimitRuleDTO = new ModifyActivityLimitRuleDTO();
//        modifyActivityLimitRuleDTO.setLimitCycle("");
//        modifyActivityLimitRuleDTO.setUserDayLimitNum(0L);
//        modifyActivityLimitRuleDTO.setActivityDayLimitNum(0L);
//        modifyActivityLimitRuleDTO.setUserWeekLimitNum(0L);
//        modifyActivityLimitRuleDTO.setActivityWeekLimitNum(0L);
//        modifyActivityLimitRuleDTO.setUserMonthLimitNum(0L);
//        modifyActivityLimitRuleDTO.setActivityMonthLimitNum(0L);
//        modifyActivityLimitRuleDTO.setUserCycLimitNum(0L);
//        modifyActivityLimitRuleDTO.setActivityCycLimitNum(0L);
//        modifyActivityLimitRuleDTO.setUserDayLimitAmt(0L);
//        modifyActivityLimitRuleDTO.setActivityDayLimitAmt(0L);
//        modifyActivityLimitRuleDTO.setUserWeekLimitAmt(0L);
//        modifyActivityLimitRuleDTO.setActivityWeekLimitAmt(0L);
//        modifyActivityLimitRuleDTO.setUserMonthLimitAmt(0L);
//        modifyActivityLimitRuleDTO.setActivityMonthLimitAmt(0L);
//        modifyActivityLimitRuleDTO.setUserCycLimitAmt(0L);
//        modifyActivityLimitRuleDTO.setActivityCycLimitAmt(0L);
//        modifyEncourageBasicInfoReqDTO.setModifyActivityLimitRuleDTO(modifyActivityLimitRuleDTO);   //  变更活动限额规则
//
//        int i = 1;//1现金；2代金券；3红包金
//        switch (i) {
//            case 1:
//                ModifyActivityCashBasicDTO modifyActivityCashBasicDTO = new ModifyActivityCashBasicDTO();
//                modifyActivityCashBasicDTO.setEquityId("");
//                modifyActivityCashBasicDTO.setRebateType("");
//                modifyActivityCashBasicDTO.setRebateAmt(0L);
//                modifyActivityCashBasicDTO.setNeedMultiply("");
//                modifyActivityCashBasicDTO.setPercentage("");
//                modifyActivityCashBasicDTO.setRandomLevel("");
//                modifyActivityCashBasicDTO.setMinSpendThreshold(0L);
//                modifyActivityCashBasicDTO.setMaxSpendThreshold(0L);
//                modifyActivityCashBasicDTO.setMinRebateAmt(0L);
//                modifyActivityCashBasicDTO.setMaxRebateAmt(0L);
//                modifyEncourageBasicInfoReqDTO.setModifyActivityCashBasicDTO(new ModifyActivityCashBasicDTO());   //  变更活动现金权益基本信息DTO
//                break;
//            case 2:
//                ModifyActivityVoucherBasicDTO modifyActivityVoucherBasicDTO = new ModifyActivityVoucherBasicDTO();
//                modifyActivityVoucherBasicDTO.setCustomContent("");
//                modifyActivityVoucherBasicDTO.setModifyActivityVoucherBasicInfoDTOList(Lists.newArrayList());
//                modifyActivityVoucherBasicDTO.setRebateType("");
//                modifyActivityVoucherBasicDTO.setRebateAmt(0L);
//                modifyActivityVoucherBasicDTO.setNeedMultiply("");
//                modifyActivityVoucherBasicDTO.setPercentage("");
//                modifyActivityVoucherBasicDTO.setRandomLevel("");
//                modifyActivityVoucherBasicDTO.setMinSpendThreshold(0L);
//                modifyActivityVoucherBasicDTO.setMaxSpendThreshold(0L);
//                modifyActivityVoucherBasicDTO.setMinRebateAmt(0L);
//                modifyActivityVoucherBasicDTO.setMaxRebateAmt(0L);
//                modifyEncourageBasicInfoReqDTO.setModifyActivityVoucherBasicDTO(modifyActivityVoucherBasicDTO);   //  变更活动代金券权益基本信息DTO
//                break;
//            case 3:
//                ModifyActivityCouponBasicDTO modifyActivityCouponBasicDTO = new ModifyActivityCouponBasicDTO();
//                modifyActivityCouponBasicDTO.setCustomContent("");
//                List<ModifyActivityCouponBasicInfoDTO> modifyActivityCouponBasicInfoDTOList = new ArrayList<>();
//                ModifyActivityCouponBasicInfoDTO modifyActivityCouponBasicInfoDTO = new ModifyActivityCouponBasicInfoDTO();
//                modifyActivityCouponBasicInfoDTO.setEquityId("");
//                modifyActivityCouponBasicInfoDTO.setEquityEffectType("");
//                modifyActivityCouponBasicInfoDTO.setEffectEndTime(new Date());
//                Set equityCustomerLevel = new HashSet<>();
//                equityCustomerLevel.add("");
//                modifyActivityCouponBasicInfoDTO.setEquityCustomerLevel(equityCustomerLevel);
//                modifyActivityCouponBasicInfoDTO.setEquityNeedBindCard("");
//                Set equityUseChannel = new HashSet<>();
//                equityCustomerLevel.add("");
//                modifyActivityCouponBasicInfoDTO.setEquityUseChannel(equityUseChannel);
//                modifyActivityCouponBasicInfoDTO.setEquityUseRule("");
//                modifyActivityCouponBasicInfoDTOList.add(modifyActivityCouponBasicInfoDTO);
//                modifyActivityCouponBasicDTO.setModifyActivityCouponBasicInfoDTOList(modifyActivityCouponBasicInfoDTOList);  //  变更活动代金券权益基本信息明细DTOS
//                modifyActivityCouponBasicDTO.setRebateType("");
//                modifyActivityCouponBasicDTO.setRebateAmt(0L);
//                modifyActivityCouponBasicDTO.setNeedMultiply("");
//                modifyActivityCouponBasicDTO.setPercentage("");
//                modifyActivityCouponBasicDTO.setRandomLevel("");
//                modifyActivityCouponBasicDTO.setMinSpendThreshold(0L);
//                modifyActivityCouponBasicDTO.setMaxSpendThreshold(0L);
//                modifyActivityCouponBasicDTO.setMinRebateAmt(0L);
//                modifyActivityCouponBasicDTO.setMaxRebateAmt(0L);
//                modifyEncourageBasicInfoReqDTO.setModifyActivityCouponBasicDTO(modifyActivityCouponBasicDTO);   //  变更活动红包金权益基本信息DTO
//                break;
//        }
//
//        modifyEncourageBasicInfoReqDTO.setRequestNo("");
//        modifyEncourageBasicInfoReqDTO.setRequestSystem("");
//        modifyEncourageBasicInfoReqDTO.setRequestDate(new Date());
//        modifyEncourageBasicInfoReqDTO.setTraceLogId("");
//        modifyEncourageBasicInfoReqDTOList.add(modifyEncourageBasicInfoReqDTO);
//        modifyToolEncourageBasicInfoReqDTO.setModifyEncourageBasicInfoReqDTOList(modifyEncourageBasicInfoReqDTOList);   //  变更活动红包金权益成本DTO
//        modifyToolEncourageBasicInfoReqDTO.setRequestNo(str);
//        modifyToolEncourageBasicInfoReqDTO.setRequestSystem("YSTEST");
//        modifyToolEncourageBasicInfoReqDTO.setRequestDate(date);
//        modifyToolEncourageBasicInfoReqDTO.setTraceLogId(traceLogId);
//
//        Result<ModifyActivityResDTO> result = toolEncourageService.modifyToolEncourageBasicInfo(modifyToolEncourageBasicInfoReqDTO);
//        System.out.println("*****************************************");
//        System.out.println("日志ID：" + modifyToolEncourageBasicInfoReqDTO.getTraceLogId());
//        System.out.println("请求流水：" + modifyToolEncourageBasicInfoReqDTO.getRequestNo());
//        if (result.getResult() != null) {
//            System.out.println("响应信息：" + result.getResult());
//        }
//    }
//}
