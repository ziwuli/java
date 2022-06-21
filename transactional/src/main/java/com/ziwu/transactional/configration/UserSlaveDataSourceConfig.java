package com.ziwu.transactional.configration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.ziwu.transactional.mapper.userslave", sqlSessionTemplateRef = "userSlaveSqlSessionTemplate")
public class UserSlaveDataSourceConfig {
    @Autowired
    @Qualifier("user2")
    private DataSource user2;

    @Bean
    public SqlSessionFactory sqlSlaveSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(user2);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate userSlaveSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSlaveSessionFactory());
    }
}
