package com.april2nd.webtest.model.dao;

import com.april2nd.webtest.dto.Note;
import com.april2nd.webtest.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoteDaoImpl implements NoteDao{
    public static NoteDaoImpl instance = new NoteDaoImpl();
    DBUtil dbUtil = DBUtil.getInstance();

    private NoteDaoImpl() {}

    public static NoteDaoImpl getInstance() {
        return instance;
    }

    @Override
    public int insert(Note note) throws SQLException {
        int result = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            String sql = "INSERT INTO note VALUES (?, ?, ?, ?)";
            conn = dbUtil.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, note.getNoteCode());
            pstmt.setString(2, note.getModel());
            pstmt.setInt(3, note.getPrice());
            pstmt.setString(4, note.getCompany());

            result = pstmt.executeUpdate();
        } finally {
            dbUtil.close(conn, pstmt);
        }
        System.out.println(result);
        return result;
    }

    @Override
    public int update(Note note) {
        String sql = "UPDATE note SET ";
        return 0;
    }

    @Override
    public int delete(String noteCode) throws SQLException{
        int result = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            String sql = "DELETE FROM note WHERE noteCode = ?; \n";
            conn = dbUtil.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, noteCode);

            result = pstmt.executeUpdate();
        } finally {
            dbUtil.close(conn, pstmt);
        }
        return result;
    }

    @Override
    public Note selectByNoteCode(String noteCode) throws SQLException{
        Note note = new Note();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            String sql = "SELECT * FROM note WHERE noteCode = ?; \n";
            conn = dbUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, noteCode);

            rs = pstmt.executeQuery();

            if(rs.next()){
                note.setNoteCode(rs.getString("noteCode"));
                note.setModel(rs.getString("model"));
                note.setPrice(rs.getInt("price"));
                note.setCompany(rs.getString("company"));
            }
        } finally {
            dbUtil.close(rs, pstmt, conn);
        }

        return note;
    }

    @Override
    public List<Note> selectAll() throws SQLException{
        List<Note> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            String sql = "SELECT * FROM note; \n";
            conn = dbUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                Note note = new Note();

                note.setNoteCode(rs.getString("noteCode"));
                note.setModel(rs.getString("model"));
                note.setPrice(rs.getInt("price"));
                note.setCompany(rs.getString("company"));

                list.add(note);
            }
        } finally {
            dbUtil.close(rs, pstmt, conn);
        }
        return list;
    }
}
