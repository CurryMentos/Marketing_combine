package Portal.common.MerchantService;

import Customize.DataGenerate;
import com.alibaba.fastjson.JSON;
import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.config.api.activity.models.PageInfoDTO;
import com.bestpay.marketing.config.api.common.MerchantService;
import com.bestpay.marketing.config.api.common.models.request.QueryMerchantTaskReqDTO;
import com.bestpay.marketing.config.api.common.models.response.MerchantTaskResDTO;
import com.bestpay.marketing.roster.api.enums.RelationTypeEnum;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * Created by Administrator on 2019/10/31.
 * 商户维护页面查询接口
 */
public class QueryMerchantTaskList extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static MerchantService merchantService = (MerchantService)ac.getBean("merchantService");

    @Test
    public static void queryMerchantTaskList() {
        QueryMerchantTaskReqDTO queryMerchantTaskReqDTO = new QueryMerchantTaskReqDTO();
//        queryMerchantTaskReqDTO.setRelationId("T20990191114175248000013");//关联编号
//        queryMerchantTaskReqDTO.setRelationType(RelationTypeEnum.ENCOURAGE.getCode());//关联类型
        //推荐人工具：RECOMMEND，双向激励工具：ENCOURAGE，商户红包工具：MERCHANT_REDBAG；
        //活动：ACTIVITY；
        //代金券权益：VOUCHER，红包金权益：COUPON
        queryMerchantTaskReqDTO.setStartTime(("2019-11-14 17:59:37").substring(0,10));//开始时间
        queryMerchantTaskReqDTO.setEndTime(("2019-11-15 16:26:40").substring(0,10));//结束时间
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
        queryMerchantTaskReqDTO.setTraceLogId(TraceLogId());

        Result<PageInfoDTO<MerchantTaskResDTO>> result = merchantService.queryMerchantTaskList(queryMerchantTaskReqDTO);
        System.out.println("****************************************");
        System.out.println("日志:" + queryMerchantTaskReqDTO.getTraceLogId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());

        PageInfoDTO<MerchantTaskResDTO> merchantTaskResDTOPageInfoDTO = result.getResult();
        String json = JSON.toJSONString(merchantTaskResDTOPageInfoDTO,true);
        System.out.println(json);
    }
}

