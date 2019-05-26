package com.example.templateadmin.controller;

import com.example.templateadmin.controller.vo.Result;
import com.example.templateadmin.entity.SysUser;
import com.example.templateadmin.service.AdminService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
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
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result adminList(int limit, int page) {
//        PageHelper.startPage(page, limit);
        Result<List> result = new Result<>();

        PageInfo<SysUser> adminList = adminService.findAllSysUsers().toPageInfo();

        result.setCode(0);
        result.setMsg("success");
        result.setCount((int) adminList.getTotal());
        result.setData(adminList.getList());
        return result;
    }
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

    @RequestMapping("/role")
    public String adminRole() {
        return "admin-role";
    }
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
