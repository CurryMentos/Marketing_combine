package Portal.tools.ToolMerchantRedService;//package config.tools.ToolMerchantRedService;
//import com.xx.dubbo.result.Result;
//import com.xx.marketing.config.api.activity.models.ModifyActivityVoucherBasicDTO;
//import com.xx.marketing.config.api.activity.models.request.MerchantReqDTO;
//import com.xx.marketing.config.api.activity.models.response.ModifyActivityResDTO;
//import com.xx.marketing.portal.api.enums.ActivitySceneEnum;
//import com.xx.marketing.portal.api.enums.CustomerLevelEnum;
//import com.xx.marketing.portal.api.enums.UserDimensionEnum;
//import com.google.common.collect.Lists;
//import com.xx.marketing.config.api.activity.models.ModifyActivityLimitRuleDTO;
//import java.text.SimpleDateFormat;
//import java.util.*;
//import com.xx.marketing.config.api.tools.ToolMerchantRedService;
//import com.xx.marketing.config.api.tools.request.ModifyToolMerchantRedBasicInfoReqDTO;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.testng.annotations.Test;
//
///**
// * 商户工具商户红包基本信息变更接口
// * Created by yangwei on 2019/8/26.
// */
//public class ModifyToolMerchantRedBasicInfo {
//    @Test
//    public static void ModifyActivityCost() throws Exception {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        ToolMerchantRedService toolMerchantRedService = (ToolMerchantRedService) ac.getBean("ToolMerchantRedService");
//        String traceLogId = UUID.randomUUID().toString().replaceAll("-", "");
//        Date date = new Date();
//        String str =  "YS" + new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(date);
//
//        ModifyToolMerchantRedBasicInfoReqDTO modifyMerchantRedBasicInfoReqDTO = new ModifyToolMerchantRedBasicInfoReqDTO();
//        modifyMerchantRedBasicInfoReqDTO.setToolId("");
//        modifyMerchantRedBasicInfoReqDTO.setToolMerchantName("");
//        modifyMerchantRedBasicInfoReqDTO.setToolLandingPage("");   //  领取页面图片
//        modifyMerchantRedBasicInfoReqDTO.setToolBlessing("");   //  领取页面祝福语
//        modifyMerchantRedBasicInfoReqDTO.setActivityId("");
//        modifyMerchantRedBasicInfoReqDTO.setActivityName("");
//        modifyMerchantRedBasicInfoReqDTO.setRelationType("");   //  关联类型
//        modifyMerchantRedBasicInfoReqDTO.setActivityEndDate("");   //  活动结束时间(yyyyMMdd)
//        Set adaptCity = new HashSet<>();
//        adaptCity.add("");
//        modifyMerchantRedBasicInfoReqDTO.setAdaptCity(adaptCity);   //  活动城市（所有）
//        Set customerLevel = new HashSet<>();
//        customerLevel.add(CustomerLevelEnum.ONE.getCode());
//        modifyMerchantRedBasicInfoReqDTO.setCustomerLevel(customerLevel);   //  账户星级
//        Set userDismension = new HashSet<>();
//        userDismension.add(UserDimensionEnum.CONTROL_NO.getCode());
//        modifyMerchantRedBasicInfoReqDTO.setUserDimension(userDismension);   //  用户维度
//        modifyMerchantRedBasicInfoReqDTO.setNeedBindCard("");   //  限制绑卡(Y 绑卡  N 不绑卡)
//        Set activityScene = new HashSet<>();
//        activityScene.add(ActivitySceneEnum.COLLECT_CODE.getCode());
//        modifyMerchantRedBasicInfoReqDTO.setActivityScene(activityScene);   //  活动场景（所有）
//        Set ownPeoductCode = new HashSet<>();
//        ownPeoductCode.add("");
//        modifyMerchantRedBasicInfoReqDTO.setOwnProductCode(ownPeoductCode);   //  自有业务-外部交易类型
//        Set orderFile = new HashSet<>();
//        orderFile.add("");
//        modifyMerchantRedBasicInfoReqDTO.setOrderFile(orderFile);   //  省活动配置变更单
//        Set riskFile = new HashSet<>();
//        riskFile.add("");
//        modifyMerchantRedBasicInfoReqDTO.setRiskFile(riskFile);   //  营销风险承诺函
//        modifyMerchantRedBasicInfoReqDTO.setApplyChannel("");   //  申请渠道
//        modifyMerchantRedBasicInfoReqDTO.setApplyUser("");   //  申请人
//
////        List<MerchantReqDTO> merchantReqDTOList = new ArrayList<>();
////        MerchantReqDTO merchantReqDTO = new MerchantReqDTO();
////        merchantReqDTO.setMerchantId("");
////        merchantReqDTO.setMerchantName("");
////        merchantReqDTO.setMerchantSource("");
////        merchantReqDTO.setSubMerchantSource("");
////        merchantReqDTO.setStoreReqDTOList(Lists.newArrayList());
////        merchantReqDTO.setGoodsReqDTOList(Lists.newArrayList());
////        modifyMerchantRedBasicInfoReqDTO.setMerchantReqDTOList(merchantReqDTOList);   //  活动参与商户列表(omp，H5常场景商户用)
//
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
//        modifyMerchantRedBasicInfoReqDTO.setModifyActivityLimitRuleDTO(modifyActivityLimitRuleDTO);   //  变更活动限额规则
//
//        ModifyActivityVoucherBasicDTO modifyActivityVoucherBasicDTO = new ModifyActivityVoucherBasicDTO();
//        modifyActivityVoucherBasicDTO.setCustomContent("");
//        modifyActivityVoucherBasicDTO.setModifyActivityVoucherBasicInfoDTOList(Lists.newArrayList());
//        modifyActivityVoucherBasicDTO.setRebateType("");
//        modifyActivityVoucherBasicDTO.setRebateAmt(0L);
//        modifyActivityVoucherBasicDTO.setNeedMultiply("");
//        modifyActivityVoucherBasicDTO.setPercentage("");
//        modifyActivityVoucherBasicDTO.setRandomLevel("");
//        modifyActivityVoucherBasicDTO.setMinSpendThreshold(0L);
//        modifyActivityVoucherBasicDTO.setMaxSpendThreshold(0L);
//        modifyActivityVoucherBasicDTO.setMinRebateAmt(0L);
//        modifyActivityVoucherBasicDTO.setMaxRebateAmt(0L);
//        modifyMerchantRedBasicInfoReqDTO.setModifyActivityVoucherBasicDTO(modifyActivityVoucherBasicDTO);   //  变更活动代金券权益基本信息DTO
//
//        modifyMerchantRedBasicInfoReqDTO.setRequestNo(str);
//        modifyMerchantRedBasicInfoReqDTO.setRequestSystem("YSTEST");
//        modifyMerchantRedBasicInfoReqDTO.setRequestDate(date);
//        modifyMerchantRedBasicInfoReqDTO.setTraceLogId(traceLogId);
//
//        Result<ModifyActivityResDTO> result = toolMerchantRedService.modifyToolMerchantRedBasicInfo(modifyMerchantRedBasicInfoReqDTO);
//        System.out.println("*****************************************");
//        System.out.println("日志ID：" + modifyMerchantRedBasicInfoReqDTO.getTraceLogId());
//        System.out.println("请求流水：" + modifyMerchantRedBasicInfoReqDTO.getRequestNo());
//        if (result.getResult() != null){
//            System.out.println("响应信息：" + result.getResult());
//        }
//    }
//}
