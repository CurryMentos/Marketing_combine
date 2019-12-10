package Portal.activity.OmpActivityConfigService;

import Customize.DataGenerate;
import Portal.ActivityDTO;
import Portal.CustomizedService;
import Portal.Preset;
import com.xx.dubbo.result.Result;
import com.xx.marketing.config.api.activity.models.request.*;
import com.xx.marketing.config.api.activity.models.response.ApplyActivityResDTO;
import com.xx.marketing.config.api.enums.*;

import java.util.*;

import com.xx.marketing.config.api.activity.OmpActivityConfigService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;


/**
 * Created by zengyouzu on 2019/9/9.
 * 钱到了app调用申请活动
 */

public class ApplyActivity extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    static OmpActivityConfigService ompActivityConfigService = (OmpActivityConfigService) ac.getBean("ompActivityConfigService");

    @Test
    public static void applyActivity() throws Exception {
        //反射得到Preset类中的CustomizedService,向下转型给ActivityDTOList,实例化ActivityDTO循环遍历取得List中所有DTO参数
        CustomizedService customizedService = Preset.PresetActivity();
        List<ActivityDTO> activityDTOList = customizedService.getActivityDTOList();
        ActivityDTO activityDTO = new ActivityDTO();
        for (int i = 0; i < activityDTOList.size(); i++) {
            activityDTO = activityDTOList.get(i);
        }

        ApplyActivityReqDTO applyActivityReqDTO = new ApplyActivityReqDTO();
        applyActivityReqDTO.setRequestNo("Req" + RandomStringNo());//请求流水号
        applyActivityReqDTO.setRequestSystem("接口发起");//请求系统
        applyActivityReqDTO.setRequestDate(now);//请求时间
        applyActivityReqDTO.setTraceLogId(TraceLogId());//日志ID
        applyActivityReqDTO.setApplyUser("nerissa");//申请人
        applyActivityReqDTO.setApplyProvince("999900");//申请人省份
        applyActivityReqDTO.setApplyCity("999901");//申请人地市
        //MINUS：立减 CONSUME_REBATE：消费返 BUSINESS_REBATE：业务返 DIRECT：直领 BATCH_RECHARGE：批充
        applyActivityReqDTO.setActivityType(ActivityTypeEnum.DIRECT.getCode());//活动类型
        applyActivityReqDTO.setApplyChannel(ApplyChannelEnum.QDL_APP_H5.getCode());//申请渠道

        //活动基本信息DTO
        applyActivityReqDTO.setApplyActivityBasicInfoReqDTO(activityDTO.getActivityBasicInfoApplyReqDTO());
        //活动参与规则请求DTO
        applyActivityReqDTO.setApplyActivityRuleReqDTO(activityDTO.getActivityRuleApplyReqDTO());
        //活动限额规则请求DTO
        applyActivityReqDTO.setApplyLimitRuleReqDTO(activityDTO.getLimitRuleReqDTO());
        //优惠规则请求DTO
        applyActivityReqDTO.setApplyPreferentialReqDTO(activityDTO.getPreferentialApplyReqDTO());

        Result<ApplyActivityResDTO> result = ompActivityConfigService.applyActivity(applyActivityReqDTO);
        System.out.println("*****************************************");
        System.out.println("处理状态:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("响应机器IP:" + result.getPrimaryErrorIP());
        System.out.println("响应错误码:" + result.getPrimaryErrorCode());
        System.out.println("响应错误信息:" + result.getPrimaryErrorMsg());

        System.out.println("*****************************************");
        if (result.getResult() != null) {
            System.out.println("*********************************");
            System.out.println("请求流水:" + applyActivityReqDTO.getRequestNo());
            System.out.println("日志号:" + applyActivityReqDTO.getTraceLogId());
            System.out.println("活动号:" + result.getResult().getActivityId());
            System.out.println("申请状态:" + result.getResult().getApplyStatus());
        }
    }
}