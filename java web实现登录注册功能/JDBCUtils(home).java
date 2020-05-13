package src.util;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    public static String url;
    private static String user;
    private static String password;
    private static String dirver;

    public static void load(String home){
    //static{
        // 从Applistener的 contextInitialized传来应用所在位置的路径
        try {
        	// 打印出home的位置，然后把jdbc.properties文件放到这个目录下
            System.out.println("=================== " + home);
            
            Properties pro = new Properties();
			FileInputStream iFile = new FileInputStream(home + "jdbc.properties");
			pro.clear();
			pro.load(iFile);
			iFile.close();

            url = pro.getProperty("url");

            user = pro.getProperty("user");
            password = pro.getProperty("password");
            dirver = pro.getProperty("driver");
            //5.娉ㄥ唽椹卞姩
            Class.forName(dirver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 鑾峰彇杩炴帴
     * @return 杩炴帴瀵硅薄
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }


    /**
     * 閲婃斁璧勬簮
     * @param ress
     * @param stat
     * @param conn
     */
    public static void close(ResultSet ress, Statement stat, Connection conn){
        if(ress != null){
            try {
                ress.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stat != null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement stat, Connection conn){
        if(stat != null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
