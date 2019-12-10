package Portal.common.DictService;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.xx.dubbo.result.Result;
import com.xx.marketing.config.api.common.DictService;
import com.xx.marketing.config.api.common.models.DictDTO;
import com.xx.marketing.config.api.common.models.request.ApplicationUrlQueryReqDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.List;
import java.util.UUID;

/**
 * Created by yangwei on 2019/6/19.
 * ��תӦ�ü�URL��ѯ�ӿ�
 */
public class ApplicationAndUrlQuery {
    @Test
    public static void applicationAndUrlQuery() throws Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:marketingManager-consumer.xml");
        DictService dictService = (DictService) ac.getBean("dictService");
        String traceLogId = UUID.randomUUID().toString().replaceAll("-", "");
        Date date = new Date();
        String str = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(date);

        ApplicationUrlQueryReqDTO applicationUrlQueryReqDTO = new ApplicationUrlQueryReqDTO();
        applicationUrlQueryReqDTO.setStatus("");  // ״̬  ���ã�open   ͣ�ã�close  Ĭ�ϲ����õ�
        applicationUrlQueryReqDTO.setRequestNo(str);
        applicationUrlQueryReqDTO.setRequestSystem("");
        applicationUrlQueryReqDTO.setRequestDate(date);
        applicationUrlQueryReqDTO.setTraceLogId(traceLogId);   //  ��־ID

        Result<List<DictDTO>> result = dictService.applicationAndUrlQuery(applicationUrlQueryReqDTO);
        System.out.println("***********************************");
        System.out.println("��־�ţ�" + applicationUrlQueryReqDTO.getTraceLogId());
        System.out.println(result);

        if (result.getResult() != null){
            List<DictDTO> list = result.getResult();
            for (DictDTO dto : list ){
                System.out.print(result.getResult());
            }
        }
    }
}