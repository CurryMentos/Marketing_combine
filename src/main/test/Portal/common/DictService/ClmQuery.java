package Portal.common.DictService;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.xx.dubbo.result.Result;
import com.xx.marketing.config.api.common.DictService;
import com.xx.marketing.config.api.common.models.DictDTO;
import com.xx.marketing.config.api.common.models.request.ClmQueryReqDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.List;
import java.util.UUID;

/**
 * Created by yangwei on 2019/6/18.
 * ʡ�����б��ѯ�ӿ�
 */
public class ClmQuery {
    @Test
    public static void ClmQuery() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:marketingManager-consumer.xml");
        DictService dictService = (DictService) ac.getBean("dictService");
        String traceLogId = UUID.randomUUID().toString().replaceAll("-", "");
        Date date = new Date();
        String str = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(date);

        ClmQueryReqDTO clmQueryReqDTO = new ClmQueryReqDTO();
        clmQueryReqDTO.setProvinceCode("");  //  ʡ����
        clmQueryReqDTO.setRequestNo(str);
        clmQueryReqDTO.setRequestSystem("");
        clmQueryReqDTO.setRequestDate(date);
        clmQueryReqDTO.setTraceLogId(traceLogId);   // ��־ID

        Result<List<DictDTO>> result = dictService.clmQuery(clmQueryReqDTO);
        System.out.println("***********************************");
        System.out.println("��־�ţ�" + clmQueryReqDTO.getTraceLogId());
        System.out.println(result);

        if (result.getResult() != null){
            List<DictDTO> list =  result.getResult();
            for (DictDTO dto : list){
                System.out.print(result.getResult());
            }
        }
    }
}
