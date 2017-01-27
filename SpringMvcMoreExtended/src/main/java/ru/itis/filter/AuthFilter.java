package ru.itis.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.itis.service.UsersService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Autowired
    private UsersService service;

    public void init(FilterConfig filterConfig) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                filterConfig.getServletContext());
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        String userName = null;
        // получаем все куки
        Cookie[] cookies = request.getCookies();
        // есди куки непустые
        if(cookies !=null){
            // идем по всем кукам
            for(Cookie cookie : cookies){
                // если у нас печенька с атрибутом user совпала
                if(cookie.getName().equals("user")) {
                    // сохраняем значение в переменную userName
                    userName = cookie.getValue();
                }
            }
        }

        // если пришел запрос на страничку с авторизацией
        if (isLoginHtml(request)) {
            // смотрим, были ли куки
            if (userName == null) {
                // если не были - пусть идет на страницу
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                // в противном случае сразу бросаем в loginSuccess
                response.sendRedirect("loginSuccess.jsp");
            }
        }
        // если не кулхацкер, то запрос идет от страницы login.html
        else if (isPostLogin(request)) {
            String currentUser = request.getParameter("user");
            String currentPassword = request.getParameter("pwd");

            /**
            // service.isRegistered(currentUser, currentPassword);
            if(userID.equals(currentUser) && password.equals(currentPassword)){
                // создаем печеньку
                Cookie loginCookie = new Cookie("user", currentUser);
                // задали время жизни печеньки
                loginCookie.setMaxAge(30*60);
                // добавили печеньку в запрос
                response.addCookie(loginCookie);
                // делаем редирект на нужную страницу
                response.sendRedirect("loginSuccess.jsp");
            }
             **/
        }
        if (userName != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            System.out.println("BAD REQUEST");
        }
    }

    private boolean isLoginHtml(HttpServletRequest request) {
        return request.getRequestURI().equals("/login.html");
    }

    private boolean isPostLogin(HttpServletRequest request) {
        return request.getRequestURI().equals("/login") && request.getMethod().equals("POST");
    }

    public void destroy() {

    }
}
