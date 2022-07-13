package org.example.cfgbean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

 @Bean
 @LoadBalanced //ribbon实现的一套客户端，   负载均衡的工具
 public RestTemplate getRestTemplate(){
  return new RestTemplate();
 }

// @Bean//更换算法
// public IRule iRule(){
// return  new RandomRule();//默认轮询此处改为 随机
//
// }
}
