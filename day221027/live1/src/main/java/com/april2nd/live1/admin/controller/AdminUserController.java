package com.april2nd.live1.admin.controller;

import com.april2nd.live1.member.model.MemberDto;
import com.april2nd.live1.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminUserController {

    private MemberService memberService;

//    @Autowired 생성자 하나만 있을 떄는 생략 가능
    public AdminUserController(MemberService memberService) {
        super();
        this.memberService = memberService;
    }

    @GetMapping("/user")
    // 넘겨줘야 할 거 : data(json), http header(applicaition/json), http status(200, 300, 400)
    // ? : 모든 타입이 될 수 있다.
    public ResponseEntity<?> userList(){
        try{
            List<MemberDto> list = memberService.listMember(null); // to Json Array
            if(list != null && !list.isEmpty()){ // 리스트가 null이 아니면서, 비어있지 않다면
                System.out.println(list.toString());
                return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
            } else { // 값이 없을 때,
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/user")
    // 넘겨줘야 할 거 : data(json), http header(applicaition/json), http status(200, 300, 400)
    // ? : 모든 타입이 될 수 있다.
    public ResponseEntity<?> userJoin(@RequestBody MemberDto memberDto){ // 넘어왔던 body 데이터를 memberDto로 매핑
        try{
            memberService.joinMember(memberDto);
            List<MemberDto> list = memberService.listMember(null); // to Json Array
            if(list != null && !list.isEmpty()){ // 리스트가 null이 아니면서, 비어있지 않다면
                System.out.println(list.toString());
                return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
            } else { // 값이 없을 때,
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/user")
    // 넘겨줘야 할 거 : data(json), http header(applicaition/json), http status(200, 300, 400)
    // ? : 모든 타입이 될 수 있다.
    public ResponseEntity<?> userModify(@RequestBody MemberDto memberDto){ // 넘어왔던 body 데이터를 memberDto로 매핑
        try{
            memberService.modifyMember(memberDto);
            List<MemberDto> list = memberService.listMember(null); // to Json Array
            if(list != null && !list.isEmpty()){ // 리스트가 null이 아니면서, 비어있지 않다면
                System.out.println(list.toString());
                return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
            } else { // 값이 없을 때,
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/user/{userid}")
    // 넘겨줘야 할 거 : data(json), http header(applicaition/json), http status(200, 300, 400)
    // ? : 모든 타입이 될 수 있다.
    public ResponseEntity<?> userDelete(@PathVariable("userid") String userId){
        try{
            memberService.deleteMember(userId);
            List<MemberDto> list = memberService.listMember(null); // to Json Array
            if(list != null && !list.isEmpty()){ // 리스트가 null이 아니면서, 비어있지 않다면
                return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
            } else { // 값이 없을 때,
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/{userid}")
    // 넘겨줘야 할 거 : data(json), http header(applicaition/json), http status(200, 300, 400)
    // ? : 모든 타입이 될 수 있다.
    public ResponseEntity<?> userView(@PathVariable("userid") String userId){
        try{
            MemberDto memberDto = memberService.getMember(userId);
            if(memberDto != null){
                return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
            } else { // 값이 없을 때,
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private ResponseEntity<String> exceptionHandling(Exception e){
        return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
