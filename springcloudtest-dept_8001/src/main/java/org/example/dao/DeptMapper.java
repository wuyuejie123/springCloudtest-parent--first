package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.Dept;

import java.util.List;

@Mapper
public interface DeptMapper {

     boolean addDept(Dept dept);

     Dept findById(Long id);

     List<Dept> findAll();
}
