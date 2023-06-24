package com.ziwu.springliquibase.configuration;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.exception.LiquibaseException;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class LiquibaseConfiguration {
    @Autowired
    private DataSource dataSource;

    @Value("${liquibase.options:}")
    private String options;

    /**
     * define rollback tag
     */
    @Value("${liquibase.tags:}")
    private String tags;


    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new MySpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:/db/master.xml");
        liquibase.setShouldRun(true);
        return liquibase;
    }

    private class MySpringLiquibase extends SpringLiquibase {
        @Override
        protected void performUpdate(Liquibase liquibase) throws LiquibaseException {
            if ("ROLLBACK".equals(options) && tags != null) {
                liquibase.rollback(tags, new Contexts(getContexts()));
            } else {
                super.performUpdate(liquibase);
            }
        }
    }
}
