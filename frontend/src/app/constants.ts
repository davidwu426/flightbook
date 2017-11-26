import { HttpHeaders } from '@angular/common/http';

export class Constants {
  // URL to application
  public static APP_URL = 'http://localhost:8080';

  // prefix to api endpoints
  private static API_PREFIX = '/api';

  // URL of API endpoint
  public static API_URL = Constants.APP_URL + Constants.API_PREFIX;

  // HTTP options for setting content type to json
  public static HTTP_OPTIONS = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  // HTTP options for setting response type to text
  public static HTTP_OPTIONS_TEXT = {
    headers: new HttpHeaders({ 'Content-Type': 'text/plain' }),
    responseType: 'text' as 'json'
  };

  // current user key in local storage
  public static CURRENT_USER_KEY = 'currentUser';
}
