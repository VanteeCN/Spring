package cn.rayfoo.common;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: rayfoo@qq.com
 * @Date: 2020/7/20 9:28 下午
 * @Description: 全局异常处理
 */
@Component
public class MyExceptionResplver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        //获取异常对象
        MyException exception = null;
        //异常类型
        exception = e instanceof MyException ? (MyException) e : new MyException("系统正在维护!");
        //创建modelAndView
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMsg",exception.getMsg());
        modelAndView.setViewName("error");

        //返回
        return modelAndView;
    }
}
