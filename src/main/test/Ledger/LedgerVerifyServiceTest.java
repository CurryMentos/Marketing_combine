package Ledger;

import com.bestpay.dubbo.result.Result;
import com.bestpay.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.bestpay.marketing.ledger.api.LedgerVerifyService;
import com.bestpay.marketing.ledger.api.enummodel.EquityTypeEnum;
import com.bestpay.marketing.ledger.api.models.VerifySharingInfoDTO;
import com.bestpay.marketing.ledger.api.models.request.VerifyRequestDTO;
import com.bestpay.marketing.ledger.api.models.result.VerifyResultDTO;
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
 * Created by wangyan on 2017/7/26.
 * 台账核销受理接口
 */
public class LedgerVerifyServiceTest {
    @Autowired
    ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    LedgerVerifyService ledgerVerifyService = (LedgerVerifyService) ac.getBean("ledgerVerifyService");

    //台账核销受理接口
    @Test//(invocationCount = 100, threadPoolSize = 10,groups = { "t9"})
    public void doVerifyForHisCouponTest() throws Exception {
        VerifyRequestDTO verifyRequestDTO = new VerifyRequestDTO();
        verifyRequestDTO.setContractNo("");
        String transLogId = UUID.randomUUID().toString();
        String requestno = "ZZ" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        verifyRequestDTO.setOriginalRequestNo("ZZ20190620105730994");
        verifyRequestDTO.setOriginalRequestSystem("Test");
        verifyRequestDTO.setOriginalRequestDate(DateUtil.parse("20190620"));

        verifyRequestDTO.setVerifyType("REVOKE");//权益类型
        //消费	CONSUME
//        撤销	CANCEL
//        退款	REFUND
//        冲正	REVOKE
        verifyRequestDTO.setEquityType(EquityTypeEnum.HIS_COUPON.getCode());//权益类型
        verifyRequestDTO.setEquityNo("E011121111");//权益编号
        verifyRequestDTO.setRelationNo("TRA201909090");//关联号
        verifyRequestDTO.setTradeAmt(2L);
        verifyRequestDTO.setDiscountAmt(1L);

//        hisCouponVerifyRequestDTO.setRequestNo(requestno);
        verifyRequestDTO.setRequestNo("ZZ20190620143104323");
        verifyRequestDTO.setRequestDate(DateUtil.parse("20190620"));
        verifyRequestDTO.setRequestSystem("Test");
        verifyRequestDTO.setTraceLogId(transLogId);
        List<VerifySharingInfoDTO> verifySharingInfoDTO = new ArrayList<VerifySharingInfoDTO>();
        verifySharingInfoDTO.add(verifySharingInfoDTO1());
        verifySharingInfoDTO.add(verifySharingInfoDTO2());
        verifySharingInfoDTO.add(verifySharingInfoDTO3());
        verifyRequestDTO.setVerifySharingInfoDTOList(verifySharingInfoDTO);
        Result<VerifyResultDTO> result = ledgerVerifyService.doVerify(verifyRequestDTO);

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("日志编号:" + transLogId);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("result:" + result);

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
