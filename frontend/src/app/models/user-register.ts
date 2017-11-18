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
  phone: string;
  address: string;
  city: string;
  zip: string;
  type: 'customer' | 'employee' | 'manager' | 'admin';

  creditCard: number;
  email: string;

  ssn: string;
  startDate: Date;
  hourlyWage: number;

  admin: boolean;
}
