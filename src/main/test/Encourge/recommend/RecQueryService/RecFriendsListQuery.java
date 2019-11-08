package Encourge.recommend.RecQueryService;

import Customize.DataGenerate;
import Encourge.recommend.RecommendService;
import com.xx.dubbo.result.Result;
import com.xx.marketing.recommend.api.RecQueryService;
import com.xx.marketing.recommend.api.models.request.RecFriendsListQueryReqDTO;
import com.xx.marketing.recommend.api.models.response.RecFriendsListQueryResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/9/6.
 * 推荐人好友列表分页查询
 */
public class RecFriendsListQuery extends DataGenerate {
    static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    static RecQueryService recQueryService = (RecQueryService) applicationContext.getBean("recQueryService");
    static RecommendService recommendService = new RecommendService();

    @Test
    public static void recFriendsListQuery() {
        RecFriendsListQueryReqDTO recFriendsListQueryReqDTO = new RecFriendsListQueryReqDTO();
        recFriendsListQueryReqDTO.setToolId(recommendService.getToolId());
        recFriendsListQueryReqDTO.setProductNo(recommendService.getProductNo());
        recFriendsListQueryReqDTO.setPageSize(0);
        recFriendsListQueryReqDTO.setPageNo(0);
        recFriendsListQueryReqDTO.setTraceLogId(TraceLogId());

        Result<RecFriendsListQueryResDTO> result = recQueryService.recFriendsListQuery(recFriendsListQueryReqDTO);
        System.out.println("********************推荐人好友列表分页查询********************");
        System.out.println("日志号:" + recFriendsListQueryReqDTO.getTraceLogId());
        System.out.println("工具号:" + recFriendsListQueryReqDTO.getToolId());
        System.out.println("推荐人手机号:" + recFriendsListQueryReqDTO.getProductNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
