package Portal.common.ApplyService;

import com.xx.dubbo.result.Result;
import com.xx.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.xx.marketing.config.api.activity.models.PageInfoDTO;
import com.xx.marketing.config.api.activity.models.request.QueryApplyTypeReqDTO;
import com.xx.marketing.config.api.common.ApplyService;
import com.xx.marketing.config.api.common.MerchantService;
import com.xx.marketing.config.api.common.models.request.QueryRosterStoreReqDTO;
import com.xx.marketing.config.api.common.models.request.RetryRosterTaskReqDTO;
import com.xx.marketing.config.api.common.models.response.RosterStoreResDTO;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * Created by Administrator on 2019/11/4.
 */
public class ApplyRetryRosterTask {
    ApplyService applyService = BeanUtil.getBean("applyService");
    @BeforeTest
    public void setup() throws Exception {

    }

    //校验/生效失败重试接口
    @Test
    public void applyRetryRosterTask() throws Exception {
        String traceLogId = UUID.randomUUID().toString();
        RetryRosterTaskReqDTO retryRosterTaskReqDTO = new RetryRosterTaskReqDTO();
        retryRosterTaskReqDTO.setBizId("E30990190909095721000085");//业务编号
        retryRosterTaskReqDTO.setStatus("");//状态
        retryRosterTaskReqDTO.setTraceLogId(traceLogId);

        Result<Boolean> result = applyService.applyRetryRosterTask(retryRosterTaskReqDTO);
        System.out.println("是否成功：" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
        System.out.println("日志:" + traceLogId);
    }
}
