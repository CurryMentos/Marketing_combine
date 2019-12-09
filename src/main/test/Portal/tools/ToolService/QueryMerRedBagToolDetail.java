package Portal.tools.ToolService;

import Customize.DataGenerate;
import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.config.api.tools.ToolService;
import com.bestpay.marketing.config.api.tools.request.QueryToolDetailReqDTO;
import com.bestpay.marketing.config.api.tools.response.QueryMerRedBagToolDetailResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by zengyouzu on 2019/9/9.
 */
public class QueryMerRedBagToolDetail extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    static ToolService toolService = (ToolService) ac.getBean("toolService");

    public static void queryMerRedBagToolDetail()throws Exception{
        QueryToolDetailReqDTO queryToolDetailReqDTO = new QueryToolDetailReqDTO();
        queryToolDetailReqDTO.setToolId("T"+RandomStringNo());
        queryToolDetailReqDTO.setTranslateFlag(false);
        queryToolDetailReqDTO.setRequestNo("Req"+RandomStringNo());
        queryToolDetailReqDTO.setRequestSystem("test");
        queryToolDetailReqDTO.setRequestDate(new Date());
        queryToolDetailReqDTO.setTraceLogId(TraceLogId());

        Result<QueryMerRedBagToolDetailResDTO> result = toolService.queryMerRedBagToolDetail(queryToolDetailReqDTO);
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
