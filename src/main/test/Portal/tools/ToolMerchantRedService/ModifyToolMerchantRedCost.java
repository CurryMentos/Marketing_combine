package Portal.tools.ToolMerchantRedService;//package config.tools.ToolMerchantRedService;
//import com.xx.marketing.config.api.activity.models.ModifyActivityVoucherCostInfoDTO;
//import com.xx.marketing.config.api.activity.models.request.CostReqDTO;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.UUID;
//
//import com.xx.dubbo.result.Result;
//import com.xx.marketing.config.api.activity.models.ModifyActivityVoucherCostDTO;
//import com.xx.marketing.config.api.activity.models.response.ModifyActivityResDTO;
//import com.google.common.collect.Sets;
//import com.xx.marketing.config.api.tools.ToolMerchantRedService;
//import com.xx.marketing.config.api.tools.request.ModifyToolMerchantRedCostReqDTO;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.testng.annotations.Test;
//
///**
// *营销工具商户红包成本变更接口
// * Created by yangwei on 2019/8/26.
// */
//public class ModifyToolMerchantRedCost {
//    @Test
//    public static void ModifyActivityCost() throws Exception {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        ToolMerchantRedService toolMerchantRedService = (ToolMerchantRedService) ac.getBean("ToolMerchantRedService");
//        String traceLogId = UUID.randomUUID().toString().replaceAll("-", "");
//        Date date = new Date();
//        String str =  "YS" + new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(date);
//
//        ModifyToolMerchantRedCostReqDTO modifyToolMerchantRedCostReqDTO = new ModifyToolMerchantRedCostReqDTO();
//        modifyToolMerchantRedCostReqDTO.setToolId("");
//        modifyToolMerchantRedCostReqDTO.setActivityId("");
//        modifyToolMerchantRedCostReqDTO.setActivityName("");
//        modifyToolMerchantRedCostReqDTO.setRelationType("");   //  关系类型
//        modifyToolMerchantRedCostReqDTO.setMoneyCertificate(Sets.newHashSet());  //  变更追加打款凭证
//        modifyToolMerchantRedCostReqDTO.setOrderFile(Sets.newHashSet());     //省活动配置变更单
////        modifyToolMerchantRedCostReqDTO.setProvinceCode("");    //  申请方省编码
////        modifyToolMerchantRedCostReqDTO.setCityCode("");         //     申请方市编码
//        modifyToolMerchantRedCostReqDTO.setApplyChannel("");      //  申请渠道
//        modifyToolMerchantRedCostReqDTO.setApplyUser("");    //  申请人
//
//
//        ModifyActivityVoucherCostDTO modifyActivityVoucherCostDTO = new ModifyActivityVoucherCostDTO();
//        modifyActivityVoucherCostDTO.setCostAddType("");   //  成本追加类型
//        modifyActivityVoucherCostDTO.setEquityTotalAmt(0L);    //   权益总成本(追加部分)
//        modifyActivityVoucherCostDTO.setEquityTotalNum(0L);    //   权益总名额(追加部分)
//        //变更活动代金券成本明细列表
//        List<ModifyActivityVoucherCostInfoDTO> modifyActivityVoucherCostInfoDTOList = new ArrayList<>();
//        ModifyActivityVoucherCostInfoDTO modifyActivityVoucherCostInfoDTO = new ModifyActivityVoucherCostInfoDTO();
//        modifyActivityVoucherCostInfoDTO.setEquityId("");  //  权益编号
//        modifyActivityVoucherCostInfoDTO.setEquityName("");   //  权益名称
//        // 成本分摊列表
//        List<CostReqDTO> costReqDTOList = new ArrayList<>();
//        CostReqDTO cosReqDTO = new CostReqDTO();
//        cosReqDTO.setInvestorType("");   //  出资方
//        cosReqDTO.setInvestorName("");    //  出资方名称
//        cosReqDTO.setInvestmentWay("");    //  出资方式
//        cosReqDTO.setInvestmentWayName("");   //  出资方式名称
//        cosReqDTO.setCostCfgPercentage("");   //   出资比例
//        cosReqDTO.setInvestmentOrgCode("");   //   出资机构编码
//        cosReqDTO.setInvestmentOrgName("");   //   出资机构名称
//        cosReqDTO.setInvestmentOrgAccount("");   //   出资账户编码
//        cosReqDTO.setInvestmentOrgAccountName("");   //  出资账户名称
//        cosReqDTO.setDueAmt(0L);  //  应付金额
//        cosReqDTO.setRealPayAmt(0L);   //实付金额
//        cosReqDTO.setAdvanceFlag("");   //  是否垫资
//        costReqDTOList.add(cosReqDTO);
//        modifyActivityVoucherCostInfoDTO.setCostReqDTOList(costReqDTOList);
//        modifyActivityVoucherCostInfoDTOList.add(modifyActivityVoucherCostInfoDTO);
//        modifyActivityVoucherCostDTO.setModifyActivityVoucherCostInfoDTOList(modifyActivityVoucherCostInfoDTOList);
//        modifyToolMerchantRedCostReqDTO.setModifyActivityVoucherCostDTO(modifyActivityVoucherCostDTO);  //变更活动红包金权益成本DTO
//
//        modifyToolMerchantRedCostReqDTO.setRequestNo(str);
//        modifyToolMerchantRedCostReqDTO.setRequestSystem("YSTEST");
//        modifyToolMerchantRedCostReqDTO.setRequestDate(date);
//        modifyToolMerchantRedCostReqDTO.setTraceLogId(traceLogId);
//
//        Result<ModifyActivityResDTO> result = toolMerchantRedService.modifyToolMerchantRedCost(modifyToolMerchantRedCostReqDTO);
//        System.out.println("*****************************************");
//        System.out.println("日志ID：" + modifyToolMerchantRedCostReqDTO.getTraceLogId());
//        System.out.println("请求流水：" + modifyToolMerchantRedCostReqDTO.getRequestNo());
//        if (result.getResult() != null){
//            System.out.println("响应信息：" + result.getResult());
//        }
//    }
//}
