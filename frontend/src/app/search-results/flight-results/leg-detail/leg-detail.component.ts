import { Component, OnInit, Input } from '@angular/core';
import { SearchEntry } from '../../../models/search-entry';
import { TripLeg } from '../../../models/trip-leg';
import { Airport } from '../../../models/airport';

@Component({
  selector: 'app-leg-detail',
  templateUrl: './leg-detail.component.html',
  styleUrls: ['./leg-detail.component.css']
})
export class LegDetailComponent implements OnInit {
  @Input()
  index: number;
  @Input()
  searchEntry: SearchEntry;
  @Input()
  tripLeg: TripLeg;
  @Input()
  to: Airport;

  constructor() { }

  ngOnInit() {
  }
}
