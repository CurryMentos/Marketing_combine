package Portal.activity.ActivityApplyService;

import Portal.ActivityDTO;
import Portal.CustomizedService;
import Portal.Preset;
import com.bestpay.marketing.config.api.activity.models.request.*;
import com.bestpay.marketing.config.api.activity.models.response.AddApplyActivityResDTO;
import com.bestpay.marketing.config.api.enums.*;

import com.bestpay.dubbo.result.Result;

import com.bestpay.marketing.config.api.activity.ActivityApplyService;
import Customize.DataGenerate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by zengyouzu on 2019/6/18.
 * 营销活动草稿保存提交
 */
public class AddApplyActivity extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    static ActivityApplyService activityApplyService = (ActivityApplyService) ac.getBean("activityApplyService");

    @Test
    public static void addApplyActivity() throws Exception {
        //反射得到Preset类中的CustomizedService,向下转型给ActivityDTOList,实例化ActivityDTO循环遍历取得List中所有DTO参数
        CustomizedService customizedService = Preset.PresetActivity();
        List<ActivityDTO> activityDTOList = customizedService.getActivityDTOList();
        ActivityDTO activityDTO = new ActivityDTO();
        for (int i = 0; i < activityDTOList.size(); i++) {
            activityDTO = activityDTOList.get(i);
        }

        ApplyActivityConfigReqDTO applyActivityConfigReqDTO = new ApplyActivityConfigReqDTO();
//        applyActivityConfigReqDTO.setApplyId("App" + RandomStringNo());//申请编号
        applyActivityConfigReqDTO.setActionType(ActionTypeEnum.SUBMIT.getCode());//操作类型(h5必传) SAVE：保存，不用走工作流;SUBMIT：提交，要走工作流
        applyActivityConfigReqDTO.setApplyUser("DZHB_apply1");//申请人
        applyActivityConfigReqDTO.setApplyProvince("999900");//申请人所属省
        applyActivityConfigReqDTO.setApplyCity("999901");//申请人所属市
        applyActivityConfigReqDTO.setActivityType(ActivityTypeEnum.BUSINESS_REBATE.getCode());//活动类型
        applyActivityConfigReqDTO.setApplyChannel(ApplyChannelEnum.H5.getCode());//申请渠道
//        applyActivityConfigReqDTO.setActivityId("Act" + RandomStringNo());//活动编号

//        活动基本信息DTO
        applyActivityConfigReqDTO.setActivityBasicInfoApplyReqDTO(activityDTO.getActivityBasicInfoApplyReqDTO());
//        活动参与规则请求DTO
        applyActivityConfigReqDTO.setActivityRuleApplyReqDTO(activityDTO.getActivityRuleApplyReqDTO());
//        活动限额规则请求DTO
        applyActivityConfigReqDTO.setLimitRuleReqDTO(activityDTO.getLimitRuleReqDTO());
//        优惠规则请求DTO
        applyActivityConfigReqDTO.setPreferentialApplyReqDTO(activityDTO.getPreferentialApplyReqDTO());
//        红包铺子信息
        applyActivityConfigReqDTO.setActivityShowShopApplyReqDTO(activityDTO.getActivityShowShopApplyReqDTO());
//        附件页面DTO
        applyActivityConfigReqDTO.setApplyAttachmentReqDTO(activityDTO.getApplyAttachmentReqDTO());

        applyActivityConfigReqDTO.setRequestNo("Req" + RandomStringNo());//请求流水
        applyActivityConfigReqDTO.setRequestSystem("Test");//请求系统
        applyActivityConfigReqDTO.setRequestDate(now);//请求时间
        applyActivityConfigReqDTO.setTraceLogId(TraceLogId());//日志号

        Result<AddApplyActivityResDTO> result = activityApplyService.addApplyActivity(applyActivityConfigReqDTO);
        System.out.println("*****************************************");
        System.out.println("日志号:" + applyActivityConfigReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
