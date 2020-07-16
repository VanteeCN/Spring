package cn.rayfoo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.cache.TransactionalCacheManager;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


/**
 * @Author: rayfoo@qq.com
 * @Date: 2020/7/15 2:31 下午
 * @Description:
 */
@MapperScan("cn.rayfoo.mapper")
@EnableTransactionManagement
@PropertySource("classpath:/properties/application.properties")
public class JdbcConfiguration {

    @Value("jdbc.driverClassName")
    private String driverClassName;

    @Value("jdbc.url")
    private String url;

    @Value("jdbc.username")
    private String username;

    @Value("jdbc.password")
    private String password;

    /**
     * 创建数据源
     * @return
     */
    @Bean(name = "datasource")
    public DruidDataSource createDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
    /**
     * 创建事务管理器对象
     * @param dataSource
     * @return
     */
    @Bean(name = "transactionManager")
    public PlatformTransactionManager createTransactionManager(@Qualifier("datasource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 配置SqlSession
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory createSqlSessionFactory(@Qualifier("datasource") DataSource dataSource) throws Exception{
        //创建SqlSession
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //设置SqlSession的数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        //设置别名
        sqlSessionFactoryBean.setTypeAliasesPackage("cn.rayfoo.bean");
        return sqlSessionFactoryBean.getObject();
    }
}
