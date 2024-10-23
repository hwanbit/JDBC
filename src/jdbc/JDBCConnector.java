//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnector {
    private static Connection con;
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
    private static final String USER_NAME = "c##sun";
    private static final String PASSWORD = "1234";

    public JDBCConnector() {
    }

    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("JDBC Driver 정상 로딩 성공.");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "c##sun", "1234");
            System.out.println("Oracle DB와 연결 성공.");
        } catch (ClassNotFoundException var1) {
            System.out.println("Oracle JDBC Driver 파일을 찾지 못했습니다.");
        } catch (SQLException var2) {
            System.out.println("Oracle DB와 연결이 되지 않았습니다.");
        }

        return con;
    }
}