package org.example8002.controller;

import org.example.entity.Dept;
import org.example8002.service.DeptService;
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

    @RequestMapping(value = "/dept/get",method = RequestMethod.POST)
    public  Dept get(@PathVariable("id") Long id){
        return deptService.findById(id);
    }

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
