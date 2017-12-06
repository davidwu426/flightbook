import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { SearchService } from '../../services/search/search.service';
import { SearchEntry } from '../../models/search-entry';
import { SearchCriteria } from '../../models/search-criteria';

@Component({
  selector: 'app-flight-results',
  templateUrl: './flight-results.component.html',
  styleUrls: ['./flight-results.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class FlightResultsComponent implements OnInit {
  searchResults: SearchEntry[];

  constructor(public searchService: SearchService) { }

  ngOnInit() {
    switch (this.searchService.type) {
      case 'oneway':
        const c = this.searchService.searchCriteria[0];

        this.searchService.searchOneWay(`${c.fromAirport}`, `${c.toAirport}`,
          c.departureDate, `${this.searchService.flightClass}`)
          .subscribe(s => this.searchResults = s);
        break;
      case 'roundtrip':
        this.searchResults = null;
        break;
      case 'multicity':
        this.searchResults = null;
        break;
    }
  }
}
