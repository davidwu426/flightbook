import { Injectable } from '@angular/core';
import { SearchCriteria } from '../../models/search-criteria';

type SearchType = 'oneway' | 'roundtrip' | 'multicity';

@Injectable()
export class SearchService {
  searchCriteria: SearchCriteria[] = [new SearchCriteria(), new SearchCriteria()];
  type: SearchType = 'oneway';

  constructor() { }

  addCriteria() {
    if (this.searchCriteria.length < 5) {
      this.searchCriteria.push(new SearchCriteria());
    }
  }

  removeCriteria() {
    if (this.searchCriteria.length > 2) {
      this.searchCriteria.pop();
    }
  }
}
