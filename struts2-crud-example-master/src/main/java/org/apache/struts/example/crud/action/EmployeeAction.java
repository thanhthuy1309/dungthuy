package org.apache.struts.example.crud.action;

import java.util.List;

import org.apache.struts.example.crud.dto.DepartmentDto;
import org.apache.struts.example.crud.dto.EmployeeDto;
import org.apache.struts.example.crud.service.EmployeeService;
import org.apache.struts.example.crud.service.impl.EmployeeServiceImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class EmployeeAction extends ActionSupport implements Preparable {
    private EmployeeService empService = new EmployeeServiceImpl();

    private EmployeeDto employee;
    private List<EmployeeDto> employees;
    private List<DepartmentDto> departments;

    /**
     * Loads employee data in case of editing, and loads departments in any
     * case, to be displayed even in case validation fails.
     * 
     * @throws Exception
     */
    @Override
    public void prepare() throws Exception {
        // deparments list will be always displayed, even if validation fails
        departments = empService.getAllDepartments();
        if (employee != null && employee.getEmployeeId() != null) {
            // retrieves the employee from data source in case of editing and
            // employee id. exists
            employee = empService.getEmployee(employee.getEmployeeId());
        }
    }

    /**
     * Adds or updates the employee given by getEmployee().
     */
    public String save() {
        if (employee.getEmployeeId() == null) {
            empService.insertEmployee(employee);
        } else {
            empService.updateEmployee(employee);
        }
        return SUCCESS;
    }

    /**
     * Delete employee which ID is getEmployee().getEmployeeId()
     */
    public String delete() {
        empService.deleteEmployee(employee.getEmployeeId());
        return SUCCESS;
    }

    /**
     * Returns all employees
     */
    public String list() {
        employees = empService.getAllEmployees();
        return SUCCESS;
    }

    /**
     * @return the employee
     */
    public EmployeeDto getEmployee() {
        return employee;
    }

    /**
     * @param employee
     *            the employee to set
     */
    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }

    /**
     * @return the employees
     */
    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    /**
     * @param employees
     *            the employees to set
     */
    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }

    /**
     * @return the departments
     */
    public List<DepartmentDto> getDepartments() {
        return departments;
    }

    /**
     * @param departments
     *            the departments to set
     */
    public void setDepartments(List<DepartmentDto> departments) {
        this.departments = departments;
    }

}
