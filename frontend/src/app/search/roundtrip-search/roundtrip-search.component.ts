import { Component, OnInit, ViewEncapsulation, Input } from '@angular/core';
import { SearchCriteria } from '../../models/search-criteria';
import { SearchService } from '../../services/search/search.service';

@Component({
  selector: 'app-roundtrip-search',
  templateUrl: './roundtrip-search.component.html',
  styleUrls: ['./roundtrip-search.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class RoundtripSearchComponent implements OnInit {
  c: SearchCriteria;

  constructor(public searchService: SearchService) {
    this.c = searchService.searchCriteria[0];
  }

  ngOnInit() {
  }

}
