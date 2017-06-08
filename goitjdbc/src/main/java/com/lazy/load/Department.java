package com.lazy.load;

import java.util.List;

/**
 * Created by denys on 6/8/2017.
 *
 * 1:n
 */
public class Department {
    private String departmentTitle;
    private List<Employee> employeeList;

    public String getDepartmentTitle() {
        return departmentTitle;
    }

    public void setDepartmentTitle(String departmentTitle) {
        this.departmentTitle = departmentTitle;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
