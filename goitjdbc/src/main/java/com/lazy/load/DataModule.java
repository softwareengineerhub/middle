package com.lazy.load;

import java.util.List;

/**
 * Created by denys on 6/8/2017.
 */
public class DataModule {
    private List<Company> companies;

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
