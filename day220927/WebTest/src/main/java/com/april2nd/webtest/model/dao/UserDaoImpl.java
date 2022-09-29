package com.april2nd.webtest.model.dao;

import com.april2nd.webtest.dto.Note;
import com.april2nd.webtest.dto.User;
import com.april2nd.webtest.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{
    public static UserDaoImpl instance = new UserDaoImpl();
    DBUtil dbUtil = DBUtil.getInstance();

    private UserDaoImpl() {}

    public static UserDaoImpl getInstance() {
        return instance;
    }

    @Override
    public User logIn(User user) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User userInfo = null;

        try{
            String sql = "SELECT * FROM user WHERE id = ? AND pw = ?; \n";
            conn = dbUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getPw());

            rs = pstmt.executeQuery();

            if(rs.next()){
                userInfo = new User();

                userInfo.setId(rs.getString("id"));
                userInfo.setPw(rs.getString("pw"));
            }
        } finally {
            dbUtil.close(rs, pstmt, conn);
        }
        return userInfo;
    }
}
