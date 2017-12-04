import { Component, OnInit, Input } from '@angular/core';
import { CustomerService } from '../../../services/customer/customer.service';
import { Customer } from '../../../models/customer';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { CreateCustomerRequest } from '../../../models/create-customer-request';

@Component({
  selector: 'app-customer-card',
  templateUrl: './customer-card.component.html',
  styleUrls: ['./customer-card.component.css']
})
export class CustomerCardComponent implements OnInit {
  @Input()
  customer: Customer;
  @Input()
  editingCustomer: Customer;
  @Input()
  createCustomerRequest: CreateCustomerRequest;

  customers: Customer[];
  editModalRef: NgbModalRef;
  createModalRef: NgbModalRef;

  showEditPersonalInfo = false;

  constructor(
    private customerService: CustomerService,
    private modalService: NgbModal
  ) { }

  ngOnInit() {
    this.customer = new Customer();
    this.editingCustomer = new Customer();
    this.customerService.getCustomers().subscribe(c => this.customers = c);
  }

  openCreate(content) {
    this.createModalRef = this.modalService.open(content);

    this.createCustomerRequest = new CreateCustomerRequest();
  }

  addCustomer() {
    this.customerService.addCustomer(this.createCustomerRequest)
      .subscribe(c => {
        this.customers.push(c);
        this.customer = new Customer();

        this.createModalRef.close();
      });
  }

  openEdit(content, accountNo: number) {
    this.showEditPersonalInfo = false;

    this.editModalRef = this.modalService.open(content);

    this.editingCustomer = new Customer();
    this.editingCustomer.accountNo = accountNo;

    const cust = this.customers.filter(c => c.accountNo === accountNo)[0];
    this.editingCustomer.id = cust.id;
    this.editingCustomer.creditCardNo = cust.creditCardNo;
    this.editingCustomer.email = cust.email;
    this.editingCustomer.creationDate = cust.creationDate;
    this.editingCustomer.rating = cust.rating;
  }

  updateCustomer() {
    this.customerService.updateCustomer(this.editingCustomer)
      .subscribe(c => {
        const updatedCustomer: Customer = this.customers.filter(customer => customer.id === c.id)[0];
        updatedCustomer.accountNo = c.accountNo;
        updatedCustomer.creditCardNo = c.creditCardNo;
        updatedCustomer.email = c.email;
        updatedCustomer.creationDate = c.creationDate;
        updatedCustomer.rating = c.rating;

        this.editModalRef.close();
      });
  }

  deleteCustomer(accountNo: number) {
    this.customerService.deleteCustomer(accountNo)
      .subscribe(_ => {
        this.customers = this.customers.filter(c => c.accountNo !== accountNo);
      });
  }
}
