package com.ninos.controller;

import com.ninos.dto.EmployeeResponse;
import com.ninos.model.Employee;
import com.ninos.repository.EmployeeRepository;
import com.ninos.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class EmployeeController {

    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository, EmployeeService employeeService) {
        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
    }


    // http://localhost:8080/all
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllUsers() {
        List<Employee> students = employeeService.findAllEmployees();
        return new ResponseEntity<>(students, OK);
    }


    @PostMapping("/employee/add")
    public ResponseEntity<EmployeeResponse> addEmployee(@RequestParam("employeeName") String employeeName,
                                                             @RequestParam("email") String email,
                                                             @RequestParam("jobTitle") String jobTitle,
                                                             @RequestParam("phone") String phone,
                                                             @RequestParam("gender") String gender,
                                                             @RequestParam(value="file",required=false) MultipartFile file) throws IOException {

        EmployeeResponse employeeResponse = employeeService.addNewEmployee(employeeName, email, jobTitle, phone, gender,file);
        return new ResponseEntity<>(employeeResponse, OK);
    }


    @GetMapping("/downloadFromDB/{fileName}")
    ResponseEntity<byte[]> downloadSingleFile(@PathVariable String fileName, HttpServletRequest request){

        Employee doc = employeeRepository.findEmployeeByFileName(fileName);

        String mimeType = request.getServletContext().getMimeType(doc.getFileName());

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mimeType))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;fileName="+resource.getFilename())
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;fileName="+ doc.getFileName())
                .body(doc.getDocFile());
    }










}
