import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth/auth.service';
import { CustomerEntity } from '../../models/customer-entity';

@Component({
  selector: 'app-profile-information-customer',
  templateUrl: './profile-information-customer.component.html',
  styleUrls: ['./profile-information-customer.component.css']
})
export class ProfileInformationCustomerComponent implements OnInit {
  customerEntity: CustomerEntity;
  stars: number[];

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.authService.getCustomerEntity()
      .subscribe(c => {
        this.customerEntity = c;
        this.stars = this.getRatingStars(this.customerEntity.rating);
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
