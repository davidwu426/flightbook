import { Component, OnInit, Input } from '@angular/core';
import { SearchEntry } from '../../../models/search-entry';
import { SearchService } from '../../../services/search/search.service';
import { TripLeg } from '../../../models/trip-leg';
import { Airport } from '../../../models/airport';
import { ReservationService } from '../../../services/reservation/reservation.service';

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
    private reservationService: ReservationService
  ) { }

  ngOnInit() {
    const tripDuration = new Date(this.searchEntry.tripArrTime).getTime() -
      new Date(this.searchEntry.tripDepTime).getTime();
    this.tripDurationHours = tripDuration / 1000 / 60 / 60;
    this.tripDurationMinutes = tripDuration / 1000 % 60;
  }
}
