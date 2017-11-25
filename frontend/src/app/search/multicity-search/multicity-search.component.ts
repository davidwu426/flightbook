import { Component, OnInit, ViewEncapsulation, Input } from '@angular/core';
import { SearchCriteria } from '../../models/search-criteria';
import { SearchService } from '../../services/search/search.service';
import { Airport } from '../../models/airport';

@Component({
  selector: 'app-multicity-search',
  templateUrl: './multicity-search.component.html',
  styleUrls: ['./multicity-search.component.css'],
  encapsulation: ViewEncapsulation.None
})

export class MulticitySearchComponent implements OnInit {
  @Input()
  airports: Airport[];

  constructor(public searchService: SearchService) { }

  ngOnInit() {
  }

  addFlight() {
    this.searchService.addCriteria();
  }

  removeFlight() {
    this.searchService.removeCriteria();
  }
}
