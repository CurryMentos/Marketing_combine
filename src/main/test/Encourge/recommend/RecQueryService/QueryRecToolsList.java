package Encourge.recommend.RecQueryService;

import Customize.DataGenerate;
import Encourge.recommend.RecommendService;
import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.recommend.api.RecQueryService;
import com.bestpay.marketing.recommend.api.models.request.RecToolsReqDTO;
import com.bestpay.marketing.recommend.api.models.response.RecToolsResDTO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/9/6.
 * 工具列表分页查询
 */
public class QueryRecToolsList extends DataGenerate {
    static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    static RecQueryService recQueryService = (RecQueryService) applicationContext.getBean("recQueryService");
    static RecommendService recommendService = new RecommendService();

    @Test
    public static void queryRecToolsList() {
        RecToolsReqDTO recToolsReqDTO = new RecToolsReqDTO();
        recToolsReqDTO.setToolId(recommendService.getToolId());
        recToolsReqDTO.setToolName("");
        recToolsReqDTO.setAdaptProvince("");//适用省份
        recToolsReqDTO.setToolType("");//工具类型
        recToolsReqDTO.setStartStartTime(Start);//开始时间的开始时间
        recToolsReqDTO.setStartEndTime(StartEnd);//开始时间的结束时间
        recToolsReqDTO.setEndStartTime(EndStart);//结束时间的开始时间
        recToolsReqDTO.setEndEndTime(End);//结束时间的结束时间
//        recToolsReqDTO.setActivityState("");//活动状态
        recToolsReqDTO.setApplyDepartment("");//所属部门
        recToolsReqDTO.setPageSize(0);//每页显示条数
        recToolsReqDTO.setPageNo(0);//页码
        recToolsReqDTO.setTraceLogId(TraceLogId());

        Result<RecToolsResDTO> result = recQueryService.queryRecToolsList(recToolsReqDTO);
        System.out.println("********************工具列表分页查询********************");
        System.out.println("日志号:" + recToolsReqDTO.getTraceLogId());
        System.out.println("工具号:" + recToolsReqDTO.getToolId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
