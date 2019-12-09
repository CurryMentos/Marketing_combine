package Encourge.encourage;

import Customize.UserList;
import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.encourage.api.EncourageConfigService;
import com.bestpay.marketing.encourage.api.enums.BindTypeEnum;
import com.bestpay.marketing.encourage.api.enums.MerchantTypeEnum;
import com.bestpay.marketing.encourage.api.models.request.ActivationQrCodeReqDTO;
import com.bestpay.marketing.encourage.api.models.request.ApplyAndActivateQrCodeReqDTO;
import com.bestpay.marketing.encourage.api.models.request.ApplyQrCodeBatchReqDTO;
import com.bestpay.marketing.encourage.api.models.request.EncourageEffectReqDTO;
import com.bestpay.marketing.encourage.api.models.response.QrCodeDetailResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class EncourageConfigServiceTest {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static EncourageConfigService encourageConfigService = (EncourageConfigService) ac.getBean("encourageConfigService");
    static Date Before = Date.from(LocalDateTime.now(ZoneOffset.ofHours(8)).minusDays(10).withHour(0).withMinute(0).withSecond(0).toInstant(ZoneOffset.ofHours(8)));
    static Date After = Date.from(LocalDateTime.now(ZoneOffset.ofHours(8)).plusDays(8).withHour(23).withMinute(59).withSecond(59).toInstant(ZoneOffset.ofHours(8)));

    //随机生成流水
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

    //预制码批量生成接口
    @Test
    public static void applyQrCodeBatch() throws Exception {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");
        String batchName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "预置码";

        ApplyQrCodeBatchReqDTO applyQrCodeBatchReqDTO = new ApplyQrCodeBatchReqDTO();
        applyQrCodeBatchReqDTO.setApplyNum(10L);//生成数量
        applyQrCodeBatchReqDTO.setApplyProvince("999900");//申请省份
        applyQrCodeBatchReqDTO.setApplyUserId("zyz");//预制码申请人
        applyQrCodeBatchReqDTO.setBatchName(batchName);//申请名称
        applyQrCodeBatchReqDTO.setRequestNo("Req" + RandomStringNo());//请求流水
        applyQrCodeBatchReqDTO.setRequestSystem("test");//请求系统
        applyQrCodeBatchReqDTO.setRequestDate(new Date());//请求时间
        applyQrCodeBatchReqDTO.setTraceLogId(traceLogId);//日志号

        Result<String> result = encourageConfigService.applyQrCodeBatch(applyQrCodeBatchReqDTO);
        System.out.println("********************预制码批量生成********************");
        System.out.println("日志:" + traceLogId);
        System.out.println("请求流水:" + applyQrCodeBatchReqDTO.getRequestNo());
        System.out.println("请求时间:" + applyQrCodeBatchReqDTO.getRequestDate());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
    }

    //预制码激活接口
    @Test
    public static void activationQrCode() throws Exception {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");

        ActivationQrCodeReqDTO activationQrCodeReqDTO = new ActivationQrCodeReqDTO();
        activationQrCodeReqDTO.setQrCodeId("11");//二维码ID
        activationQrCodeReqDTO.setBindType(BindTypeEnum.MERCHANT.getCode());//绑定类型
        activationQrCodeReqDTO.setMerchantNo(UserList.MerchantNo());//商户号
        activationQrCodeReqDTO.setMerchantName("123");//商户名称
        activationQrCodeReqDTO.setMerchantType(MerchantTypeEnum.COMPANY.getCode());//商户类型
        activationQrCodeReqDTO.setMerchantOperatorNo(UserList.MerchantNo());//商户操作员号
        activationQrCodeReqDTO.setStoreNo("");//门店号
        activationQrCodeReqDTO.setStoreName("");//门店名称
        activationQrCodeReqDTO.setShopNo("");//店员编号
        activationQrCodeReqDTO.setShopName("");//店员名称
        activationQrCodeReqDTO.setShopProductNo(UserList.ContralNo());//店员手机号
        activationQrCodeReqDTO.setShopOperatorNo(UserList.MerchantNo());//店员操作员号
        activationQrCodeReqDTO.setRequestNo("Req" + RandomStringNo());//请求流水
        activationQrCodeReqDTO.setRequestSystem("test");//请求系统
        activationQrCodeReqDTO.setRequestDate(new Date());//请求时间
        activationQrCodeReqDTO.setTraceLogId(traceLogId);//日志号

        Result<Boolean> result = encourageConfigService.activationQrCode(activationQrCodeReqDTO);
        System.out.println("********************预制码激活********************");
        System.out.println("日志:" + traceLogId);
        System.out.println("请求流水:" + activationQrCodeReqDTO.getRequestNo());
        System.out.println("请求时间:" + activationQrCodeReqDTO.getRequestDate());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
    }

    //预制码生成并激活接口
    @Test
    public static void applyAndActivateQrCode() throws Exception {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");

        ApplyAndActivateQrCodeReqDTO applyAndActivateQrCodeReqDTO = new ApplyAndActivateQrCodeReqDTO();
        applyAndActivateQrCodeReqDTO.setBindType(BindTypeEnum.MERCHANT.getCode());
        applyAndActivateQrCodeReqDTO.setMerchantNo(UserList.MerchantNo());
        applyAndActivateQrCodeReqDTO.setMerchantName("123");
        applyAndActivateQrCodeReqDTO.setMerchantType("COMPANY");
        applyAndActivateQrCodeReqDTO.setMerchantOperatorNo(UserList.MerchantNo());
        applyAndActivateQrCodeReqDTO.setStoreNo("");
        applyAndActivateQrCodeReqDTO.setStoreName("");
        applyAndActivateQrCodeReqDTO.setShopNo("");
        applyAndActivateQrCodeReqDTO.setShopName("");
        applyAndActivateQrCodeReqDTO.setShopProductNo(UserList.ContralNo());
        applyAndActivateQrCodeReqDTO.setShopOperatorNo(UserList.MerchantNo());
        applyAndActivateQrCodeReqDTO.setRequestNo("Req" + RandomStringNo());
        applyAndActivateQrCodeReqDTO.setRequestSystem("test");
        applyAndActivateQrCodeReqDTO.setRequestDate(new Date());
        applyAndActivateQrCodeReqDTO.setTraceLogId(traceLogId);

        Result<QrCodeDetailResDTO> result = encourageConfigService.applyAndActivateQrCode(applyAndActivateQrCodeReqDTO);
        System.out.println("********************预制码生成并激活********************");
        System.out.println("日志:" + traceLogId);
        System.out.println("请求流水:" + applyAndActivateQrCodeReqDTO.getRequestNo());
        System.out.println("请求时间:" + applyAndActivateQrCodeReqDTO.getRequestDate());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
    }

    //双向激励生效接口
    @Test
    public static void encourageEffect() throws Exception {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");

        EncourageEffectReqDTO encourageEffectReqDTO = new EncourageEffectReqDTO();
        encourageEffectReqDTO.setToolId("T" + RandomStringNo());
        encourageEffectReqDTO.setMarketCfgId("A" + RandomStringNo());
        encourageEffectReqDTO.setMerchantMarketCfgId("M" + RandomStringNo());
        encourageEffectReqDTO.setToolName("");
        encourageEffectReqDTO.setMarketCfgName("");
        encourageEffectReqDTO.setMerchantMarketCfgName("");
        encourageEffectReqDTO.setTraceLogId(traceLogId);
        encourageEffectReqDTO.setToolType("");
        encourageEffectReqDTO.setMerchantMarketCfgType("");
        encourageEffectReqDTO.setMarketCfgType("");
        encourageEffectReqDTO.setApplyProvince("999900");
        encourageEffectReqDTO.setAdaptProvince("999900");
//        encourageEffectReqDTO.setAdaptCity("");
        encourageEffectReqDTO.setPurpose("");
        encourageEffectReqDTO.setApplyEmail("");
        encourageEffectReqDTO.setApplyPhone("");
        encourageEffectReqDTO.setCreateBy("");
        encourageEffectReqDTO.setApplyDepartment("");
        encourageEffectReqDTO.setStartTime(Before);
        encourageEffectReqDTO.setEndTime(After);
        encourageEffectReqDTO.setToolDesc("");
//        encourageEffectReqDTO.setUpdatedBy("");

        Result<Boolean> result = encourageConfigService.encourageEffect(encourageEffectReqDTO);
        System.out.println("********************双向激励生效********************");
        System.out.println("日志:" + traceLogId);
        System.out.println("ToolId:" + encourageEffectReqDTO.getToolId());
        System.out.println("MarketCfgId:" + encourageEffectReqDTO.getMarketCfgId());
        System.out.println("MerchantMarketCfgId:" + encourageEffectReqDTO.getMerchantMarketCfgId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
    }
}
