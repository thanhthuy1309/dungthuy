package org.apache.struts.example.crud.util;

import org.apache.struts.example.crud.dto.DepartmentDto;
import org.apache.struts.example.crud.dto.EmployeeDto;
import org.apache.struts.example.crud.model.Department;
import org.apache.struts.example.crud.model.Employee;

public class ConvertObject {

	public static DepartmentDto convertToDepartmentDto(Department department) {
		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setDepartmentId(department.getDepartmentId());
		departmentDto.setName(department.getName());
		return departmentDto;
	}

	public static Department convertToDepartment(DepartmentDto departmentDto) {
		Department department = new Department();
		if (departmentDto.getDepartmentId() != null) {
			department.setDepartmentId(departmentDto.getDepartmentId());
		}
		department.setName(departmentDto.getName());
		return department;
	}

	public static EmployeeDto convertToEmployeeDto(Employee employee, DepartmentDto departmentDto) {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setEmployeeId(employee.getEmployeeId());
		employeeDto.setAge(employee.getAge());
		employeeDto.setDepartment(departmentDto);
		employeeDto.setEmployeeId(employee.getEmployeeId());
		employeeDto.setFirstName(employee.getFirstName());
		employeeDto.setLastName(employee.getLastName());
		return employeeDto;
	}

	public static Employee convertEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		employee.setAge(employeeDto.getAge());
		employee.setDepartmentId(employeeDto.getDepartment().getDepartmentId());
		employee.setEmployeeId(employeeDto.getEmployeeId());
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		return employee;
	}

}
