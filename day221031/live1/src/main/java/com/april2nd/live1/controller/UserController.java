package com.april2nd.live1.controller;

import com.april2nd.live1.model.dto.User;
import com.april2nd.live1.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    UserService userService;

    @Autowired
    public UserController(UserService userService){
        super();
        this.userService = userService;
    }

    @PostMapping("/user/regist")
    public String join(User user, Model model) {
        logger.debug("uUser info : {}", user);
        try {
            userService.regist(user);
            return "redirect:/";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errmsg", "회원 가입 중 문제 발생!!!");
            return "error/commonerr";
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam Map<String, String> map, Model model, HttpSession session, HttpServletResponse response) {
        logger.debug("map : {}", map.get("id"));
        try {
            User temp = new User();
            temp.setId(map.get("id"));
            temp.setPass(map.get("pass"));

            User user = userService.loginUser(temp);
            logger.debug("User : {}", user);
            if(user != null) {
                session.setAttribute("loginUser", user);

                Cookie cookie = new Cookie("ssafy_id", map.get("id"));
                cookie.setPath("/");
                if("ok".equals(map.get("saveid"))) {
                    cookie.setMaxAge(60*60*24*365*40);
                } else {
                    cookie.setMaxAge(0);
                }
                response.addCookie(cookie);
                return "redirect:/";
            } else {
                model.addAttribute("errmsg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요!");
                return "/";
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errmsg", "로그인 중 문제 발생!!!");
            return "error/commonerr";
        }
    }

    @GetMapping("/logout")
    public String doLogout(HttpSession session){
        session.invalidate();
        return "redirect:/index";
    }
}
