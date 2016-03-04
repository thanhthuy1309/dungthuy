package org.apache.struts.example.crud.dao.impl;

import java.util.List;

import org.apache.struts.example.crud.dao.DepartmentDao;
import org.apache.struts.example.crud.model.Department;
import org.apache.struts.example.crud.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class DepartmentDaoImpl implements DepartmentDao {

    public Department getDepartmentById(Integer departmentId) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        // Query get lesson
        Query query = session.createQuery("from Department where departmentId =?");
        // Set parameter
        query.setParameter(0, departmentId);
        Department department = (Department) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return department;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Department> getAllDepartments() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Department> departments = session.createQuery("from Department").list();
        session.getTransaction().commit();
        session.close();
        return departments;
    }

	@Override
	public void update(Department emp) {
		Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(emp);
        session.getTransaction().commit();
        session.close();
	}

	@Override
	public void insert(Department emp) {
		try {
            Session session = HibernateUtil.getSession();
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	public void delete(Department emp) {
		Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(emp);
        session.getTransaction().commit();
        session.close();
	}

}
