package com.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by denys on 7/27/2017.
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String process(WebRequest webRequest, Model model){
        System.out.println("process()"+webRequest.getParameter("test"));
        model.addAttribute("param","Value");
        return "greeting";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(WebRequest webRequest, Model model){
        System.out.println("add()" + webRequest.getParameter("test"));
        int a = Integer.parseInt(webRequest.getParameter("a"));
        int b = Integer.parseInt(webRequest.getParameter("b"));
        model.addAttribute("param", "Value");
        model.addAttribute("result", a+b);
        return "add";
    }

}
