package org.example.service;

import org.example.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@FeignClient(value = "SPRINGCLOUDTEST-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClinetService {
    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    boolean addDept(Dept dept);
    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    Dept findById(@PathVariable("id") Long id);
    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    List<Dept> findAll();
}
