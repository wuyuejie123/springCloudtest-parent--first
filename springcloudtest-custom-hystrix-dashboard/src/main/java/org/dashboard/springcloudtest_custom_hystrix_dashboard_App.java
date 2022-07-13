package org.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class springcloudtest_custom_hystrix_dashboard_App {
    public static void main(String[] args) {
        SpringApplication.run(springcloudtest_custom_hystrix_dashboard_App.class,args);
    }

}
