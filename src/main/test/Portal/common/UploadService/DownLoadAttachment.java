package Portal.common.UploadService;

import java.util.Date;

import Customize.DataGenerate;
import com.alibaba.fastjson.JSON;
import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.config.api.common.UploadService;
import com.bestpay.marketing.config.api.common.models.request.DownLoadAttachmentReqDTO;
import com.bestpay.marketing.config.api.common.models.response.DownLoadAttachmentRespDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zengyouzu on 2019/11/12.
 * 下载附件
 */
public class DownLoadAttachment extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static UploadService uploadService = (UploadService) ac.getBean("uploadService");

    public static void downLoadAttachment() {
        DownLoadAttachmentReqDTO downLoadAttachmentReqDTO = new DownLoadAttachmentReqDTO();
        downLoadAttachmentReqDTO.setFileId(0L);
        downLoadAttachmentReqDTO.setRequestNo("Req" + RandomStringNo());
        downLoadAttachmentReqDTO.setRequestSystem("test");
        downLoadAttachmentReqDTO.setRequestDate(new Date());
        downLoadAttachmentReqDTO.setTraceLogId(TraceLogId());

        Result<DownLoadAttachmentRespDTO> result = uploadService.downLoadAttachment(downLoadAttachmentReqDTO);
        String json = JSON.toJSONString(result.getResult());
        System.out.println("***********************************");
        System.out.println("日志:" + downLoadAttachmentReqDTO.getTraceLogId());
        System.out.println(json);
    }
}
