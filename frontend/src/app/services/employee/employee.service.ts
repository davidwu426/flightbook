import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Constants } from '../../constants';
import { Employee } from '../../models/employee';
import { CreateEmployeeRequest } from '../../models/create-employee-request';

@Injectable()
export class EmployeeService {
  constructor(private http: HttpClient) { }

  getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(Constants.API_EMPLOYEES_URL);
  }

  addEmployee(createEmployeeRequest: CreateEmployeeRequest): Observable<Employee> {
    return this.http.post<Employee>(Constants.API_EMPLOYEES_URL, createEmployeeRequest, Constants.HTTP_OPTIONS);
  }

  updateEmployee(employee: Employee): Observable<any> {
    const url = `${Constants.API_EMPLOYEES_URL}/${employee.ssn}`;

    return this.http.put(url, employee, Constants.HTTP_OPTIONS);
  }

  deleteEmployee(ssn: number): Observable<Employee> {
    const url = `${Constants.API_EMPLOYEES_URL}/${ssn}`;

    return this.http.delete<Employee>(url, Constants.HTTP_OPTIONS);
  }
}
