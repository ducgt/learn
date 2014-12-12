package com.gqshao.authentication.controller;

import com.gqshao.authentication.filter.MyAuthenticationFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class LoginController {

    /**
     * shiro通过/login访问该控制器方法，由该方法跳转到真实登陆页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 只有登陆认证失败才会访问到该方法
     *
     * @param userName
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String fail(@RequestParam(MyAuthenticationFilter.DEFAULT_LOGINNAME_PARAM) String userName, Model model) {
        model.addAttribute(MyAuthenticationFilter.DEFAULT_LOGINNAME_PARAM, userName);
        model.addAttribute(MyAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME, true);
        return "login";
    }
}
