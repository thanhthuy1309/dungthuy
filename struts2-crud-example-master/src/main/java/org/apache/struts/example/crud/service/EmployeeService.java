package org.apache.struts.example.crud.service;

import java.util.List;

import org.apache.struts.example.crud.dto.DepartmentDto;
import org.apache.struts.example.crud.dto.EmployeeDto;

public interface EmployeeService {

    public List<EmployeeDto> getAllEmployees();

    public void updateEmployee(EmployeeDto emp);

    public void deleteEmployee(Integer id);

    public EmployeeDto getEmployee(Integer id);

    public void insertEmployee(EmployeeDto emp);

    public List<DepartmentDto> getAllDepartments();

}
