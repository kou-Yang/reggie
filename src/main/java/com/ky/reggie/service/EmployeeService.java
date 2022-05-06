package com.ky.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ky.reggie.common.R;
import com.ky.reggie.entity.Employee;

import javax.servlet.http.HttpServletRequest;

public interface EmployeeService extends IService<Employee> {
    R<Employee> findByUsernameAndPassword(HttpServletRequest request, Employee employee);
}
