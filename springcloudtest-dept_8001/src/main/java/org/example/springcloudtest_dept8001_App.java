package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //本服务启动后会自动注册进eureka服务中
//@ComponentScan(basePackages = "org.example")
public class springcloudtest_dept8001_App {

    public static void main(String[] args) {
        SpringApplication.run(springcloudtest_dept8001_App.class,args);
    }
}
