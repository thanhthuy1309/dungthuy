package org.apache.struts.example.crud.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.example.crud.dao.DepartmentDao;
import org.apache.struts.example.crud.dao.impl.DepartmentDaoImpl;
import org.apache.struts.example.crud.dto.DepartmentDto;
import org.apache.struts.example.crud.model.Department;
import org.apache.struts.example.crud.service.DepartmentSevice;
import org.apache.struts.example.crud.util.ConvertObject;

public class DepartmentSeviceImpl implements DepartmentSevice {


    private DepartmentDao departmentDao;

    public DepartmentSeviceImpl() {
    	this.departmentDao = new DepartmentDaoImpl();
	}

	@Override
	public void updateDepartment(DepartmentDto emp) {
		Department department = ConvertObject.convertToDepartment(emp);
		departmentDao.update(department);
	}

	@Override
	public void deleteDepartment(Integer id) {
		Department department = departmentDao.getDepartmentById(id);
		departmentDao.delete(department);
		
	}

	@Override
	public DepartmentDto getDepartment(Integer id) {
		Department department = departmentDao.getDepartmentById(id);
		return ConvertObject.convertToDepartmentDto(department);
	}

	@Override
	public void insertDepartment(DepartmentDto emp) {
		Department department = ConvertObject.convertToDepartment(emp);
		departmentDao.insert(department);
	}

	@Override
	public List<DepartmentDto> getAllDepartments() {
		List<Department> departments = departmentDao.getAllDepartments();
        List<DepartmentDto> departmentDtos = new ArrayList<DepartmentDto>();
        for (Department department : departments) {
            departmentDtos.add(ConvertObject.convertToDepartmentDto(department));
        }
        return departmentDtos;
	}

}
