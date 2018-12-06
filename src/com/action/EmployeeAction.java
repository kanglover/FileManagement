package com.action;

import com.entity.Employee;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.EmployeeService;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Controller
@Scope("prototype")
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {
    private Employee employee = new Employee();

    @Resource
    private EmployeeService employeeService;

    public String login(){
        Employee e = employeeService.findByAccount(employee);
        if (e != null) {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.getSession().setAttribute("employee", e);
            return SUCCESS;
        } else {
            this.addFieldError("error", "账号或者密码错误！");
            return INPUT;
        }
    }
    @Override
    // 重载ActionSupport类的方法（Validateable接口）
    public void validate() {
        super.validate();
        // 验证方式一：
        if ("".equals(employee.getAccount())) {
            this.addFieldError("account", "对不起，用户名不可以为空！");
        }
        if ("".equals(employee.getPassword())) {
            this.addFieldError("password", "对不起，密码不可以为空！");
        }
    }
    @Override
    public Employee getModel() {
        return this.employee;
    }

}
