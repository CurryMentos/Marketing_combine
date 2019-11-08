package Portal.activity.ActivityService;
import java.util.Date;

import com.xx.dubbo.result.Result;
import com.xx.marketing.config.api.activity.models.ModifySharingInfoDTO;
import com.xx.marketing.config.api.activity.models.request.ModifyOmpEquityDetailDTO;
import com.xx.marketing.config.api.activity.models.response.ModifyActivityResDTO;

import java.text.SimpleDateFormat;
import java.util.*;

import com.xx.marketing.config.api.activity.ActivityService;
import com.xx.marketing.config.api.activity.models.request.ModifyActivityCostReqDTO;
import com.xx.marketing.config.api.enums.ApplyChannelEnum;
import com.xx.marketing.config.api.enums.EquityTypeEnum;
import com.xx.marketing.config.api.enums.SwitchEnum;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zengyouzu on 2019/6/18.
 * 活动成本变更
 */
/*public class ModifyActivityCost {
    public static void modifyActivityCost() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ActivityService activityService = (ActivityService) ac.getBean("activityService");

        String var = UUID.randomUUID().toString();
        Date now = new Date();
        String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now);

        ModifyActivityCostReqDTO modifyActivityCostReqDTO = new ModifyActivityCostReqDTO();
        modifyActivityCostReqDTO.setActivityId("");//活动编号
        modifyActivityCostReqDTO.setActivityName("");//活动名称
        modifyActivityCostReqDTO.setLedgerFlag(SwitchEnum.N.getCode());//是否走台账,否
//        modifyActivityCostReqDTO.setLedgerFlag(SwitchEnum.Y.getCode());//是否走台账,是
        modifyActivityCostReqDTO.setTotalAmount(0L);//活动追加总成本
        modifyActivityCostReqDTO.setTmsFinance("");//财务回单号
//        modifyActivityCostReqDTO.setApplyChannel(ApplyChannelEnum.MIS.getCode());//申请渠道,综管台
        modifyActivityCostReqDTO.setApplyChannel(ApplyChannelEnum.OMP.getCode());//申请渠道,自助平台
//        modifyActivityCostReqDTO.setApplyChannel(ApplyChannelEnum.H5.getCode());//申请渠道,前后端分离H5
//        modifyActivityCostReqDTO.setApplyChannel(ApplyChannelEnum.QDL_APP_H5.getCode());//申请渠道,钱到啦APP_H5
        modifyActivityCostReqDTO.setApplyUser("");//申请人

        //权益明细列表
        List<ModifyOmpEquityDetailDTO> modifyOmpEquityDetailDTOList = new ArrayList();
        ModifyOmpEquityDetailDTO modifyOmpEquityDetailDTO = new ModifyOmpEquityDetailDTO();
        modifyOmpEquityDetailDTO.setEquityNo("");//权益编号
        modifyOmpEquityDetailDTO.setEquityName("");//权益名称
        modifyOmpEquityDetailDTO.setEquityType(EquityTypeEnum.CASH.getCode());//权益类型,现金
//        modifyOmpEquityDetailDTO.setEquityType(EquityTypeEnum.VOUCHER.getCode());//权益类型,代金券
//        modifyOmpEquityDetailDTO.setEquityType(EquityTypeEnum.FLOW.getCode());//权益类型,流量
//        modifyOmpEquityDetailDTO.setEquityType(EquityTypeEnum.CARD.getCode());//权益类型,发卡
//        modifyOmpEquityDetailDTO.setEquityType(EquityTypeEnum.COUPON.getCode());//权益类型,红包金
        modifyOmpEquityDetailDTO.setEquityTotalAmt(0L);//权益追加总成本
        modifyOmpEquityDetailDTO.setEquityRealPayAmt(0L);//权益追加实付成本

        //成本分摊明细
        List<ModifySharingInfoDTO> modifySharingInfoDTOList = new ArrayList();
        ModifySharingInfoDTO modifySharingInfoDTO = new ModifySharingInfoDTO();
        modifySharingInfoDTO.setOrgCode("");//机构号
        modifySharingInfoDTO.setOrgType("");//机构类型
        modifySharingInfoDTO.setVerifyRate("");//分摊比例
        modifySharingInfoDTO.setDueRate("");//应付比例
        modifySharingInfoDTO.setDueAmt(0L);//应付追加金额
        modifySharingInfoDTO.setRealPayAmt(0L);//实付追加金额
        modifySharingInfoDTO.setAgreementType("");//出资方式
        modifySharingInfoDTO.setAgreementName("");//出资协议名称
        modifySharingInfoDTOList.add(modifySharingInfoDTO);
        modifyOmpEquityDetailDTO.setModifySharingInfoDTO(modifySharingInfoDTOList);
        modifyOmpEquityDetailDTOList.add(modifyOmpEquityDetailDTO);
        modifyActivityCostReqDTO.setModifyOmpEquityDetailDTOList(modifyOmpEquityDetailDTOList);

        modifyActivityCostReqDTO.setRequestNo(sdf);//请求流水
        modifyActivityCostReqDTO.setRequestSystem("");//请求系统
        modifyActivityCostReqDTO.setRequestDate(now);//请求时间
        modifyActivityCostReqDTO.setTraceLogId(var);//日志号

        Result<ModifyActivityResDTO> result = activityService.modifyActivityCost(modifyActivityCostReqDTO);
        System.out.println("*****************************************");
        System.out.println("请求流水:" + modifyActivityCostReqDTO.getRequestNo());
        System.out.println("日志号:" + modifyActivityCostReqDTO.getTraceLogId());
        System.out.println(result);

        if (result.getResult() != null) {
            System.out.println("*****************************************");
            System.out.println(result.getResult());
        }
    }
}*/
