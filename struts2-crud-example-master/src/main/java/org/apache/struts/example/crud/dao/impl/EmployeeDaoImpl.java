package org.apache.struts.example.crud.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.example.crud.dao.EmployeeDao;
import org.apache.struts.example.crud.model.Employee;
import org.apache.struts.example.crud.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class EmployeeDaoImpl implements EmployeeDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<Employee>();

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        employeeList = session.createQuery("from Employee").list();
        session.getTransaction().commit();
        session.close();
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(Integer employeeId) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        // Query get lesson
        Query query = session.createQuery("from Employee where employeeId =?");
        // Set parameter
        query.setParameter(0, employeeId);
        Employee employee = (Employee) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return employee;
    }

    @Override
    public void update(Employee emp) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(emp);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void insert(Employee emp) {
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
    public void delete(Employee emp) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(emp);
        session.getTransaction().commit();
        session.close();
    }

}
