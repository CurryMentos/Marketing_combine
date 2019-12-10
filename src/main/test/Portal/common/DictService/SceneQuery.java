package Portal.common.DictService;/*
package common.DictService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.xx.dubbo.result.Result;
import com.xx.marketing.config.api.common.DictService;
import com.xx.marketing.config.api.common.models.request.SceneQueryReqDTO;
import com.xx.marketing.config.api.common.models.response.ConfigSceneQueryRespDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

*/
/**
 * Created by yangwei on 2019/6/18.
 * �����б��ѯ�ӿ�
 *//*

public class SceneQuery {
    @Test
    public static void dictQuery() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:marketingManager-consumer.xml");
        DictService dictService = (DictService) ac.getBean("dictService");
        String traceLogId = UUID.randomUUID().toString().replaceAll("-", "");
        Date date = new Date();
        String str = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(date);

        SceneQueryReqDTO sceneQueryReqDTO = new SceneQueryReqDTO();
        sceneQueryReqDTO.setActivityType("");   // ���ʽ
        sceneQueryReqDTO.setProvinceFlag("");   //
        sceneQueryReqDTO.setStatus("");  // ״̬
        sceneQueryReqDTO.setRequestNo(str);
        sceneQueryReqDTO.setRequestSystem("");
        sceneQueryReqDTO.setRequestDate(date);
        sceneQueryReqDTO.setTraceLogId(traceLogId);   // ��־

        Result<List<ConfigSceneQueryRespDTO>> result = dictService.sceneQuery(sceneQueryReqDTO);
        System.out.println("***********************************");
        System.out.println("��־�ţ�" + sceneQueryReqDTO.getTraceLogId());
        System.out.println(result);

        if (result.getResult() != null){
            List<ConfigSceneQueryRespDTO> list = result.getResult();
            for (ConfigSceneQueryRespDTO dto : list) {
                System.out.print(result.getResult());
            }
        }
    }
}
*/
