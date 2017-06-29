package com.app;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by denys on 6/29/2017.
 */
@WebFilter(filterName = "CRUDEndpointFilter", urlPatterns = "/CRUDEndpoint")
public class CRUDEndpointFilter implements Filter {
    private FilterConfig config;

    public void init(FilterConfig config) throws ServletException {
        this.config=config;
    }


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Before call to Servlet");
        long start = System.currentTimeMillis();
        chain.doFilter(req, resp);
        System.out.println("After call to Servlet. Time took:"+(System.currentTimeMillis()-start));
    }

    public void destroy() {
    }

}
