import { Component, OnInit, Input } from '@angular/core';
import { SearchEntry } from '../../../models/search-entry';
import { SearchService } from '../../../services/search/search.service';
import { TripLeg } from '../../../models/trip-leg';
import { Airport } from '../../../models/airport';
import { ReservationService } from '../../../services/reservation/reservation.service';
import { BookRequest } from '../../../models/book-request';
import { AuthService } from '../../../services/auth/auth.service';

@Component({
  selector: 'app-oneway-search-entry',
  templateUrl: './oneway-search-entry.component.html',
  styleUrls: ['./oneway-search-entry.component.css']
})
export class OnewaySearchEntryComponent implements OnInit {
  @Input()
  searchEntry: SearchEntry;
  @Input()
  to: Airport;
  @Input()
  from: Airport;
  @Input()
  searchEntryIndex: number;

  tripDuration: number;
  tripDurationHours: number;
  tripDurationMinutes: number;

  constructor(
    private searchService: SearchService,
    private reservationService: ReservationService,
    private authService: AuthService
  ) { }

  ngOnInit() {
    const tripDuration = new Date(this.searchEntry.tripArrTime).getTime() -
      new Date(this.searchEntry.tripDepTime).getTime();
    this.tripDurationHours = tripDuration / 1000 / 60 / 60;
    this.tripDurationMinutes = tripDuration / 1000 % 60;
  }

  book() {
    this.authService.getCustomer().subscribe(c => {
      const accountNo = c.accountNo;
      const totalFare = this.searchEntry.price;
      const bookingFee = totalFare / 10;
      const flightClass = this.searchEntry.flightClass;
      const meal = 'meal';
      const seatNo = '32A';
      const legs = this.searchEntry.tripLegs;
      const fromLegNo = this.searchEntry.fromFlightNo;

      const bookRequest = new BookRequest(accountNo,
        totalFare,
        bookingFee,
        flightClass,
        meal,
        seatNo,
        legs,
        fromLegNo);

      this.reservationService.bookOneWay(bookRequest);
    });
  }
}
