package Ledger;

import com.bestpay.dubbo.result.Result;
import com.bestpay.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.bestpay.marketing.ledger.api.HisCouponService;
import com.bestpay.marketing.ledger.api.enummodel.EquityTypeEnum;
import com.bestpay.marketing.ledger.api.models.VerifySharingInfoDTO;
import com.bestpay.marketing.ledger.api.models.request.HisCouponDirectRefundRequestDTO;
import com.bestpay.marketing.ledger.api.models.request.HisCouponVerifyRequestDTO;
import com.bestpay.marketing.ledger.api.models.result.HisCouponDirectRefundResultDTO;
import com.bestpay.marketing.ledger.api.models.result.HisCouponVerifyResultDTO;
import com.bestpay.utils.DateUtil;
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
 * Created by wangyan on 2019/6/21.
 * 老红包金核销接口
 */
public class DoDirectRefundForHisCouponTest {
    @Autowired
    ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    HisCouponService hisCouponService = (HisCouponService) ac.getBean("hisCouponService");

    //老红包金核销接口
    @Test//(invocationCount = 100, threadPoolSize = 10,groups = { "t9"})
    public void doVerifyForHisCouponTest() throws Exception {
        HisCouponVerifyRequestDTO hisCouponVerifyRequestDTO = new HisCouponVerifyRequestDTO();
        String transLogId = UUID.randomUUID().toString();
        String requestno = "ZZ" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        hisCouponVerifyRequestDTO.setOriginalRequestNo("ZZ20190620105730994");
        hisCouponVerifyRequestDTO.setOriginalRequestSystem("Test");
        hisCouponVerifyRequestDTO.setOriginalRequestDate(DateUtil.parse("20190620"));

        hisCouponVerifyRequestDTO.setVerifyType("REVOKE");//权益类型
        //消费	CONSUME
//        撤销	CANCEL
//        退款	REFUND
//        冲正	REVOKE
        hisCouponVerifyRequestDTO.setEquityType(EquityTypeEnum.HIS_COUPON.getCode());//权益类型
        hisCouponVerifyRequestDTO.setEquityNo("E011121111");//权益编号
        hisCouponVerifyRequestDTO.setAccountNo("66000000000000132156");//个人红包金账户
        hisCouponVerifyRequestDTO.setRelationNo("TRA201909090");//关联号
        hisCouponVerifyRequestDTO.setTradeAmt(2L);
        hisCouponVerifyRequestDTO.setDiscountAmt(1L);

//        hisCouponVerifyRequestDTO.setRequestNo(requestno);
        hisCouponVerifyRequestDTO.setRequestNo("ZZ20190620143104323");
        hisCouponVerifyRequestDTO.setRequestDate(DateUtil.parse("20190620"));
        hisCouponVerifyRequestDTO.setRequestSystem("Test");
        hisCouponVerifyRequestDTO.setTraceLogId(transLogId);
        List<VerifySharingInfoDTO> verifySharingInfoDTO = new ArrayList<VerifySharingInfoDTO>();
        verifySharingInfoDTO.add(verifySharingInfoDTO1());
        verifySharingInfoDTO.add(verifySharingInfoDTO2());
        verifySharingInfoDTO.add(verifySharingInfoDTO3());
        hisCouponVerifyRequestDTO.setVerifySharingInfoDTOList(verifySharingInfoDTO);

        Result<HisCouponVerifyResultDTO> result = hisCouponService.doVerifyForHisCoupon(hisCouponVerifyRequestDTO);

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("日志编号:" + transLogId);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("result:" + result);

        System.out.println("系统实际返回错误码:" + result.getErrorCode());
        System.out.println("系统实际返回错误信息:" + result.getErrorMsg());
        System.out.println("系统实际返回是否成功:" + result.isSuccess());
        System.out.println("系统实际返回结果:" + result.getResult());
    }

    //老红包金强制退款接口
    @Test//(invocationCount = 100, threadPoolSize = 10,groups = { "t9"})
    public void doDirectRefundForHisCouponTest() throws Exception {
        HisCouponDirectRefundRequestDTO hisCouponDirectRefundRequestDTO = new HisCouponDirectRefundRequestDTO();

        String transLogId = UUID.randomUUID().toString();
        String requestno = "ZZ" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

        hisCouponDirectRefundRequestDTO.setVerifyType("CANCEL");//核销类型
//        消费	CONSUME
//        撤销	CANCEL
//        退款	REFUND
//        冲正	REVOKE
        hisCouponDirectRefundRequestDTO.setEquityType(EquityTypeEnum.HIS_COUPON_DIRECT_REFUND.getCode());//权益类型
        //COUPON
        //HIS_COUPON
        hisCouponDirectRefundRequestDTO.setEquityNo("E011121111");//权益编号
        hisCouponDirectRefundRequestDTO.setRelationNo("TRA201909090");//关联号
        hisCouponDirectRefundRequestDTO.setTradeAmt(2L);
        hisCouponDirectRefundRequestDTO.setDiscountAmt(1L);
        hisCouponDirectRefundRequestDTO.setTransInAccountNo("66000000000000132156");
        hisCouponDirectRefundRequestDTO.setTransOutAccountNo("881225080000019156");

//        hisCouponDirectRefundRequestDTO.setRequestNo(requestno);
        hisCouponDirectRefundRequestDTO.setRequestNo("ZZ20190618171830186001");

        hisCouponDirectRefundRequestDTO.setRequestDate(DateUtil.parse("20190911"));
        hisCouponDirectRefundRequestDTO.setRequestSystem("Test");//请求系统
        hisCouponDirectRefundRequestDTO.setTraceLogId(transLogId);
        List<VerifySharingInfoDTO> verifySharingInfoDTO = new ArrayList<VerifySharingInfoDTO>();
        verifySharingInfoDTO.add(verifySharingInfoDTO1());
        verifySharingInfoDTO.add(verifySharingInfoDTO2());
        verifySharingInfoDTO.add(verifySharingInfoDTO3());
        hisCouponDirectRefundRequestDTO.setVerifySharingInfoDTOList(verifySharingInfoDTO);
        Result<HisCouponDirectRefundResultDTO> result = hisCouponService.doDirectRefundForHisCoupon(hisCouponDirectRefundRequestDTO);

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("日志编号:" + transLogId);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        System.out.println("系统实际返回错误码:" + result.getErrorCode());
        System.out.println("系统实际返回错误信息:" + result.getErrorMsg());
        System.out.println("系统实际返回是否成功:" + result.isSuccess());
        System.out.println("系统实际返回结果:" + result.getResult());
    }

    public VerifySharingInfoDTO verifySharingInfoDTO1() {
        VerifySharingInfoDTO verifySharingInfoDTO = new VerifySharingInfoDTO();
        verifySharingInfoDTO.setOrgType("ORG");//
        verifySharingInfoDTO.setOrgCode("3178002068640427");
        verifySharingInfoDTO.setVerifyRate("1");//分摊比例
        verifySharingInfoDTO.setAgreementType("31");//出资协议类型
        return verifySharingInfoDTO;
    }

    public VerifySharingInfoDTO verifySharingInfoDTO2() {
        VerifySharingInfoDTO verifySharingInfoDTO = new VerifySharingInfoDTO();
        verifySharingInfoDTO.setOrgType("ORG");//
        verifySharingInfoDTO.setOrgCode("3178002068640428");
        verifySharingInfoDTO.setVerifyRate("1");//分摊比例
        verifySharingInfoDTO.setAgreementType("31");//出资协议类型
        return verifySharingInfoDTO;
    }

    public VerifySharingInfoDTO verifySharingInfoDTO3() {
        VerifySharingInfoDTO verifySharingInfoDTO = new VerifySharingInfoDTO();
        verifySharingInfoDTO.setOrgType("ORG");//
        verifySharingInfoDTO.setOrgCode("3178002068640429");
        verifySharingInfoDTO.setVerifyRate("1");//分摊比例
        verifySharingInfoDTO.setAgreementType("31");//出资协议类型
        return verifySharingInfoDTO;
    }
}
