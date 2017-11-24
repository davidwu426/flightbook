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

  creditCard: string;
  email: string;

  ssn: number;
  startDate: Date;
  hourlyWage: number;

  admin: boolean;

  convertToCreateCustomerRequest(): CreateCustomerRequest {
    return new CreateCustomerRequest(
      this.username,
      this.password,
      this.firstName,
      this.lastName,
      this.telephone,
      this.address,
      this.city,
      this.state,
      this.zip,
      this.creditCard,
      this.email
    );
  }

  convertToCreateEmployeeRequest(): CreateEmployeeRequest {
    return new CreateEmployeeRequest(
      this.username,
      this.password,
      this.firstName,
      this.lastName,
      this.telephone,
      this.address,
      this.city,
      this.state,
      this.zip,
      this.ssn,
      this.startDate,
      this.hourlyWage
    );
  }

  convertToCreateAdminRequest(): CreateAdminRequest {
    return new CreateAdminRequest(
      this.username,
      this.password,
      this.firstName,
      this.lastName,
      this.telephone,
      this.address,
      this.city,
      this.state,
      this.zip
    );
  }
}
