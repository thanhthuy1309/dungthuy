package org.apache.struts.example.crud.service;

import java.util.List;

import org.apache.struts.example.crud.dto.DepartmentDto;

public interface DepartmentSevice {

    public void updateDepartment(DepartmentDto emp);

    public void deleteDepartment(Integer id);

    public DepartmentDto getDepartment(Integer id);

    public void insertDepartment(DepartmentDto emp);

    public List<DepartmentDto> getAllDepartments();
}
