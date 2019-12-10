package TradeProduct;

import Customize.DataGenerate;
import com.xx.dubbo.result.Result;
import com.xx.tradeproduct.service.acquiring.api.TradeProductRefundService;
import com.xx.tradeproduct.service.acquiring.api.model.TradeProductRefundReqDTO;
import com.xx.tradeproduct.service.acquiring.api.model.result.TradeProductBaseResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * Created by zengyouzu on 2019/9/27.
 * 3.0产品层下单退款
 */
public class Refund extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static TradeProductRefundService tradeProductRefundService = (TradeProductRefundService) ac.getBean("tradeProductRefundService");

    @Test
    public static void refund() {
        String traceLogId = TraceLogId();

        TradeProductRefundReqDTO tradeProductRefundReqDTO = new TradeProductRefundReqDTO();
        tradeProductRefundReqDTO.setMerchantNo("3178002076404718");//商户号
        tradeProductRefundReqDTO.setRequestOrderNo("Req" + RandomStringNo());//请求系统单号
        tradeProductRefundReqDTO.setRequestSystem("TRADE_ACQUIRING");//请求系统
        tradeProductRefundReqDTO.setRequestDate(now);//请求时间
        tradeProductRefundReqDTO.setRefundTradeChannel("APP");//退款渠道
        tradeProductRefundReqDTO.setOriginalTradeNo("20191009100000210002100255539951");//原交易号
        tradeProductRefundReqDTO.setRefundAmount(2000L);//退款金额
        tradeProductRefundReqDTO.setRefundCcy("156");//退款币种
        tradeProductRefundReqDTO.setRefundReason("测试退款");//退款原因
        tradeProductRefundReqDTO.setProductCode("71100080237");//46产品码
//        tradeProductCreateAndPayOrderReqDTO.setProductCode("71100060194");//沙箱产品码
        tradeProductRefundReqDTO.setMemo("退款POS");//备注 O
        tradeProductRefundReqDTO.setOperator("WY");//操作人

        Result<TradeProductBaseResDTO> result = tradeProductRefundService.refund(tradeProductRefundReqDTO, traceLogId);
        System.out.println("********************被推荐人退款********************");
        System.out.println("日志号:" + traceLogId);
        System.out.println("是否成功：" + result.isSuccess());
        System.out.println("错误信息:" + result.getErrorMsg());
        System.out.println("返回信息:" + result.getResult());
    }
}
