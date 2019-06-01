package com.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages={"com.auto.dao"},
        sqlSessionTemplateRef="autoSqlSessionTemplate")
public class AutoDBConfig {
    @Bean(name="autoDataSource")
    @ConfigurationProperties(prefix="spring.datasource.auto")
    public DataSource test01DataSource(){
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "autoSqlSessionFactory")
    public SqlSessionFactory test01SqlSessionFactory(@Qualifier("autoDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        org.apache.ibatis.session.Configuration ibatisConfiguration
                = new org.apache.ibatis.session.Configuration();
        //控制台打印sql
        ibatisConfiguration.setLogImpl(org.apache.ibatis.logging.stdout.StdOutImpl.class);
        //开启驼峰匹配
        ibatisConfiguration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(ibatisConfiguration);
        bean.setDataSource(dataSource);
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
/*    @Bean(name = "test01TransactionManager")
    public DataSourceTransactionManager test01TransactionManager(@Qualifier("test01DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }*/
    @Bean(name="autoSqlSessionTemplate")
    public SqlSessionTemplate autoSqlSessionTemplate(@Qualifier("autoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
        return template;
    }
}
