package com.live1.interceptor;

import com.live1.dto.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@SuppressWarnings("deprecation")
//public class ConfirmInterceptor extends HandlerInterceptorAdapter {
// spring 5.3 부터는 HandlerInterceptor implements
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        User memberDto = (User) session.getAttribute("userinfo");
        if(memberDto == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return false;
        }
        return true;
    }

}
