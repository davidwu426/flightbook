import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { SearchEntry } from '../../../models/search-entry';
import { Airport } from '../../../models/airport';
import { SearchService } from '../../../services/search/search.service';

@Component({
  selector: 'app-multicity-search-entry',
  templateUrl: './multicity-search-entry.component.html',
  styleUrls: ['./multicity-search-entry.component.css']
})
export class MulticitySearchEntryComponent implements OnInit {
  @Input()
  searchEntries: SearchEntry[];
  @Input()
  searchEntryIndex: number;
  @Output()
  onBook: EventEmitter<SearchEntry[]> = new EventEmitter();

  tripDuration: number;
  tripDurationHours: number;
  tripDurationMinutes: number;

  searchEntry: SearchEntry;

  totalPrice = 0;

  constructor(private searchService: SearchService) { }

  ngOnInit() {
    this.searchEntry = this.searchEntries[0];

    for (let i = 0; i < this.searchEntries.length; i++) {
      this.totalPrice += this.searchEntries[i].price;
    }
  }

  triggerBook() {
    this.onBook.emit(this.searchEntries);
  }
}
