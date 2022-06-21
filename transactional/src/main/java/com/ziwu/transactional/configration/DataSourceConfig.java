package com.ziwu.transactional.configration;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import javax.transaction.UserTransaction;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource user1(UserConfig userConfig) {
        MysqlXADataSource dataSource = new MysqlXADataSource();
        dataSource.setUrl(userConfig.getUrl());
        dataSource.setUser(userConfig.getUsername());
        dataSource.setPassword(userConfig.getPassword());
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(dataSource);
        atomikosDataSourceBean.setUniqueResourceName("user1");
        return atomikosDataSourceBean;
    }

    @Bean
    public DataSource user2(UserSlaveConfig userSlaveConfig) {
        MysqlXADataSource dataSource = new MysqlXADataSource();
        dataSource.setUrl(userSlaveConfig.getUrl());
        dataSource.setUser(userSlaveConfig.getUsername());
        dataSource.setPassword(userSlaveConfig.getPassword());
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(dataSource);
        atomikosDataSourceBean.setUniqueResourceName("user2");
        return atomikosDataSourceBean;
    }

    @Bean
    public JtaTransactionManager jtaTransactionManager() {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        UserTransaction userTransaction = new UserTransactionImp();
        return new JtaTransactionManager(userTransaction, userTransactionManager);
    }
}
