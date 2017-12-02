import { Component, OnInit, Input } from '@angular/core';
import { ManagerService } from '../../../services/manager/manager.service';
import { Employee } from '../../../models/employee';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { CreateEmployeeRequest } from '../../../models/create-employee-request';

@Component({
  selector: 'app-manager-card',
  templateUrl: './manager-card.component.html',
  styleUrls: ['./manager-card.component.css']
})
export class ManagerCardComponent implements OnInit {
  @Input()
  manager: Employee;
  @Input()
  editingManager: Employee;
  @Input()
  createManagerRequest: CreateEmployeeRequest;

  managers: Employee[];
  editModalRef: NgbModalRef;
  createModalRef: NgbModalRef;

  constructor(
    private managerService: ManagerService,
    private modalService: NgbModal
  ) { }

  ngOnInit() {
    this.manager = new Employee();
    this.editingManager = new Employee();
    this.managerService.getManagers().subscribe(m => this.managers = m);
  }

  openCreate(content) {
    this.createModalRef = this.modalService.open(content);

    this.createManagerRequest = new CreateEmployeeRequest();
    this.createManagerRequest.username = 'manager2';
    this.createManagerRequest.password = 'password';
    this.createManagerRequest.firstName = 'mana';
    this.createManagerRequest.lastName = 'ger';
    this.createManagerRequest.address = '123 Address';
    this.createManagerRequest.city = 'Stony Brook';
    this.createManagerRequest.state = 'New York';
    this.createManagerRequest.zip = 11790;
    this.createManagerRequest.telephone = '1234567890';
    this.createManagerRequest.ssn = 1231231245;
    this.createManagerRequest.startDate = new Date();
    this.createManagerRequest.hourlyRate = 42.0;
  }

  addManager() {
    this.managerService.addManager(this.createManagerRequest)
      .subscribe(m => {
        this.managers.push(m);
        this.manager = new Employee();

        this.createModalRef.close();
      });
  }

  openEdit(content, ssn: number) {
    this.editModalRef = this.modalService.open(content);

    this.editingManager = new Employee();
    this.editingManager.ssn = ssn;

    const emp = this.managers.filter(m => m.ssn === ssn)[0];
    this.editingManager.id = emp.id;
    this.editingManager.startDate = emp.startDate;
    this.editingManager.hourlyRate = emp.hourlyRate;
  }

  updateManager() {
    this.managerService.updateManager(this.editingManager)
      .subscribe(m => {
        const updatedManager: Employee = this.managers.filter(manager => manager.id === m.id)[0];
        updatedManager.ssn = m.ssn;
        updatedManager.startDate = m.startDate;
        updatedManager.hourlyRate = m.hourlyRate;

        this.editModalRef.close();
      });
  }

  deleteManager(ssn: number) {
    this.managerService.deleteManager(ssn)
      .subscribe(_ => {
        this.managers = this.managers.filter(m => m.ssn !== ssn);
      });
  }
}
