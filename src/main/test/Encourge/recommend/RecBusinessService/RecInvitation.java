package Encourge.recommend.RecBusinessService;

import Customize.UserList;
import Customize.DataGenerate;
import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.recommend.api.RecBusinessService;
import com.bestpay.marketing.recommend.api.models.request.RecInvitationReqDTO;
import com.bestpay.marketing.recommend.api.models.response.RecInvitationResDTO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/9/6.
 * 立即邀请
 */
public class RecInvitation extends DataGenerate{
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static RecBusinessService recBusinessService = (RecBusinessService) ac.getBean("recBusinessService");

    @Test
    public static void recInviation() {
        RecInvitationReqDTO invitationReqDTO = new RecInvitationReqDTO();
        invitationReqDTO.setToolId("T30990191010102319000078");//  工具ID
//        invitationReqDTO.setProductNo(UserList.ContralNo());//  推荐人手机号
        invitationReqDTO.setProductNo("18861619182");//  推荐人手机号
        invitationReqDTO.setTraceLogId(TraceLogId());

        Result<RecInvitationResDTO> result = recBusinessService.recInvitation(invitationReqDTO);
        System.out.println("********************立即邀请********************");
        System.out.println("日志号:" + invitationReqDTO.getTraceLogId());
        System.out.println("工具号:" + invitationReqDTO.getToolId());
        System.out.println("推荐人手机号:" + invitationReqDTO.getProductNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
