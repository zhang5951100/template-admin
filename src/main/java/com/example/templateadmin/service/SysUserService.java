package com.example.templateadmin.service;

import com.example.templateadmin.entity.SysRole;
import com.example.templateadmin.entity.SysUser;
import com.example.templateadmin.repository.SysRoleRepository;
import com.example.templateadmin.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysUserService implements UserDetailsService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 初始化2个认证用户
     */
    @PostConstruct
    private void init() {
        if (sysUserRepository.findByUsername("administrator") == null) {
            SysRole roleAdministrator = new SysRole();
            roleAdministrator.setName("ROLE_ADMINISTRATOR");
            roleAdministrator.setDescription("超级管理员");

            SysUser sysAdmin = new SysUser();
            sysAdmin.setUsername("administrator");
            sysAdmin.setPassword(passwordEncoder.encode("admin"));
            List<SysRole> sysRolesAdmin = new ArrayList<>();
            sysRolesAdmin.add(roleAdministrator);
            sysAdmin.setSysRoles(sysRolesAdmin);

            sysRoleRepository.save(roleAdministrator);
            sysUserRepository.save(sysAdmin);
        }

        if (sysUserRepository.findByUsername("admin") == null) {
            SysRole roleAdmin = new SysRole();
            roleAdmin.setName("ROLE_ADMIN");
            roleAdmin.setDescription("管理员");

            SysUser sysAdmin = new SysUser();
            sysAdmin.setUsername("admin");
            sysAdmin.setPassword(passwordEncoder.encode("admin"));
            List<SysRole> sysRolesAdmin = new ArrayList<>();
            sysRolesAdmin.add(roleAdmin);
            sysAdmin.setSysRoles(sysRolesAdmin);

            sysRoleRepository.save(roleAdmin);
            sysUserRepository.save(sysAdmin);
        }

        if (sysUserRepository.findByUsername("user") == null) {
            SysRole roleUser = new SysRole();
            roleUser.setName("ROLE_USER");
            roleUser.setDescription("普通用户");

            SysUser sysUser = new SysUser();
            sysUser.setUsername("user");
            sysUser.setPassword(passwordEncoder.encode("user"));
            List<SysRole> sysRolesUser = new ArrayList<>();
            sysRolesUser.add(roleUser);
            sysUser.setSysRoles(sysRolesUser);

            sysRoleRepository.save(roleUser);
            sysUserRepository.save(sysUser);

        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return sysUserRepository.findByUsername(username);
    }


}
