import { Leg } from './leg';

export class SearchEntry {
  airlineId: string;
  price: number;
  fromFlightNo: number;
  legs: Leg[];
}
