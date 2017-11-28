import { Component, OnInit, Input } from '@angular/core';
import { AirlineService } from '../../services/airline/airline.service';
import { Airline } from '../../models/airline';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-airline-card',
  templateUrl: './airline-card.component.html',
  styleUrls: ['./airline-card.component.css']
})
export class AirlineCardComponent implements OnInit {
  @Input()
  airline: Airline;
  @Input()
  editingAirline: Airline;

  airlines: Airline[];
  modalRef: NgbModalRef;

  constructor(
    private airlineService: AirlineService,
    private modalService: NgbModal
  ) { }

  ngOnInit() {
    this.airline = new Airline();
    this.editingAirline = new Airline();
    this.airlineService.getAirlines().subscribe(a => this.airlines = a);
  }

  addAirline() {
    const id = this.airline.id.trim();
    const name = this.airline.name.trim();
    if (!name || !id) {
      return;
    }

    this.airlineService.addAirline({
      id: id,
      name: name
    } as Airline)
      .subscribe(a => {
        this.airlines.push(a);
        this.airline = new Airline();
      });
  }

  open(content, id: string) {
    this.modalRef = this.modalService.open(content);

    this.editingAirline = new Airline();
    this.editingAirline.id = id;
    this.editingAirline.name = this.airlines.filter(a => a.id === id)[0].name;
  }

  updateAirline() {
    this.airlineService.updateAirline(this.editingAirline)
      .subscribe(a => {
        const updatedAirline: Airline = this.airlines.filter(airline => airline.id === a.id)[0];
        updatedAirline.name = a.name;

        this.modalRef.close();
      });
  }

  deleteAirline(id: string) {
    this.airlineService.deleteAirline(id)
      .subscribe(_ => {
        this.airlines = this.airlines.filter(a => a.id !== id);
      });
  }
}
