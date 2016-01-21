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
            employeeDtos.add(convertToEmployeeDto(employee));
        }
        return employeeDtos;
    }

    private EmployeeDto convertToEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeId(employee.getEmployeeId());
        employeeDto.setAge(employee.getAge());
        employeeDto.setDepartment(getDepartmentById(employee.getDepartmentId()));
        employeeDto.setEmployeeId(employee.getEmployeeId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        return employeeDto;
    }

    public DepartmentDto getDepartmentById(Integer departmentId) {
        Department department = departmentDao.getDepartmentById(departmentId);
        return convertToDepartmentDto(department);
    }

    private DepartmentDto convertToDepartmentDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentId(department.getDepartmentId());
        departmentDto.setName(department.getName());
        return departmentDto;
    }

    @Override
    public void updateEmployee(EmployeeDto emp) {
        Employee employee = convertEmployee(emp);
        employeeDao.update(employee);
    }

    private Employee convertEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setAge(employeeDto.getAge());
        employee.setDepartmentId(employeeDto.getDepartment().getDepartmentId());;
        employee.setEmployeeId(employeeDto.getEmployeeId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        return employee;
    }

    @Override
    public void deleteEmployee(Integer id) {
        Employee employee = employeeDao.getEmployeeById(id);
        employeeDao.delete(employee);
    }

    @Override
    public EmployeeDto getEmployee(Integer id) {
        Employee employee = employeeDao.getEmployeeById(id);
        return convertToEmployeeDto(employee);
    }

    @Override
    public void insertEmployee(EmployeeDto emp) {
        Employee employee = convertEmployee(emp);
        employeeDao.insert(employee);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentDao.getAllDepartments();
        List<DepartmentDto> departmentDtos = new ArrayList<DepartmentDto>();
        for (Department department : departments) {
            departmentDtos.add(convertToDepartmentDto(department));
        }
        return departmentDtos;
    }
}
