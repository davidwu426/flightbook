import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { SearchEntry } from '../../../models/search-entry';
import { Airport } from '../../../models/airport';

@Component({
  selector: 'app-roundtrip-search-entry',
  templateUrl: './roundtrip-search-entry.component.html',
  styleUrls: ['./roundtrip-search-entry.component.css']
})
export class RoundtripSearchEntryComponent implements OnInit {
  @Input()
  searchEntries: SearchEntry[];
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

  searchEntry: SearchEntry;
  returnEntry: SearchEntry;

  constructor() { }

  ngOnInit() {
    this.searchEntry = this.searchEntries[0];
    this.returnEntry = this.searchEntries[1];

    if (this.returnEntry) {
      const tripDuration0 = new Date(this.searchEntries[0].tripArrTime).getTime() -
        new Date(this.returnEntry.tripDepTime).getTime();
      const tripDuration1 = new Date(this.returnEntry.tripArrTime).getTime() -
        new Date(this.returnEntry.tripDepTime).getTime();
      this.tripDurationHours = (tripDuration0 + tripDuration1) / 1000 / 60 / 60;
      this.tripDurationMinutes = (tripDuration0 + tripDuration1) / 1000 % 60;
    }
  }

  triggerBook() {
    this.onBook.emit(this.searchEntries);
  }
}
