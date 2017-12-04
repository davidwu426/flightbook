import { Component, OnInit } from '@angular/core';
import { ReservationDetails } from '../../../../models/reservation-details';
import { ReservationService } from '../../../../services/reservation/reservation.service';
import { AuthService } from '../../../../services/auth/auth.service';

@Component({
  selector: 'app-customer-reservation-card',
  templateUrl: './customer-reservation-card.component.html',
  styleUrls: ['./customer-reservation-card.component.css']
})
export class CustomerReservationCardComponent implements OnInit {
  reservations: ReservationDetails[];

  constructor(
    private reservationService: ReservationService,
    private authService: AuthService
  ) { }

  ngOnInit() {
    const accountNo = this.authService.getCustomer().subscribe(c => {
      this.reservationService.getReservationByAccountNo(c.accountNo).subscribe(r => {
        this.reservations = r;
      });
    });
  }
}
