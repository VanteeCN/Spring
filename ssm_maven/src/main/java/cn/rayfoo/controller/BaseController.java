package cn.rayfoo.controller;

import cn.rayfoo.service.AccountService;
import cn.rayfoo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: rayfoo@qq.com
 * @Date: 2020/7/16 7:38 下午
 * @Description:
 */
public class BaseController {

    /**
     * 注入全部service
     */
    @Autowired
    protected AccountService accountService;
    @Autowired
    protected PersonService personService;

    /**
     * 创建session、Request、Response等对象
     */
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;


    /**
     * 在每个子类方法调用之前先调用
     * 设置request,response,session这三个对象
     * @param request
     * @param response
     */
    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession(true);
    }

}
