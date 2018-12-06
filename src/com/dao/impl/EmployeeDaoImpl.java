package com.dao.impl;

import com.dao.EmployeeDao;
import com.entity.Employee;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDao {
    @Resource(name="hibernateTemplate")
    private HibernateTemplate hibernateTemplate;
    @Override
    public Employee findByAccount(Employee employee) {
        String hql = "from Employee where account = '" + employee.getAccount() +
                "' and password = '" + employee.getPassword() + "'";
        List<Employee> employees = (List<Employee>)hibernateTemplate.find(hql);
        if (employees.size() == 0) {
            return null;
        } else {
            return employees.get(0);
        }
    }
}
