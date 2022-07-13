package org.example_hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.example.entity.Dept;
import org.example_hystrix.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient client;
    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)

    public  boolean add(@RequestBody Dept dept){
        return deptService.addDept( dept);
    }

    @RequestMapping(value = "/dept/get/{id}")
    //一旦调用服务方法失败并抛出错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public  Dept get(@PathVariable("id") Long id){
        Dept dept=deptService.findById(id);
        System.out.println(dept);
        if(dept==null){
            throw  new RuntimeException("没有该数据");
        }
        return dept;
    }
    public Dept processHystrix_Get(@PathVariable("id") Long id){
        return  new Dept().setDeptno(id).setDname("该ID："+id+"HystrixCommand，服务暂停").setDb_source("no this" +
                "database in mysql");
    }

/*    @HystrixCommand(fallbackMethod = "processHystrix_Get")*/
    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return deptService.findAll();
    }


    /*
    * 服务发现*/
    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list =client.getServices();
        System.out.println("*******"+list);
        List<ServiceInstance> instanceList = client.getInstances("SPRINGCLOUDTEST-DEPT");
        for (ServiceInstance element : instanceList) {
            System.out.println("_____");
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }
        return this.client;
    }

}
