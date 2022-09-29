package com.april2nd.webtest.controller;

import com.april2nd.webtest.dto.Note;
import com.april2nd.webtest.model.service.NoteServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "NoteController", value = "/note")
public class NoteController extends HttpServlet {
    public NoteServiceImpl noteService = NoteServiceImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // doGet = FORM method : POST 이외의 모든 요청
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청 분석 -> 컨트롤 타워 느낌
        String action = request.getParameter("action");
        if (action == null) {
            response.sendRedirect(request.getContextPath());
        } else if (action.equals("form")) {
            request.getRequestDispatcher("/note/registNote.jsp").forward(request, response);
        } else if (action.equals("regist")) {
            doRegist(request, response);
        } else if (action.equals("list")) {
            doList(request, response);
        } else if (action.equals("upForm")) {

        } else if (action.equals("modify")) {

        } else if (action.equals("remove")) {
            doRemove(request, response);
        } else if (action.equals("detail")) {
            doDetail(request, response);
        }
    }

    private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            String noteCode = request.getParameter("noteCode");
            Note note = noteService.findByNoteCode(noteCode);

            request.setAttribute("note", note);
            request.getRequestDispatcher("/note/detailNote.jsp").forward(request, response);
        } catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "상세 정보 출력 중 에러 발생 !");
            response.sendRedirect("/error/error.jsp");

            //forward : request, session
            //redirect : session
        }
    }

    private void doRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            String noteCode = request.getParameter("noteCode");
            int result = noteService.remove(noteCode);
            response.sendRedirect("/note?action=list");
        } catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "상품 삭제 중 에러 발생 !!");
            response.sendRedirect("/error/error.jsp");
        }
    }

    private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            List<Note> list = noteService.findAll();
            request.setAttribute("noteList", list);
            request.getRequestDispatcher("/note/listNote.jsp").forward(request, response);
        } catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "목록 조회 중 에러 발생!!");
            response.sendRedirect("/error/error.jsp");
        }
    }

    private void doRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Note note = new Note();

        note.setNoteCode(request.getParameter("noteCode"));
        note.setModel(request.getParameter("model"));
        note.setPrice(Integer.parseInt(request.getParameter("price")));
        note.setCompany(request.getParameter("company"));

        try{
            noteService.add(note);
            response.sendRedirect(request.getContextPath() + "/note?action=list");
        } catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "노트북 추가 작업 중에 에러 발생 !");
            response.sendRedirect("/error/error.jsp");
        }
    }

}
