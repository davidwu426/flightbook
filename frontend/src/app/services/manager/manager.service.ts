import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Constants } from '../../constants';
import { Employee } from '../../models/employee';
import { CreateEmployeeRequest } from '../../models/create-employee-request';

@Injectable()
export class ManagerService {
  constructor(private http: HttpClient) { }

  getManagers(): Observable<Employee[]> {
    return this.http.get<Employee[]>(Constants.API_MANAGERS_URL);
  }

  addManager(createEmployeeRequest: CreateEmployeeRequest): Observable<Employee> {
    return this.http.post<Employee>(Constants.API_MANAGERS_URL, createEmployeeRequest, Constants.HTTP_OPTIONS);
  }

  updateManager(manager: Employee): Observable<any> {
    const url = `${Constants.API_MANAGERS_URL}/${manager.ssn}`;

    return this.http.put(url, manager, Constants.HTTP_OPTIONS);
  }

  deleteManager(ssn: number): Observable<Employee> {
    const url = `${Constants.API_MANAGERS_URL}/${ssn}`;

    return this.http.delete<Employee>(url, Constants.HTTP_OPTIONS);
  }
}
