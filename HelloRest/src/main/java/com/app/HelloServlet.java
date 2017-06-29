package com.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by denys on 6/29/2017.
 */
@WebServlet(name = "HelloServlet", urlPatterns = "/HelloServlet")
public class HelloServlet extends HttpServlet {

    /*static{
        System.out.println("Static block");
    }

    {
        System.out.println("init block");
    }

    public HelloServlet() {
        System.out.println("Constructor");
    }


    public void finalize() throws Throwable {
        try {
            super.finalize();
        } finally{

        }
    }*/

    @Override
    public void init(){
        System.out.println("Init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.hashCode="+hashCode());
        String name = req.getParameter("name");
        //null could be
        String ttt=req.getParameter("ttt");
        System.out.println("name="+name);
        boolean flag = Boolean.parseBoolean(req.getParameter("nedToKill"));
        if(flag) {
            String s = null;
            s.toString();
        }
    }

    @Override
    public void destroy(){
        System.out.println("Destory");
    }


}
