package Portal.tools.ToolRecommendService;

import java.util.Date;
import java.util.List;

import Customize.DataGenerate;
import Portal.CustomizedService;
import Portal.Preset;
import Portal.ToolDTO;
import com.xx.dubbo.result.Result;
import com.xx.marketing.config.api.tools.ToolRecommendService;
import com.xx.marketing.config.api.tools.request.QueryToolApplyDetailReqDTO;
import com.xx.marketing.config.api.tools.response.ApplyToolRecommendDetailResDTO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/9/9.
 * 查询推荐人工具
 */
public class QueryToolRecommendDetail extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    static ToolRecommendService toolRecommendService = (ToolRecommendService) ac.getBean("toolRecommendService");

    @BeforeTest
    public static void beforeTest(){
        AddApplyToolRecommend.addApplyToolRecommend();
    }
    @Test
    public static void queryToolRecommendDetail() throws Exception {
        CustomizedService customizedService = Preset.PresetTool();
        List<ToolDTO> toolDTOList = customizedService.getToolDTOList();
        ToolDTO toolDTO = new ToolDTO();
        for (int i = 0; i < toolDTOList.size(); i++) {
            toolDTO = toolDTOList.get(i);
        }

        QueryToolApplyDetailReqDTO queryToolApplyDetailReqDTO = new QueryToolApplyDetailReqDTO();
        queryToolApplyDetailReqDTO.setToolId(toolDTO.getToolId());
        queryToolApplyDetailReqDTO.setApplyId(toolDTO.getApplyId());
        queryToolApplyDetailReqDTO.setTranslateFlag(false);
        queryToolApplyDetailReqDTO.setRequestNo("Req" + RandomStringNo());
        queryToolApplyDetailReqDTO.setRequestSystem("test");
        queryToolApplyDetailReqDTO.setRequestDate(new Date());
        queryToolApplyDetailReqDTO.setTraceLogId(TraceLogId());

        Result<ApplyToolRecommendDetailResDTO> result = toolRecommendService.queryToolRecommendDetail(queryToolApplyDetailReqDTO);
        System.out.println("*****************************************");
        System.out.println("日志号:" + queryToolApplyDetailReqDTO.getTraceLogId());
        System.out.println("申请号:" + queryToolApplyDetailReqDTO.getApplyId());
        System.out.println("工具号:" + queryToolApplyDetailReqDTO.getToolId());
        System.out.println("请求流水:" + queryToolApplyDetailReqDTO.getRequestNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
    }
}
