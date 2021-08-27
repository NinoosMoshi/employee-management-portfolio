package com.ninos.service;

import com.ninos.dto.EmployeeResponse;
import com.ninos.model.Employee;
import com.ninos.repository.EmployeeRepository;
import com.ninos.utill.RandomCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeResponse addNewEmployee(String employeeName, String email, String jobTitle, String phone, String gender, MultipartFile file) throws IOException {
        Employee employee = new Employee();
        String random = RandomCode.generateRandomCode();
        if(file == null){
            employee.setEmployeeName(employeeName);
            employee.setEmail(email);
            employee.setJobTitle(jobTitle);
            employee.setPhone(phone);
            employee.setGender(gender);
            employee.setEmployeeCode(random);

            String image_robohash = "https://robohash.org/"+ employeeName;
            employee.setImageUrl(image_robohash);
//            fileDocument.setFileName(null);
//            fileDocument.setDocFile(file.getBytes());
            employeeRepository.save(employee);
//            String contentType = file.getContentType();
            EmployeeResponse response = new EmployeeResponse(employeeName, email, jobTitle, phone, gender, image_robohash);
            return response;
        }
        String name = StringUtils.cleanPath(file.getOriginalFilename());
        String imageUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFromDB/")
                .path(name)
                .toUriString();


        employee.setEmployeeName(employeeName);
        employee.setEmail(email);
        employee.setJobTitle(jobTitle);
        employee.setPhone(phone);
        employee.setGender(gender);
        employee.setEmployeeCode(random);
        employee.setImageUrl(imageUrl);
        employee.setFileName(name);
        employee.setDocFile(file.getBytes());
        employeeRepository.save(employee);
        String contentType = file.getContentType();
        EmployeeResponse response = new EmployeeResponse(employeeName, email, jobTitle, phone, gender,random,name, contentType, imageUrl);
        return response;
    }




}
