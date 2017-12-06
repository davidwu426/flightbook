import { Component, OnInit, OnChanges, Input } from '@angular/core';
import { SearchService } from '../../services/search/search.service';
import { SearchEntry } from '../../models/search-entry';
import { SearchCriteria } from '../../models/search-criteria';
import { EventEmitter } from 'events';
import { Airport } from '../../models/airport';
import { FlightClass } from '../../models/flight-class';

@Component({
  selector: 'app-flight-results',
  templateUrl: './flight-results.component.html',
  styleUrls: ['./flight-results.component.css']
})
export class FlightResultsComponent implements OnInit, OnChanges {
  @Input()
  timesReSearched: number;

  type: string;
  fromAirport: Airport;
  toAirport: Airport;
  depDate: Date;
  arrDate: Date;
  flightClass: FlightClass;

  searchResults: SearchEntry[][] = [];

  constructor(public searchService: SearchService) { }

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
        this.searchResults = null;
        break;
    }
  }
}
