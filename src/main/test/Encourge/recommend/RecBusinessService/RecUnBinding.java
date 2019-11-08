package Encourge.recommend.RecBusinessService;

import Customize.DataGenerate;
import com.xx.dubbo.result.Result;
import com.xx.marketing.recommend.api.RecBusinessService;
import com.xx.marketing.recommend.api.models.request.RecUnBindingReqDTO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/9/6.
 * 推荐人工具关系解除绑定
 */
public class RecUnBinding extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static RecBusinessService recBusinessService = (RecBusinessService) ac.getBean("recBusinessService");

    @Test
    public static void recUnBinding() {
        RecUnBindingReqDTO recUnBindingReqDTO = new RecUnBindingReqDTO();
        recUnBindingReqDTO.setProductNo("13215777189");//被推荐人手机号
        recUnBindingReqDTO.setTraceLogId(TraceLogId());

        Result<Boolean> result = recBusinessService.recUnBinding(recUnBindingReqDTO);
        System.out.println("********************推荐人工具关系解除绑定********************");
        System.out.println("日志号:" + recUnBindingReqDTO.getTraceLogId());
        System.out.println("被推荐人手机号:" + recUnBindingReqDTO.getProductNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
