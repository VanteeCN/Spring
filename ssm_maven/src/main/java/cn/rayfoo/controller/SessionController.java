package cn.rayfoo.controller;

import com.alibaba.druid.pool.PreparedStatementPool;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.*;

/**
 * @Author: rayfoo@qq.com
 * @Date: 2020/7/20 3:11 下午
 * @Description:
 */
@RestController
public class SessionController extends BaseController {


    /**
     * session持久化测试
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/session")
    public String getSession(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);
        return session.getId();
    }

    @GetMapping("/test")
    public String test(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session.getId();
    }

}
