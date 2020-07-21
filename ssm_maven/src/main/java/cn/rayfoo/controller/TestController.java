package cn.rayfoo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: rayfoo@qq.com
 * @Date: 2020/7/21 5:12 下午
 * @Description:
 */
@Controller@Slf4j@RequestMapping("/test")
public class TestController {

    @GetMapping("/testInterceptor")
    public String testInterceptor(){
        log.debug("成功进入了testInterceptor方法");
        return "success";
    }

}
