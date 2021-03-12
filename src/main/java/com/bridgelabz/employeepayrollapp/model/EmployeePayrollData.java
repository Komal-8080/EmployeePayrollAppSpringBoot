package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


public @Data class EmployeePayrollData {
    private int empId;
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private  String note;
    private String profilePic;
    private List<String> departments;

    public EmployeePayrollData() { }

    public void updateEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        this.name = empPayrollDTO.name;
        this.salary = empPayrollDTO.salary;
        this.gender = empPayrollDTO.gender;
        this.note = empPayrollDTO.note;
        this.startDate = empPayrollDTO.startDate;
        this.profilePic = empPayrollDTO.profilePic;
        this.departments = empPayrollDTO.departments;
    }

    public EmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        this.empId = empId;
        this.updateEmployeePayrollData(empPayrollDTO);
    }
}
