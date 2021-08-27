import { Employee } from './../model/employee';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseURL = 'http://localhost:8080';

  constructor(private http: HttpClient) { }


  // http://localhost:8080/all
  getEmployees(): Observable<Employee[]>{
    return this.http.get<Employee[]>(`${this.baseURL}/all`);
  }


  // http://localhost:8080/employee/add
  addEmployee(formData: FormData): Observable<Employee | HttpErrorResponse>{
    return this.http.post<Employee>(`${this.baseURL}/employee/add`, formData);
  }



  createStudetFormData(employee: Employee, profileImage: File): FormData{
    const formData = new FormData();
    formData.append('name', employee.employeeName);
    formData.append('email', employee.email);
    formData.append('jobTitle', employee.jobTitle);
    formData.append('phone', employee.phone);
    formData.append('gender', employee.gender);
    formData.append('profileImage', profileImage);
    return formData;
  }











}
