import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { OnewaySearchComponent } from '../../search/oneway-search/oneway-search.component';

@Component({
  selector: 'app-oneway-search-condensed',
  templateUrl: './oneway-search-condensed.component.html',
  styleUrls: ['./oneway-search-condensed.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class OnewaySearchCondensedComponent extends OnewaySearchComponent {
}
