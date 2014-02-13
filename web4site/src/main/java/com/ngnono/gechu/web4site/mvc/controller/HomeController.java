package com.ngnono.gechu.web4site.mvc.controller;

import com.ngnono.gechu.core.dto.Hello;
import com.ngnono.gechu.core.repository.impl.AccountRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ngnono on 14-1-24.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private AccountRepositoryImpl accountRepositoryImpl;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(ModelMap model) {
        Hello m = new Hello();
        m.setMessage("Hello world!");
        model.addAttribute("model", m);

        return "home/hello";
    }


}
