package Portal.common.DictService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.config.api.common.DictService;
import com.bestpay.marketing.config.api.common.models.DictDTO;
import com.bestpay.marketing.config.api.common.models.request.ProvinceAndCityQueryReqDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by yangwei on 2019/6/18.
 * ʡ���б��ѯ�ӿ�
 */
public class ProvinceAndCityQuery {
    @Test
    public static void dictQuery() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:marketingManager-consumer.xml");
        DictService dictService = (DictService) ac.getBean("dictService");
        String traceLogId = UUID.randomUUID().toString().replaceAll("-", "");
        Date date = new Date();
        String str = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(date);

        ProvinceAndCityQueryReqDTO provinceAndCityQueryReqDTO = new ProvinceAndCityQueryReqDTO();
        provinceAndCityQueryReqDTO.setProvinceCode("");  // ʡ����
        provinceAndCityQueryReqDTO.setRequestNo(str);
        provinceAndCityQueryReqDTO.setRequestSystem("");
        provinceAndCityQueryReqDTO.setRequestDate(date);
        provinceAndCityQueryReqDTO.setTraceLogId(traceLogId);  // ��־ID

        Result<List<DictDTO>> result = dictService.provinceAndCityQuery(provinceAndCityQueryReqDTO);
        System.out.println("***********************************");
        System.out.println("��־�ţ�" + provinceAndCityQueryReqDTO.getTraceLogId());
        System.out.println(result);

        if (result != null){
            List<DictDTO> list = result.getResult();
            for (DictDTO dto : list ){
                System.out.print(result.getResult());
            }
        }
    }
}
