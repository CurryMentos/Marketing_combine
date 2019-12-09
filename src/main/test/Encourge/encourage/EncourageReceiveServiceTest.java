package Encourge.encourage;

import Customize.UserList;
import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.encourage.api.EncourageReceiveService;
import com.bestpay.marketing.encourage.api.models.request.ReceiveEquityReqDTO;
import com.bestpay.marketing.encourage.api.models.response.ReceiveEquityResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class EncourageReceiveServiceTest {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static EncourageReceiveService encourageReceiveService = (EncourageReceiveService) ac.getBean("encourageReceiveService");

    static String RandomStringNo() {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i <= 23; i++) {
            int randomNum = random.nextInt(9);
            String num = randomNum + "";
            stringBuffer = stringBuffer.append(num);
        }

        String randomRequestNo = String.valueOf(stringBuffer);
        return randomRequestNo;
    }

    //扫码领取权益
    @Test
    public static void applyQrCodeBatch() throws Exception {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");

        ReceiveEquityReqDTO receiveEquityReqDTO = new ReceiveEquityReqDTO();
        receiveEquityReqDTO.setQrCodeId("11");
        receiveEquityReqDTO.setDeviceNo(UserList.DeviceNo());
        receiveEquityReqDTO.setOperatorNo(UserList.MerchantNo());
        receiveEquityReqDTO.setRequestNo("Req" + RandomStringNo());
        receiveEquityReqDTO.setRequestSystem("test");
        receiveEquityReqDTO.setRequestDate(new Date());
        receiveEquityReqDTO.setTraceLogId(traceLogId);

        Result<ReceiveEquityResDTO> result = encourageReceiveService.receiveEquity(receiveEquityReqDTO);
        System.out.println("********************扫码领取权益********************");
        System.out.println("日志:" + traceLogId);
        System.out.println("DeviceNo:" + receiveEquityReqDTO.getDeviceNo());
        System.out.println("OperatorNo:" + receiveEquityReqDTO.getOperatorNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
    }
}
