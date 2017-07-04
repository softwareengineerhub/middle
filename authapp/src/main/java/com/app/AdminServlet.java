package com.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by denys on 7/4/2017.
 */
@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Admin page");
        String username=req.getRemoteUser();
        System.out.println("Hello, "+username);
        resp.getOutputStream().write(("Hello, "+username).getBytes());
        HttpSession session = req.getSession();
        //logout
        //session.invalidate();
    }
}
