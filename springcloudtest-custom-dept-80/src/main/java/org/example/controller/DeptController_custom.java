package org.example.controller;

import org.example.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_custom {
    private static final String TEST_URL_PREFIX="http://SPRINGCLOUDTEST-DEPT";

    /*
    * 使用restTemplate访问restful接口非常的简单
    * （url,requestMap,ResponseBean.class）这三个参数分别代表
    * REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
    * */
    @Autowired
    private RestTemplate restTemplate; //用于调用和发出rest请求

    @RequestMapping(value = "/customer/dept/add")
    public boolean add(Dept dept){
        return  restTemplate.postForObject(TEST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping(value = "/customer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(TEST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping(value = "/customer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(TEST_URL_PREFIX+"/dept/list",List.class);
    }


    @RequestMapping(value = "/customer/dept/discovery")
    public Object discovery(){
        return restTemplate.getForObject(TEST_URL_PREFIX+"/dept/discovery",Object.class);
    }

}
