package com.service.impl;

import com.dao.EmployeeDao;
import com.entity.Employee;
import com.service.EmployeeService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeDao employeeDao;

    @Override
    public Employee findByAccount(Employee employee) {
        return this.employeeDao.findByAccount(employee);
    }

    @Override
    public List<Employee> findEmployees() {
        return this.employeeDao.findEmployees();
    }
}
