import { Component, OnInit } from '@angular/core';
import { BestSoldFlight } from '../../../models/best-sold-flights';
import { FlightService } from '../../../services/flight/flight.service';

@Component({
  selector: 'app-best-sold-flights-card',
  templateUrl: './best-sold-flights-card.component.html',
  styleUrls: ['./best-sold-flights-card.component.css']
})
export class BestSoldFlightsCardComponent implements OnInit {
  bestSoldFlights : BestSoldFlight[]

  constructor(private flightService : FlightService) { }

  ngOnInit() {
     this.flightService.getBestSoldFlight().subscribe(f => this.bestSoldFlights = f);
  }
}
