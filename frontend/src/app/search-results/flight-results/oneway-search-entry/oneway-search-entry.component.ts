import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
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
  @Output()
  onBook: EventEmitter<SearchEntry[]> = new EventEmitter();

  tripDuration: number;
  tripDurationHours: number;
  tripDurationMinutes: number;

  searchEntryAsList: SearchEntry[];

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

    this.searchEntryAsList = [];
    this.searchEntryAsList.push(this.searchEntry);
  }

  triggerBook() {
    this.onBook.emit([this.searchEntry]);
  }
}
