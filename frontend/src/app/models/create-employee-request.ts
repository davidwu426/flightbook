export class CreateEmployeeRequest {
  username: string;
  password: string;

  firstName: string;
  lastName: string;
  telephone: string;
  address: string;
  city: string;
  state: string;
  zip: number;

  ssn: number;
  startDate: Date;
  hourlyRate: number;
}
