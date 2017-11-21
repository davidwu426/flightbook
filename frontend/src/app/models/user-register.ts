import { CreateCustomerRequest } from './create-customer-request';

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

  ssn: string;
  startDate: Date;
  hourlyWage: number;

  admin: boolean;

  convertToCreateCustomerRequest() {
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
}
