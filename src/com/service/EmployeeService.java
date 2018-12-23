package com.service;

import com.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findByAccount(Employee employee);

    List<Employee> findEmployees();

}
