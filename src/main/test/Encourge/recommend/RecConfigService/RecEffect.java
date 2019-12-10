package Encourge.recommend.RecConfigService;
import com.xx.marketing.config.api.enums.ApplyDepartmentEnum;
import com.xx.marketing.config.api.enums.RecThemeTypeEnum;
import com.google.common.collect.Sets;

import Customize.DataGenerate;
import Customize.UserList;
import Encourge.recommend.RecommendService;
import com.xx.dubbo.result.Result;
import com.xx.marketing.config.api.enums.ActivityTypeEnum;
import com.xx.marketing.recommend.api.RecConfigService;
import com.xx.marketing.recommend.api.enums.RecJumpTypeEnum;
import com.xx.marketing.recommend.api.enums.RecSubThemeTypeEnum;
import com.xx.marketing.recommend.api.models.request.RecEffectReqDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zengyouzu on 2019/9/7.
 * 推荐人工具生效
 */
public class RecEffect extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static RecConfigService recConfigService = (RecConfigService) ac.getBean("recConfigService");

    @Test
    public static void recEffect() {
        String str = sdf + "推荐人工具";
        RecEffectReqDTO recEffectReqDTO = new RecEffectReqDTO();
        recEffectReqDTO.setToolId("T30990190916142339000065");
        recEffectReqDTO.setToolName(str);
        recEffectReqDTO.setToolDesc(str);
        recEffectReqDTO.setTitle(str);
        recEffectReqDTO.setTitleDesc(str);
        recEffectReqDTO.setThemeType(RecThemeTypeEnum.DEFAULT.getCode());
        recEffectReqDTO.setSubThemeType(RecSubThemeTypeEnum.GENERAL.getCode());
        recEffectReqDTO.setBackgroundPictureAddress("");
        recEffectReqDTO.setButtonPictureAddress("");
        recEffectReqDTO.setButtonName("");
        recEffectReqDTO.setJumpType(RecJumpTypeEnum.CHAINING.getCode());
        recEffectReqDTO.setJumpUrl("http://www.baidu.com");
        recEffectReqDTO.setActivityId("A" + RandomStringNo());
        recEffectReqDTO.setActivityType(ActivityTypeEnum.BUSINESS_REBATE.getCode());
        recEffectReqDTO.setActivityName(str);
        recEffectReqDTO.setToolRuleGroupId("TRG" + RandomStringNo());
        recEffectReqDTO.setStartTime(Start);
        recEffectReqDTO.setEndTime(End);
        recEffectReqDTO.setAdaptProvince("999900");

        Set CitySet = new HashSet<>();
        CitySet.add("999901");
        recEffectReqDTO.setAdaptCity(CitySet);

        Set PurposeSet = new HashSet<>();
        PurposeSet.add("");
        recEffectReqDTO.setPurpose(PurposeSet);

        recEffectReqDTO.setApplyEmail("123@qq.com");
        recEffectReqDTO.setApplyPhone(UserList.ContralNo());
        recEffectReqDTO.setApplyDepartment(ApplyDepartmentEnum.O2O.getCode());
        recEffectReqDTO.setRemarks("");
        recEffectReqDTO.setTraceLogId(TraceLogId());
        recEffectReqDTO.setRequestNo("Req" + RandomStringNo());
        recEffectReqDTO.setRequestSystem("test");
        recEffectReqDTO.setRequestDate(new Date());

        Result<Boolean> result = recConfigService.recEffect(recEffectReqDTO);
        System.out.println("********************推荐人工具生效********************");
        System.out.println("日志号:" + recEffectReqDTO.getTraceLogId());
        System.out.println("工具号:" + recEffectReqDTO.getToolId());
        System.out.println("活动号:" + recEffectReqDTO.getActivityId());
        System.out.println("请求流水:" + recEffectReqDTO.getRequestNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
