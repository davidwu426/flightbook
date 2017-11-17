import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { SearchComponent } from '../search/search.component';

@Component({
  selector: 'app-search-condensed',
  templateUrl: './search-condensed.component.html',
  styleUrls: ['./search-condensed.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class SearchCondensedComponent extends SearchComponent {
}
