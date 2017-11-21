export class UserCredentials {
  username: string;
  jwt: string;

  constructor(username: string, jwt: string) {
    this.username = username;
    this.jwt = jwt;
  }
}
