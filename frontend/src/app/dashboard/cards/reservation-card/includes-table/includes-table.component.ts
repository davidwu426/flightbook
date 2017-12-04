import { Component, OnInit, Input } from '@angular/core';
import { Include } from '../../../../models/include';

@Component({
  selector: 'app-includes-table',
  templateUrl: './includes-table.component.html',
  styleUrls: ['./includes-table.component.css']
})
export class IncludesTableComponent implements OnInit {
  @Input()
  includes: Include[];

  constructor() { }

  ngOnInit() {
  }
}
