package com.ninos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeResponse {

    private String employeeName;
    private String email;
    private String jobTitle;
    private String phone;
    private String gender;
    private String imageUrl;

    private String employeeCode;
    private String fileName;
    private String contentType;


    // constructor without (employeeCode,fileName,contentType)
    public EmployeeResponse(String employeeName, String email, String jobTitle, String phone, String gender, String imageUrl) {
        this.employeeName = employeeName;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.gender = gender;
        this.imageUrl = imageUrl;
    }


    // constructor without (fileName,contentType)
    public EmployeeResponse(String employeeName, String email, String jobTitle, String phone, String gender, String imageUrl, String employeeCode) {
        this.employeeName = employeeName;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.gender = gender;
        this.imageUrl = imageUrl;
        this.employeeCode = employeeCode;
    }
}
