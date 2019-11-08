package TradeProduct;

import Customize.DataGenerate;
import com.xx.dubbo.result.Result;
import com.xx.tradeproduct.service.acquiring.api.TradeProductSeniorOrderService;
import com.xx.tradeproduct.service.acquiring.api.model.TradeProductCreateAndPayOrderReqDTO;
import com.xx.tradeproduct.service.acquiring.api.model.result.TradeProductResDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * Created by zengyouzu on 2019/9/24.
 * 3.0产品层下单消费
 */
public class CreateAndPay extends DataGenerate {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    static TradeProductSeniorOrderService tradeProductSeniorOrderService = (TradeProductSeniorOrderService) ac.getBean("tradeProductSeniorOrderService");

    @Test
    public static void createAndPay() {
        String traceLogId = TraceLogId();

        TradeProductCreateAndPayOrderReqDTO tradeProductCreateAndPayOrderReqDTO = new TradeProductCreateAndPayOrderReqDTO();
        tradeProductCreateAndPayOrderReqDTO.setPlatformMerchantNo("999999999");//平台商户号
        tradeProductCreateAndPayOrderReqDTO.setRequestOrderNo("Req" + RandomStringNo());//请求系统单号
        tradeProductCreateAndPayOrderReqDTO.setRequestSystem("TRADE_ACQUIRING");//请求系统
        tradeProductCreateAndPayOrderReqDTO.setRequestDate(now);//请求时间
        tradeProductCreateAndPayOrderReqDTO.setProductCode("71100080237");//46产品码
//        tradeProductCreateAndPayOrderReqDTO.setProductCode("71100060194");//沙箱产品码
        tradeProductCreateAndPayOrderReqDTO.setTradeChannel("POS");//交易渠道
        tradeProductCreateAndPayOrderReqDTO.setCustomerOperatorNo("3178002078357137");//
        tradeProductCreateAndPayOrderReqDTO.setAmount(2000L);//金额
        tradeProductCreateAndPayOrderReqDTO.setCcy("156");//币种
        tradeProductCreateAndPayOrderReqDTO.setRate(0l);//汇率
        tradeProductCreateAndPayOrderReqDTO.setForeignCcy("");//外币币种
        tradeProductCreateAndPayOrderReqDTO.setForeignAmount(0L);//外币金额
        tradeProductCreateAndPayOrderReqDTO.setStoreCode("ST00003");//门店号
        tradeProductCreateAndPayOrderReqDTO.setMerchantTradeNo("Mer" + RandomStringNo());
        tradeProductCreateAndPayOrderReqDTO.setGoodsInfo("高级即时下单并支付");//商品信息摘要
        tradeProductCreateAndPayOrderReqDTO.setTimeOut(100000L);//超时时间
        tradeProductCreateAndPayOrderReqDTO.setSecurity("DOUBLEFACTOR");//安全等级
        tradeProductCreateAndPayOrderReqDTO.setOperator("WY");//操作人
        tradeProductCreateAndPayOrderReqDTO.setMemo("高级即时下单并支付");//备注

        int TradeType = 1;//1 业务返现金; 2 业务返红包金; 3 业务返代金券
        switch (TradeType) {
            case 1:
                tradeProductCreateAndPayOrderReqDTO.setMerchantNo("3178002076404718");//46
//                tradeProductCreateAndPayOrderReqDTO.setMerchantNo("3178002070610393");//沙箱
                Result<TradeProductResDTO> result1 = tradeProductSeniorOrderService.createSeniorOrderAndPay(tradeProductCreateAndPayOrderReqDTO, traceLogId);
                System.out.println("********************被推荐人消费********************");
                System.out.println("日志号:" + traceLogId);
                System.out.println("是否成功：" + result1.isSuccess());
                System.out.println("错误信息:" + result1.getErrorMsg());
                System.out.println("返回信息:" + result1.getResult());
                break;

            case 2:
                tradeProductCreateAndPayOrderReqDTO.setMerchantNo("3178002076404848");//46
//                tradeProductCreateAndPayOrderReqDTO.setMerchantNo("3178002070610263");//沙箱
                Result<TradeProductResDTO> result2 = tradeProductSeniorOrderService.createSeniorOrderAndPay(tradeProductCreateAndPayOrderReqDTO, traceLogId);
                System.out.println("********************被推荐人消费********************");
                System.out.println("日志号:" + traceLogId);
                System.out.println("是否成功：" + result2.isSuccess());
                System.out.println("错误信息:" + result2.getErrorMsg());
                System.out.println("返回信息:" + result2.getResult());
                break;

            case 3:
                tradeProductCreateAndPayOrderReqDTO.setMerchantNo("3178002076404969");//46
//                tradeProductCreateAndPayOrderReqDTO.setMerchantNo("3178002070610254");//沙箱
                Result<TradeProductResDTO> result3 = tradeProductSeniorOrderService.createSeniorOrderAndPay(tradeProductCreateAndPayOrderReqDTO, traceLogId);
                System.out.println("********************被推荐人消费********************");
                System.out.println("日志号:" + traceLogId);
                System.out.println("是否成功：" + result3.isSuccess());
                System.out.println("错误信息:" + result3.getErrorMsg());
                System.out.println("返回信息:" + result3.getResult());
                break;
        }
    }
}
