package Portal.activity.OmpActivityConfigService;/*
package config.activity.OmpActivityConfigService;

import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.config.api.activity.OmpActivityConfigService;
import com.bestpay.marketing.config.api.activity.models.request.InValidActivityReqDTO;
import com.bestpay.marketing.config.api.activity.models.response.omp.InValidActivityResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

*/
/**
 * Created by zengyouzu on 2019/6/18.
 * 活动作废
 *//*

public class InValidActivity {
    public static void inValidActivity() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        OmpActivityConfigService ompActivityConfigService = (OmpActivityConfigService) ac.getBean("ompActivityConfigService");

        String var = UUID.randomUUID().toString();
        Date now = new Date();
        String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now);

        InValidActivityReqDTO inValidActivityReqDTO = new InValidActivityReqDTO();
        inValidActivityReqDTO.setOriginalRequestNo("");//原请求流水
        inValidActivityReqDTO.setCancelType("");//作废类型
        inValidActivityReqDTO.setApplyType("");//申请类型
        inValidActivityReqDTO.setActivityId("");//活动号
        inValidActivityReqDTO.setRequestNo(sdf);//请求流水
        inValidActivityReqDTO.setRequestSystem("");//请求系统
        inValidActivityReqDTO.setRequestDate(now);//请求时间
        inValidActivityReqDTO.setTraceLogId(var);//日志号

        Result<InValidActivityResDTO> result =ompActivityConfigService.inValidActivity(inValidActivityReqDTO);
        System.out.println("*****************************************");
        System.out.println("请求流水:" + inValidActivityReqDTO.getRequestNo());
        System.out.println("日志号:" + inValidActivityReqDTO.getTraceLogId());
        System.out.println(result);

        if (result.getResult() != null) {
            System.out.println("*****************************************");
            System.out.println(result.getResult());
        }
    }
}
*/
