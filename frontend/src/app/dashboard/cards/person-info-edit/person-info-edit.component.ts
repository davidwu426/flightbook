import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { PersonService } from '../../../services/person/person.service';
import { Person } from '../../../models/person';
import { NgbModalRef } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-person-info-edit',
  templateUrl: './person-info-edit.component.html',
  styleUrls: ['./person-info-edit.component.css']
})
export class PersonInfoEditComponent implements OnInit {
  @Input()
  id: number;
  @Input()
  show: boolean;
  @Output()
  showChange = new EventEmitter();
  @Input()
  person: Person;
  @Input()
  modalRef: NgbModalRef;

  constructor(private personService: PersonService) { }

  ngOnInit() {
    this.personService.getPerson(this.id).subscribe(p => this.person = p);
  }

  toggle() {
    this.show = false;
    this.showChange.emit(false);
  }

  updatePerson() {
    this.personService.updatePerson(this.person).subscribe(p => {


      this.modalRef.close();
    });
  }
}
