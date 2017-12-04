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

  public static API_LOGIN_URL = Constants.API_URL + '/login';

  public static API_AIRPORTS_URL = Constants.API_URL + '/airports';
  public static API_AIRLINES_URL = Constants.API_URL + '/airlines';

  public static API_CUSTOMERS_URL = Constants.API_URL + '/customers';
  public static API_EMPLOYEES_URL = Constants.API_URL + '/employees';
  public static API_MANAGERS_URL = Constants.API_URL + '/managers';
  public static API_ADMINS_URL = Constants.API_URL + '/admins';
  public static API_PEOPLE_URL = Constants.API_URL + '/people';
  public static API_USERS_URL = Constants.API_URL + '/users';

  public static API_USER_ID_URL = Constants.API_USERS_URL + '/id';
  public static API_PERSON_ID_URL = Constants.API_PEOPLE_URL + '/id';

  public static API_USER_USERNAME_URL = Constants.API_USERS_URL + '/username';
  public static API_PERSON_USERNAME_URL = Constants.API_PEOPLE_URL + '/username';
  public static API_CUSTOMER_USERNAME_URL = Constants.API_CUSTOMERS_URL + '/username';
  public static API_EMPLOYEE_USERNAME_URL = Constants.API_EMPLOYEES_URL + '/username';
  public static API_MANAGER_USERNAME_URL = Constants.API_MANAGERS_URL + '/username';

  public static API_FLIGHTS_URL = Constants.API_URL + '/flights';
  public static API_LEGS = '/legs';
  public static API_SEARCH = Constants.API_URL +  '/search';

  public static API_RESERVATIONS_URL = Constants.API_URL + '/reservations';
}
