package Portal.common.UploadService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.xx.dubbo.result.Result;
import com.xx.marketing.config.api.common.UploadService;
import com.xx.marketing.config.api.common.models.request.AttachmentReqDTO;
import com.xx.marketing.config.api.common.models.response.AttachmentRespDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by yangwei on 2019/6/19.
 * �ϴ�����
 */
public class UploadAttachment {
    @Test
    public static void uploadAttachment() throws Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:marketingManager-consumer.xml");
        UploadService uploadService = (UploadService)  ac.getBean("UploadService");
        String traceLogId = UUID.randomUUID().toString().replaceAll("-", "");
        Date date = new Date();
        String str = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(date);

        AttachmentReqDTO attachmentReqDTO = new AttachmentReqDTO();
        attachmentReqDTO.setApplyUser("");
        attachmentReqDTO.setModelId("");
        attachmentReqDTO.setBase64Code("");
        attachmentReqDTO.setFileName("");
        attachmentReqDTO.setFileType("");
        attachmentReqDTO.setMerchantType("");
        attachmentReqDTO.setFilePrefix("");
        attachmentReqDTO.setRequestNo("");
        attachmentReqDTO.setRequestSystem("");
        attachmentReqDTO.setRequestDate(date);
        attachmentReqDTO.setTraceLogId(traceLogId);

        Result<AttachmentRespDTO> result = uploadService.uploadAttachment(attachmentReqDTO);
        System.out.println("***********************************");
        System.out.println("��־�ţ�" + attachmentReqDTO.getTraceLogId());
        System.out.println(result);

        if (result.getResult() != null){
            System.out.print(result.getResult());
        }
    }
}
