package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    private List<EmployeePayrollData> empDataList = new ArrayList<>();

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return empDataList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return empDataList.stream()
                .filter(empData -> empData.getEmpId() == empId)
                .findFirst()
                .orElseThrow(() ->new EmployeePayrollException("Employee Not Found"));
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(empPayrollDTO);
        empDataList.add(empData);
        log.debug("Emp Data: "+empData.toString());
        return employeePayrollRepository.save(empData);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.setName(empPayrollDTO.name);
        empData.setSalary(empPayrollDTO.salary);
        empDataList.set(empId-1,empData);
        return empData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        empDataList.remove(empId-1);
    }
}
