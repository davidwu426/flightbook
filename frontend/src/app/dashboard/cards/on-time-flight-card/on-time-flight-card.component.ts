import { Component, OnInit } from '@angular/core';
import { Flight } from '../../../models/flight';
import { FlightService } from '../../../services/flight/flight.service';

@Component({
  selector: 'app-on-time-flight-card',
  templateUrl: './on-time-flight-card.component.html',
  styleUrls: ['./on-time-flight-card.component.css']
})
export class OnTimeFlightCardComponent implements OnInit {
  onTimeFlights : Flight[];
  constructor(private flightService : FlightService) { }

  ngOnInit() {
    return this.flightService.getOnTimeFlights().subscribe(f => this.onTimeFlights = f)
  }

}
