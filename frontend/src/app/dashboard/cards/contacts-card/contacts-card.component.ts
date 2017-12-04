import { Component, OnInit } from '@angular/core';
import { CustomerContact } from '../../../models/customer-contact';
import { PersonService } from '../../../services/person/person.service';

@Component({
  selector: 'app-contacts-card',
  templateUrl: './contacts-card.component.html',
  styleUrls: ['./contacts-card.component.css']
})
export class ContactsCardComponent implements OnInit {
  contacts: CustomerContact[];

  constructor(private personService: PersonService) { }

  ngOnInit() {
    this.personService.getContacts().subscribe(c => this.contacts = c);
  }
}
