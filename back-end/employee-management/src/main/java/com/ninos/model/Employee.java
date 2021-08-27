package com.ninos.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "email")
    private String email;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "phone")
    private String phone;

    @Column(name = "gender")
    private String gender;

    @Column(name = "employee_code")
    private String employeeCode;


    @Column(name = "image_url")
    private String imageUrl;



    @Column(name = "file_name")
    private String fileName;

    @Lob
    @Column(name = "doc_file")
    private byte[] docFile;



}




