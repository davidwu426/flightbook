import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth/auth.service';
import { Customer } from '../../models/customer';

@Component({
  selector: 'app-profile-information-customer',
  templateUrl: './profile-information-customer.component.html',
  styleUrls: ['./profile-information-customer.component.css']
})
export class ProfileInformationCustomerComponent implements OnInit {
  customer: Customer;
  stars: number[];

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.authService.getCustomer()
      .subscribe(c => {
        this.customer = c;
        this.stars = this.getRatingStars(this.customer.rating);
      });
  }

  getRatingStars(rating): number[] {
    const stars: number[] = [];

    for (let i = 0; i < 5; i++) {
      if (rating >= 1) {
        stars.push(1);
      } else if (rating <= 0) {
        stars.push(-1);
      } else {
        if (rating >= 0.5) {
          stars.push(0);
        } else {
          stars.push(-1);
        }
      }

      rating--;
    }

    return stars;
  }
}
