package com.alsinteligence.sfgpetclinic.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"","/","home", "home.html"})
    public String index(){
        return "index";
    }

    @RequestMapping({"/oups"})
    public String oupsHandler(){
        return "notimplemented";
    }
}
