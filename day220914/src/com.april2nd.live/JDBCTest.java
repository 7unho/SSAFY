package com.april2nd.live;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
    public static void main(String[] args) throws Exception{
        // 1. 제품군 선택 (driver loading)
        Class.forName("com.mysql.cj.jdbc.Driver");
//        Class.forName("com.mysql.jdbc.Driver");

        // 2. 연결객체 생성
        String url = "jdbc:mysql://127.0.0.1:3306/ssafy_user?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
//        String url = "jdbc:mysql://localhost:3306/ssafydb";
        Connection conn = DriverManager.getConnection(url, "root", "jorbors97!");

        System.out.println("DB 연결 성공 !!");

        // 미션 1.
        String sql = "insert into dept values(50, 'IT', '도쿄')";

        // 3. 실험 객체 생성
        Statement stmt = conn.createStatement();
        // 실행 요청하는 sql 명령문이 insert, update, delete일 때 사용
//        int rowCnt = stmt.executeUpdate(sql);

//        System.out.println("rowCnt (입력된 행의 개수) >>> " + rowCnt);

        // 미션 2.
        sql = "select empno, ename, sal from emp where deptno = 20";
        // 4. 결과 집합 객체 생성
        ResultSet rs = stmt.executeQuery(sql);

        // rs => 행열 ( 덩어리 데이터 ) : record
        // 4-1. get rows data : rs.next()
        // 4-2. get cols data : rs.getInt(조회된 인덱스), rs.getString(컬럼명), rs.getDate()

    }
}
