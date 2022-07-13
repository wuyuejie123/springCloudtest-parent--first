package org.example_hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //本服务启动后会自动注册进eureka服务中
//@ComponentScan(basePackages = "org.example")
@EnableDiscoveryClient//开启服务发现
@EnableCircuitBreaker//对hystrix开启熔断机制的支持
public class Springcloudtest_dept_Hystrix8001_App {

    public static void main(String[] args) {
        SpringApplication.run(Springcloudtest_dept_Hystrix8001_App.class,args);
    }
}
