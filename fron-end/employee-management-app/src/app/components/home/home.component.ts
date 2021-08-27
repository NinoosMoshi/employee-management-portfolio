import { EmployeeService } from './../../services/employee.service';
import { Employee } from './../../model/employee';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  employees: Employee[];
  selectedEmployee: Employee;

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.getEmployees();
  }


  public getEmployees(){
    this.employeeService.getEmployees().subscribe(
      data =>{
        this.employees = data
      }
    )
 }


 public onSelectEmployee(selectedEmployee: Employee): void {
   this.selectedEmployee = selectedEmployee;
   document.getElementById('openUserInfo').click();
 }







}
