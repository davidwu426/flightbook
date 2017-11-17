import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { MulticitySearchComponent } from '../../search/multicity-search/multicity-search.component';

@Component({
  selector: 'app-multicity-search-condensed',
  templateUrl: './multicity-search-condensed.component.html',
  styleUrls: ['./multicity-search-condensed.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class MulticitySearchCondensedComponent extends MulticitySearchComponent {
}
