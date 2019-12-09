package Portal.equity.EquityApplyService;

import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.config.api.equity.EquityApplyService;
import com.bestpay.marketing.config.api.equity.request.EquityRemoveReqDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * Created by gaowenpei on 2019/6/19.
 * <p>
 * 关闭红包金
 */

public class RemoveCoupon {
    @Test
    public static void queryCoupon() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext( "classpath:applicationContext.xml" );
        EquityApplyService equityApplyService = (EquityApplyService) ac.getBean( "equityApplyService" );
        String var = UUID.randomUUID().toString();

        EquityRemoveReqDTO equityRemoveReqDTO = new EquityRemoveReqDTO();
        //申请人
        equityRemoveReqDTO.setApplyUser( "" );
        //权益编号
        equityRemoveReqDTO.setEquityId( "" );

        Result<Boolean> result = equityApplyService.removeVoucher( equityRemoveReqDTO );
        System.out.println( "是否成功:" + result.isSuccess() );
        System.out.println( "错误码:" + result.getErrorCode() );
        System.out.println( "错误信息:" + result.getErrorMsg() );
        System.out.println( "错误码:" + result.getPrimaryErrorCode() );
        System.out.println( "错误信息:" + result.getPrimaryErrorMsg() );
        System.out.println( "测试服务器:" + result.getPrimaryErrorIP() );

    }
}
