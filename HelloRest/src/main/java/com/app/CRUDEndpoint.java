package com.app;

import com.app.dao.DAO;
import com.app.dao.DAOImpl;
import com.app.model.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by denys on 6/29/2017.
 */
@WebServlet(name = "CRUDEndpoint", urlPatterns = "/CRUDEndpoint")
public class CRUDEndpoint extends HttpServlet {
    private DAO dao;

    @Override
    public void init(){
        dao = new DAOImpl();
    }

    /*@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //before
       super.service(req, resp);
       //after
        System.out.println("MyService!!!");
    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person person = parseRequest(req);
        boolean parseByAgeFlag = Boolean.parseBoolean(req.getParameter("parseByAgeFlag"));
        List<Person> result = parseByAgeFlag ? dao.getByAge(person.getAge()) : dao.getByName(person.getName());

        long start = System.currentTimeMillis();
        while(System.currentTimeMillis()-start<10000){
        }

        //PrintWriter pw = resp.getWriter();
        StringBuilder sb = new StringBuilder();
        sb.append("<table>");
        for(int i=0;i<result.size();i++) {
            Person p = result.get(i);
            sb.append("<tr>");
            sb.append("<td>");
            sb.append(i+1);
            sb.append("</td>");
            sb.append("<td>");
            sb.append(p.getName());
            sb.append("</td>");
            sb.append("<td>");
            sb.append(p.getAge());
            sb.append("</td>");
            sb.append("</tr>");
        }
        sb.append("</table>");
        /*pw.println(sb.toString());
        pw.flush();*/




        try(OutputStream out = resp.getOutputStream()){
            byte[] data = sb.toString().getBytes();
            out.write(data);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //idempotant
        //биекция
        //System.out.println("POST!!!");
        Person oldPerson = parseRequest(req);
        Person newPerson = parseRequestForUpdate(req);
        dao.update(oldPerson, newPerson);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person p = parseRequest(req);
        dao.save(p);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //delete
        Person p = parseRequest(req);
        dao.delete(p);
    }

    private Person parseRequest(HttpServletRequest req){
        String name=req.getParameter("name");
        String ageParam = req.getParameter("age");
        int age = Integer.parseInt(ageParam);
        Person p = new Person();
        p.setName(name);
        p.setAge(age);
        return p;
    }

    private Person parseRequestForUpdate(HttpServletRequest req){
        String name=req.getParameter("newName");
        String ageParam = req.getParameter("newAge");
        int age = Integer.parseInt(ageParam);
        Person p = new Person();
        p.setName(name);
        p.setAge(age);
        return p;
    }
}
