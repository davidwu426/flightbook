import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Reservation } from '../../models/reservation';
import { Constants } from '../../constants';
import { ReservationDetails } from '../../models/reservation-details';
import { Include } from '../../models/include';
import { BookRequest } from '../../models/book-request';

@Injectable()
export class ReservationService {
  constructor(private http: HttpClient) { }

  getReservations(): Observable<ReservationDetails[]> {
    return this.http.get<ReservationDetails[]>(Constants.API_RESERVATIONS_URL);
  }

  getReservationByNo(resrNo: number): Observable<ReservationDetails> {
    return this.http.get<ReservationDetails>(`${Constants.API_RESERVATIONS_URL}/${resrNo}`);
  }

  getReservationByFlight(airlineId: string, flightNo: number): Observable<ReservationDetails[]> {
    let params = new HttpParams();
    params = params.append('airlineId', airlineId);
    params = params.append('flightNo', `${flightNo}`);

    return this.http.get<ReservationDetails[]>(Constants.API_RESERVATIONS_URL, { params: params });
  }

  getReservationByAccountNo(accountNo: number): Observable<ReservationDetails[]> {
    let params = new HttpParams();
    params = params.append('accountNo', `${accountNo}`);

    return this.http.get<ReservationDetails[]>(Constants.API_RESERVATIONS_URL, { params: params });
  }

  getReservationByCustomerName(firstName: string, lastName: string): Observable<ReservationDetails[]> {
    let params = new HttpParams();
    params = params.append('firstName', firstName);
    params = params.append('lastName', lastName);

    return this.http.get<ReservationDetails[]>(Constants.API_RESERVATIONS_URL, { params: params });
  }

  addReservation(reservation: Reservation, includes: Include[]): Observable<ReservationDetails> {
    const addRequest = {
      reservation: reservation,
      include: includes
    };

    return this.http.post<ReservationDetails>(Constants.API_RESERVATIONS_URL, addRequest, Constants.HTTP_OPTIONS);
  }

  deleteReservation(resrNo: number): Observable<Reservation> {
    const url = `${Constants.API_RESERVATIONS_URL}/${resrNo}`;

    return this.http.delete<Reservation>(url, Constants.HTTP_OPTIONS);
  }

  bookOneWay(bookRequest: BookRequest): Observable<boolean> {
    return this.http.post<boolean>(Constants.API_BOOK_ONEWAY_URL, bookRequest, Constants.HTTP_OPTIONS);
  }

  bookMulti(bookRequests: BookRequest[]): Observable<boolean> {
    return this.http.post<boolean>(Constants.API_BOOK_MULTI_URL, bookRequests, Constants.HTTP_OPTIONS);
  }
}
