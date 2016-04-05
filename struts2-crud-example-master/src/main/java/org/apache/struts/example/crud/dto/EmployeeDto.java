package org.apache.struts.example.crud.dto;


public class EmployeeDto {

    private Integer employeeId;

    private Integer age;

    private String firstName;

    private String lastName;

    private DepartmentDto department;

    public EmployeeDto() {
    }

    /**
     * @param employeeId
     * @param age
     * @param firstName
     * @param lastName
     * @param department
     */
    public EmployeeDto(Integer employeeId, Integer age, String firstName, String lastName, DepartmentDto department) {
        this.employeeId = employeeId;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    /**
     * @return the department
     */
    public DepartmentDto getDepartment() {
        return department;
    }

    /**
     * @param department
     *            the department to set
     */
    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
