package cn.rayfoo.common;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: rayfoo@qq.com
 * @Date: 2020/7/16 2:19 下午
 * @Description:
 */
@Component(value = "myAspect")@Slf4j
public class MyAspect {

    public void check(){
        log.debug("进入了切点");
        System.out.println("权限校验");
    }

}
