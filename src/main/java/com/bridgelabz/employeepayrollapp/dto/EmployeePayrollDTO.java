package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;


public @ToString class EmployeePayrollDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    public String name;

    @Min(value = 500, message = "Minimum Wage Should be More then 500")
    public long salary;

    @Pattern(regexp = "male|female", message = "Gender needs to be male or female")
    public String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "startDate should Note be Empty")
    @PastOrPresent(message = "startDate should be past or todays date")
    public LocalDate startDate;

    @NotBlank(message = "Notes cannot be empty")
    public  String note;

    @NotBlank(message = "Profile cannot be empty")
    public String profilePic;

    @NotNull(message = "Department cannot be empty")
    public List<String> departments;

}
