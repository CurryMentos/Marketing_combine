package Encourge.encourage;

import Customize.UserList;
import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.encourage.api.EncourageQueryService;
import com.bestpay.marketing.encourage.api.models.request.*;
import com.bestpay.marketing.encourage.api.models.response.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class EncourageQueryServiceTest {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static EncourageQueryService encourageQueryService = (EncourageQueryService) ac.getBean("encourageQueryService");
    static Date StartStart = Date.from(LocalDateTime.now(ZoneOffset.ofHours(8)).minusDays(10).withHour(0).withMinute(0).withSecond(0).toInstant(ZoneOffset.ofHours(8)));
    static Date StartEnd = Date.from(LocalDateTime.now(ZoneOffset.ofHours(8)).minusDays(8).withHour(23).withMinute(59).withSecond(59).toInstant(ZoneOffset.ofHours(8)));
    static Date EndStart = Date.from(LocalDateTime.now(ZoneOffset.ofHours(8)).plusDays(8).withHour(0).withMinute(0).withSecond(0).toInstant(ZoneOffset.ofHours(8)));
    static Date EndEnd = Date.from(LocalDateTime.now(ZoneOffset.ofHours(8)).plusDays(10).withHour(23).withMinute(59).withSecond(59).toInstant(ZoneOffset.ofHours(8)));
    static String name = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "双向激励";

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

    //分页查询二维码批次信息
    @Test
    public static void queryQrCodeBatchList() throws Exception {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");

        QueryQrCodeBatchReqDTO queryQrCodeBatchReqDTO = new QueryQrCodeBatchReqDTO();
        queryQrCodeBatchReqDTO.setBatchNoOrName(name);
        queryQrCodeBatchReqDTO.setApplyProvince("999900");
        queryQrCodeBatchReqDTO.setApplyUserId("");
        queryQrCodeBatchReqDTO.setApplyStartTime(StartStart);
        queryQrCodeBatchReqDTO.setApplyEndTime(EndEnd);
        queryQrCodeBatchReqDTO.setPageSize(0L);
        queryQrCodeBatchReqDTO.setPageNo(0L);
        queryQrCodeBatchReqDTO.setTraceLogId(traceLogId);

        Result<QrCodeBatchResDTO> result = encourageQueryService.queryQrCodeBatchList(queryQrCodeBatchReqDTO);
        System.out.println("********************分页查询二维码批次信息********************");
        System.out.println("日志:" + traceLogId);
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
    }

    //根据批次号分页查询预制码
    @Test
    public static void queryQrCode() throws Exception {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");

        QueryQrCodeBatchReqDTO queryQrCodeBatchReqDTO = new QueryQrCodeBatchReqDTO();
        queryQrCodeBatchReqDTO.setBatchNoOrName(name);
        queryQrCodeBatchReqDTO.setApplyProvince("999900");
        queryQrCodeBatchReqDTO.setApplyUserId("");
        queryQrCodeBatchReqDTO.setApplyStartTime(StartStart);
        queryQrCodeBatchReqDTO.setApplyEndTime(EndEnd);
        queryQrCodeBatchReqDTO.setPageSize(0L);
        queryQrCodeBatchReqDTO.setPageNo(0L);
        queryQrCodeBatchReqDTO.setTraceLogId(traceLogId);

        Result<QrCodeBatchResDTO> result = encourageQueryService.queryQrCodeBatchList(queryQrCodeBatchReqDTO);
        System.out.println("********************根据批次号分页查询预制码********************");
        System.out.println("日志:" + traceLogId);
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
    }

    //根据二维码ID和操作员编号查询权益领取结果
    @Test
    public static void queryReceiveResult() throws Exception {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");

        QueryReceiveResultReqDTO queryReceiveResultReqDTO = new QueryReceiveResultReqDTO();
        queryReceiveResultReqDTO.setQrCodeId("11");
        queryReceiveResultReqDTO.setOperatorNo(UserList.MerchantNo());
        queryReceiveResultReqDTO.setRequestNo("Req" + RandomStringNo());
        queryReceiveResultReqDTO.setRequestSystem("test");
        queryReceiveResultReqDTO.setRequestDate(new Date());
        queryReceiveResultReqDTO.setTraceLogId(traceLogId);

        Result<ReceiveEquityResDTO> result = encourageQueryService.queryReceiveResult(queryReceiveResultReqDTO);
        System.out.println("********************根据二维码ID和操作员编号查询权益领取结果********************");
        System.out.println("日志:" + traceLogId);
        System.out.println("请求流水:" + queryReceiveResultReqDTO.getRequestNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
    }

    //预制码详情查询
    @Test
    public static void queryQrCodeDetail() throws Exception {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");

        QueryQrCodeDetailReqDTO queryQrCodeDetailReqDTO = new QueryQrCodeDetailReqDTO();
        queryQrCodeDetailReqDTO.setBatchNo("B" + RandomStringNo());
        queryQrCodeDetailReqDTO.setTraceLogId(traceLogId);

        Result<List<QueryQrCodeInfoResDTO>> result = encourageQueryService.queryQrCodeDetail(queryQrCodeDetailReqDTO);
        System.out.println("********************预制码详情查询********************");
        System.out.println("日志:" + traceLogId);
        System.out.println("批次号:" + queryQrCodeDetailReqDTO.getBatchNo());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
    }

    //双向激励工具列表查询
    public static void queryEncourageToolsList() throws Exception {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");

        QueryEncourageToolsReqDTO queryEncourageToolsReqDTO = new QueryEncourageToolsReqDTO();
        queryEncourageToolsReqDTO.setApplyId("A" + RandomStringNo());
        queryEncourageToolsReqDTO.setApplyName(name);
        queryEncourageToolsReqDTO.setAdaptProvince("");
        queryEncourageToolsReqDTO.setApplyType("");
        queryEncourageToolsReqDTO.setApplyStartStartTime(StartStart);
        queryEncourageToolsReqDTO.setApplyStartEndTime(StartEnd);
        queryEncourageToolsReqDTO.setApplyEndStartTime(EndStart);
        queryEncourageToolsReqDTO.setApplyEndEndTime(EndEnd);
        queryEncourageToolsReqDTO.setActivityForm("");
        queryEncourageToolsReqDTO.setActivityState("");
        queryEncourageToolsReqDTO.setApplyDepartment("");
        queryEncourageToolsReqDTO.setPageSize(0L);
        queryEncourageToolsReqDTO.setPageNo(0L);
        queryEncourageToolsReqDTO.setTraceLogId(traceLogId);

        Result<EncourageToolsResDTO> result = encourageQueryService.queryEncourageToolsList(queryEncourageToolsReqDTO);
        System.out.println("********************双向激励工具列表查询********************");
        System.out.println("日志:" + traceLogId);
        System.out.println("ApplyId:" + queryEncourageToolsReqDTO.getApplyId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
    }

    //双向激励工具详情查询
    public static void queryEncourageToolsDetail() throws Exception {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");

        QueryEncourageToolsDetailReqDTO queryEncourageToolsDetailReqDTO = new QueryEncourageToolsDetailReqDTO();
        queryEncourageToolsDetailReqDTO.setToolsId("T" + RandomStringNo());
        queryEncourageToolsDetailReqDTO.setTraceLogId(traceLogId);

        Result<EncourageToolsDetailResDTO> result = encourageQueryService.queryEncourageToolsDetail(queryEncourageToolsDetailReqDTO);
        System.out.println("********************双向激励工具列表查询********************");
        System.out.println("日志:" + traceLogId);
        System.out.println("ToolsId:" + queryEncourageToolsDetailReqDTO.getToolsId());
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
    }
}
