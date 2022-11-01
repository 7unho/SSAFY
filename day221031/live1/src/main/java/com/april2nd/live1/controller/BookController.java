package com.april2nd.live1.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.april2nd.live1.model.dto.Book;
import com.april2nd.live1.model.dto.SearchCondition;
import com.april2nd.live1.model.dto.User;
import com.april2nd.live1.model.service.BookService;
import com.april2nd.live1.model.service.UserService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private ServletContext servletContext;

	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	@GetMapping("/regist")
	public String regist_form(){
		return "book/regist";
	}

	@PostMapping("/regist")
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

	@RequestMapping("/regist_result")
	public String regist_resut(Model model){
		model.addAttribute("book", model.getAttribute("book"));
		return "book/regist_result";
	}

	@GetMapping("/list")
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
