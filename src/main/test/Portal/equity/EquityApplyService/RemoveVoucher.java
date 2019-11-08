package Portal.equity.EquityApplyService;

import com.xx.dubbo.result.Result;
import com.xx.marketing.config.api.equity.EquityApplyService;
import com.xx.marketing.config.api.equity.request.EquityRemoveReqDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * Created by gaowenpei on 2019/6/19.
 * <p>
 * 权益申请删除
 */

public class RemoveVoucher {
    @Test
    public static void removeVoucher() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext( "classpath:applicationContext.xml" );
        EquityApplyService equityApplyService = (EquityApplyService) ac.getBean( "equityApplyService" );

        String var = UUID.randomUUID().toString();
        EquityRemoveReqDTO removeReqDTO = new EquityRemoveReqDTO();
        removeReqDTO.setApplyUser( "" );
        removeReqDTO.setEquityId( "" );

        Result<Boolean> result = equityApplyService.removeVoucher( removeReqDTO );
        System.out.println( "是否成功:" + result.isSuccess() );
        System.out.println( "错误码:" + result.getErrorCode() );
        System.out.println( "错误信息:" + result.getErrorMsg() );
        System.out.println( "错误码:" + result.getPrimaryErrorCode() );
        System.out.println( "错误信息:" + result.getPrimaryErrorMsg() );
        System.out.println( "测试服务器:" + result.getPrimaryErrorIP() );

    }
}