import { Component, OnInit, ViewEncapsulation, Input } from '@angular/core';
import { SearchCriteria } from '../../models/search-criteria';
import { SearchService } from '../../services/search/search.service';
import { Airport } from '../../models/airport';

@Component({
  selector: 'app-oneway-search',
  templateUrl: './oneway-search.component.html',
  styleUrls: ['./oneway-search.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class OnewaySearchComponent implements OnInit {
  @Input()
  airports: Airport[];

  c: SearchCriteria;

  constructor(public searchService: SearchService) {
    this.c = this.searchService.searchCriteria[0];
  }

  ngOnInit() {
  }
}
