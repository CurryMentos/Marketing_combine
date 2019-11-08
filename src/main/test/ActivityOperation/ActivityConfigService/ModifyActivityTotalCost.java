package ActivityOperation.ActivityConfigService;

import com.xx.dubbo.result.Result;
import com.xx.marketing.activity.operation.api.ActivityConfigService;
import com.xx.marketing.activity.operation.api.models.request.ModifyActivityTotalCostReqDTO;
import com.xx.marketing.activity.operation.api.models.response.TradeStatusResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author: nerissa
 * @Date: 2019/6/17 14:41
 * @Description: 活动成本变更（追加成本）*/


public class ModifyActivityTotalCost {
    @Test
    public static void modifyActivityTotalCostTest() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext( "applicationContext.xml" );
        ActivityConfigService activityConfigService = (ActivityConfigService) ac.getBean( "activityConfigService" );

        String var = UUID.randomUUID().toString();
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyyMMddHHmmssSSSSSS" );
        String Time = dateFormat.format( now );

        ModifyActivityTotalCostReqDTO modifyActivityTotalCostReqDTO = new ModifyActivityTotalCostReqDTO();
        //活动号
        modifyActivityTotalCostReqDTO.setActivityId( "" );
        //申请人
        modifyActivityTotalCostReqDTO.setApplyUser( "" );
        //申请渠道
        modifyActivityTotalCostReqDTO.setApplyChannel( "" );
        //请求流水
        modifyActivityTotalCostReqDTO.setRequestNo( Time );
        //请求系统
        modifyActivityTotalCostReqDTO.setRequestSystem( "" );
        //追加的成本
        modifyActivityTotalCostReqDTO.setExtraCost( 1L );
        modifyActivityTotalCostReqDTO.setTraceLogId( var );

        Result<TradeStatusResDTO> result = activityConfigService.modifyActivityTotalCost( modifyActivityTotalCostReqDTO );
        System.out.println( "********************************" );
        System.out.println( "日志号：" + modifyActivityTotalCostReqDTO.getTraceLogId() );
        System.out.println( "是否成功:" + result.isSuccess() );
        System.out.println( "错误码:" + result.getErrorCode() );
        System.out.println( "错误描述:" + result.getErrorMsg() );
        System.out.println( "结果集:" + result.getResult() );
        System.out.println( "响应错误码:" + result.getPrimaryErrorCode() );
        System.out.println( "响应错误信息:" + result.getPrimaryErrorMsg() );
        System.out.println( "响应机器IP:" + result.getPrimaryErrorIP() );

        if (result.getResult() != null) {
            System.out.println( "***********************************" );
            System.out.println( "活动号：" + result.getResult().getActivityId() );

        }
    }
}
