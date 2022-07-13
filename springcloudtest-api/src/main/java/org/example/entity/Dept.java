package org.example.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Accessors(chain = true)//链式编程
public class Dept implements Serializable {
    private Long deptno; //主键
    private String dname;//部门名称
    private String db_source;//来自那个数据库，因为徵服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库

    public static void main(String[] args) {
        Dept dept = new Dept();
        
    }
}
