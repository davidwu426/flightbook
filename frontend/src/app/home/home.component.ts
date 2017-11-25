import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { SearchService } from '../services/search/search.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class HomeComponent implements OnInit {
  constructor() { }

  ngOnInit() {
  }
}
