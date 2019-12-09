package ActivityOperation.ActivityConfigService;

import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.activity.operation.api.ActivityConfigService;
import com.bestpay.marketing.activity.operation.api.enums.StatusEnum;
import com.bestpay.marketing.activity.operation.api.models.request.ModifyActivityReqDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author: nerissa
 * @Date: 2019/6/3 17:18
 * @Description:
 */
public class ModifyActivity {
    @Test
    public static void modifyActivityTest() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext( "applicationContext.xml" );
        ActivityConfigService activityConfigService = (ActivityConfigService) ac.getBean( "activityConfigService" );

        String var = UUID.randomUUID().toString();
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyyMMddHHmmssSSSSSS" );
        String Time = dateFormat.format( now );

        ModifyActivityReqDTO modifyActivityReqDTO = new ModifyActivityReqDTO();
        //活动ID
        modifyActivityReqDTO.setActivityId( "" );
        //申请人
        modifyActivityReqDTO.setApplyUser( "" );
        //申请渠道
        modifyActivityReqDTO.setApplyChannel( "" );
        //请求流水
        modifyActivityReqDTO.setRequestNo( Time );
        //请求系统
        modifyActivityReqDTO.setRequestSystem( "" );
        //变更类型
        modifyActivityReqDTO.setModifyType( "" );
        //状态 VALID、INVALID、SUSPEND
        modifyActivityReqDTO.setStatus( StatusEnum.VALID.getCode() );
        //日志ID
        modifyActivityReqDTO.setTraceLogId( var );

        Result<Boolean> result = activityConfigService.modifyActivity( modifyActivityReqDTO );
        System.out.println( "********************************" );
        System.out.println( "是否成功:" + result.isSuccess() );
        System.out.println( "错误码:" + result.getErrorCode() );
        System.out.println( "错误描述:" + result.getErrorMsg() );
        System.out.println( "结果集:" + result.getResult() );
        System.out.println( "响应错误码:" + result.getPrimaryErrorCode() );
        System.out.println( "响应错误信息:" + result.getPrimaryErrorMsg() );
        System.out.println( "响应机器IP:" + result.getPrimaryErrorIP() );

    }
}

