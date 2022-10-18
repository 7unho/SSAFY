package com.april2nd.live1.member.model.dao;

import com.april2nd.live1.member.model.MemberDto;
import com.april2nd.live1.util.DBUtil;

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
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dbUtil.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO members (user_id, user_name, user_password, email_id, email_domain, join_date) \n");
            sql.append("values(?, ?, ?, ?, ?, now()) \n");
            pstmt = conn.prepareStatement(sql.toString());
            int idx = 0;
            pstmt.setString(++idx, memberDto.getUserId());
            pstmt.setString(++idx, memberDto.getUserName());
            pstmt.setString(++idx, memberDto.getUserPwd());
            pstmt.setString(++idx, memberDto.getEmailId());
            pstmt.setString(++idx, memberDto.getEmailDomain());

            pstmt.executeUpdate();
        } finally {
            dbUtil.close(pstmt, conn);
        }
    }

    @Override
    public MemberDto loginMember(String userId, String password) throws SQLException {
        MemberDto memberDto = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn = dbUtil.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT user_id, user_name \n");
            sql.append("FROM members \n");
            sql.append("WHERE user_id = ? and user_password = ?");

            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, userId);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery();
            if(rs.next()){
                memberDto = new MemberDto();
                memberDto.setUserId(rs.getString("user_id"));
                memberDto.setUserName(rs.getString("user_name"));
            }
        } finally {
            // rs, pstmt, conn은 AutoClosable을 상속받는다.
            dbUtil.close(rs, pstmt, conn);
        }
        return memberDto;
    }
}
