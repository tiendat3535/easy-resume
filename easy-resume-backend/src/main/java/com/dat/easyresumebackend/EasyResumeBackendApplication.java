package com.dat.easyresumebackend;

import com.dat.easyresumebackend.configuration.ApplicationConfig;
import com.dat.easyresumebackend.configuration.OAuth2AuthServerConfig;
import com.dat.easyresumebackend.configuration.OAuth2ResourceServerConfig;
import com.dat.easyresumebackend.endpoint.PrivateUserEndpoint;
import com.dat.easyresumebackend.service.impl.UserDetailsServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan(basePackageClasses = {PrivateUserEndpoint.class, UserDetailsServiceImpl.class})
@Import(value = {OAuth2AuthServerConfig.class, OAuth2ResourceServerConfig.class, ApplicationConfig.class})
public class EasyResumeBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyResumeBackendApplication.class, args);
    }
}
