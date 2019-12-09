package Portal.common.DictService;/*
package common.DictService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.config.api.common.DictService;
import com.bestpay.marketing.config.api.common.models.request.ConfigInvestQueryReqDTO;
import com.bestpay.marketing.config.api.common.models.response.ConfigInvestQueryRespDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

*/
/**
 * Created by yangwei on 2019/6/18.
 *�ɱ���̯�б��ѯ
 *//*

public class InvestConfigQuery {
    @Test
    public static void dictQuery() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:marketingManager-consumer.xml");
        DictService dictService = (DictService)ac.getBean("dictService");
        String traceLogId = UUID.randomUUID().toString().replaceAll("-", "");
        Date date = new Date();
        String str = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(date);

        ConfigInvestQueryReqDTO configInvestQueryReqDTO = new ConfigInvestQueryReqDTO();
        configInvestQueryReqDTO.setEquityType("");   // Ȩ������   �ֽ�CASH  ����ȯ��VOUCHER  �����COUPON
        configInvestQueryReqDTO.setInvestorType("");    //���ʷ�
        configInvestQueryReqDTO.setProvinceCode("");    // ʡ
        configInvestQueryReqDTO.setCityCode("");   //��
        configInvestQueryReqDTO.setStatus("");
        configInvestQueryReqDTO.setRequestNo(str);  // ������ˮ
        configInvestQueryReqDTO.setRequestSystem("");
        configInvestQueryReqDTO.setRequestDate(date);
        configInvestQueryReqDTO.setTraceLogId(traceLogId); //  ��־ID

        Result<List<ConfigInvestQueryRespDTO>> result = dictService.investConfigQuery(configInvestQueryReqDTO);
        System.out.println("***********************************");
        System.out.println("��־�ţ�" + configInvestQueryReqDTO.getTraceLogId());
        System.out.println(result);

        if (result.getResult() != null){
            List<ConfigInvestQueryRespDTO> list = result.getResult();
            for (ConfigInvestQueryRespDTO dto : list){
                System.out.print(result.getResult());
            }
        }
    }
}
*/
