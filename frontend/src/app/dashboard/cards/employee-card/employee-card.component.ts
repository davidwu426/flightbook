import { Component, OnInit, Input } from '@angular/core';
import { EmployeeService } from '../../../services/employee/employee.service';
import { Employee } from '../../../models/employee';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { CreateEmployeeRequest } from '../../../models/create-employee-request';

@Component({
  selector: 'app-employee-card',
  templateUrl: './employee-card.component.html',
  styleUrls: ['./employee-card.component.css']
})
export class EmployeeCardComponent implements OnInit {
  @Input()
  employee: Employee;
  @Input()
  editingEmployee: Employee;
  @Input()
  createEmployeeRequest: CreateEmployeeRequest;

  employees: Employee[];
  editModalRef: NgbModalRef;
  createModalRef: NgbModalRef;

  constructor(
    private employeeService: EmployeeService,
    private modalService: NgbModal
  ) { }

  ngOnInit() {
    this.employee = new Employee();
    this.editingEmployee = new Employee();
    this.employeeService.getEmployees().subscribe(e => this.employees = e);
  }

  openCreate(content) {
    this.createModalRef = this.modalService.open(content);

    this.createEmployeeRequest = new CreateEmployeeRequest();
  }

  addEmployee() {
    this.employeeService.addEmployee(this.createEmployeeRequest)
      .subscribe(e => {
        this.employees.push(e);
        this.employee = new Employee();

        this.createModalRef.close();
      });
  }

  openEdit(content, ssn: number) {
    this.editModalRef = this.modalService.open(content);

    this.editingEmployee = new Employee();
    this.editingEmployee.ssn = ssn;

    const emp = this.employees.filter(e => e.ssn === ssn)[0];
    this.editingEmployee.id = emp.id;
    this.editingEmployee.startDate = emp.startDate;
    this.editingEmployee.hourlyRate = emp.hourlyRate;
  }

  updateEmployee() {
    this.employeeService.updateEmployee(this.editingEmployee)
      .subscribe(e => {
        const updatedEmployee: Employee = this.employees.filter(employee => employee.id === e.id)[0];
        updatedEmployee.ssn = e.ssn;
        updatedEmployee.startDate = e.startDate;
        updatedEmployee.hourlyRate = e.hourlyRate;

        this.editModalRef.close();
      });
  }

  deleteEmployee(ssn: number) {
    this.employeeService.deleteEmployee(ssn)
      .subscribe(_ => {
        this.employees = this.employees.filter(e => e.ssn !== ssn);
      });
  }
}
