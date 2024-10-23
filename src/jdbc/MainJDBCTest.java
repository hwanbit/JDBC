package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainJDBCTest {

    public static void main(String[] args) {
        // Connection 개체의 주소값 (참조값) 반환
        // 연결이 되면 SQL문을 실행할 수 있는 문장 객체 필요 (statement, prepared statement)
        // 문장 객체가 있다면 SQL문 실행 (문장 객체의 메서드를 통해 실행)
        Connection con = JDBCConnector.getConnection();
        String sql = "select 주문고객, 제품명, 수량 from 주문 o, 제품 p where o.주문제품 = p.제품번호";
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(sql);
            ResultSet result = pstmt.executeQuery();
            // result = sql문의 출력 결과, result.next(); 를 통해 result 값의 첫번째 행을 가리킬 수 있음, 후에 get 메서드를 통해 특정 행과 열을 가져옴
            // while문에 boolean을 통해 다음 행에 값이 있는지 판단 (값이 있으면 true, 값이 없으면 false)

            // sql문은 index가 0이 아닌 1로 시작, column 명으로 접근하는 게 가독성이 좋음
            while (result.next()) {
                //String customerId = result.getString(2);
                String customerId = result.getString("주문고객");
                String productName = result.getString("제품명");
                int count = result.getInt("수량");
                System.out.printf("-주문고객명 : %s\t-주문제품명 : %s\t-수량 : %d\n", customerId, productName, count);
            }

        } catch (SQLException e) {
            System.out.println("문장객체 생성에 문제가 발생했습니다.");
        }
        try {
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("연결 종료에 문제가 발생했습니다.");
        }
    }
}