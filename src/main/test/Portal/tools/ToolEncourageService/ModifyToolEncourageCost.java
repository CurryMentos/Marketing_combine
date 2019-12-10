package Portal.tools.ToolEncourageService;//package config.tools.ToolEncourageService;
//import com.google.common.collect.Lists;
//import com.xx.marketing.config.api.activity.models.*;
//import com.xx.dubbo.result.Result;
//import com.xx.marketing.config.api.activity.models.request.CostReqDTO;
//import com.xx.marketing.config.api.activity.models.response.ModifyActivityResDTO;
//import com.xx.marketing.config.api.tools.request.ModifyEncourageCostReqDTO;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.UUID;
//import java.util.concurrent.CopyOnWriteArrayList;
//
//import com.google.common.collect.Sets;
//
//import com.xx.marketing.config.api.tools.ToolEncourageService;
//import com.xx.marketing.config.api.tools.request.ModifyToolEncourageCostReqDTO;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.testng.annotations.Test;
//
///**
// * 营销工具双向激励成本变更接口
// * Created by yangwei on 2019/8/27.
// */
//public class ModifyToolEncourageCost {
//    @Test
//    public static void ModifyToolEncourageCost() throws Exception {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        ToolEncourageService toolEncourageService = (ToolEncourageService) ac.getBean("ToolEncourageService");
//        String traceLogId = UUID.randomUUID().toString().replaceAll("-", "");
//        Date date = new Date();
//        String str =  "YS" + new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(date);
//
//        ModifyToolEncourageCostReqDTO modifyToolEncourageCostReqDTO = new ModifyToolEncourageCostReqDTO();
//        modifyToolEncourageCostReqDTO.setToolId("");
//        modifyToolEncourageCostReqDTO.setMoneyCertificate(Sets.newHashSet());  // 变更追加打款凭证 除支付公司成本、省公司老机构号成本，其他分摊方式无需上传
//        modifyToolEncourageCostReqDTO.setOrderFile(Sets.newHashSet());   //   省活动配置变更单
//        modifyToolEncourageCostReqDTO.setApplyChannel("");    //  申请渠道
//        modifyToolEncourageCostReqDTO.setApplyUser("");   //  申请人
//
//        List<ModifyEncourageCostReqDTO> modifyEncourageCostReqDTOList = new ArrayList<>();
//        ModifyEncourageCostReqDTO modifyEncourageCostReqDTO = new ModifyEncourageCostReqDTO();
//        modifyEncourageCostReqDTO.setActivityId("");
//        modifyEncourageCostReqDTO.setActivityName("");
//        modifyEncourageCostReqDTO.setRelationType("");
//
//        ModifyActivityCashCostDTO modifyActivityCashCostDTO = new ModifyActivityCashCostDTO();
//        modifyActivityCashCostDTO.setEquityId("");
//        modifyActivityCashCostDTO.setEquityTotalAmt(0L);
//        int i = 1; //  1 现金、 2 代金券、 3 红包金
//        switch (i){
//            case 1:
//                List<CostReqDTO> costReqDTOList = new ArrayList<>();
//                CostReqDTO cosReqDTO = new CostReqDTO();
//                cosReqDTO.setInvestorType("");
//                cosReqDTO.setInvestorName("");
//                cosReqDTO.setInvestmentWay("");
//                cosReqDTO.setInvestmentWayName("");
//                cosReqDTO.setCostCfgPercentage("");
//                cosReqDTO.setInvestmentOrgCode("");
//                cosReqDTO.setInvestmentOrgName("");
//                cosReqDTO.setInvestmentOrgAccount("");
//                cosReqDTO.setInvestmentOrgAccountName("");
//                cosReqDTO.setDueAmt(0L);
//                cosReqDTO.setRealPayAmt(0L);
//                cosReqDTO.setAdvanceFlag("");
//                costReqDTOList.add(cosReqDTO);
//                modifyActivityCashCostDTO.setCostReqDTOList(costReqDTOList);  //  成本分摊列表
//                modifyEncourageCostReqDTO.setModifyActivityCashCostDTO(modifyActivityCashCostDTO);   //  变更活动现金权益成本DTO
//                break;
//            case 2:
//                ModifyActivityVoucherCostDTO modifyActivityVoucherCostDTO = new ModifyActivityVoucherCostDTO();
//                modifyActivityVoucherCostDTO.setCostAddType("");
//                modifyActivityVoucherCostDTO.setEquityTotalAmt(0L);
//                modifyActivityVoucherCostDTO.setEquityTotalNum(0L);
//                List<ModifyActivityVoucherCostInfoDTO> modifyActivityVoucherCostInfoDTOList = new ArrayList<>();
//                ModifyActivityVoucherCostInfoDTO modifyActivityVoucherCostInfoDTO = new ModifyActivityVoucherCostInfoDTO();
//                modifyActivityVoucherCostInfoDTO.setEquityId("");
//                modifyActivityVoucherCostInfoDTO.setEquityName("");
//                List<CostReqDTO> costReqDTOList1 = new ArrayList<>();
//                CostReqDTO costReqDTO = new CostReqDTO();
//                costReqDTO.setInvestorType("");
//                costReqDTO.setInvestorName("");
//                costReqDTO.setInvestmentWay("");
//                costReqDTO.setInvestmentWayName("");
//                costReqDTO.setCostCfgPercentage("");
//                costReqDTO.setInvestmentOrgCode("");
//                costReqDTO.setInvestmentOrgName("");
//                costReqDTO.setInvestmentOrgAccount("");
//                costReqDTO.setInvestmentOrgAccountName("");
//                costReqDTO.setDueAmt(0L);
//                costReqDTO.setRealPayAmt(0L);
//                costReqDTO.setModifyRealPayAmt(0L);
//                costReqDTO.setAdvanceFlag("");
//                costReqDTOList1.add(costReqDTO);
//                modifyActivityVoucherCostInfoDTO.setCostReqDTOList(costReqDTOList1);   //  成本分摊列表
//                modifyActivityVoucherCostInfoDTOList.add(modifyActivityVoucherCostInfoDTO);
//                modifyActivityVoucherCostDTO.setModifyActivityVoucherCostInfoDTOList(modifyActivityVoucherCostInfoDTOList);   //  变更活动代金券成本明细列表
//                modifyEncourageCostReqDTO.setModifyActivityVoucherCostDTO(modifyActivityVoucherCostDTO);   //  变更活动代金券权益成本DTO
//                break;
//            case 3:
//                ModifyActivityCouponCostDTO modifyActivityCouponCostDTO = new ModifyActivityCouponCostDTO();
//                modifyActivityCouponCostDTO.setCostAddType("");
//                modifyActivityCouponCostDTO.setConfigCostType("");
//                modifyActivityCouponCostDTO.setEquityTotalAmt(0L);
//                modifyActivityCouponCostDTO.setEquityTotalNum(0L);
//                List<ModifyActivityCouponCostInfoDTO> modifyActivityCouponCostInfoDTOList = new ArrayList<>();
//                ModifyActivityCouponCostInfoDTO ModifyActivityCouponCostInfoDTO = new ModifyActivityCouponCostInfoDTO();
//                ModifyActivityCouponCostInfoDTO.setEquityId("");
//                ModifyActivityCouponCostInfoDTO.setEquityName("");
//                List<CostReqDTO> costReqDTOlist1 = new CopyOnWriteArrayList<>();
//                CostReqDTO costReqDTO1 = new CostReqDTO();
//                costReqDTO1.setInvestorType("");
//                costReqDTO1.setInvestorName("");
//                costReqDTO1.setInvestmentWay("");
//                costReqDTO1.setInvestmentWayName("");
//                costReqDTO1.setCostCfgPercentage("");
//                costReqDTO1.setInvestmentOrgCode("");
//                costReqDTO1.setInvestmentOrgName("");
//                costReqDTO1.setInvestmentOrgAccount("");
//                costReqDTO1.setInvestmentOrgAccountName("");
//                costReqDTO1.setDueAmt(0L);
//                costReqDTO1.setRealPayAmt(0L);
//                costReqDTO1.setAdvanceFlag("");
//                costReqDTOlist1.add(costReqDTO1);
//                ModifyActivityCouponCostInfoDTO.setCostReqDTOList(costReqDTOlist1);
//                ModifyActivityCouponCostInfoDTO.setRequestNo("");
//                ModifyActivityCouponCostInfoDTO.setRequestSystem("");
//                ModifyActivityCouponCostInfoDTO.setRequestDate(new Date());
//                ModifyActivityCouponCostInfoDTO.setTraceLogId("");
//                modifyActivityCouponCostInfoDTOList.add(ModifyActivityCouponCostInfoDTO);
//                modifyActivityCouponCostDTO.setModifyActivityCouponCostInfoDTOList(modifyActivityCouponCostInfoDTOList);  //  变更红包金权益明细列表
//                modifyActivityCouponCostDTO.setRequestNo("");
//                modifyActivityCouponCostDTO.setRequestSystem("");
//                modifyActivityCouponCostDTO.setRequestDate(new Date());
//                modifyActivityCouponCostDTO.setTraceLogId("");
//                modifyEncourageCostReqDTO.setModifyActivityCouponCostDTO(modifyActivityCouponCostDTO);   //  变更活动红包金权益成本DTO
//                break;
//        }
//        modifyEncourageCostReqDTO.setRequestNo("");
//        modifyEncourageCostReqDTO.setRequestSystem("");
//        modifyEncourageCostReqDTO.setRequestDate(new Date());
//        modifyEncourageCostReqDTO.setTraceLogId("");
//        modifyEncourageCostReqDTOList.add(modifyEncourageCostReqDTO);
//        modifyToolEncourageCostReqDTO.setModifyEncourageCostReqDTOList(modifyEncourageCostReqDTOList);   //  变更双向激励成本请求DTO
//
//        modifyToolEncourageCostReqDTO.setRequestNo(str);
//        modifyToolEncourageCostReqDTO.setRequestSystem("YSTEST");
//        modifyToolEncourageCostReqDTO.setRequestDate(date);
//        modifyToolEncourageCostReqDTO.setTraceLogId(traceLogId);
//
//        Result<ModifyActivityResDTO> result = toolEncourageService.modifyToolEncourageCost(modifyToolEncourageCostReqDTO);
//        System.out.println("*****************************************");
//        System.out.println("日志ID：" + modifyToolEncourageCostReqDTO.getTraceLogId());
//        System.out.println("请求流水：" + modifyToolEncourageCostReqDTO.getRequestNo());
//        if (result.getResult() != null){
//            System.out.println(result.getResult());
//        }
//    }
//}
