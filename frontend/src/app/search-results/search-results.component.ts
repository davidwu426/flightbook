import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-search-results',
  templateUrl: './search-results.component.html',
  styleUrls: ['./search-results.component.css']
})
export class SearchResultsComponent implements OnInit {
  timesReSearched = 0;

  constructor() { }

  ngOnInit() {
  }

  triggerReSearch() {
    this.timesReSearched++;
  }
}
