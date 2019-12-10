package Customize;

import Customize.SQLTable.Oracle.T_MARKET_CHANNEL_RELATION;
import Customize.SQLTable.Oracle.T_MARKET_MERCHANT_RELATION;
import Customize.SQLTable.Oracle.T_MARKET_REBATE_TYPE;
import Customize.SQLTable.Oracle.T_MARKET_TXN_TYPE_RELATION;
import Encourge.recommend.CombineTest;
import Encourge.recommend.RecommendService;
import MarketingBusiness.BusinessService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.sql.*;
import java.util.*;

/**
 * Created by zengyouzu on 2019/2/11.
 * 数据库操作方法类
 */
public class SQLOperate extends DatabaseUtil {

    static RecommendService recommendService = CombineTest.recommendService;
    static BusinessService businessService = new BusinessService();

    //生效数据入工具信息表校验
    public static void CheckData() {
        String ToolId = recommendService.getToolId();

        if (ToolId != null) {
            String SQL = "SELECT t.* FROM t_rec_tools_info t WHERE t.TOOL_ID = " + "'" + ToolId + "'";
            System.out.println("****************************************");
            System.out.println(SQL + ";");
            System.out.println("****************************************");

            Connection connection = connectToEncourage();
            if (connection != null) {

            } else {
                System.out.println("数据库连接失败");
            }
            PreparedStatement preparedStatement = null;

            try {
                preparedStatement = connection.prepareStatement(SQL);
                ResultSet resultSet = preparedStatement.executeQuery(SQL);

                //判断执行SQL后结果集是否为空,为空证明数据没有入表
                if (!resultSet.next()) {
                    System.out.println("入表失败");
                } else {
                    System.out.println("入表成功");
                }
                resultSet.close();
                preparedStatement.close();
                closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("获取ToolId失败");
        }
    }

    //获取推荐人和被推荐人绑定关系信息
    public static void getBindingInfo() {
        String ToolId = recommendService.getToolId();
        String ProductNo = recommendService.getProductNo();
        String RecommendProductNo = recommendService.getRecommendProductNo();
        String RecommendedOperatorNo = null;
        String RecommendedContractNo = null;
        String RecommendContractNo = null;
        Map BindingInfoMap = new HashMap<>();

        if (ToolId != null) {
            String SQL = "SELECT t.* FROM t_rec_binding_info t WHERE t.TOOL_ID =  " + "'" + ToolId + "'" + "AND t.REC_LOGIN_NO =" + "'" + ProductNo + "'" + "AND t.RECOMMENDED_LOGIN_NO =" + "'" + RecommendProductNo + "'";
            System.out.println("****************************************");
            System.out.println(SQL + ";");
            System.out.println("****************************************");

            Connection connection = connectToEncourage();
            if (connection != null) {

            } else {
                System.out.println("数据库连接失败");
            }
            PreparedStatement preparedStatement = null;

            try {
                preparedStatement = connection.prepareStatement(SQL);
                ResultSet resultSet = preparedStatement.executeQuery(SQL);
                ResultSetMetaData data = resultSet.getMetaData();

                // 获取第N列的值
                while (resultSet.next()) {
                    RecommendedOperatorNo = resultSet.getString("RECOMMENDED_OPERATION");
                    RecommendedContractNo = resultSet.getString("RECOMMENDED_CONTRACT_NO");
                    RecommendContractNo = resultSet.getString("REC_CONTRACT_NO");
                    if (RecommendedOperatorNo != null) {
                        System.out.println(ToolId + "被推荐人操作员号:" + RecommendedOperatorNo);
                    } else {
                        System.out.println("所取字段为null");
                    }
                    if (RecommendedContractNo != null) {
                        System.out.println(ToolId + "被推荐人客户账户号:" + RecommendedContractNo);
                    } else {
                        System.out.println("所取字段为null");
                    }
                    if (RecommendContractNo != null) {
                        System.out.println(ToolId + "被推荐人客户账户号:" + RecommendContractNo);
                    } else {
                        System.out.println("所取字段为null");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("获取ToolId失败");
        }

        BindingInfoMap.put("RecommendedOperatorNo", RecommendedOperatorNo);
        BindingInfoMap.put("RecommendedContractNo", RecommendedContractNo);
        BindingInfoMap.put("RecommendContractNo", RecommendContractNo);

        recommendService.setBindingInfoMap(BindingInfoMap);

    }

    //账户余额校验
    public static void checkAccount() {
        Map BindingInfoMap = recommendService.getBindingInfoMap();
        String RecommendedContractNo = BindingInfoMap.get("RecommendedContractNo").toString();
        String RecommendContractNo = BindingInfoMap.get("RecommendContractNo").toString();
        String RecommendedBal = null;//被推荐人账户余额
        String RecommendBal = null;//推荐人账户余额

        if (RecommendedContractNo != null && RecommendContractNo != null) {
            String SQL1 = "SELECT t.* FROM t_bal_person_unwithdraw t WHERE t.CONTRACT_NO = " + "'" + RecommendedContractNo + "'";
            String SQL2 = "SELECT t.* FROM t_bal_person_unwithdraw t WHERE t.CONTRACT_NO = " + "'" + RecommendContractNo + "'";
            System.out.println("****************************************");
            System.out.println(SQL1 + ";");
            System.out.println(SQL2 + ";");
            System.out.println("****************************************");

            Connection connection = connectToAccount();
            if (connection != null) {

            } else {
                System.out.println("数据库连接失败");
            }
            PreparedStatement preparedStatement = null;

            try {
                preparedStatement = connection.prepareStatement(SQL1);
                ResultSet resultSet = preparedStatement.executeQuery(SQL1);
                ResultSetMetaData data = resultSet.getMetaData();

                while (resultSet.next()) {
                    RecommendedBal = resultSet.getString("CURR_BAL");
                    if (RecommendedBal != null) {
                        System.out.println("被推荐人" + RecommendedContractNo + "账户余额:" + RecommendedBal);
                    } else {
                        System.out.println("所取字段为null");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                preparedStatement = connection.prepareStatement(SQL2);
                ResultSet resultSet = preparedStatement.executeQuery(SQL2);
                ResultSetMetaData data = resultSet.getMetaData();

                while (resultSet.next()) {
                    RecommendBal = resultSet.getString("CURR_BAL");
                    if (RecommendBal != null) {
                        System.out.println("推荐人" + RecommendContractNo + "账户余额:" + RecommendBal);
                    } else {
                        System.out.println("所取字段为null");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("获取推荐人&被推荐人信息失败");
        }
    }

    //校验推荐人和被推荐人绑定状态
    public static void checkBindingStatus() {
        String ToolId = recommendService.getToolId();
        String ProductNo = recommendService.getProductNo();
        String RecommendProductNo = recommendService.getRecommendProductNo();

        if (ToolId != null) {
            String SQL = "SELECT t.* FROM t_rec_binding_info t WHERE t.TOOL_ID =  " + "'" + ToolId + "'" + "AND t.REC_LOGIN_NO =" + "'" + ProductNo + "'" + "AND t.RECOMMENDED_LOGIN_NO =" + "'" + RecommendProductNo + "'";
            System.out.println("****************************************");
            System.out.println(SQL + ";");
            System.out.println("****************************************");

            Connection connection = connectToEncourage();
            if (connection != null) {

            } else {
                System.out.println("数据库连接失败");
            }
            PreparedStatement preparedStatement = null;

            try {
                preparedStatement = connection.prepareStatement(SQL);
                ResultSet resultSet = preparedStatement.executeQuery(SQL);
                ResultSetMetaData data = resultSet.getMetaData();

                while (resultSet.next()) {
                    if (resultSet.getString("STATUS") != null) {
                        System.out.println("推荐人被推荐人绑定状态为:" + resultSet.getString("STATUS"));
                    } else {
                        System.out.println("所取字段为null");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("获取ToolId失败");
        }
    }

    //查询活动基本信息
    public static void getActivityBasicInfo(String ActivityId) {
        String MerchantId = null;//商户号
        String OutTxnType = null;//外部交易类型
        String TxnChannel = null;//渠道
        String Threshold = null;//门槛
        List<String> MerchantIdList = new ArrayList<>();
        List<String> OutTxnTypeList = new ArrayList<>();
        List<String> TxnChannelList = new ArrayList<>();
        Map ActivityInfoMap = new HashMap<>();

        Connection connection = connectToMarketing();
        if (connection != null) {

        } else {
            System.out.println("数据库连接失败");
        }

        try {
            //查询活动商户
            String SQL = "SELECT t.* FROM t_market_merchant_relation t WHERE t.market_cfg_id = " + "'" + ActivityId + "'";
            System.out.println("****************************************");
            System.out.println(SQL + ";");
            System.out.println("****************************************");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery(SQL);

            while (resultSet.next()) {
                if (resultSet.getString("MERCHANT_ID") != null) {
                    System.out.println("活动商户为:" + resultSet.getString("MERCHANT_ID"));
                    MerchantIdList.add(resultSet.getString("MERCHANT_ID"));
                } else {
                    System.out.println("所取字段为null");
                }
            }
            MerchantId = MerchantIdList.get(new Random().nextInt(MerchantIdList.size()));
            System.out.println("MerchantId:" + MerchantId);

            //查询活动外部交易类型
            SQL = "SELECT t.* FROM t_market_txn_type_relation t WHERE t.market_cfg_id = " + "'" + ActivityId + "'";
            System.out.println("****************************************");
            System.out.println(SQL + ";");
            System.out.println("****************************************");

            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery(SQL);

            while (resultSet.next()) {
                if (resultSet.getString("OUT_TXN_TYPE") != null) {
                    System.out.println("活动外部交易类型为:" + resultSet.getString("OUT_TXN_TYPE"));
                    OutTxnTypeList.add(resultSet.getString("OUT_TXN_TYPE"));
                } else {
                    System.out.println("所取字段为null");
                }
            }
            OutTxnType = OutTxnTypeList.get(new Random().nextInt(OutTxnTypeList.size()));
            System.out.println("OutTxnType:" + OutTxnType);

            //查询活动渠道
            SQL = "SELECT t.* FROM t_market_channel_relation t WHERE t.market_cfg_id = " + "'" + ActivityId + "'";
            System.out.println("****************************************");
            System.out.println(SQL + ";");
            System.out.println("****************************************");

            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery(SQL);

            while (resultSet.next()) {
                if (resultSet.getString("TXN_CHANNEL") != null) {
                    System.out.println("活动渠道为:" + resultSet.getString("TXN_CHANNEL"));
                    TxnChannelList.add(resultSet.getString("TXN_CHANNEL"));
                } else {
                    System.out.println("所取字段为null");
                }
            }
            TxnChannel = TxnChannelList.get(new Random().nextInt(TxnChannelList.size()));
            System.out.println("TxnChannel:" + TxnChannel);

            //查询活动门槛
            SQL = "SELECT t.* FROM t_market_rebate_type t WHERE t.market_cfg_id = " + "'" + ActivityId + "'";
            System.out.println("****************************************");
            System.out.println(SQL + ";");
            System.out.println("****************************************");

            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery(SQL);

            while (resultSet.next()) {
                if (resultSet.getString("MIN_TXN_AMT") != null) {
                    System.out.println("活动门槛为:" + resultSet.getString("MIN_TXN_AMT"));
                    Threshold = resultSet.getString("MIN_TXN_AMT");
                } else {
                    System.out.println("所取字段为null");
                }
            }

            //查询活动门店
            SQL = "SELECT t.* FROM t_market_rebate_type t WHERE t.market_cfg_id = " + "'" + ActivityId + "'";
            System.out.println("****************************************");
            System.out.println(SQL + ";");
            System.out.println("****************************************");

            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery(SQL);

            while (resultSet.next()) {
                if (resultSet.getString("MIN_TXN_AMT") != null) {
                    System.out.println("活动门槛为:" + resultSet.getString("MIN_TXN_AMT"));
                    Threshold = resultSet.getString("MIN_TXN_AMT");
                } else {
                    System.out.println("所取字段为null");
                }
            }

            ActivityInfoMap.put("MerchantId", MerchantId);
            ActivityInfoMap.put("OutTxnType", OutTxnType);
            ActivityInfoMap.put("TxnChannel", TxnChannel);
            ActivityInfoMap.put("Threshold", Threshold);

            businessService.setActivityInfoMap(ActivityInfoMap);

            resultSet.close();
            preparedStatement.close();
            closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //查询活动基本信息
    public static void getBasicInfo(String MarketCfgId) throws Exception {
        Map ActivityInfoMap = new HashMap<>();
        String MerchantId = null;//商户号
        String OutTxnType = null;//外部交易类型
        String TxnChannel = null;//渠道
        String Threshold = null;//门槛
        List<String> MerchantIdList = new ArrayList<>();
        List<String> OutTxnTypeList = new ArrayList<>();
        List<String> TxnChannelList = new ArrayList<>();

        InputStream inputStream = Resources.getResourceAsStream("Configuration.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        T_MARKET_MERCHANT_RELATION selectMerchant = new T_MARKET_MERCHANT_RELATION();
        selectMerchant.setMARKET_CFG_ID(MarketCfgId);
        List<T_MARKET_MERCHANT_RELATION> merchantList = new ArrayList<>();
        merchantList = sqlSession.selectList("MerchantTest.selectMerchant", selectMerchant);
        for (T_MARKET_MERCHANT_RELATION merchant : merchantList) {
            MerchantIdList.add(merchant.getMERCHANT_ID());
//            System.out.println("商户号:" + merchant.getMERCHANT_ID());
        }
        MerchantId = MerchantIdList.get(new Random().nextInt(MerchantIdList.size()));
        System.out.println("商户号:" + MerchantId);
        System.out.println("****************************************");

        T_MARKET_TXN_TYPE_RELATION selectTxn = new T_MARKET_TXN_TYPE_RELATION();
        selectTxn.setMARKET_CFG_ID(MarketCfgId);
        List<T_MARKET_TXN_TYPE_RELATION> txnList = new ArrayList<>();
        txnList = sqlSession.selectList("TxnTest.selectTxn", selectTxn);
        for (T_MARKET_TXN_TYPE_RELATION txn : txnList) {
            OutTxnTypeList.add(txn.getOUT_TXN_TYPE());
//            System.out.println("外部交易类型:" + txn.getOUT_TXN_TYPE());
        }
        OutTxnType = OutTxnTypeList.get(new Random().nextInt(OutTxnTypeList.size()));
        System.out.println("外部交易类型:" + OutTxnType);
        System.out.println("****************************************");

        T_MARKET_CHANNEL_RELATION selectChannel = new T_MARKET_CHANNEL_RELATION();
        selectChannel.setMARKET_CFG_ID(MarketCfgId);
        List<T_MARKET_CHANNEL_RELATION> channelList = new ArrayList<>();
        channelList = sqlSession.selectList("ChannelTest.selectChannel", selectChannel);
        for (T_MARKET_CHANNEL_RELATION channel : channelList) {
            TxnChannelList.add(channel.getTXN_CHANNEL());
//            System.out.println("渠道:" + channel.getTXN_CHANNEL());
        }
        TxnChannel = TxnChannelList.get(new Random().nextInt(TxnChannelList.size()));
        System.out.println("渠道:" + TxnChannel);
        System.out.println("****************************************");

        T_MARKET_REBATE_TYPE selectMinTxnAmt = new T_MARKET_REBATE_TYPE();
        selectMinTxnAmt.setMARKET_CFG_ID(MarketCfgId);
        Threshold = sqlSession.selectOne("RebateTypeTest.selectMinTxnAmt", selectMinTxnAmt);
        System.out.println("最小消费金额:" + Threshold);
        System.out.println("****************************************");

        ActivityInfoMap.put("MerchantId", MerchantId);
        ActivityInfoMap.put("OutTxnType", OutTxnType);
        ActivityInfoMap.put("TxnChannel", TxnChannel);
        ActivityInfoMap.put("Threshold", Threshold);
    }

    @Test
    public void test() {
//        getBindingInfo();
//        checkAccount();
//        getActivityBasicInfo("A30990191125181516000068");
        try {
            getBasicInfo("A30990191125181516000068");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
