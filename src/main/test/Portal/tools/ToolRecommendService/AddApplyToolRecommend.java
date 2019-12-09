package Portal.tools.ToolRecommendService;

import Customize.DataGenerate;
import Portal.CustomizedService;
import Portal.Preset;
import Portal.ToolDTO;
import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.config.api.enums.ActionTypeEnum;
import com.bestpay.marketing.config.api.enums.ApplyChannelEnum;
import com.bestpay.marketing.config.api.enums.ToolTypeEnum;

import java.util.Date;
import java.util.List;

import com.bestpay.marketing.config.api.tools.ToolRecommendService;
import com.bestpay.marketing.config.api.tools.request.ApplyToolRecommendReqDTO;
import com.bestpay.marketing.config.api.tools.response.ApplyToolRecommendResDTO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/9/9.
 * 申请推荐人工具
 */
public class AddApplyToolRecommend extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    static ToolRecommendService toolRecommendService = (ToolRecommendService) ac.getBean("toolRecommendService");

    @Test
    public static void addApplyToolRecommend() {
        CustomizedService customizedService = Preset.PresetTool();
        List<ToolDTO> toolDTOList = customizedService.getToolDTOList();
        ToolDTO toolDTO = new ToolDTO();
        for (int i = 0; i < toolDTOList.size(); i++) {
            toolDTO = toolDTOList.get(i);
        }

        ApplyToolRecommendReqDTO applyToolRecommendReqDTO = new ApplyToolRecommendReqDTO();
//        applyToolRecommendReqDTO.setApplyId("AI2770190916085832000001");//申请号
        applyToolRecommendReqDTO.setActionType(ActionTypeEnum.SUBMIT.getCode());//提交
//        applyToolRecommendReqDTO.setActionType(ActionTypeEnum.SAVE.getCode());//保存
        applyToolRecommendReqDTO.setApplyUser("DZHB_apply1");
        applyToolRecommendReqDTO.setApplyProvince("999900");
        applyToolRecommendReqDTO.setApplyCity("999901");
        applyToolRecommendReqDTO.setToolType(ToolTypeEnum.RECOMMEND.getCode());//推荐人工具
        applyToolRecommendReqDTO.setApplyChannel(ApplyChannelEnum.MIS.getCode());
//        applyToolRecommendReqDTO.setToolId("T30990190916085832000001");//工具号
        applyToolRecommendReqDTO.setApplyToolRecommendBasicInfoReqDTO(toolDTO.getApplyToolRecommendBasicInfoReqDTO());
        applyToolRecommendReqDTO.setApplyRecommendRuleReqDTO(toolDTO.getApplyRecommendRuleReqDTO());
        applyToolRecommendReqDTO.setApplyRecommendPreferentialReqDTO(toolDTO.getApplyRecommendPreferentialReqDTO());
        applyToolRecommendReqDTO.setApplyRecommendedRuleReqDTO(toolDTO.getApplyRecommendedRuleReqDTO());
//        applyToolRecommendReqDTO.setApplyAttachmentReqDTO(toolDTO.getApplyAttachmentReqDTO());
        applyToolRecommendReqDTO.setRequestNo("Req" + RandomStringNo());
        applyToolRecommendReqDTO.setRequestSystem("test");
        applyToolRecommendReqDTO.setRequestDate(new Date());
        applyToolRecommendReqDTO.setTraceLogId(TraceLogId());

        Result<ApplyToolRecommendResDTO> result = toolRecommendService.addApplyToolRecommend(applyToolRecommendReqDTO);
        System.out.println("********************推荐人工具申请********************");
        System.out.println("日志号:" + applyToolRecommendReqDTO.getTraceLogId());
        System.out.println("申请号:" + result.getResult().getApplyId());
        System.out.println("工具号:" + result.getResult().getToolId());
        System.out.println("请求流水:" + applyToolRecommendReqDTO.getRequestNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());

        toolDTO.setToolId(result.getResult().getToolId());
        toolDTO.setApplyId(result.getResult().getApplyId());
    }
}
