import { Injectable } from '@angular/core';
import { SearchCriteria } from '../../models/search-criteria';
import { HttpClient } from '@angular/common/http';

type SearchType = 'oneway' | 'roundtrip' | 'multicity';

@Injectable()
export class SearchService {
  searchCriteria: SearchCriteria[] = [new SearchCriteria(), new SearchCriteria()];
  type: SearchType = 'oneway';

  constructor(http: HttpClient) { }

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

  getOneWay(){

  }
}
