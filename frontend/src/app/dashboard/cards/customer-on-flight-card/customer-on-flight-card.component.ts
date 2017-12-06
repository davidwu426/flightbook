import { Component, OnInit, Input} from '@angular/core';
import { CustomerOnFlight } from '../../../models/customer-on-flight';
import { FlightService } from '../../../services/flight/flight.service';


@Component({
  selector: 'app-customer-on-flight-card',
  templateUrl: './customer-on-flight-card.component.html',
  styleUrls: ['./customer-on-flight-card.component.css']
})
export class CustomerOnFlightCardComponent implements OnInit {
  customerOnFlight : CustomerOnFlight[];
  @Input()
  airlineId : string;
  flightNo : number;


  constructor(private flightService: FlightService) { }

  ngOnInit() {
  }
  
  getCustomerOnFlight()
  {
    this.flightService.getCustomerOnFlight(this.airlineId, this.flightNo).subscribe(c => this.customerOnFlight = c);
  }

}
