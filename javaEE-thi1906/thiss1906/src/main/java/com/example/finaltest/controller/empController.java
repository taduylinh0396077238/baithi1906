package com.example.finaltest.controller;/*Welcome to my show !

@author: NgKhanh
Date: 6/19/2023
Time: 7:02 PM

ProjectName: finalTest*/

import com.example.finaltest.entity.Employee;
import com.example.finaltest.impl.EmployeeImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="employeeservlet", value = "/employee")
public class empController extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("/pages/list.jsp");

        EmployeeImpl employee = new EmployeeImpl();

        List<Employee> employeesList = employee.findall();
        req.setAttribute("employees", employeesList);
        view.forward(req, res);
    }
}
