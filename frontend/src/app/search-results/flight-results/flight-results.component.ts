import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { SearchService } from '../../services/search/search.service';

@Component({
  selector: 'app-flight-results',
  templateUrl: './flight-results.component.html',
  styleUrls: ['./flight-results.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class FlightResultsComponent implements OnInit {

  constructor(public searchService: SearchService) { }

  ngOnInit() {
  }

}
