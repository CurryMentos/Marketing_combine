package Portal.common.GenerateIdService;/*
package common.GenerateIdService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.xx.dubbo.result.Result;
import com.xx.marketing.config.api.activity.models.request.GenerateModelIdReqDTO;
import com.xx.marketing.config.api.common.GenerateIdService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

*/
/**
 * Created by yangwei on 2019/6/19.
 * ����ģ��ID
 *//*

public class GenerateModelId {
    @Test
    public static void  GenerateModelId() throws Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:marketingManager-consumer.xml");
        GenerateIdService generateIDService = (GenerateIdService) ac.getBean("generateIDService");
        String traceLogId = UUID.randomUUID().toString().replaceAll("-", "");
        Date date = new Date();
        String str = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(date);

        GenerateModelIdReqDTO generateModelIdReqDTO = new GenerateModelIdReqDTO();
        generateModelIdReqDTO.setModelType("");
        generateModelIdReqDTO.setModelCategory("");
        generateModelIdReqDTO.setApplyUserArea("");
        generateModelIdReqDTO.setRequestNo(str);
        generateModelIdReqDTO.setRequestSystem("");
        generateModelIdReqDTO.setRequestDate(date);
        generateModelIdReqDTO.setTraceLogId(traceLogId);  //   ��־ID

        Result<String> result = generateIDService.generateModelId(generateModelIdReqDTO);
        System.out.println("***********************************");
        System.out.println("��־�ţ�" + generateModelIdReqDTO.getTraceLogId());
        System.out.println(result);

        if (result.getResult() != null){
            System.out.print(result.getResult());
        }
    }
}
*/
