package Portal.common.ModifyStatusService;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.xx.dubbo.result.Result;
import com.xx.marketing.config.api.common.ModifyStatusService;
import com.xx.marketing.config.api.common.models.request.ModifyApplyStatusReqDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * Created by yangwei on 2019/6/19.
 * �������״̬
 */
public class ModifyApplyStatus {
    @Test
    public static void modifyApplyStatus() throws Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:marketingManager-consumer.xml");
        ModifyStatusService modifyStatusService = (ModifyStatusService) ac.getBean("ModifyStatusService");
        String traceLogId = UUID.randomUUID().toString().replaceAll("-", "");
        Date date = new Date();
        String str = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(date);

        ModifyApplyStatusReqDTO modifyApplyStatusReqDTO = new ModifyApplyStatusReqDTO();
        modifyApplyStatusReqDTO.setApplyId("");
        modifyApplyStatusReqDTO.setApplyStatus("");
        modifyApplyStatusReqDTO.setApplyUser("");
        modifyApplyStatusReqDTO.setApplyReason("");
        modifyApplyStatusReqDTO.setRequestNo(str);
        modifyApplyStatusReqDTO.setRequestSystem("");
        modifyApplyStatusReqDTO.setRequestDate(date);
        modifyApplyStatusReqDTO.setTraceLogId(traceLogId);

        Result<Boolean> result = modifyStatusService.modifyApplyStatus(modifyApplyStatusReqDTO);
        System.out.println("***********************************");
        System.out.println("��־�ţ�" + modifyApplyStatusReqDTO.getTraceLogId());
        System.out.println(result);

        if (result.getResult() != null){
            System.out.println(result.getResult());
        }
    }
}
