package Portal.equity.EquityApplyService;/*
package equity.EquityApplyService;

import com.bestpay.dubbo.result.Result;
import com.bestpay.marketing.config.api.activity.models.response.VoucherInfoApplyRespDTO;
import com.bestpay.marketing.config.api.equity.EquityApplyService;
import com.bestpay.marketing.config.api.equity.request.EquityQueryReqDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.UUID;

*/
/**
 * Created by gaowenpei on 2019/6/19.
 * <p>
 * 权益申请查询明细
 *//*


public class QueryVoucher {
    @Test
    public static void queryVoucher() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext( "classpath:applicationContext.xml" );
        EquityApplyService equityApplyService = (EquityApplyService) ac.getBean( "equityApplyService" );
        String var = UUID.randomUUID().toString();

        EquityQueryReqDTO equityQueryReqDTO = new EquityQueryReqDTO();
        equityQueryReqDTO.setEquityId( "" );

        Result<VoucherInfoApplyRespDTO> result = equityApplyService.queryVoucher( equityQueryReqDTO );
        System.out.println( "是否成功:" + result.isSuccess() );
        System.out.println( "错误码:" + result.getErrorCode() );
        System.out.println( "错误信息:" + result.getErrorMsg() );
        System.out.println( "错误码:" + result.getPrimaryErrorCode() );
        System.out.println( "错误信息:" + result.getPrimaryErrorMsg() );
        System.out.println( "测试服务器:" + result.getPrimaryErrorIP() );

        if (result.getResult() != null) {
            System.out.println( "*********************************" );
            System.out.println( "权益编号" + result.getResult().getEquityId() );
            System.out.println( "权益名称" + result.getResult().getEquityName() );
            System.out.println( "申请用途" + result.getResult().getApplyUses() );
            System.out.println( "券类别" + result.getResult().getEquityCategory() );
            System.out.println( "业务类型" + result.getResult().getBusinessType() );
            System.out.println( "跳转应用" + result.getResult().getJumpApplication() );

            System.out.println( "使用渠道" + result.getResult().getUseChannel() );
            System.out.println( "生效方式" + result.getResult().getEffectType() );
            System.out.println( "生效时间" + result.getResult().getEffectStartTime() );
            System.out.println( "失效时间" + result.getResult().getEffectEndTime() );
            System.out.println( "间隔天数" + result.getResult().getEffectInterval() );
            System.out.println( "生效周期" + result.getResult().getEffectCircle() );
            System.out.println( "生效周期类型(日月周)" + result.getResult().getEffectDateType() );
            System.out.println( "生效周期点" + result.getResult().getEffectDatePoint() );
            System.out.println( "每天开始时间" + result.getResult().getDayStartTime() );
            System.out.println( "每天结束时间" + result.getResult().getDayEndTime() );
            System.out.println( "面值类型" + result.getResult().getDenominationType() );
            System.out.println( "折扣" + result.getResult().getPercentage() );
            System.out.println( "面值" + result.getResult().getDenomination() );
            System.out.println( "消费限额(最小)" + result.getResult().getLowerLimit() );
            System.out.println( "消费限额(最大)" + result.getResult().getUpperLimit() );
            System.out.println( "人均返券张数" + result.getResult().getDistributeCount() );
            System.out.println( "账户星级" + result.getResult().getCustomerLevel() );
            System.out.println( "限制绑卡" + result.getResult().getNeedBindCard() );
            System.out.println( "使用规则简述" + result.getResult().getContext() );
            System.out.println( "签报号" + result.getResult().getTms() );
            System.out.println( "账务回单号" + result.getResult().getTmsFinance() );
            System.out.println( "成本分摊列表" + result.getResult().getCostRespDTOList() );

        }
    }
}
*/
