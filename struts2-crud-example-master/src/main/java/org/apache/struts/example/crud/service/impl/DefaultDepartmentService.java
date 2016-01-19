package org.apache.struts.example.crud.service.impl;

import org.apache.struts.example.crud.dao.DepartmentDao;
import org.apache.struts.example.crud.dao.impl.InMemoryDepartmentDao;
import org.apache.struts.example.crud.model.Department;
import org.apache.struts.example.crud.service.DepartmentService;

import java.util.List;

public class DefaultDepartmentService implements DepartmentService {

    private DepartmentDao dao;

    public DefaultDepartmentService() {
        this.dao = new InMemoryDepartmentDao();
    }

    public List<Department> getAllDepartments() {
        return dao.getAllDepartments();
    }

}
