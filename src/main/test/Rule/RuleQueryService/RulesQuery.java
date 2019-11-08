package Rule.RuleQueryService;

import Customize.DataGenerate;
import com.xx.dubbo.result.Result;
import com.xx.marketing.rule.api.RuleQueryService;
import com.xx.marketing.rule.api.models.request.RulesQueryReqDTO;
import com.xx.marketing.rule.api.models.response.RulesQueryResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/9/10.
 * 规则查询
 */
public class RulesQuery extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    static RuleQueryService ruleQueryService = (RuleQueryService) ac.getBean("ruleQueryService");

    @Test
    public static void rulesQuery() throws Exception {
        RulesQueryReqDTO rulesQueryReqDTO = new RulesQueryReqDTO();
        rulesQueryReqDTO.setRuleGroupCode("RGC37640558620450571123677");

        String traceLogId = TraceLogId();

        Result<RulesQueryResDTO> result = ruleQueryService.rulesQuery(rulesQueryReqDTO, traceLogId);
        System.out.println("********************规则查询********************");
        System.out.println("日志号:" + traceLogId);
        System.out.println("规则组编号:" + rulesQueryReqDTO.getRuleGroupCode());
        System.out.println("日志号:" + traceLogId);
        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("结果集:" + result.getResult());
    }
}
