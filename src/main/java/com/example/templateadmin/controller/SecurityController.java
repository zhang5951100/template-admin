package com.example.templateadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityController {

    @RequestMapping("/login")
    public String login() {
        return "templates/login.html";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("error", true);
        model.addAttribute("msg", "账号/密码错误");
        return "templates/login.html";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "templates/login.html";
    }

    @RequestMapping("/json")
    @ResponseBody
    public String json() {
        return "welcome";
    }


    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/welcome1")
    public String welcome1() {
        return "welcome1";
    }

    @RequestMapping("/member-list")
    public String memberList() {
        return "member-list";
    }

    @RequestMapping("/member-list1")
    public String memberList1() {
        return "member-list1";
    }

    @RequestMapping("/member-del")
    public String memberDel() {
        return "member-del";
    }

    @RequestMapping("/member-add")
    public String memberAdd() {
        return "member-add";
    }

    @RequestMapping("/member-edit")
    public String memberEdit() {
        return "member-edit";
    }

    @RequestMapping("/member-password")
    public String memberPassword() {
        return "member-password";
    }

    @RequestMapping("/order-list")
    public String orderList() {
        return "order-list";
    }

    @RequestMapping("/order-list1")
    public String orderList1() {
        return "order-list1";
    }

    @RequestMapping("/order-add")
    public String orderAdd() {
        return "order-add";
    }

    @RequestMapping("/order-view")
    public String orderView() {
        return "order-view";
    }

    @RequestMapping("/cate")
    public String cate() {
        return "cate";
    }

    @RequestMapping("/city")
    public String city() {
        return "city";
    }

    @RequestMapping("/unicode")
    public String unicode() {
        return "unicode";
    }
}
