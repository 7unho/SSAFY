package com.live1.controller;

import com.live1.dto.Book;
import com.live1.model.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class BookController {

    @Autowired
    private ServletContext servletContext;

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        super();
        this.bookService = bookService;
    }

    @GetMapping({"/", "index"})
    public String index(){
        return "index";
    }

    @GetMapping("/book/regist")
    public String regist_form(){
        return "book/regist";
    }

    @PostMapping("/book/regist")
    public String regist(@RequestParam Map<String, String> map, Model model, HttpSession session, HttpServletResponse response) {
        try {
            String isbn = map.get("isbn");
            String title = map.get("title");
            String author = map.get("author");
            int price = Integer.parseInt(map.get("price"));
            String content = map.get("content");
            String img = map.get("img");

            Book book = new Book(isbn, title, author, price, content, img);
            System.out.println(book.toString());
            bookService.regist(book);

            model.addAttribute("book", book);
            return "/book/regist_result";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errmsg", "로그인 중 문제 발생!!!");
            return "error/commonerr";
        }
    }

    @RequestMapping("/book/regist_result")
    public String regist_resut(Model model){
        model.addAttribute("book", model.getAttribute("book"));
        return "book/regist_result";
    }

    @GetMapping("/book/list")
    public String list(Model model){
        try{
            List<Book> books = bookService.findAll();
            model.addAttribute("books", books);
            return "/book/list";
        } catch (Exception e){
            e.printStackTrace();
            model.addAttribute("errmsg", "목록 출력 중 에러 발생 !");
            return "error/commonerr";
        }
    }


}
