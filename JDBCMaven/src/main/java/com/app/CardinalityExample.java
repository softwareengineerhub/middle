package com.app;

import com.app.model.Company;
import com.app.model.Department;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by denys on 6/22/2017.
 */
public class CardinalityExample {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Department department1 = new Department();
        department1.setDepartmentName("D1");
        Department department2 = new Department();
        department2.setDepartmentName("D2");
        List<Department> departmentList = new ArrayList();
        departmentList.add(department1);
        departmentList.add(department2);


        Company company = new Company();
        company.setCompanyName("C1");
        company.setDepartments(departmentList);
        department1.setCompany(company);
        department2.setCompany(company);

        //em.persist(department1);
        //em.persist(department2);

        em.persist(company);

        em.getTransaction().commit();
    }
}
