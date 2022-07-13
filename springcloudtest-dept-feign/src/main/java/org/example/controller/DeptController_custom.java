package org.example.controller;

import org.example.entity.Dept;
import org.example.service.DeptClinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_custom {
   @Autowired
    private DeptClinetService service;
    @RequestMapping(value = "/customer/dept/add",method = RequestMethod.POST)
    public boolean addDept(Dept dept){
        return this.service.addDept(dept);
    }
    @RequestMapping(value = "/customer/dept/get/{id}",method = RequestMethod.GET)
    public Dept findById(@PathVariable("id") Long id){
        return this.service.findById(id);
    }
    @RequestMapping(value = "/customer/dept/list",method = RequestMethod.GET)
    public List<Dept> findAll(){
        return this.service.findAll();
    }

}
