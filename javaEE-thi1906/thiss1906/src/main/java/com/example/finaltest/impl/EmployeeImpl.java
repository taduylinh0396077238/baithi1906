package com.example.finaltest.impl;/*Welcome to my show !

@author: NgKhanh
Date: 6/14/2023
Time: 7:55 PM

ProjectName: jpa_sem4*/

import com.example.finaltest.entity.Employee;

import java.util.List;

public class EmployeeImpl extends JpaExecutorImpl<Employee>{
    public EmployeeImpl() {
        super(Employee.class);
    }

    public Object getAll() {
        return findall();
    }

    public static void main(String[] args) {
        EmployeeImpl obj = new EmployeeImpl();
        List<Employee> employeeList = obj.findall();
        System.err.println(employeeList);

        System.err.println(obj);
    }
}
