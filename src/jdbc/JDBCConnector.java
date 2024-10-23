package jdbc;
// OJDBC 드라이버 설치 -> EXTERNAL 라이브러리에 넣고 IMPORT -> JDBC 드라이버 로딩(객체 생성) -> 정상적으로 로딩되는지 확인(TRY-CATCH)
// ORACLE 데이터베이스에 접속하기 위한 URL, USER NAME, PASSWORD 필요 => FINAL 상수로 만듦
// MARIA DB같은 다른 DB와 연결 시, 그에 맞는 JDBC 설치 필요
// DB와 연결 실패 시 이유 : 데이터베이스 서버가 시작되지 않은 경우, URL이 잘못된 경우, USER NAME이 잘못된 경우, PASSWORD가 잘못된 경우
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnector {

    private static Connection con;
    // url, username, password 필요
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
    private static final String USER_NAME = "c##sun";
    private static final String PASSWORD = "1234";

    public static Connection getConnection(){
        // JDBC Driver Loading(OracleDriver 클래스의 객체 생성)
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("JDBC Driver 정상 로딩 성공.");
        // Oracle DB와 연결
            con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println("Oracle DB와 연결 성공.");
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver 파일을 찾지 못했습니다.");
        } catch (SQLException e) {
            System.out.println("Oracle DB와 연결이 되지 않았습니다.");
        }

        return con;
    }
}