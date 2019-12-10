package Portal.common.UploadService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import Customize.DataGenerate;
import com.alibaba.fastjson.JSON;
import com.xx.dubbo.result.Result;
import com.xx.marketing.config.api.common.UploadService;
import com.xx.marketing.config.api.common.models.request.AttachmentReqDTO;
import com.xx.marketing.config.api.common.models.response.AttachmentRespDTO;
import com.xx.marketing.config.api.enums.FileTypeEnum;
import com.xx.marketing.encourage.api.enums.MerchantTypeEnum;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by yangwei on 2019/6/19.
 * 更改附件
 */
public class UploadAttachment extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static UploadService uploadService = (UploadService) ac.getBean("uploadService");

    @Test
    public static void uploadAttachment() throws Exception {
        AttachmentReqDTO attachmentReqDTO = new AttachmentReqDTO();
        attachmentReqDTO.setApplyUser("DZHB_apply1");
        attachmentReqDTO.setModelId("");
        attachmentReqDTO.setBase64Code("");
        attachmentReqDTO.setFileName("");
        attachmentReqDTO.setFileType(FileTypeEnum.MERCHANT_FILE.getCode());
        attachmentReqDTO.setMerchantType(MerchantTypeEnum.COMPANY.getCode());
        attachmentReqDTO.setFilePrefix("");
        attachmentReqDTO.setRequestNo("Req"+RandomStringNo());
        attachmentReqDTO.setRequestSystem("test");
        attachmentReqDTO.setRequestDate(new Date());
        attachmentReqDTO.setTraceLogId(TraceLogId());

        Result<AttachmentRespDTO> result = uploadService.uploadAttachment(attachmentReqDTO);
        String json = JSON.toJSONString(result.getResult());
        System.out.println("***********************************");
        System.out.println("日志:" + attachmentReqDTO.getTraceLogId());
        System.out.println(json);
    }
}
