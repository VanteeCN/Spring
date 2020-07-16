package cn.rayfoo.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author: rayfoo@qq.com
 * @Date: 2020/7/16 5:37 下午
 * @Description:
 */
@Slf4j
public class TestApp {

    @Test
    public void slf4jTest(){
      log.trace("trace");
      log.info("info");
      log.debug("info");
      log.error("info");
    }

}
