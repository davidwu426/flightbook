import { Airport } from './airport';

export class SearchCriteria {
  fromAirport: Airport;
  toAirport: Airport;
  departureDate: Date;
  returningDate: Date;
}
