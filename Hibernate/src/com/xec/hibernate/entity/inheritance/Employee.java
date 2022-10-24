package com.xec.hibernate.entity.inheritance;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMP_ID")
    private int empId;

    @Column(name = "name")
    private String name;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}