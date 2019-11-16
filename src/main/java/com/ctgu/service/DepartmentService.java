package com.ctgu.service;

import com.ctgu.pojo.Department;

import java.util.List;

/**

 */
public interface DepartmentService {

    List<Department> getDepartmentList();

    void saveDepartment(Department department);

    void updateDepartment(Department department);

    void deleteDepById(int d_id);

    Department getDepartmentById(int d_id);

    /*根据部门名称查找部门*/
    Department getDepartmentByName(String d_name);
}
