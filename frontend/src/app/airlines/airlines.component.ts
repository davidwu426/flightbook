import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Airline } from '../models/airline';
import { AirlineService } from '../services/airline/airline.service';

@Component({
  selector: 'app-airlines',
  templateUrl: './airlines.component.html',
  styleUrls: ['./airlines.component.css']
})
export class AirlinesComponent implements OnInit {
  airlines: Airline[];

  constructor(private airlineService: AirlineService) { }

  ngOnInit() {
    this.getAirlines();
  }

  getAirlines(): void {
    this.airlineService.getAirlines()
      .subscribe(airlines => this.airlines = airlines);
  }

  add(id: string, name: string): void {
    id = id.trim();
    name = name.trim();
    if (!name || !id) {
      return;
    }

    this.airlineService.addAirline({
      id: id,
      name: name
    } as Airline)
      .subscribe(airline => {
        this.airlines.push(airline);
      });
  }

  delete(airline: Airline): void {
    this.airlines = this.airlines.filter(h => h !== airline);
    this.airlineService.deleteAirline(airline).subscribe();
  }
}
