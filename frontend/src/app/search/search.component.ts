import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { SearchService } from '../services/search/search.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class SearchComponent implements OnInit {

  constructor(
    public searchService: SearchService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  search() {
    this.router.navigateByUrl('search-results');
  }
}
