import { Leg } from './leg';
import { TripLeg } from './trip-leg';

export class SearchEntry {
  airlineId: string;
  airlineName: string;
  price: number;
  fromFlightNo: number;
  flightClass: string;

  tripLegs: TripLeg[];

  tripDepTime: Date;
  tripArrTime: Date;
}
