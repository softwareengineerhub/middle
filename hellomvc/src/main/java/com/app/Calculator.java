package com.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * Created by denys on 7/27/2017.
 */
@Controller
public class Calculator {

    /*@RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(WebRequest webRequest, ModelMap model){
        int a = -1;
        int b = -1;
        model.addAttribute("result", a+b);
        return "add";
    }*/

    @RequestMapping(value = "/subtract")
    public String subtract(Model model){
        int a = -1;
        int b = -1;
        model.addAttribute("result", a-b);
        return "subtract";
    }

    @RequestMapping(value = "/multiply")
    public String multiply(Model model){
        int a = -1;
        int b = -1;
        model.addAttribute("result", a*b);
        return "multiply";
    }

    @RequestMapping(value = "/devide")
    public String devide(Model model){
        int a = -1;
        int b = -1;
        model.addAttribute("result", a/b);
        return "devide";

    }
}
