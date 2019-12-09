package Encourge.recommend.RecBusinessService;

import Customize.DataGenerate;
import Customize.UserList;
import Encourge.recommend.RecommendService;
import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.recommend.api.RecBusinessService;
import com.bestpay.marketing.recommend.api.models.request.RecBindingReqDTO;
import com.bestpay.marketing.recommend.api.models.response.RecBindingResDTO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/9/6.
 * 推荐人工具关系绑定
 */
public class RecBinding extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static RecBusinessService recBusinessService = (RecBusinessService) ac.getBean("recBusinessService");

    @Test
    public static void recBinding() {
        RecBindingReqDTO recBindingReqDTO = new RecBindingReqDTO();
        recBindingReqDTO.setRecommendUrl("3178002078358639T30990191009200731000062");// 邀请链接 8630021000351915T30990191010100816000076
//        recBindingReqDTO.setRecommendedProductNo(UserList.ContralNo());//  被推荐人手机号
        recBindingReqDTO.setRecommendedProductNo("13215777189");//  被推荐人手机号
        recBindingReqDTO.setTraceLogId(TraceLogId());

        Result<RecBindingResDTO> result = recBusinessService.recBinding(recBindingReqDTO);
        System.out.println("********************推荐人工具关系绑定********************");
        System.out.println("日志号:" + recBindingReqDTO.getTraceLogId());
        System.out.println("被推荐人手机号:" + recBindingReqDTO.getRecommendedProductNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
