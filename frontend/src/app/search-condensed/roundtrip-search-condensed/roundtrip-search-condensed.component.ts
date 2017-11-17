import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { RoundtripSearchComponent } from '../../search/roundtrip-search/roundtrip-search.component';

@Component({
  selector: 'app-roundtrip-search-condensed',
  templateUrl: './roundtrip-search-condensed.component.html',
  styleUrls: ['./roundtrip-search-condensed.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class RoundtripSearchCondensedComponent extends RoundtripSearchComponent {
}
