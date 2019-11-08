package Customize;

import Customize.DatabaseUtil;
import Encourge.recommend.CombineTest;
import Encourge.recommend.RecommendService;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zengyouzu on 2019/2/11.
 * 数据库操作方法类
 */
public class SQLOperate extends DatabaseUtil {

    static RecommendService recommendService = CombineTest.recommendService;

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

    @Test
    public void test() {
        getBindingInfo();
//        checkAccount();
    }
}
