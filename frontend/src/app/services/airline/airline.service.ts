import { Injectable } from '@angular/core';
import { Airline } from '../../models/airline';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { MessageService } from '../message/message.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class AirlineService {
  private airlineUrl = 'http://localhost:8080/api/airlines';

  constructor(
    private messageService: MessageService,
    private http: HttpClient
  ) { }

  getAirlines(): Observable<Airline[]> {
    return this.http.get<Airline[]>(this.airlineUrl)
      .pipe(
        tap(_ => this.log('fetched airlines')),
        catchError(this.handleError('getAirlines', []))
      );
  }

  getAirline(id: string): Observable<Airline> {
    const url = `${this.airlineUrl}/${id}`;

    return this.http.get<Airline>(url).pipe(
      tap(_ => this.log(`fetched airline id=${id}`)),
      catchError(this.handleError<Airline>(`getAirline id=${id}`))
    );
  }

  updateAirline(airline: Airline): Observable<any> {
    const url = `${this.airlineUrl}/${airline.id}`;

    return this.http.put(url, airline, httpOptions)
      .pipe(
        tap(_ => this.log(`updated airline id=${airline.id}`)),
        catchError(this.handleError<any>('updateAirline'))
      );
  }

  addAirline(airline: Airline): Observable<Airline> {
    return this.http.post<Airline>(this.airlineUrl, airline, httpOptions)
      .pipe(
        tap((a: Airline) => this.log(`added airline with id=${a.id}`)),
        catchError(this.handleError<Airline>('addAirline'))
      );
  }

  deleteAirline(airline: Airline): Observable<Airline> {
    const id = airline.id;
    const url = `${this.airlineUrl}/${id}`;

    return this.http.delete<Airline>(url, httpOptions)
      .pipe(
        tap(_ => this.log(`deleted airline id=${id}`)),
        catchError(this.handleError<Airline>('deleteAirline'))
      );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      this.log(`${operation} failed: ${error.message}`);

      return of(result as T);
    };
  }

  private log(message: string) {
    this.messageService.add('AirlineService: ' + message);
  }
}
