package Ledger;

import com.xx.dubbo.result.Result;
import com.xx.infra.skynet.testng.dataProviderUtils.spring.BeanUtil;
import com.xx.marketing.coupon.center.api.CouponBatchEffectService;
import com.xx.marketing.coupon.center.api.enums.*;
import com.xx.marketing.coupon.center.api.model.request.CouponBatchEffectListReqDTO;
import com.xx.marketing.coupon.center.api.model.request.CouponBatchEffectReqDTO;
import com.xx.marketing.coupon.center.api.model.request.CouponCostAllocationReqDTO;
import com.xx.marketing.coupon.center.api.model.request.CouponMerchantReqDTO;
import com.xx.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by wangyan on 2019/6/21.
 * 新红包金批次生效接口
 */
public class CouponBatchEffectServiceTest {
    @Autowired
    ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    CouponBatchEffectService couponBatchEffectService = (CouponBatchEffectService) ac.getBean("couponBatchEffectService");

    //新红包金批次生效接口
    @Test//(invocationCount = 100, threadPoolSize = 10,groups = { "t9"})
    public void couponBatchEffectBatchTest() throws Exception {
        CouponBatchEffectListReqDTO couponBatchEffectListReqDTO = new CouponBatchEffectListReqDTO();
        String traceLogId = UUID.randomUUID().toString();

        String requestno = "ZZ" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

        couponBatchEffectListReqDTO.setRequestNo(requestno);
        couponBatchEffectListReqDTO.setRequestSystem("COUPON_PRODUCT");
        couponBatchEffectListReqDTO.setRequestDate(new Date());

        //成本分摊
        List<CouponCostAllocationReqDTO> couponCostApplyReqDTOList = new ArrayList<CouponCostAllocationReqDTO>();

        //成本分摊参数1
        CouponCostAllocationReqDTO couponCostApplyReqDTO1 = new CouponCostAllocationReqDTO();
        couponCostApplyReqDTO1.setEnterpriseAccount("7100846211127156");//预存款账户,出资账户
        couponCostApplyReqDTO1.setInvestmentOrgCode("3178002074056410");//出资机构代码,商户号
        couponCostApplyReqDTO1.setInvestmentOrgName("中国电信股份有限公司辽宁分公司");//出资机构名称
        couponCostApplyReqDTO1.setInvestorType(InvestorTypeEnum.PROVINCE.getCode());//枚举值
        couponCostApplyReqDTO1.setInvestmentWay("84");//出资方式
        couponCostApplyReqDTO1.setCostCfgPercentage(new BigDecimal(30));//比例
        couponCostApplyReqDTO1.setCreatedBy("System");
        couponCostApplyReqDTO1.setIsAdvance("N");//是否垫资
        couponCostApplyReqDTOList.add(couponCostApplyReqDTO1);

        //成本分摊参数2
        CouponCostAllocationReqDTO couponCostApplyReqDTO2 = new CouponCostAllocationReqDTO();
        couponCostApplyReqDTO2.setEnterpriseAccount("881232040000011156");//预存款账户,出资账户
        couponCostApplyReqDTO2.setInvestmentOrgCode("");//出资机构代码,
        couponCostApplyReqDTO2.setInvestmentOrgName("");//出资机构名称
        couponCostApplyReqDTO2.setInvestorType(InvestorTypeEnum.PROVINCE.getCode());//枚举值
        couponCostApplyReqDTO2.setInvestmentWay("91");//出资方式 一点结算
        couponCostApplyReqDTO2.setCostCfgPercentage(new BigDecimal(70));//比例
        couponCostApplyReqDTO2.setCreatedBy("System");
        couponCostApplyReqDTO2.setIsAdvance("Y");//是否垫资
        couponCostApplyReqDTOList.add(couponCostApplyReqDTO2);

        //商户list
        Set<CouponMerchantReqDTO> couponMerchantReqDTOSet = new HashSet<CouponMerchantReqDTO>();
        //商户1
        CouponMerchantReqDTO couponMerchantReqDTO1 = new CouponMerchantReqDTO();
        couponMerchantReqDTO1.setMerchantNo("3178002069818414");//商户号
        couponMerchantReqDTO1.setMerchantName("测试商户");
        couponMerchantReqDTO1.setCreatedBy("System");
        couponMerchantReqDTOSet.add(couponMerchantReqDTO1);

        //商户2
        CouponMerchantReqDTO couponMerchantReqDTO2 = new CouponMerchantReqDTO();
        couponMerchantReqDTO2.setMerchantNo("3178002069818414");//商户号
        couponMerchantReqDTO2.setMerchantName("测试商户");
        couponMerchantReqDTO2.setCreatedBy("System");
        couponMerchantReqDTOSet.add(couponMerchantReqDTO2);

        //红包金批次生效
        List<CouponBatchEffectReqDTO> couponBatchEffectReqDTOList = new ArrayList<CouponBatchEffectReqDTO>();

        CouponBatchEffectReqDTO couponBatchEffectReqDTO1 = new CouponBatchEffectReqDTO();
        couponBatchEffectReqDTO1.setBatchName("TEST0510");//批次名
        couponBatchEffectReqDTO1.setBatchNo("wy20190621001");
        couponBatchEffectReqDTO1.setCostAmt(1000000L); //总成本
        couponBatchEffectReqDTO1.setDenomination(100L);//面额
        couponBatchEffectReqDTO1.setThresholdAmt(0L);//门槛

        couponBatchEffectReqDTO1.setCreatedProvince("340000"); //创建省份,340000,999900
        Set CreatedCity = new HashSet();//999901
        CreatedCity.add("340010");
        CreatedCity.add("340020");//340020
        couponBatchEffectReqDTO1.setCreatedCity(CreatedCity); //创建城市,340010
        Set CustomerLevel = new HashSet();
        CustomerLevel.add(CustomerLevelEnum.GUEST.getCode());
        CustomerLevel.add(CustomerLevelEnum.TWO.getCode());
        CustomerLevel.add(CustomerLevelEnum.THREE.getCode());
        couponBatchEffectReqDTO1.setCustomerLevel(CustomerLevel);//客户等级,枚举,GUEST,TWO,THREE

        Set TradeChannel = new HashSet();
        TradeChannel.add(TradeChannelEnum.WEB.getCode());
        TradeChannel.add(TradeChannelEnum.APP.getCode());
        TradeChannel.add(TradeChannelEnum.POS.getCode());
        TradeChannel.add(TradeChannelEnum.H5.getCode());
        couponBatchEffectReqDTO1.setTradeChannel(TradeChannel);//渠道暂时只有五种:WEB、APP、POS、H5、INNER; 没有ALL

        Set ProductCode = new HashSet();
        ProductCode.add("68800020138");
        ProductCode.add("68800020205");
        couponBatchEffectReqDTO1.setProductCode(ProductCode); //产品码,68800020138 68800020205
        couponBatchEffectReqDTOList.add(couponBatchEffectReqDTO1);

        couponBatchEffectReqDTO1.setEffectType(EffectTypeEnum.ASSIGN.getCode());//生效方式,枚举,ASSIGN:指定,CIRCLE:周期
        couponBatchEffectReqDTO1.setEffectStartTime(DateUtil.parse("20190610"));//生效时间,dBefore（指定）
        couponBatchEffectReqDTO1.setEffectEndTime(DateUtil.parse("20200620"));//失效时间,dAfter（指定）
        couponBatchEffectReqDTO1.setEffectInterval(2);//间隔天数（周期）,XX天后生效
        couponBatchEffectReqDTO1.setEffectCircle(7);//生效周期（周期）,起止日期为X天
        couponBatchEffectReqDTO1.setFinalDistributeTime(DateUtil.parse("20200620")); //最后发券时间,dAfter
        couponBatchEffectReqDTO1.setBatchType(BatchTypeEnum.COMMON.getCode());//批次类型,枚举,COMMON:通用券,MERCHANT;商户券,PRODUCT_CODE;业务券
        couponBatchEffectReqDTO1.setDenominationType(DenominationTypeEnum.FIXED.getCode()); //面值类型,枚举,FIXED:固定面值
        couponBatchEffectReqDTO1.setMinDenomination(0L);//最小 消费门槛
        // couponBatchEffectReqDTO.setMaxDenomination(999L);//最大消费门槛  可为空
        couponBatchEffectReqDTO1.setNeedBindCard("N");//是否绑卡,枚举,Y,N
        couponBatchEffectReqDTO1.setNeedInvoice("N"); //是否开票,枚举,Y,N
        couponBatchEffectReqDTO1.setDistributeMsgFlag("N");//发券短信开关
        couponBatchEffectReqDTO1.setConsumeMsgFlag("N");//消费短信开关F
        couponBatchEffectReqDTO1.setTms("QBH"); //签报号,QBH
        couponBatchEffectReqDTO1.setTmsFinance("TF001");//财务回单号
        couponBatchEffectReqDTO1.setDistributeMsgTemplateId("SMS_TP_00001492"); //发券短信模板号,默认,SMS_TP_00001492;自定义,SMS_TP_00001503
        couponBatchEffectReqDTO1.setDistributeMsgContent("abc"); //发券短信自定义内容,abc
        couponBatchEffectReqDTO1.setConsumeMsgTemplateId("SMS002");//消费短信id,SMS002
        couponBatchEffectReqDTO1.setConsumeMsgContent("cba");//消费短信自定义内容,cba
        couponBatchEffectReqDTO1.setUseRule("XYZ");//使用规则,XYZ
        couponBatchEffectReqDTO1.setDepartment("01");//所属部门  01
        couponBatchEffectReqDTO1.setActivityPurpose("01");//活动目的
        couponBatchEffectReqDTO1.setCreatedBy("SYSTEM");//创建人
        couponBatchEffectReqDTO1.setToolId("1");
        couponBatchEffectReqDTO1.setToolType("11");
        couponBatchEffectReqDTO1.setActivityId("111");
        couponBatchEffectReqDTO1.setActivityType("1111");

        couponBatchEffectReqDTO1.setCouponCostAllocationReqDTOList(couponCostApplyReqDTOList);//成本分摊
        couponBatchEffectReqDTO1.setCouponMerchantReqDTOSet(couponMerchantReqDTOSet);//商户list
        couponBatchEffectListReqDTO.setCouponBatchEffectReqDTOS(couponBatchEffectReqDTOList);
        Result<Boolean> result = couponBatchEffectService.couponBatchEffectBatch(couponBatchEffectListReqDTO, traceLogId);

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("日志编号:" + traceLogId);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("result:" + result);

        System.out.println("是否成功:" + result.isSuccess());
        System.out.println("错误码:" + result.getErrorCode());
        System.out.println("错误信息:" + result.getErrorMsg());

    }

}
