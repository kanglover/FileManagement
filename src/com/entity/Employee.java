package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "eid",nullable = false,unique = true)
    private Integer eid;

    @Column(name = "name",nullable = true,unique=false)
    private String name;

    @Column(name = "account",nullable = true)
    private String account;

    @Column(name = "password",nullable = true)
    private String password;

    @ManyToOne(targetEntity=Department.class,cascade={CascadeType.ALL})
    @JoinColumn(name = "did")
    private Department department;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
