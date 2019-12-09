package Portal.tools.ToolApplyService;//package tools.ToolApplyService;
//
//import com.bestpay.dubbo.result.Result;
//import com.bestpay.marketing.config.api.tools.ToolApplyService;
//import com.bestpay.marketing.config.api.tools.request.ToolApplyModifyCostReqDTO;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.testng.annotations.Test;
//
//import java.util.UUID;
//
///**
// * @Author: nerissa
// * @Date: 2019/6/19 10:04
// * @Description:
// *
// * 成本信息变更接口
// */
//public class ModifyCost {
//    @Test
//    public static void modifyCostTest() throws Exception {
//        ApplicationContext ac = new ClassPathXmlApplicationContext( "classpath:applicationContext.xml" );
//        ToolApplyService toolApplyService = (ToolApplyService) ac.getBean( "toolApplyService" );
//
//        String var = UUID.randomUUID().toString();
//        ToolApplyModifyCostReqDTO toolApplyModifyCostReqDTO = new ToolApplyModifyCostReqDTO();
//
//        Result<String> result = toolApplyService.modifyCost( toolApplyModifyCostReqDTO );
//        System.out.println( "****************************************" );
//        System.out.println( "是否成功:" + result.isSuccess() );
//        System.out.println( "错误码:" + result.getErrorCode() );
//        System.out.println( "错误描述:" + result.getErrorMsg() );
//        System.out.println( "结果集:" + result.getResult() );
//        System.out.println( "响应错误码:" + result.getPrimaryErrorCode() );
//        System.out.println( "响应错误信息:" + result.getPrimaryErrorMsg() );
//        System.out.println( "响应机器IP:" + result.getPrimaryErrorIP() );
//
//    }
//}
