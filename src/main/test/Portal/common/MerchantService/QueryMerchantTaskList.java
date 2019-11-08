package Portal.common.MerchantService;

import com.xx.dubbo.result.Result;
import com.xx.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.xx.marketing.config.api.activity.models.PageInfoDTO;
import com.xx.marketing.config.api.common.MerchantService;
import com.xx.marketing.config.api.common.models.request.QueryMerchantTaskReqDTO;
import com.xx.marketing.config.api.common.models.response.MerchantTaskResDTO;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * Created by Administrator on 2019/10/31.
 */
public class QueryMerchantTaskList {
    MerchantService merchantService = BeanUtil.getBean("merchantService");

    //商户维护界面信息查询接口
    @Test
    public void queryMerchantTaskList() throws Exception {
        String traceLogId = UUID.randomUUID().toString();
        QueryMerchantTaskReqDTO queryMerchantTaskReqDTO = new QueryMerchantTaskReqDTO();
        queryMerchantTaskReqDTO.setRelationId("E30990190909095721000085");//关联编号
        queryMerchantTaskReqDTO.setRelationType("");//关联类型
        //推荐人工具：RECOMMEND，双向激励工具：ENCOURAGE，商户红包工具：MERCHANT_REDBAG；
        //活动：ACTIVITY；
        //代金券权益：VOUCHER，红包金权益：COUPON
        queryMerchantTaskReqDTO.setStartTime("");//开始时间
        queryMerchantTaskReqDTO.setEndTime("");//结束时间
        queryMerchantTaskReqDTO.setStatus("");//状态
        //待校验：TO_CHECK
        //校验中：CHECK_PROCESSING
        //校验成功：CHECK_SUCCESS
        //校验失败：CHECK_FAIL
        //生效中：EFFECT_PROCESSING
        //生效成功：EFFECT_SUCCESS
        //生效失败：EFFECT_FAIL
        //待添加商品：TO_ADD_GOODS
        queryMerchantTaskReqDTO.setPageSize(1);//分页大小
        queryMerchantTaskReqDTO.setPageNo(1);//当前页数
        queryMerchantTaskReqDTO.setTraceLogId(traceLogId);

        Result<PageInfoDTO<MerchantTaskResDTO>> result = merchantService.queryMerchantTaskList(queryMerchantTaskReqDTO);
        System.out.println("是否成功：" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
        System.out.println("日志:" + traceLogId);
    }
}
