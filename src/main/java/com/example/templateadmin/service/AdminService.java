package com.example.templateadmin.service;

import com.example.templateadmin.entity.SysUser;
import com.example.templateadmin.repository.SysRoleRepository;
import com.example.templateadmin.repository.SysUserRepository;
import com.example.templateadmin.repository.mybatis.AdminMapper;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Page<SysUser> findAllSysUsers() {
        Page<SysUser> sysUsers = adminMapper.findSysUsers();
        return sysUsers;
    }
}
