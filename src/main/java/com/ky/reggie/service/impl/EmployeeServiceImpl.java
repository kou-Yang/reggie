package com.ky.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ky.reggie.common.R;
import com.ky.reggie.entity.Employee;
import com.ky.reggie.mapper.EmployeeMapper;
import com.ky.reggie.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public R<Employee> findByUsernameAndPassword(HttpServletRequest request, Employee employee) {
        // 加密
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Employee::getUsername, employee.getUsername());
        Employee emp = employeeMapper.selectOne(wrapper);

        if (emp == null) {
            return R.error("登录失败！");
        }

        if (!emp.getPassword().equals(password)) {
            return R.error("登录失败！");
        }

        if (emp.getStatus() == 0) {
            return R.error("账号已禁用！");
        }

        request.getSession().setAttribute("employee", emp.getId());
        return R.success(emp);
    }
}
