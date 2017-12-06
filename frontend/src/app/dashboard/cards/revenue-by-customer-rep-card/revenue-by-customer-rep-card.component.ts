import { Component, OnInit } from '@angular/core';
import { RevenueService } from '../../../services/revenue/revenue.service';

@Component({
  selector: 'app-revenue-by-customer-rep-card',
  templateUrl: './revenue-by-customer-rep-card.component.html',
  styleUrls: ['./revenue-by-customer-rep-card.component.css']
})
export class RevenueByCustomerRepCardComponent implements OnInit {
  id : number;
  constructor(private revenueService: RevenueService) { 
    
  }

  ngOnInit() {
    this.revenueService.getRevenueOfBestCustomerRep().subscribe(b => {
      this.id = b;
    })
  }
}
