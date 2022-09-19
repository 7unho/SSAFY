package com.live1.live1.member.model.dao;

import com.live1.live1.member.model.MemberDto;
import com.live1.live1.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDaoImpl implements MemberDao{
    private static MemberDao memberDao = new MemberDaoImpl();
    private DBUtil dbUtil;
    private MemberDaoImpl() {
        dbUtil = DBUtil.getInstance();
    }

    public static MemberDao getMemberDao(){
        return memberDao;
    }

    @Override
    public int idCheck(String userId) throws SQLException {
        int cnt = 1;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT count(*) \n");
            sql.append("FROM members \n");
            sql.append("WHERE user_id = ?");

            conn = dbUtil.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, userId);

            rs = pstmt.executeQuery();
            rs.next();

            cnt = rs.getInt(1);
        } finally {
            // rs, pstmt, conn은 AutoClosable을 상속받는다.
            dbUtil.close(rs, pstmt, conn);
        }
        return cnt;
    }

    @Override
    public void joinMember(MemberDto memberDto) throws SQLException {

    }

    @Override
    public MemberDto loginMember(String userId, String password) throws SQLException {
        return null;
    }
}
