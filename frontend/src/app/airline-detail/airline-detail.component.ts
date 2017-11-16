import { Component, OnInit, ViewEncapsulation, Input } from '@angular/core';
import { Airline } from '../models/airline';
import { ActivatedRoute } from '@angular/router';
import { AirlineService } from '../services/airline/airline.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-airline-detail',
  templateUrl: './airline-detail.component.html',
  styleUrls: ['./airline-detail.component.css']
})
export class AirlineDetailComponent implements OnInit {
  @Input()
  airline: Airline;

  constructor(
    private route: ActivatedRoute,
    private airlineService: AirlineService,
    private location: Location
  ) { }

  ngOnInit() {
    this.getAirline();
  }

  getAirline(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.airlineService.getAirline(id)
      .subscribe(airline => this.airline = airline);
  }

  save(): void {
    this.airlineService.updateAirline(this.airline)
      .subscribe(_ => this.goBack());
  }

  goBack(): void {
    this.location.back();
  }
}
