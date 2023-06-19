package com.example.finaltest.controller;/*Welcome to my show !

@author: NgKhanh
Date: 6/19/2023
Time: 8:27 PM

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
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="createservlet", value = "/create")
public class createController extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        RequestDispatcher view = req.getRequestDispatcher("/pages/createForm.jsp");
        view.forward(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        String fullname = req.getParameter("fullName");
        String address = req.getParameter("address");
        String position = req.getParameter("position");
        String birthDate = req.getParameter("birthDate");
        String department = req.getParameter("department");

        EmployeeImpl employee = new EmployeeImpl();
        try {
            employee.createNew(fullname, address, position, birthDate, department);
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res.sendRedirect(req.getContextPath() + "/employee");
    }
}
