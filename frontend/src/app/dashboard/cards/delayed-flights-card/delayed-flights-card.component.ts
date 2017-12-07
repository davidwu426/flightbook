import { Component, OnInit } from '@angular/core';
import { Flight } from '../../../models/flight';
import { FlightService } from '../../../services/flight/flight.service';

@Component({
  selector: 'app-delayed-flights-card',
  templateUrl: './delayed-flights-card.component.html',
  styleUrls: ['./delayed-flights-card.component.css']
})
export class DelayedFlightsCardComponent implements OnInit {
  delayedFlights : Flight[];
  constructor(private flightService : FlightService) { }

  ngOnInit() {
    this.flightService.getDelayedFights().subscribe(f => this.delayedFlights = f);
  }

}
