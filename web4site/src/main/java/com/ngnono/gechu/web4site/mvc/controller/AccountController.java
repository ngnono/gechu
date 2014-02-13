package com.ngnono.gechu.web4site.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by ngnono on 14-1-24.
 */

@Controller
@RequestMapping("/account")
public class AccountController {
    @RequestMapping(value = "/changepassword",method = RequestMethod.GET)
    public String changePsd(){

        return "changepsd";
    }

    @RequestMapping(value = "/changepassword",method = RequestMethod.POST)
    public String changePsd(RedirectAttributes redirectAttributes){

        return "success";
    }
}
