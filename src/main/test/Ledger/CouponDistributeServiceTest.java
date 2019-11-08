package Ledger;

import com.xx.dubbo.result.Result;
import com.xx.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.xx.marketing.coupon.center.api.CouponDistributeService;
import com.xx.marketing.coupon.center.api.model.request.CouponBatchInfoReqDTO;
import com.xx.marketing.coupon.center.api.model.request.CouponDistributeDetialReqDTO;
import com.xx.marketing.coupon.center.api.model.request.CouponDistributeReqDTO;
import com.xx.marketing.coupon.center.api.model.request.CouponRecycleReqDTO;
import com.xx.marketing.coupon.center.api.model.response.CouponDistributeResDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * *Created by wangyan on 2019/6/21.
 * 券发放接口+回收
 */
public class CouponDistributeServiceTest {
    @Autowired
    ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    CouponDistributeService couponDistributeService = (CouponDistributeService) ac.getBean("couponDistributeService");

    //券发放接口
    @Test//(invocationCount = 100, threadPoolSize = 10,groups = { "t9"})
    public void distributeTest() throws Exception {
        CouponDistributeReqDTO couponDistributeReqDTO = new CouponDistributeReqDTO();
        String traceLogId = UUID.randomUUID().toString();
        String requestno = "ZZ" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

        couponDistributeReqDTO.setRequestNo(requestno);
        couponDistributeReqDTO.setRequestSystem("Test");
        couponDistributeReqDTO.setProductNo("13854252186");
        //18192089766     3177000040029029
        //18192089767   3177000040029113
        couponDistributeReqDTO.setRelationNo("wy20190621001");
        couponDistributeReqDTO.setContractNo("3177002084910178");
        //3177000040029029

        //批次金额
        List<CouponDistributeDetialReqDTO> couponDistributeDetials = new ArrayList<CouponDistributeDetialReqDTO>();
        CouponDistributeDetialReqDTO couponDistributeDetialReqDTO1 = new CouponDistributeDetialReqDTO();
        couponDistributeDetialReqDTO1.setCouponAmt(200L);
        couponDistributeDetials.add(couponDistributeDetialReqDTO1);

        //券批次列表-可多批次发券
        List<CouponBatchInfoReqDTO> couponBatchLists = new ArrayList<CouponBatchInfoReqDTO>();

        //批次1
        CouponBatchInfoReqDTO couponBatchInfoReqDTO1 = new CouponBatchInfoReqDTO();
        couponBatchInfoReqDTO1.setBatchNo("E21000190705164945000042");//券批次

        //单个成本分摊方
        //新批次:E21000190625110922000103
        //老批次:E201906241639499978ad54d27

        //多个成本分摊方
        //新批次:E21000190625182339000013
        //老批次:E20190624202505041779af8ad
        //老红包金单分摊方，通用券:E201906241639499978ad54d27
        //老红包金多分摊方，通用券:E2019062610075394304b3e61f
        //新红包金，通用券，单个分摊方:E21000190625110922000103
        //新红包金，通用券，多个分摊方:E21000190625182339000013


        couponBatchInfoReqDTO1.setBatchDistributeCount(7);
        couponBatchInfoReqDTO1.setCouponDistributeDetial(couponDistributeDetials);
        couponBatchLists.add(couponBatchInfoReqDTO1);

//        //批次2
//        CouponBatchInfoReqDTO couponBatchInfoReqDTO2 = new CouponBatchInfoReqDTO();
//        couponBatchInfoReqDTO2.setBatchNo("E20190624202505041779af8ad");//券批次
//        couponBatchInfoReqDTO2.setBatchDistributeCount(2);
//        couponBatchInfoReqDTO2.setCouponDistributeDetial(couponDistributeDetials);
//        couponBatchLists.add(couponBatchInfoReqDTO2);


        couponDistributeReqDTO.setCouponBatchList(couponBatchLists);//批次列表

        Result<List<CouponDistributeResDTO>> result = couponDistributeService.distribute(couponDistributeReqDTO, traceLogId);


        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("日志编号:" + traceLogId);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("result:" + result);

        System.out.println("系统实际返回错误码:" + result.getErrorCode());
        System.out.println("系统实际返回错误信息:" + result.getErrorMsg());
        System.out.println("系统实际返回是否成功:" + result.isSuccess());
        System.out.println("系统实际返回结果:" + result.getResult());
    }

    //券回收
    public void recycleTest() throws Exception {
        CouponRecycleReqDTO couponRecycleReqDTO = new CouponRecycleReqDTO();
        String traceLogId = UUID.randomUUID().toString();
        Result<Boolean> result = couponDistributeService.recycle(couponRecycleReqDTO, traceLogId);


        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("日志编号:" + traceLogId);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("result:" + result);

        System.out.println("系统实际返回错误码:" + result.getErrorCode());
        System.out.println("系统实际返回错误信息:" + result.getErrorMsg());
        System.out.println("系统实际返回是否成功:" + result.isSuccess());
        System.out.println("系统实际返回结果:" + result.getResult());


    }

}
