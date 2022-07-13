package org.example8003.service;

import org.example.entity.Dept;

import java.util.List;


public interface DeptService {

    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}
