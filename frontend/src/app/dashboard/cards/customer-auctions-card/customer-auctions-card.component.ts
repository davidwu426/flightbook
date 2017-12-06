import { Component, OnInit, Input } from '@angular/core';
import { Auction } from '../../../models/auction';
import { CustomerService } from '../../../services/customer/customer.service';
import { AuthService } from '../../../services/auth/auth.service';

@Component({
  selector: 'app-customer-auctions-card',
  templateUrl: './customer-auctions-card.component.html',
  styleUrls: ['./customer-auctions-card.component.css']
})
export class CustomerAuctionsCardComponent implements OnInit {
  auctions: Auction[];

  constructor(
    private customerService: CustomerService, 
    private authService: AuthService
  ) { }

  ngOnInit() {
    this.authService.getCustomer().subscribe(c => {
      const accountNo = c.accountNo;
      this.customerService.getAuctionsByAccountNo(accountNo).subscribe(a => this.auctions = a);
    })
  }

}
