package cn.rayfoo.iterceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: rayfoo@qq.com
 * @Date: 2020/7/21 5:15 下午
 * @Description: 由于JDK1.8做了增强，所以接口可以直接声明方法 需要手动查看源码复制这三个方法。
 */
@Slf4j
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 预处理方法，在Controller方法运行之前运行
     * @param request 可以直接通过request response跳转到某个页面 不继续执行后续Controller方法
     * @param response 权限校验失败后，可以跳转到一些自定义错误页面等
     * @param handler
     * @return true放行执行下一个拦截器，如果没有 直接执行Controller方法 false不放行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("成功进入了拦截器preHandle方法");
//        request.getRequestDispatcher("/views/unlogin.html").forward(request,response);
        //return false;
        return true;
    }

    /**
     * 后处理方法 用于Controller处理结束后执行 success执行之前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        log.debug("postHandle执行了");
        //如果在这里进行了页面的跳转，Controller方法中的跳转也会生效
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        log.debug("afterCompletion方法执行了");
        //一般用于关闭资源等。。
    }

}
