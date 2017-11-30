import { Component, OnInit, Input } from '@angular/core';
import { Flight } from '../../../models/flight';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { FlightService } from '../../../services/flight/flight.service';

@Component({
  selector: 'app-flight-card',
  templateUrl: './flight-card.component.html',
  styleUrls: ['./flight-card.component.css']
})
export class FlightCardComponent implements OnInit {
  @Input()
  flight: Flight;
  @Input()
  editingFlight: Flight;

  flights: Flight[];
  modalRef: NgbModalRef;

  constructor(
    private flightService: FlightService,
    private modalService: NgbModal
  ) { }

  ngOnInit() {
    this.flight = new Flight();
    this.editingFlight = new Flight();
    this.flightService.getFlights().subscribe(a => this.flights = a);
  }

  addFlight() {
    const airlineId = this.flight.airlineId.trim();
    if (!airlineId) {
      return;
    }

    this.flightService.addFlight({
      airlineId: airlineId,
      flightNo: this.flight.flightNo,
      noOfSeats: this.flight.noOfSeats,
      daysOperating: this.flight.daysOperating,
      minLengthOfStay: this.flight.minLengthOfStay,
      maxLengthOfStay: this.flight.maxLengthOfStay
    } as Flight)
      .subscribe(a => {
        this.flights.push(a);
        this.flight = new Flight();
      });
  }

  open(content, airlineId: string, flightNo: number) {
    this.modalRef = this.modalService.open(content);

    this.editingFlight = new Flight();
    this.editingFlight.airlineId = airlineId;
    this.editingFlight.flightNo = flightNo;

    const fl = this.flights.filter(f => f.airlineId === airlineId && f.flightNo === flightNo)[0];
    this.editingFlight.noOfSeats = fl.noOfSeats;
    this.editingFlight.minLengthOfStay = fl.minLengthOfStay;
    this.editingFlight.maxLengthOfStay = fl.maxLengthOfStay;
  }

  updateFlight() {
    this.flightService.updateFlight(this.editingFlight)
      .subscribe(a => {
        const updatedFlight: Flight = this.flights.filter(flight => flight.airlineId === a.airlineId)[0];
        updatedFlight.noOfSeats = a.noOfSeats;
        updatedFlight.daysOperating = a.daysOperating;
        updatedFlight.minLengthOfStay = a.minLengthOfStay;
        updatedFlight.maxLengthOfStay = a.maxLengthOfStay;

        this.modalRef.close();
      });
  }

  deleteFlight(airlineId: string, flightNo: number) {
    this.flightService.deleteFlight(airlineId, flightNo)
      .subscribe(_ => {
        this.flights = this.flights.filter(a => a.airlineId !== airlineId && a.flightNo !== flightNo);
      });
  }
}
