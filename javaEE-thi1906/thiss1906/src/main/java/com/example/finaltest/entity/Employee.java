package com.example.finaltest.entity;/*Welcome to my show !

@author: NgKhanh
Date: 6/19/2023
Time: 7:02 PM

ProjectName: finalTest*/

import com.example.finaltest.annotation.Column;
import com.example.finaltest.annotation.Entity;
import com.example.finaltest.annotation.Id;
import com.example.finaltest.constant.SqlDataType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity(tablename = "employee")
public class Employee {
    @Id(name = "id")
    private int id;
    @Column(name = "fullName", dataType = SqlDataType.TEXT)
    private String fullName;
    @Column(name = "birthDay", dataType = SqlDataType.TEXT)
    private String birthDay;
    @Column(name = "address", dataType = SqlDataType.TEXT)
    private String address;
    @Column(name = "position", dataType = SqlDataType.TEXT)
    private String position;
    @Column(name = "department", dataType = SqlDataType.TEXT)
    private String department;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}