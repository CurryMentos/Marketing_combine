package Portal.tools.ToolService;

import java.util.Date;

import Customize.DataGenerate;
import com.xx.dubbo.result.Result;
import com.xx.marketing.config.api.tools.ToolService;
import com.xx.marketing.config.api.tools.request.QueryToolDetailReqDTO;
import com.xx.marketing.config.api.tools.response.QueryEncourageToolDetailResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by zengyouzu on 2019/9/9.
 * 双向激励工具详情查询
 */
public class QueryEncourageToolDetail extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    static ToolService toolService = (ToolService) ac.getBean("toolService");

    public static void queryEncourageToolDetail() throws Exception {
        QueryToolDetailReqDTO queryToolDetailReqDTO = new QueryToolDetailReqDTO();
        queryToolDetailReqDTO.setToolId("T"+RandomStringNo());
        queryToolDetailReqDTO.setTranslateFlag(false);
        queryToolDetailReqDTO.setRequestNo("Req"+RandomStringNo());
        queryToolDetailReqDTO.setRequestSystem("test");
        queryToolDetailReqDTO.setRequestDate(new Date());
        queryToolDetailReqDTO.setTraceLogId(TraceLogId());

        Result<QueryEncourageToolDetailResDTO> result = toolService.queryEncourageToolDetail(queryToolDetailReqDTO);
        System.out.println("********************双向激励工具详情查询********************");
        System.out.println("日志号:" + queryToolDetailReqDTO.getTraceLogId());
        System.out.println("工具号:"+queryToolDetailReqDTO.getToolId());
        System.out.println("请求流水:"+queryToolDetailReqDTO.getRequestNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
