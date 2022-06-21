package com.ziwu.transactional.configration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.datasource.user1")
@Data
public class UserConfig {
    private String driverClassName;
    private String url;
    private String password;
    private String username;
}
