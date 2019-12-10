package Portal.tools.ToolApplyService;//package tools.ToolApplyService;
//
//import com.xx.dubbo.result.Result;
//import com.xx.marketing.config.api.tools.ToolApplyService;
//import com.xx.marketing.config.api.tools.request.ToolApplyOperateReqDTO;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.testng.annotations.Test;
//
//import java.util.Date;
//import java.util.UUID;
//
///**
// * @Author: nerissa
// * @Date: 2019/6/19 09:45
// * @Description:
// *
// * 营销工具删除接口
// */
//public class RemoveApplyTool {
//    @Test
//    public static void removeApplyToolTest() throws Exception {
//        ApplicationContext ac = new ClassPathXmlApplicationContext( "classpath:applicationContext.xml" );
//        ToolApplyService toolApplyService = (ToolApplyService) ac.getBean( "toolApplyService" );
//
//        String var = UUID.randomUUID().toString();
//        ToolApplyOperateReqDTO toolApplyOperateReqDTO = new ToolApplyOperateReqDTO();
//        //申请人
//        toolApplyOperateReqDTO.setApplyUser("");
//        //申请编号
//        toolApplyOperateReqDTO.setApplyId("");
//        //工具ID
//        toolApplyOperateReqDTO.setToolId("");
//        toolApplyOperateReqDTO.setRequestNo("");
//        toolApplyOperateReqDTO.setRequestSystem("");
//        toolApplyOperateReqDTO.setRequestDate(new Date());
//        toolApplyOperateReqDTO.setTraceLogId(var);
//
//        Result<Boolean> result=toolApplyService.removeApplyTool(toolApplyOperateReqDTO);
//        System.out.println("****************************************");
//        System.out.println("是否成功:" + result.isSuccess());
//        System.out.println("错误码:" + result.getErrorCode());
//        System.out.println("错误描述:" + result.getErrorMsg());
//        System.out.println("结果集:" + result.getResult());
//        System.out.println("响应错误码:" + result.getPrimaryErrorCode());
//        System.out.println("响应错误信息:" + result.getPrimaryErrorMsg());
//        System.out.println("响应机器IP:" + result.getPrimaryErrorIP());
//    }
//}
