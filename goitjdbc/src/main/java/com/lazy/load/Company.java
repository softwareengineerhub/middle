package com.lazy.load;

import java.util.List;

/**
 * Created by denys on 6/8/2017.
 */
public class Company {
    private String companyName;
    private List<Department> departments;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
