import { Component, OnInit, OnChanges, Input, ViewChild } from '@angular/core';
import { SearchService } from '../../services/search/search.service';
import { SearchEntry } from '../../models/search-entry';
import { SearchCriteria } from '../../models/search-criteria';
import { EventEmitter } from 'events';
import { Airport } from '../../models/airport';
import { FlightClass } from '../../models/flight-class';
import { AuthService } from '../../services/auth/auth.service';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { ReservationService } from '../../services/reservation/reservation.service';
import { BookRequest } from '../../models/book-request';
import { Router } from '@angular/router';
import { NotificationService } from '../../services/notification/notification.service';

@Component({
  selector: 'app-flight-results',
  templateUrl: './flight-results.component.html',
  styleUrls: ['./flight-results.component.css']
})
export class FlightResultsComponent implements OnInit, OnChanges {
  @ViewChild('bookFlight')
  modal: NgbModalRef;
  modalRef: NgbModalRef;

  @Input()
  timesReSearched: number;

  type: string;
  fromAirport: Airport;
  toAirport: Airport;
  depDate: Date;
  arrDate: Date;
  flightClass: FlightClass;

  searchResults: SearchEntry[][] = [];

  flightsToBook: SearchEntry[];
  meal: string;
  seat: string;
  totalFare: number;

  constructor(
    private searchService: SearchService,
    private authService: AuthService,
    private modalService: NgbModal,
    private reservationService: ReservationService,
    private router: Router,
    private notificationService: NotificationService
  ) { }

  ngOnInit() {
    this.reSearch();
  }

  ngOnChanges() {
    this.reSearch();
  }

  reSearch() {
    // update summary
    this.type = this.searchService.type;
    this.fromAirport = this.searchService.searchCriteria[0].fromAirport;
    this.toAirport = this.searchService.searchCriteria[0].toAirport;
    this.depDate = this.searchService.searchCriteria[0].departureDate;
    this.arrDate = this.searchService.searchCriteria[0].returningDate;
    this.flightClass = this.searchService.flightClass;

    const c = this.searchService.searchCriteria[0];

    switch (this.searchService.type) {
      case 'oneway':
        this.searchService.searchOneWay(`${c.fromAirport}`, `${c.toAirport}`,
          new Date(c.departureDate), `${this.searchService.flightClass}`)
          .subscribe(s => this.searchResults[0] = s);
        break;
      case 'roundtrip':
        this.searchService.searchRoundTrip(`${c.fromAirport}`, `${c.toAirport}`,
          new Date(c.departureDate), new Date(c.returningDate),
          `${this.searchService.flightClass}`)
          .subscribe(s => this.searchResults = s);
        break;
      case 'multicity':
        this.searchService.searchMultiCity(this.searchService.searchCriteria,
          `${this.searchService.flightClass}`)
          .subscribe(s => this.searchResults = s);
        break;
    }
  }

  checkout(searchEntries: SearchEntry[]) {
    this.flightsToBook = searchEntries;
    this.totalFare = searchEntries.reduce((total, s) => total + s.price, 0);
    this.modalRef = this.modalService.open(this.modal);
  }

  book() {
    if (this.flightsToBook.length > 0) {
      this.authService.getCustomer().subscribe(c => {
        const requests = new Array<BookRequest>();

        for (let i = 0; i < this.flightsToBook.length; i++) {
          const flight = this.flightsToBook[i];
          const accountNo = c.accountNo;
          const totalFare = this.totalFare;
          const bookingFee = totalFare / 10;
          const flightClass = flight.flightClass;
          const meal = this.meal;
          const seatNo = this.seat;
          const legs = flight.tripLegs;
          const fromLegNo = flight.fromFlightNo;

          const bookRequest = new BookRequest(
            accountNo,
            totalFare,
            bookingFee,
            flightClass,
            meal,
            seatNo,
            legs,
            fromLegNo);

            requests.push(bookRequest);
        }

        this.reservationService.bookMulti(requests).subscribe(b => {
          if (b) {
            this.notificationService.success('Successfully booked flight');
            this.modalRef.close();
            this.router.navigateByUrl('/');
          } else {
            this.notificationService.warning('Error occured attempting to book flight');
            this.modalRef.close();
            this.router.navigateByUrl('/');
          }
        });
      });
    }
  }
}
