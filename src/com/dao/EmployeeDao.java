package com.dao;

import com.entity.Employee;

public interface EmployeeDao {
    Employee findByAccount(Employee employee);
}
