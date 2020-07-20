package cn.rayfoo.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author: rayfoo@qq.com
 * @Date: 2020/7/16 2:19 下午
 * @Description:
 */
@Aspect @Component @Slf4j
public class MyAspect {

    /**
     * 前置通知，joinPoint必须为第一个参数
     * @param joinPoint
     */
    @Before(value = "execution(* cn.rayfoo.service.impl.AccountServiceImpl.transFer(..))")
    public void check(JoinPoint joinPoint){

        //获取被代理方法的参数列表
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            //打印参数列表
            log.debug(arg.toString());
        }
        log.debug("进入了切点");
    }

    @AfterReturning(value = "MyAspect.transFerPointcut()",returning = "res")
    public void logs(Object res){
        log.debug("转账执行成功，返回信息为：" + res);
    }

    @Around(value = "execution(* cn.rayfoo.service.impl.AccountServiceImpl.transFer(..))")
    public Object around(ProceedingJoinPoint joinPoint){
        Object proceed = null;
        log.debug("=====前置通知");
        try {
            proceed = joinPoint.proceed();
            log.debug("=====后置通知");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            log.debug("=====异常通知");
        }finally {
            log.debug("=====finally通知");
        }
        return proceed;
    }

    @Pointcut(value = "execution(* cn.rayfoo.service.impl.AccountServiceImpl.transFer(..))")
    private void transFerPointcut(){

    }

}
