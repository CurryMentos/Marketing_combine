package Portal.common.DictService;

import java.text.SimpleDateFormat;
import java.util.*;

import com.xx.dubbo.result.Result;
import com.xx.marketing.config.api.common.DictService;
import com.xx.marketing.config.api.common.models.DictDTO;
import com.xx.marketing.config.api.common.models.request.DictionaryItemQueryReqDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by yangwei on 2019/6/18.
 * �����ֵ��б��ѯ�ӿ�
 */
public class DictQuery {
    @Test
    public static void dictQuery() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:marketingManager-consumer.xml");
        DictService dictService = (DictService) ac.getBean("dictService");
        String traceLogId = UUID.randomUUID().toString().replaceAll("-", "");
        Date date = new Date();
        String str = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(date);

        DictionaryItemQueryReqDTO dictionaryItemQueryReqDTO = new DictionaryItemQueryReqDTO();
        dictionaryItemQueryReqDTO.setStatus("");   // ״̬  ���ã�open  ͣ�ã�close  Ĭ�ϲ����õ�
        dictionaryItemQueryReqDTO.setRequestNo(str);    //
        dictionaryItemQueryReqDTO.setRequestSystem("");    //
        dictionaryItemQueryReqDTO.setRequestDate(date);
        dictionaryItemQueryReqDTO.setTraceLogId(traceLogId);   // ��־

        Result<Map<String, List<DictDTO>>> result = dictService.dictQuery(dictionaryItemQueryReqDTO);
        System.out.println("***********************************");
        System.out.println("��־�ţ�" + dictionaryItemQueryReqDTO.getTraceLogId());
        System.out.println(result);

        if (result.getResult() != null) {
            Map<String, List<DictDTO>> map = result.getResult();
            for (String key : map.keySet()) {
                System.out.print(result.getResult());
            }
        }
    }
}
