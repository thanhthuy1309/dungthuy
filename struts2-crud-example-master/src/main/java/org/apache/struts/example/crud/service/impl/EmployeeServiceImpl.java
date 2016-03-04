package org.apache.struts.example.crud.service.impl;

import org.apache.struts.example.crud.dao.DepartmentDao;
import org.apache.struts.example.crud.dao.EmployeeDao;
import org.apache.struts.example.crud.dao.impl.DepartmentDaoImpl;
import org.apache.struts.example.crud.dao.impl.EmployeeDaoImpl;
import org.apache.struts.example.crud.dto.DepartmentDto;
import org.apache.struts.example.crud.dto.EmployeeDto;
import org.apache.struts.example.crud.model.Department;
import org.apache.struts.example.crud.model.Employee;
import org.apache.struts.example.crud.service.EmployeeService;
import org.apache.struts.example.crud.util.ConvertObject;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    private DepartmentDao departmentDao;

    public EmployeeServiceImpl() {
        this.employeeDao = new EmployeeDaoImpl();
        this.departmentDao = new DepartmentDaoImpl();
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeDao.getAllEmployees();
        List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();
        for (Employee employee : employees) {
            employeeDtos.add(ConvertObject.convertToEmployeeDto(employee, getDepartmentById(employee.getDepartmentId())));
        }
        return employeeDtos;
    }

    public DepartmentDto getDepartmentById(Integer departmentId) {
        Department department = departmentDao.getDepartmentById(departmentId);
        return ConvertObject.convertToDepartmentDto(department);
    }

    @Override
    public void updateEmployee(EmployeeDto emp) {
        Employee employee = ConvertObject.convertEmployee(emp);
        employeeDao.update(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        Employee employee = employeeDao.getEmployeeById(id);
        employeeDao.delete(employee);
    }

    @Override
    public EmployeeDto getEmployee(Integer id) {
        Employee employee = employeeDao.getEmployeeById(id);
        return ConvertObject.convertToEmployeeDto(employee, getDepartmentById(employee.getDepartmentId()));
    }

    @Override
    public void insertEmployee(EmployeeDto emp) {
        Employee employee = ConvertObject.convertEmployee(emp);
        employeeDao.insert(employee);
    }

}
