package org.example.service.impl;

import org.example.dao.DeptMapper;
import org.example.entity.Dept;
import org.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept findById(Long id) {
        return deptMapper.findById(id);
    }

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }
}
