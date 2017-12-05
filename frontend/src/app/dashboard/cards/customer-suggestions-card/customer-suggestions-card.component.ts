import { Component, OnInit } from '@angular/core';
import { Flight } from '../../../models/flight';
import { CustomerService } from '../../../services/customer/customer.service';
import { AuthService } from '../../../services/auth/auth.service';

@Component({
  selector: 'app-customer-suggestions-card',
  templateUrl: './customer-suggestions-card.component.html',
  styleUrls: ['./customer-suggestions-card.component.css']
})
export class CustomerSuggestionsCardComponent implements OnInit {

  suggestions: Flight[];

  constructor(
    private customerService: CustomerService,
    private authService: AuthService
  ) { }

  ngOnInit() {
    this.authService.getCustomer().subscribe(c => {
      const accountNo = c.accountNo;
      this.customerService.getSuggestions(accountNo).subscribe(f => this.suggestions = f);
    })
  }
}
