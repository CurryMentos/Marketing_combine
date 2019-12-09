package Encourge.recommend.RecConfigService;

import Customize.DataGenerate;
import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.recommend.api.RecConfigService;
import com.bestpay.marketing.recommend.api.models.request.RecCancelEffectReqDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/9/7.
 * 推荐人工具作废
 */
public class RecCancelEffect extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static RecConfigService recConfigService = (RecConfigService) ac.getBean("recConfigService");

    @Test
    public static void recCancelEffect() {
        RecCancelEffectReqDTO recCancelEffectReqDTO = new RecCancelEffectReqDTO();
        recCancelEffectReqDTO.setToolId("");
        recCancelEffectReqDTO.setTraceLogId(TraceLogId());

        Result<Boolean> result = recConfigService.recCancelEffect(recCancelEffectReqDTO);
        System.out.println("********************推荐人工具作废********************");
        System.out.println("日志号:" + recCancelEffectReqDTO.getTraceLogId());
        System.out.println("工具号:" + recCancelEffectReqDTO.getToolId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
