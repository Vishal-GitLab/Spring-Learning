package com.example.demo;

import com.example.loose.NotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration   // ye bhi btana padega ki hamko ye class config class hai
@ComponentScan(basePackages = "com.example")  // ye btata hai ki hmko is class me manage karna hai ... sare sare manage spring component ko
public class AppConfig {


    @Bean(initMethod = "init", destroyMethod = "cleanup")
    public LifecycleBean lifecycleBean(NotificationService notificationService ) {
        return new LifecycleBean(notificationService);
    }
}
