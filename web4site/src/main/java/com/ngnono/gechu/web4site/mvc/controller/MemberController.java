package com.ngnono.gechu.web4site.mvc.controller;


import com.ngnono.gechu.web4site.mvc.model.UserLoginVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by ngnono on 14-2-8.
 */
@Controller
@RequestMapping("/member")
public class MemberController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(MemberController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Index() {
        return "/member/index";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {

        return "/member/login";

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid UserLoginVo user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        try {
            if (bindingResult.hasErrors()) {
                return "/member/login";
            }
            //使用权限工具进行用户登录，登录成功后跳到shiro配置的successUrl中，与下面的return没什么关系！
            SecurityUtils.getSubject().login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));

            return  "/member/index";
        } catch (AuthenticationException e) {
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误");



            logger.error(e.getMessage(),e.getCause());
            return "/member/login";
        }
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(RedirectAttributes redirectAttributes) {
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
        SecurityUtils.getSubject().logout();
        redirectAttributes.addFlashAttribute("message", "您已安全退出");
        return "/member/login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole() {
        return "/403";
    }

    @RequestMapping("/success")
    public String loginSuccessFull(){
           return "/member/success";
    }

    @RequestMapping("/default")
    public String logindefault(){
        return "/member/default";
    }
}
