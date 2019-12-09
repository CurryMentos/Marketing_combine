package Portal.AuditService;

import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.config.api.audit.AuditService;
import com.bestpay.marketing.config.api.audit.models.request.AuditQueryInfo;
import com.bestpay.marketing.config.api.audit.models.response.AuditInfo;
import com.bestpay.marketing.config.api.tools.response.ToolApplyInfoDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: nerissa
 * @Date: 2019/6/19 11:07
 * @Description:
 *
 * 流转列表
 */
public class HistoricList {
    @Test
    public static void historicListTest() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext( "classpath:applicationContext.xml" );
        AuditService auditService = (AuditService) ac.getBean( "auditService" );

        String var = UUID.randomUUID().toString();
        AuditQueryInfo auditQueryInfo = new AuditQueryInfo();
        //流程实例ID
        auditQueryInfo.setProcInsId( "" );
        //开始查询条数(开始查询数量从0开始，且不得小于0)
        auditQueryInfo.setFirstResult( 0 );
        //每页显示条数(每页显示数量不得小于0，且不得大于30)
        auditQueryInfo.setMaxResults( 0 );
        auditQueryInfo.setRequestNo( "" );
        auditQueryInfo.setRequestSystem( "" );
        auditQueryInfo.setRequestDate( new Date() );
        auditQueryInfo.setTraceLogId( var );

        Result<List<AuditInfo>> result = auditService.historicList( auditQueryInfo );
        System.out.println( "****************************************" );
        System.out.println( "是否成功:" + result.isSuccess() );
        System.out.println( "错误码:" + result.getErrorCode() );
        System.out.println( "错误描述:" + result.getErrorMsg() );
        System.out.println( "结果集:" + result.getResult() );
        System.out.println( "响应错误码:" + result.getPrimaryErrorCode() );
        System.out.println( "响应错误信息:" + result.getPrimaryErrorMsg() );
        System.out.println( "响应机器IP:" + result.getPrimaryErrorIP() );

        if (result.getResult() != null) {
            List<AuditInfo> list = result.getResult();
            for (AuditInfo dto : list) {
                System.out.println( "*********************************" );
                System.out.println( "" + dto.getNode() );
                System.out.println( "" + dto.getAuditUser() );
                System.out.println( "开始时间" + dto.getStartTime() );
                System.out.println( "结束时间" + dto.getEndTime() );
                System.out.println( "" + dto.getComment() );
                System.out.println( "" + dto.getTimeCost() );

            }
        }
    }
}