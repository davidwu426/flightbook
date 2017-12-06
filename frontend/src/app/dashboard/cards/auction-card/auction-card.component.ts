import { Component, OnInit } from '@angular/core';
import { Auction } from '../../../models/auction';
import { CustomerService } from '../../../services/customer/customer.service';

@Component({
  selector: 'app-auction-card',
  templateUrl: './auction-card.component.html',
  styleUrls: ['./auction-card.component.css']
})
export class AuctionCardComponent implements OnInit {
  auctions: Auction[];
  airlineId: string;
  flightNo: number;
  flightClass: string;

  constructor(private customerService: CustomerService) { }

  ngOnInit() {
  }

  getAuction() {
    this.customerService.getAuction(this.airlineId, this.flightNo, this.flightClass).subscribe(a => this.auctions = a);
  }

}
