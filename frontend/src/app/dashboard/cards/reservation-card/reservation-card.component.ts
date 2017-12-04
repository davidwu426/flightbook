import { Component, OnInit, Input } from '@angular/core';
import { Reservation } from '../../../models/reservation';
import { ReservationService } from '../../../services/reservation/reservation.service';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { ReservationDetails } from '../../../models/reservation-details';

@Component({
  selector: 'app-reservation-card',
  templateUrl: './reservation-card.component.html',
  styleUrls: ['./reservation-card.component.css']
})
export class ReservationCardComponent implements OnInit {
  @Input()
  filterChoice = 0;
  @Input()
  filterResrNo: number;
  @Input()
  filterAirlineId: string;
  @Input()
  filterFlightNo: number;
  @Input()
  filterAccountNo: number;
  @Input()
  filterFirstName: string;
  @Input()
  filterLastName: string;

  reservations: ReservationDetails[];
  filtered = false;

  constructor(
    private reservationService: ReservationService,
  ) { }

  ngOnInit() {
    this.reservationService.getReservations().subscribe(r => this.reservations = r);
  }

  deleteReservation(resrNo: number) {
    this.reservationService.deleteReservation(resrNo)
      .subscribe(_ => {
        this.reservations = this.reservations.filter(r => r.resrNo !== resrNo);
      });
  }

  filter() {
    switch (this.filterChoice) {
      case 0:
        this.reservationService.getReservationByNo(this.filterResrNo)
          .subscribe(r => this.reservations = [r]);
        break;
      case 1:
        this.reservationService.getReservationByFlight(this.filterAirlineId, this.filterFlightNo)
          .subscribe(r => this.reservations = r);
        break;
      case 2:
        this.reservationService.getReservationByAccountNo(this.filterAccountNo)
          .subscribe(r => this.reservations = r);
        break;
      case 3:
        this.reservationService.getReservationByCustomerName(this.filterFirstName, this.filterLastName)
          .subscribe(r => this.reservations = r);
        break;
    }

    this.filtered = true;
  }

  resetFilter() {
    this.reservationService.getReservations().subscribe(r => this.reservations = r);

    this.filtered = false;
  }
}
