package Portal.tools.ToolApplyService;//package tools.ToolApplyService;
//
//import com.bestpay.dubbo.result.Result;
//import com.bestpay.marketing.config.api.tools.ToolApplyService;
//import com.bestpay.marketing.config.api.tools.request.QueryToolApplyDetailReqDTO;
//import com.bestpay.marketing.config.api.tools.response.ToolApplyDetailRespDTO;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.testng.annotations.Test;
//
//import java.util.UUID;
//
///**
// * @Author: nerissa
// * @Date: 2019/6/19 10:09
// * @Description:
// *
// * 营销工具草稿详情
// */
//public class QueryToolDetail {
//    @Test
//    public static void queryToolDetailTest() throws Exception {
//        ApplicationContext ac = new ClassPathXmlApplicationContext( "classpath:applicationContext.xml" );
//        ToolApplyService toolApplyService = (ToolApplyService) ac.getBean( "toolApplyService" );
//
//        String var = UUID.randomUUID().toString();
//        QueryToolApplyDetailReqDTO queryToolApplyDetailReqDTO = new QueryToolApplyDetailReqDTO();
//        queryToolApplyDetailReqDTO.setToolId( "" );
//        queryToolApplyDetailReqDTO.setTraceLogId( var );
//
//        Result<ToolApplyDetailRespDTO> result = toolApplyService.queryToolDetail( queryToolApplyDetailReqDTO );
//        System.out.println( "****************************************" );
//        System.out.println( "是否成功:" + result.isSuccess() );
//        System.out.println( "错误码:" + result.getErrorCode() );
//        System.out.println( "错误描述:" + result.getErrorMsg() );
//        System.out.println( "结果集:" + result.getResult() );
//        System.out.println( "响应错误码:" + result.getPrimaryErrorCode() );
//        System.out.println( "响应错误信息:" + result.getPrimaryErrorMsg() );
//        System.out.println( "响应机器IP:" + result.getPrimaryErrorIP() );
//
//        if (result.getResult() != null) {
//            System.out.println( "*******************************************" );
//            System.out.println( "申请编号:" + result.getResult().getApplyId() );
//            System.out.println( "工具编号:" + result.getResult().getToolId() );
//            System.out.println( "工具类型:" + result.getResult().getToolType() );
//            System.out.println( "申请人:" + result.getResult().getApplyUser() );
//            System.out.println( "工具基本信息:" + result.getResult().getToolBasicInfoDTO() );
//            System.out.println( "规则请求体:" + result.getResult().getActivityRuleApplyRespDTO() );
//            System.out.println( "限额规则请求体:" + result.getResult().getLimitRuleApplyRespDTO() );
//            System.out.println( "优惠规则请求体:" + result.getResult().getPreferentialApplyRespDTO() );
//            System.out.println( "展示信息:" + result.getResult().getActivityShowShopApplyRespDTO() );
//            System.out.println( "附件信息:" + result.getResult().getAttachmentDTOList() );
//
//        }
//    }
//}
//
