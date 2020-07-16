package cn.rayfoo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Author: rayfoo@qq.com
 * @Date: 2020/7/15 10:23 上午
 * @Description:
 */
@Configuration
@EnableTransactionManagement
@Import(JdbcConfiguration.class)
@ComponentScan(basePackages = "cn.rayfoo")
public class SpringConfiguration {

}
