package com.dao;

import com.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee findByAccount(Employee employee);

    List<Employee> findEmployees();
}
