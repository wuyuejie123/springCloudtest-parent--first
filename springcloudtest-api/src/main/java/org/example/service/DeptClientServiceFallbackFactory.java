package org.example.service;

import feign.hystrix.FallbackFactory;
import org.example.entity.Dept;
import org.springframework.stereotype.Component;

import java.util.List;

/*
* 服务降级配置
* */
@Component//必须添加 
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClinetService> {
    @Override
    public DeptClinetService create(Throwable throwable) {
        return new DeptClinetService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public Dept findById(Long id) {
                return new Dept().setDeptno(id).setDname("该ID："+id+"HystrixCommand").setDb_source("no this" +
                        "database in mysql");
            }

            @Override
            public List<Dept> findAll() {
                return null;
            }
        };
    }
}
