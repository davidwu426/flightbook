import { Component, OnInit, Input } from '@angular/core';
import { SearchEntry } from '../../../models/search-entry';
import { SearchService } from '../../../services/search/search.service';
import { TripLeg } from '../../../models/trip-leg';

@Component({
  selector: 'app-oneway-search-entry',
  templateUrl: './oneway-search-entry.component.html',
  styleUrls: ['./oneway-search-entry.component.css']
})
export class OnewaySearchEntryComponent implements OnInit {
  @Input()
  searchEntry: SearchEntry;
  tripDuration: number;
  tripDurationHours: number;
  tripDurationMinutes: number;

  constructor(private searchService: SearchService) { }

  ngOnInit() {
    const tripLegs = this.searchEntry.tripLegs;

    const tripDuration = new Date(this.searchEntry.tripArrTime).getTime() -
      new Date(this.searchEntry.tripDepTime).getTime();
    this.tripDurationHours = tripDuration / 1000 / 60 / 60;
    this.tripDurationMinutes = tripDuration / 1000 % 60;
  }
}
