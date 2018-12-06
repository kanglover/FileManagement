package com.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "department")
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "did",nullable = false,unique = true)
    private Integer did;

    @Column(name = "name",nullable = true,unique=false)
    private String name;

    @OneToMany(targetEntity=Employee.class,cascade={CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name="did")
    private Set<Employee> employees = new HashSet<>();

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
