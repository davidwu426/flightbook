import { Component, OnInit, Input } from '@angular/core';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { Leg } from '../../../../models/leg';
import { LegService } from '../../../../services/leg/leg.service';

@Component({
  selector: 'app-leg-table',
  templateUrl: './leg-table.component.html',
  styleUrls: ['./leg-table.component.css']
})
export class LegTableComponent implements OnInit {
  @Input()
  airlineId: string;
  @Input()
  flightNo: number;
  @Input()
  leg: Leg;
  @Input()
  editingLeg: Leg;

  legs: Leg[];
  modalRef: NgbModalRef;

  constructor(
    private legService: LegService,
    private modalService: NgbModal
  ) { }

  ngOnInit() {
    this.leg = new Leg();
    this.editingLeg = new Leg();
    this.legService.getLegsByFlightNo(this.airlineId, this.flightNo).subscribe(l => this.legs = l);
  }

  addLeg() {
    const daysOperating = '1010101';

    this.legService.addLeg({
      airlineId: this.airlineId,
      flightNo: this.flightNo,
      legNo: this.leg.legNo,
      depAirportId: this.leg.depAirportId,
      arrAirportId: this.leg.arrAirportId,
      arrTime: this.leg.arrTime,
      depTime: this.leg.depTime
    } as Leg)
      .subscribe(a => {
        this.legs.push(a);
        this.leg = new Leg();
      });
  }

  open(content, airlineId: string, flightNo: number, legNo: number) {
    this.modalRef = this.modalService.open(content);

    this.editingLeg = new Leg();
    this.editingLeg.airlineId = airlineId;
    this.editingLeg.flightNo = flightNo;
    this.editingLeg.legNo = legNo;

    const l = this.legs.filter(leg => leg.airlineId === airlineId && leg.flightNo === flightNo && leg.legNo === legNo)[0];
    this.editingLeg.depAirportId = l.depAirportId;
    this.editingLeg.arrAirportId = l.arrAirportId;
    this.editingLeg.arrTime = l.arrTime;
    this.editingLeg.depTime = l.depTime;
  }

  updateLeg() {
    this.legService.updateLeg(this.editingLeg)
      .subscribe(l => {
        console.log(l);
        const updatedLeg: Leg = this.legs.filter(leg =>
          leg.airlineId === this.editingLeg.airlineId &&
          leg.flightNo === this.editingLeg.flightNo &&
          leg.legNo === this.editingLeg.legNo)[0];
        updatedLeg.depAirportId = l.depAirportId;
        updatedLeg.arrAirportId = l.arrAirportId;
        updatedLeg.arrTime = l.arrTime;
        updatedLeg.depTime = l.depTime;

        this.modalRef.close();
      });
  }

  deleteLeg(airlineId: string, flightNo: number, legNo: number) {
    this.legService.deleteLeg(airlineId, flightNo, legNo)
      .subscribe(_ => {
        this.legs = this.legs.filter(leg =>
          leg.airlineId !== airlineId &&
          leg.flightNo !== flightNo &&
          leg.legNo !== legNo);
      });
  }
}
