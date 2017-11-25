import { Component, OnInit, Input } from '@angular/core';
import { SearchService } from '../services/search/search.service';
import { Router } from '@angular/router';
import { AirportService } from '../services/airport/airport.service';
import { Airport } from '../models/airport';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  isLoading = false;
  airports: Airport[];

  constructor(
    public searchService: SearchService,
    public airportService: AirportService,
    private router: Router
  ) { }

  ngOnInit() {
    this.airportService.getAirports().subscribe(airports => this.airports = airports);
  }

  search() {
    this.isLoading = true;

    this.router.navigateByUrl('search-results');
  }
}
