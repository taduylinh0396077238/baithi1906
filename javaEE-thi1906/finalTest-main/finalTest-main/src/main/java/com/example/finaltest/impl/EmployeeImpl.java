package com.example.finaltest.impl;

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
