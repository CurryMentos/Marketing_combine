package Portal.common.DictService;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.xx.dubbo.result.Result;
import com.xx.marketing.config.api.common.DictService;
import com.xx.marketing.config.api.common.models.request.EquityMsgTemplateQueryReqDTO;
import com.xx.marketing.config.api.common.models.response.EquityMsgTemplateQueryRespDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.List;
import java.util.UUID;

/**
 * Created by yangwei on 2019/6/19.
 * Ȩ�����ģ���ѯ�ӿ�
 */
public class EquityMsgTemplateQuery {
    @Test
    public static void equityMsgTemplateQuery() throws Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:marketingManager-consumer.xml");
        DictService dictService = (DictService) ac.getBean("dictService");
        String traceLogId = UUID.randomUUID().toString().replaceAll("-", "");
        Date date = new Date();
        String str = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(date);

        EquityMsgTemplateQueryReqDTO equityMsgTemplateQueryReqDTO = new EquityMsgTemplateQueryReqDTO();
        equityMsgTemplateQueryReqDTO.setEquityType("");  //   Ȩ������  �ֽ�CASH ����ȯ��VOUCHER  �����COUPON
        equityMsgTemplateQueryReqDTO.setStatus("");  // ״̬  ���ã�open  ͣ�ã�close   Ĭ�ϲ����õ�
        equityMsgTemplateQueryReqDTO.setRequestNo(str);  // ������ˮ
        equityMsgTemplateQueryReqDTO.setRequestSystem("");
        equityMsgTemplateQueryReqDTO.setRequestDate(date);  // ����ʱ��
        equityMsgTemplateQueryReqDTO.setTraceLogId(traceLogId);  //  ��־ID

        Result<List<EquityMsgTemplateQueryRespDTO>> result = dictService.equityMsgTemplateQuery(equityMsgTemplateQueryReqDTO);
        System.out.println("***********************************");
        System.out.println("��־�ţ�" + equityMsgTemplateQueryReqDTO.getTraceLogId());
        System.out.println(result);

        if (result.getResult() != null){
            List<EquityMsgTemplateQueryRespDTO> list = result.getResult();
            for (EquityMsgTemplateQueryRespDTO dto : list ){
                System.out.print(result.getResult());
            }
        }
    }
}
