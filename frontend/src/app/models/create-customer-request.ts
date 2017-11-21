export class CreateCustomerRequest {
  constructor(
    private username: string,
    private password: string,
    private firstName: string,
    private lastName: string,
    private telephone: string,
    private address: string,
    private city: string,
    private state: string,
    private zip: number,
    private creditCardNo: string,
    private email: string
  ) {
  }
}
