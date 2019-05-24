package com.example.templateadmin.controller;

import com.example.templateadmin.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

//    @RequestMapping("/edit")
//    public String adminEdit(String id) {
//        System.out.println("id = " + id);
//        return "admin-edit";
//    }
//
//    @RequestMapping("/add")
//    public String adminAdd() {
//        return "admin-add";
//    }
//
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public String adminList(@RequestParam(defaultValue = "1") int pageNum, Model model) {
//        PageHelper.startPage(pageNum, 10);
//        PageInfo<SysUser> adminList = adminService.findAllSysUsers().toPageInfo();
//        model.addAttribute("adminList", adminList);
//        return "admin-list";
//    }
//
//    @RequestMapping("/cate")
//    public String adminCate() {
//        return "admin-cate";
//    }
//
//    @RequestMapping("/rule")
//    public String adminRule() {
//        return "admin-rule";
//    }
//
//    @RequestMapping("/role")
//    public String adminRole() {
//        return "admin-role";
//    }
//
//    @RequestMapping("/role/edit")
//    public String roleEdit() {
//        return "role-edit";
//    }
//
//    @RequestMapping("/role/add")
//    public String roleAdd() {
//        return "role-add";
//    }
}
