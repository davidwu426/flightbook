import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Person } from '../../models/person';
import { Observable } from 'rxjs/Observable';
import { Constants } from '../../constants';

@Injectable()
export class PersonService {
  constructor(private http: HttpClient) { }

  getPeople(): Observable<Person[]> {
    return this.http.get<Person[]>(Constants.API_PEOPLE_URL);
  }

  getPerson(id: number): Observable<Person> {
    return this.http.get<Person>(`${Constants.API_PERSON_ID_URL}/${id}`);
  }

  updatePerson(person: Person): Observable<any> {
    const url = `${Constants.API_PEOPLE_URL}/${person.id}`;

    return this.http.put(url, person, Constants.HTTP_OPTIONS);
  }
}
