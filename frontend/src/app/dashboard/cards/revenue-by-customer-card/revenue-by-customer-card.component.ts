import { Component, OnInit } from '@angular/core';
import { RevenueService } from '../../../services/revenue/revenue.service';
import { CustomerPerson } from '../../../models/customer-person';

@Component({
  selector: 'app-revenue-by-customer-card',
  templateUrl: './revenue-by-customer-card.component.html',
  styleUrls: ['./revenue-by-customer-card.component.css']
})
export class RevenueByCustomerCardComponent implements OnInit {
  bestCustomer : CustomerPerson;
  
  constructor(private revenueService: RevenueService) { }

  ngOnInit() {
    this.revenueService.getRevenueOfBestCustomer().subscribe(b => {
      this.bestCustomer = b;
    })
  }
}
