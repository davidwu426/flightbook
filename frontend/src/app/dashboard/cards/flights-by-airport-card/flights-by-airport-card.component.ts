import { Component, OnInit, Input } from '@angular/core';
import { Flight } from '../../../models/flight';
import { FlightService } from '../../../services/flight/flight.service';

@Component({
  selector: 'app-flights-by-airport-card',
  templateUrl: './flights-by-airport-card.component.html',
  styleUrls: ['./flights-by-airport-card.component.css']
})
export class FlightsByAirportCardComponent implements OnInit {
  flights: Flight[];
  @Input()
  airportId: string;

  constructor(private flightService: FlightService) { }

  ngOnInit() {
  }

  getFlightsByAirport() {
    this.flightService.getFlightsByAirport(this.airportId).subscribe(f => this.flights = f);
  }

}
