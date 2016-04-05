package org.apache.struts.example.crud.dto;


public class DepartmentDto {

    private Integer departmentId;

    private String name;

    public DepartmentDto() {
    }

    public DepartmentDto(Integer departmentId, String name) {
        this.departmentId = departmentId;
        this.name = name;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
