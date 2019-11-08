package Portal.activity.ActivityService;
import java.util.Date;

import com.xx.dubbo.result.Result;
import com.xx.marketing.config.api.activity.models.request.ModifyOmpEquityBasicInfoDTO;
import com.xx.marketing.config.api.activity.models.response.ModifyActivityResDTO;
import com.xx.marketing.config.api.enums.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import com.xx.marketing.config.api.activity.ActivityService;
import com.xx.marketing.config.api.activity.models.request.ModifyActivityBasicInfoReqDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zengyouzu on 2019/6/18.
 * 活动基本信息变更
 */
/*public class ModifyActivityBasicInfo {
    public static void modifyActivityBasicInfo() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ActivityService activityService = (ActivityService) ac.getBean("activityService");

        String var = UUID.randomUUID().toString();
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.DAY_OF_YEAR, 10);
        String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now);

        ModifyActivityBasicInfoReqDTO modifyActivityBasicInfoReqDTO = new ModifyActivityBasicInfoReqDTO();
        modifyActivityBasicInfoReqDTO.setToolName("");//工具名称
        modifyActivityBasicInfoReqDTO.setActivityId("");//活动编号
        modifyActivityBasicInfoReqDTO.setActivityName("");//活动名称
        modifyActivityBasicInfoReqDTO.setLedgerFlag(SwitchEnum.N.getCode());//是否走台账,否
//        modifyActivityBasicInfoReqDTO.setLedgerFlag(SwitchEnum.Y.getCode());//是否走台账,是
        modifyActivityBasicInfoReqDTO.setActivityEndTime("");//活动结束时间
        modifyActivityBasicInfoReqDTO.setAdaptCity("");//活动适用地区所在市

        //交易渠道
        Set txnChannelList = new HashSet();
        txnChannelList.add("01");
        modifyActivityBasicInfoReqDTO.setTxnChannelList(txnChannelList);

        //外部交易类型
        Set outTxnTypeList =new HashSet();
        outTxnTypeList.add("");
        modifyActivityBasicInfoReqDTO.setOutTxnTypeList(outTxnTypeList);

        //账户星级
        Set customerLevel = new HashSet();
        customerLevel.add(CustomerLevelEnum.GUEST.getCode());//游客
        customerLevel.add(CustomerLevelEnum.TWO.getCode());//二星用户
        customerLevel.add(CustomerLevelEnum.THREE.getCode());//三星用户
        modifyActivityBasicInfoReqDTO.setCustomerLevel(customerLevel);

        //用户维度
        Set userDimension = new HashSet();
        userDimension.add(UserDimensionEnum.PRODUCT_NO.getCode());//手机号
        userDimension.add(UserDimensionEnum.ID_CARD.getCode());//身份证
        userDimension.add(UserDimensionEnum.CONTROL_NO.getCode());//设备号
        modifyActivityBasicInfoReqDTO.setUserDimension(userDimension);

        modifyActivityBasicInfoReqDTO.setNeedBindCard(SwitchEnum.N.getCode());//限制绑卡,否
//        modifyActivityBasicInfoReqDTO.setNeedBindCard(SwitchEnum.Y.getCode());//限制绑卡,是
        modifyActivityBasicInfoReqDTO.setDistributeMsgContent("");//自定义短信内容
        modifyActivityBasicInfoReqDTO.setTmsFinance("");//财务回单号
//        modifyActivityBasicInfoReqDTO.setApplyChannel(ApplyChannelEnum.MIS.getCode());//申请渠道,综管台
        modifyActivityBasicInfoReqDTO.setApplyChannel(ApplyChannelEnum.OMP.getCode());//申请渠道,自助平台
//        modifyActivityBasicInfoReqDTO.setApplyChannel(ApplyChannelEnum.H5.getCode());//申请渠道,前后端分离H5
//        modifyActivityBasicInfoReqDTO.setApplyChannel(ApplyChannelEnum.QDL_APP_H5.getCode());//申请渠道,钱到啦APP_H5
        modifyActivityBasicInfoReqDTO.setApplyUser("");//申请人

        //红包金批次基本信息更改集合
        List<ModifyOmpEquityBasicInfoDTO> modifyOmpEquityBasicInfoDTOList = new ArrayList();
        ModifyOmpEquityBasicInfoDTO modifyOmpEquityBasicInfoDTO = new ModifyOmpEquityBasicInfoDTO();
        modifyOmpEquityBasicInfoDTO.setEquityNo("");//权益编号
        modifyOmpEquityBasicInfoDTO.setEquityType(EquityTypeEnum.CASH.getCode());//权益类型,现金
//        modifyOmpEquityBasicInfoDTO.setEquityType(EquityTypeEnum.VOUCHER.getCode());//权益类型,代金券
//        modifyOmpEquityBasicInfoDTO.setEquityType(EquityTypeEnum.FLOW.getCode());//权益类型,流量
//        modifyOmpEquityBasicInfoDTO.setEquityType(EquityTypeEnum.CARD.getCode());//权益类型,发卡
//        modifyOmpEquityBasicInfoDTO.setEquityType(EquityTypeEnum.COUPON.getCode());//权益类型,红包金
        modifyOmpEquityBasicInfoDTO.setEquityEffectEndTime(cal.getTime());//权益失效时间
        modifyOmpEquityBasicInfoDTO.setEquityCustomerLevel(customerLevel);//权益账户星级
        modifyOmpEquityBasicInfoDTO.setEquityNeedBindCard(SwitchEnum.N.getCode());//权益限制绑卡,否
//        modifyOmpEquityBasicInfoDTO.setEquityNeedBindCard(SwitchEnum.Y.getCode());//权益限制绑卡,是

        //权益使用渠道
        Set equityUseChannel = new HashSet();
        equityUseChannel.add(UseChannelEnum.POS.getCode());//POS
        equityUseChannel.add(UseChannelEnum.WEB.getCode());//WEB
        equityUseChannel.add(UseChannelEnum.SMS.getCode());//短信
        equityUseChannel.add(UseChannelEnum.APP.getCode());//客户端
        equityUseChannel.add(UseChannelEnum.PAYESU.getCode());//添益宝
        equityUseChannel.add(UseChannelEnum.H5.getCode());//H5
        modifyOmpEquityBasicInfoDTO.setEquityUseChannel(equityUseChannel);//权益使用渠道

        modifyOmpEquityBasicInfoDTO.setEquityUseRule("");//权益使用规则
        modifyOmpEquityBasicInfoDTOList.add(modifyOmpEquityBasicInfoDTO);
        modifyActivityBasicInfoReqDTO.setModifyOmpEquityBasicInfoDTOList(modifyOmpEquityBasicInfoDTOList);

        modifyActivityBasicInfoReqDTO.setRequestNo(sdf);//请求流水
        modifyActivityBasicInfoReqDTO.setRequestSystem("");//请求系统
        modifyActivityBasicInfoReqDTO.setRequestDate(now);//请求时间
        modifyActivityBasicInfoReqDTO.setTraceLogId(var);//日志号

        Result<ModifyActivityResDTO> result = activityService.modifyActivityBasicInfo(modifyActivityBasicInfoReqDTO);
        System.out.println("*****************************************");
        System.out.println("请求流水:" + modifyActivityBasicInfoReqDTO.getRequestNo());
        System.out.println("日志号:" + modifyActivityBasicInfoReqDTO.getTraceLogId());
        System.out.println(result);

        if (result.getResult() != null) {
            System.out.println("*****************************************");
            System.out.println(result.getResult());
        }
    }
}*/
