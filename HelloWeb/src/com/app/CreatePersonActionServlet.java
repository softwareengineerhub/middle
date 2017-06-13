package com.app;

import com.dao.DAO;
import com.dao.DAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by denys on 6/13/2017.
 */
@WebServlet(name = "CreatePersonActionServlet",urlPatterns = {"/CreatePersonActionServlet"})
public class CreatePersonActionServlet extends HttpServlet {
    private DAO dao = new DAOImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person person = new Person();
        String name=req.getParameter("name");
        String age = req.getParameter("age");
        person.setName(name);
        person.setAge(Integer.parseInt(age));
        System.out.println(person);
        dao.save(person);
    }
}
