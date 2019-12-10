package Encourge.recommend.RecConfigService;

import Customize.DataGenerate;
import com.xx.dubbo.result.Result;
import com.xx.marketing.recommend.api.RecConfigService;
import com.xx.marketing.recommend.api.enums.RecJumpTypeEnum;
import com.xx.marketing.recommend.api.enums.RecSubThemeTypeEnum;
import com.xx.marketing.recommend.api.models.request.RecModifyEffectReqDTO;
import com.google.common.collect.Sets;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zengyouzu on 2019/9/7.
 * 推荐人工具变更
 */
public class RecModifyEffect extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static RecConfigService recConfigService = (RecConfigService) ac.getBean("recConfigService");

    @Test
    public static void recModifyEffect() {
        RecModifyEffectReqDTO recModifyEffectReqDTO = new RecModifyEffectReqDTO();
        recModifyEffectReqDTO.setToolId("T30990190922145925000005");
//        recModifyEffectReqDTO.setToolDesc("20190920120458推荐人工具");
//        recModifyEffectReqDTO.setTitle("20190920120458推荐人工具");
//        recModifyEffectReqDTO.setTitleDesc("20190920120458推荐人工具");
//        recModifyEffectReqDTO.setSubThemeType(RecSubThemeTypeEnum.GENERAL.getCode());
        recModifyEffectReqDTO.setBackgroundPictureAddress("1713");
        recModifyEffectReqDTO.setButtonPictureAddress("1714");
//        recModifyEffectReqDTO.setButtonName("");
//        recModifyEffectReqDTO.setJumpType(RecJumpTypeEnum.CHAINING.getCode());
//        recModifyEffectReqDTO.setJumpUrl("http://www.baidu.com");
//        recModifyEffectReqDTO.setEndTime(Date.from(LocalDateTime.now(ZoneOffset.ofHours(8)).plusDays(10).withHour(23).withMinute(59).withSecond(59).toInstant(ZoneOffset.ofHours(8))));

        Set CitySet = new HashSet<>();
        CitySet.add("999901");
//        recModifyEffectReqDTO.setAdaptCity(CitySet);

//        recModifyEffectReqDTO.setRequestNo("Req" + RandomStringNo());
//        recModifyEffectReqDTO.setRequestSystem("test");
//        recModifyEffectReqDTO.setRequestDate(new Date());
        recModifyEffectReqDTO.setTraceLogId(TraceLogId());

        Result<Boolean> result = recConfigService.recModifyEffect(recModifyEffectReqDTO);
        System.out.println("********************推荐人工具变更********************");
        System.out.println("日志号:" + recModifyEffectReqDTO.getTraceLogId());
        System.out.println("工具号:" + recModifyEffectReqDTO.getToolId());
        System.out.println("请求流水:" + recModifyEffectReqDTO.getRequestNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
