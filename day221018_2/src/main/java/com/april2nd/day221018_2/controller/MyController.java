package com.april2nd.day221018_2.controller;

import com.april2nd.day221018_2.dto.Calculator;
import com.april2nd.day221018_2.dto.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

//    @RequestMapping("/form")
    @GetMapping("/form")
    public String form(){
        return "form";
    }

    @RequestMapping("/calForm")
    public String calForm(){
        return "/calculator/calForm";
    }

    @PostMapping("/calResult")
    public String cal(Calculator cal, Model model){
        model.addAttribute("result", cal.getResult());
        return "/calculator/calResult";
    }

//    @RequestMapping(value = "/form", method = RequestMethod.POST)
//    @PostMapping("/form")
//    public String formProcess(HttpServletRequest request, HttpSession session){
//        String name = request.getParameter("user_name");
//        System.out.println(name);
//        return "form";
//    }

//    @PostMapping("/form")
//    public String formProcess(Person person){
//        System.out.println("전달받은 정보 : " + person.toString());
//        return "result";
//    }

    @PostMapping("/form")
    public String formProcess(Person person, Model model){
        // model => 데이터를 영역에 저장하는 클래스
        //       => 의미상 Request영역과 같다.
        model.addAttribute("person", person);

//        return "result"; // 포워드
        return "redirect:result"; // redirect 이동
    }

    // redirect 호출하려면 또 하나의 포워딩이 필요하다 !
    // 리턴 문자열(이동할 페이지 정보)가 없을 때는 요청 문자열이 곧 리턴 문자열이 된다. -> /result
    @GetMapping("/result")
    public void result(){}
}
