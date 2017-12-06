import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { SearchComponent } from '../search/search.component';
import { FlightClass } from '../models/flight-class';

@Component({
  selector: 'app-search-condensed',
  templateUrl: './search-condensed.component.html',
  styleUrls: ['./search-condensed.component.css']
})
export class SearchCondensedComponent extends SearchComponent {
  @Output()
  onReSearch: EventEmitter<any> = new EventEmitter();

  reSearch() {
    this.onReSearch.emit();
  }
}
