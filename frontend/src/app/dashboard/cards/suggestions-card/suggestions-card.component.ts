import { Component, OnInit, Input } from '@angular/core';
import { Flight } from '../../../models/flight';
import { CustomerService } from '../../../services/customer/customer.service';

@Component({
  selector: 'app-suggestions-card',
  templateUrl: './suggestions-card.component.html',
  styleUrls: ['./suggestions-card.component.css']
})
export class SuggestionsCardComponent implements OnInit {
  suggestions: Flight[];
  @Input()
  accountNo: number;

  constructor(private customerService: CustomerService) { }

  ngOnInit() { }

  getSuggestions() {
    this.customerService.getSuggestions(this.accountNo).subscribe(f => this.suggestions = f);
  }

}
