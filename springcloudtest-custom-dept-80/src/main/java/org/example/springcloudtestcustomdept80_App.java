package org.example;

import org.ribbonconfig.MySelfConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
//在启动该微服务的时候就能去加载我们自定义的Ribbon配置类，从而使配置生效
@RibbonClient(name = "SPRINGCLOUDTEST-DEPT",configuration = MySelfConfig.class)
public class springcloudtestcustomdept80_App {
    public static void main(String[] args) {
        SpringApplication.run(springcloudtestcustomdept80_App.class,args);
    }
}
