package com.april2nd.live1.board.controller;

import com.april2nd.live1.board.model.BoardDto;
import com.april2nd.live1.board.model.service.BoardService;
import com.april2nd.live1.board.model.service.BoardServiceImpl;
import com.april2nd.live1.member.model.MemberDto;
import com.april2nd.live1.util.ParameterCheck;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/board")
public class BoardController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private BoardService boardService;
    private Map<String, String> map;

    public void init() {
        boardService = BoardServiceImpl.getBoardService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String act = request.getParameter("act");

        int pgNo = ParameterCheck.notNumberToOne(request.getParameter("pgno"));
        String key = ParameterCheck.nullToBlank(request.getParameter("key"));
        String word = ParameterCheck.nullToBlank(request.getParameter("word"));
        String queryString = "?pgno=" + pgNo + "&key=" + key + "&word=" + word;
        map = new HashMap<>();
        map.put("pgno", pgNo + "");
        map.put("key", key);
        map.put("word", word);

        String path = "/index.jsp";
        if ("list".equals(act)) {
            path = list(request, response);
            forward(request, response, path + queryString);
        } else if ("mvwrite".equals(act)) {
            path = "/board/write.jsp";
            redirect(request, response, path);
        } else if ("write".equals(act)) {
            path = write(request, response);
            forward(request, response, path);
        } else if ("view".equals(act)) {
            path = view(request, response);
            forward(request, response, path);
        } else if ("mvmodify".equals(act)) {
            path = mvModify(request, response);
            forward(request, response, path);
        } else if ("modify".equals(act)) {
            path = modify(request, response);
            forward(request, response, path);
        } else if ("delete".equals(act)) {
            path = delete(request, response);
            redirect(request, response, path);
        } else {
            redirect(request, response, path);
        }
    }

    private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }

    private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
        response.sendRedirect(request.getContextPath() + path);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }

    private String list(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");

        if (memberDto != null) {
            try {
                List<BoardDto> list = boardService.listArticle(map);
                request.setAttribute("articles", list);
                return "/board/list.jsp";
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("msg", "글목록 조회 중 에러 발생 !");
                return "/error/error.jsp";
            }
        } else {
            return "/user/login.jsp";
        }
    }

    private String write(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
        BoardDto boardDto = new BoardDto();

        if (memberDto != null) {
            boardDto.setUserId(memberDto.getUserId());
            boardDto.setSubject(request.getParameter("subject"));
            boardDto.setContent(request.getParameter("content"));

            try {
                boardService.writeArticle(boardDto);
                return "/board?act=list&pgno=1&key=&word=";
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("msg", "글 작성 중 에러 발생 !!");
                return "/error/error.jsp";
            }
        } else {
            return "/user/login.jsp";
        }
    }

    private String view(HttpServletRequest request, HttpServletResponse response) {
        // pgno, key, word,
        HttpSession session = request.getSession();
        MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");

        if (memberDto != null) {
            try {
                int articleNo = Integer.parseInt(request.getParameter("articleno"));
                BoardDto boardDto = boardService.getArticle(articleNo);
                boardService.updateHit(articleNo);
                request.setAttribute("article", boardDto);
                return "/board/view.jsp";
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("msg", "글목록 조회 중 에러 발생 !");
                return "/error/error.jsp";
            }
        } else {
            return "/user/login.jsp";
        }
    }

    private String mvModify(HttpServletRequest request, HttpServletResponse response) {
        return "";
    }

    private String modify(HttpServletRequest request, HttpServletResponse response) {
        return "";
    }

    private String delete(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");

        if (memberDto != null) {
            try {
                int articleNo = Integer.parseInt(request.getParameter("articleno"));
                boardService.deleteArticle(articleNo);
                return "/board?act=list&pgno=1&key=&word=";
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("msg", "글 삭제 중 에러 발생 !");
                return "/error/error.jsp";
            }
        } else {
            return "/user/login.jsp";
        }
    }

}
