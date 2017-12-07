import { Component, OnInit } from '@angular/core';
import { FrequentFlight } from '../../../models/frequent-flight';
import { FlightService } from '../../../services/flight/flight.service';

@Component({
  selector: 'app-most-frequent-flight-card',
  templateUrl: './most-frequent-flight-card.component.html',
  styleUrls: ['./most-frequent-flight-card.component.css']
})
export class MostFrequentFlightCardComponent implements OnInit {
  frequentFlights : FrequentFlight[];

  constructor(private flightService : FlightService) { }

  ngOnInit() {
    this.flightService.getMostFrequentFlight().subscribe(f =>{
      console.log(f);
     this.frequentFlights = f;
    });
  }

}
