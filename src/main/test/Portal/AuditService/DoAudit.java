package Portal.AuditService;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Date;

import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.config.api.audit.AuditService;
import com.bestpay.marketing.config.api.audit.models.request.AuditReqDTO;
import com.bestpay.marketing.config.api.audit.models.response.AuditResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.List;
import java.util.UUID;

/**
 * Created by zengyouzu on 2019/6/18.
 * <p/>
 * 审核接口(同意,驳回)
 */
public class DoAudit {
    @Test
    public static void doAuditTest() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AuditService auditService = (AuditService) ac.getBean("auditService");

        String var = UUID.randomUUID().toString();
        AuditReqDTO auditReqDTO = new AuditReqDTO();

        //申请ID
        auditReqDTO.setApplyId("");
        //用户ID
        auditReqDTO.setApplyUser("");
        //角色信息List
        List<String> roleGroupList = new ArrayList<>();
        roleGroupList.add("");
        auditReqDTO.setRoleGroup(roleGroupList);
        //任务ID
        auditReqDTO.setTaskId("");
        //流程实例ID
        auditReqDTO.setProcessInstanceId("");
        //申请类型(ACTIVITY：活动 TOOL：工具)
        auditReqDTO.setApplyModel("");
        //审核状态(AGREE：同意  REJECT：驳回 )
        auditReqDTO.setAuditFlag("");
        //审核理由
        auditReqDTO.setAuditReason("");
        //审核时间(yyyyMMddHHmmss)
        auditReqDTO.setAuditTime(new Date());
        //请求系统
        auditReqDTO.setRequestSystem("");
        //请求时间(yyyyMMddHHmmss)
        auditReqDTO.setRequestDate(new Date());
        //请求流水
        auditReqDTO.setRequestNo("");
        auditReqDTO.setTraceLogId(var);
        auditReqDTO.setTmsFinance("");
        auditReqDTO.setAuditStatus("");
        auditReqDTO.setTaskName("");

        Result<AuditResDTO> result = auditService.doAudit(auditReqDTO);
        System.out.println("****************************************");
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误描述:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
        System.out.println("响应错误码:" + result.getPrimaryErrorCode());
        System.out.println("响应错误信息:" + result.getPrimaryErrorMsg());
        System.out.println("响应机器IP:" + result.getPrimaryErrorIP());

        if (result.getResult() != null) {
            System.out.println("*********************************");
            System.out.println("处理状态(审核业务是否成功)" + result.getResult().getHandleStatus());

        }
    }
}
