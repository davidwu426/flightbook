import { CreateCustomerRequest } from './create-customer-request';
import { CreateEmployeeRequest } from './create-employee-request';
import { CreateAdminRequest } from './create-admin-request';

export class UserRegister {
  constructor() {
    this.type = 'customer';
    this.admin = false;
  }

  username: string;
  firstName: string;
  lastName: string;
  password: string;
  confirmPassword: string;
  telephone: string;
  address: string;
  state: string;
  city: string;
  zip: number;
  type: 'customer' | 'employee' | 'manager' | 'admin';

  creditCardNo: string;
  email: string;

  ssn: number;
  startDate: Date;
  hourlyRate: number;

  admin: boolean;

  convertToCreateCustomerRequest(): CreateCustomerRequest {
    const c = new CreateCustomerRequest();
    c.username = this.username;
    c.password = this.password;
    c.firstName = this.firstName;
    c.lastName = this.lastName;
    c.telephone = this.telephone;
    c.address = this.address;
    c.city = this.city;
    c.state = this.state;
    c.zip = this.zip;
    c.creditCardNo = this.creditCardNo;
    c.email = this.email;

    return c;
  }

  convertToCreateEmployeeRequest(): CreateEmployeeRequest {
    const e = new CreateEmployeeRequest();
    e.username = this.username;
    e.password = this.password;
    e.firstName = this.firstName;
    e.lastName = this.lastName;
    e.telephone = this.telephone;
    e.address = this.address;
    e.city = this.city;
    e.state = this.state;
    e.zip = this.zip;
    e.ssn = this.ssn;
    e.startDate = this.startDate;
    e.hourlyRate = this.hourlyRate;

    return e;
  }

  convertToCreateAdminRequest(): CreateAdminRequest {
    const c = new CreateAdminRequest();
    c.username = this.username;
    c.password = this.password;
    c.firstName = this.firstName;
    c.lastName = this.lastName;
    c.telephone = this.telephone;
    c.address = this.address;
    c.city = this.city;
    c.state = this.state;
    c.zip = this.zip;

    return c;
  }
}
