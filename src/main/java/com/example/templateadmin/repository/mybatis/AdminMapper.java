package com.example.templateadmin.repository.mybatis;

import com.example.templateadmin.entity.SysUser;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    Page<SysUser> findSysUsers();
}
