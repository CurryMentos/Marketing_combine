package Portal.tools.ToolApplyService;//package tools.ToolApplyService;
//import com.google.common.collect.Lists;
//import java.util.Date;
//
//import com.bestpay.dubbo.result.Result;
//import com.bestpay.marketing.config.api.tools.ToolApplyService;
//import com.bestpay.marketing.config.api.tools.request.ToolApplyQueryReqDTO;
//import com.bestpay.marketing.config.api.tools.response.ToolApplyInfoDTO;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.testng.annotations.Test;
//
//import java.util.List;
//import java.util.UUID;
//
///**
// * @Author: nerissa
// * @Date: 2019/6/18 16:32
// * @Description:
// *
// * 工具已申请列表查询接口
// */
//public class QueryAppliedList {
//    @Test
//    public static void queryAppliedListTest() throws Exception {
//        ApplicationContext ac = new ClassPathXmlApplicationContext( "classpath:applicationContext.xml" );
//        ToolApplyService toolApplyService = (ToolApplyService) ac.getBean( "toolApplyService" );
//
//        String var = UUID.randomUUID().toString();
//        ToolApplyQueryReqDTO toolApplyQueryReqDTO = new ToolApplyQueryReqDTO();
//        //查询类型
//        toolApplyQueryReqDTO.setQueryType("");
//        //用户角色组
//        toolApplyQueryReqDTO.setRoleGroup(Lists.newArrayList());
//        //申请人
//        toolApplyQueryReqDTO.setApplyUser("");
//        //申请编号
//        toolApplyQueryReqDTO.setApplyId("");
//        //工具编号
//        toolApplyQueryReqDTO.setToolId("");
//        //工具名称
//        toolApplyQueryReqDTO.setToolName("");
//        //申请省份
//        toolApplyQueryReqDTO.setApplyProvince("");
//        //申请地市
//        toolApplyQueryReqDTO.setApplyCity("");
//        //申请类型
//        toolApplyQueryReqDTO.setApplyModel("");
//        //流转开始时间
//        toolApplyQueryReqDTO.setStartTime("");
//        //流转结束时间
//        toolApplyQueryReqDTO.setEndTime("");
//        //工具状态
//        toolApplyQueryReqDTO.setToolStatus("");
//        //工具所属事业群/部门
//        toolApplyQueryReqDTO.setApplyDepartment("");
//        toolApplyQueryReqDTO.setTraceLogId(var);
//        //工具类型
//        toolApplyQueryReqDTO.setToolType("");
//        //审核状态
//        toolApplyQueryReqDTO.setAuditStatus("");
//        //请求系统
//        toolApplyQueryReqDTO.setRequestSystem("");
//        //开始查询条数(开始查询数量从0开始，且不得小于0)
//        toolApplyQueryReqDTO.setFirstResult(0);
//        //每页显示条数(每页显示数量不得小于0，且不得大于30)
//        toolApplyQueryReqDTO.setMaxResults(0);
//        toolApplyQueryReqDTO.setRequestNo("");
//        toolApplyQueryReqDTO.setRequestSystem("");
//        toolApplyQueryReqDTO.setRequestDate(new Date());
//
//        Result<List<ToolApplyInfoDTO>> result = toolApplyService.queryList( toolApplyQueryReqDTO );
//        System.out.println( "********************************" );
//        System.out.println( "是否成功:" + result.isSuccess() );
//        System.out.println( "错误码:" + result.getErrorCode() );
//        System.out.println( "错误描述:" + result.getErrorMsg() );
//        System.out.println( "结果集:" + result.getResult() );
//        System.out.println( "响应错误码:" + result.getPrimaryErrorCode() );
//        System.out.println( "响应错误信息:" + result.getPrimaryErrorMsg() );
//        System.out.println( "响应机器IP:" + result.getPrimaryErrorIP() );
//
//        if (result.getResult() != null) {
//            List<ToolApplyInfoDTO> list = result.getResult();
//            for (ToolApplyInfoDTO dto : list) {
//                System.out.println( "*********************************" );
//                System.out.println( "申请编号" + dto.getApplyId() );
//                System.out.println( "工具编号" + dto.getToolId() );
//                System.out.println( "工具名称" + dto.getToolName() );
//                System.out.println( "工具类型" + dto.getToolType() );
//                System.out.println( "申请省份" + dto.getApplyProvince() );
//                System.out.println( "所属部门" + dto.getApplyDepartment() );
//                System.out.println( "申请时间" + dto.getApplyDate() );
//                System.out.println( "流转时间" + dto.getWorkflowTime() );
//                System.out.println( "申请人" + dto.getApplyUser() );
//                System.out.println( "工具状态" + dto.getToolStatus() );
//                System.out.println( "任务ID" + dto.getTaskId() );
//
//            }
//        }
//    }
//}
