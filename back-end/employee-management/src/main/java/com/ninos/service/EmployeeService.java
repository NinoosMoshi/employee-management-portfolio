package com.ninos.service;

import com.ninos.dto.EmployeeResponse;
import com.ninos.model.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {

    public List<Employee> findAllEmployees();

    public EmployeeResponse addNewEmployee(String employeeName, String email, String jobTitle, String phone, String gender, MultipartFile file) throws IOException;


}
