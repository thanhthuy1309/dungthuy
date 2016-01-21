package org.apache.struts.example.crud.dao;

import java.util.List;

import org.apache.struts.example.crud.model.Department;

public interface DepartmentDao {

    public Department getDepartmentById(Integer departmentId);

    public List<Department> getAllDepartments();

}
