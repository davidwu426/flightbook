import { Component, OnInit, Input } from '@angular/core';
import { AirportService } from '../../services/airport/airport.service';
import { Airport } from '../../models/airport';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-airport-card',
  templateUrl: './airport-card.component.html',
  styleUrls: ['./airport-card.component.css']
})
export class AirportCardComponent implements OnInit {
  @Input()
  airport: Airport;
  @Input()
  editingAirport: Airport;

  airports: Airport[];
  modalRef: NgbModalRef;

  constructor(
    private airportService: AirportService,
    private modalService: NgbModal
  ) { }

  ngOnInit() {
    this.airport = new Airport();
    this.editingAirport = new Airport();
    this.airportService.getAirports().subscribe(a => this.airports = a);
  }

  addAirport() {
    const id = this.airport.id.trim();
    const name = this.airport.name.trim();
    const city = this.airport.city.trim();
    const country = this.airport.country.trim();
    if (!name || !id || !city || !country) {
      return;
    }

    this.airportService.addAirport({
      id: id,
      name: name,
      city: city,
      country: country
    } as Airport)
      .subscribe(a => {
        this.airports.push(a);
        this.airport = new Airport();
      });
  }

  open(content, id: string) {
    this.modalRef = this.modalService.open(content);

    this.editingAirport = new Airport();
    this.editingAirport.id = id;

    const ap = this.airports.filter(a => a.id === id)[0];
    this.editingAirport.name = ap.name;
    this.editingAirport.city = ap.city;
    this.editingAirport.country = ap.country;
  }

  updateAirport() {
    this.airportService.updateAirport(this.editingAirport)
      .subscribe(a => {
        const updatedAirport: Airport = this.airports.filter(airport => airport.id === a.id)[0];
        updatedAirport.name = a.name;
        updatedAirport.city = a.city;
        updatedAirport.country = a.country;

        this.modalRef.close();
      });
  }

  deleteAirport(id: string) {
    this.airportService.deleteAirport(id)
      .subscribe(_ => {
        this.airports = this.airports.filter(a => a.id !== id);
      });
  }
}
