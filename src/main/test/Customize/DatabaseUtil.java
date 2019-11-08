package Customize;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by zengyouzu on 2019/1/31.
 * 数据库工具类
 */
public class DatabaseUtil {
    private static String MySQLDriver = "com.mysql.jdbc.Driver";

    private static String OracleDriver = "oracle.jdbc.driver.OracleDriver";

    //46环境oracle数据库Account库
    private static String AccountUrl = "jdbc:oracle:thin:@xxx.xx.xx.x:1521/test30";
    private static String AccountUserName = "ACCOUNT";
    private static String AccountPassWord = "xx";

    //46环境mysql数据库marketing_portal库
    private static String PortalUrl = "jdbc:mysql://xxx.xx.xx.x:3306/marketing_portal";
    private static String PortalName = "u_portal";
    private static String PortalPassWord = "u_portal78@78M";

    //46环境mysql数据库marketing_ledger库
    private static String LedgerUrl = "jdbc:mysql://xxx.xx.xx.x:3306/marketing_ledger";
    private static String LedgerUserName = "u_ledger";
    private static String LedgerPassWord = "u_ledger78@78M";

    //46环境mysql数据库marketing_limit库
    private static String LimitUrl = "jdbc:mysql://xxx.xx.xx.x:3306/marketing_limit";
    private static String LimitUserName = "u_limit";
    private static String LimitPassWord = "u_limit78@78M";

    //46环境mysql数据库marketing_activity_operation库
    private static String ActivityUrl = "jdbc:mysql://xxx.xx.xx.x:3306/marketing_activity_operation";
    private static String ActivityUserName = "u_activity";
    private static String ActivityPassWord = "u_activity78@78M";

    //46环境mysql数据库marketing_encourage库
    private static String EncourageUrl = "jdbc:mysql://xxx.xx.xx.x:3306/marketing_encourage";
    private static String EncourageUserName = "u_encourage";
    private static String EncouragePassWord = "u_encourage78@78M";

    //46环境mysql数据库marketing_rule库
    private static String RuleUrl = "jdbc:mysql://xxx.xx.xx.x:3306/marketing_rule";
    private static String RuleUserName = "mktrule_app";
    private static String RulePassWord = "mktrule_app78@78M";

    //沙箱oracle数据库
    /*private static String AccountUrl = "jdbc:oracle:thin:@xxx.xx.xx.x:1521/test30";
    private static String AccountUserName = "ACCOUNT_APP";
    private static String AccountPassWord = "xx";*/

    //沙箱环境mysql数据库marketing_encourage库
//    private static String EncourageUrl = "jdbc:mysql://xxx.xx.xx.x:3306/marketing_encourage";
//    private static String EncourageUserName = "u_encourage";
//    private static String EncouragePassWord = "u_encourage78@78M";

    static {
        try {
            Class.forName(MySQLDriver);
            Class.forName(OracleDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //连接marketing_encourage数据库
    public static Connection connectToEncourage() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(EncourageUrl, EncourageUserName, EncouragePassWord);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //连接客户体系数据库
    public static Connection connectToAccount() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(AccountUrl, AccountUserName, AccountPassWord);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //关闭数据库连接
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //测试连接是否成功
    public static void main(String[] args) {
        connectToAccount();
    }
}
