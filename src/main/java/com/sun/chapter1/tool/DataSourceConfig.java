package com.sun.chapter1.tool;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


/**
 *  采用Spring Boot的java配置注入数据源：
 *  创建 DataSource 和 JdbcTemplate
 * 目前使用的是单个数据库
 */

@Configuration
public class DataSourceConfig {

    //@value获取 yml中的数据库连接配置文件
 /*   @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.url}")
    private String driverUrl;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;*/

    @Bean  //定义一个Bean
    // @ConfigurationProperties批量获取 yml中的配置
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource  dataSource(){
        return new DruidDataSource();
    }
   @Bean  //定义一个Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }




}
