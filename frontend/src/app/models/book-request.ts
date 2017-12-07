import { TripLeg } from './trip-leg';

export class BookRequest {
  constructor(private accountNo: number,
    private totalFare: number,
    private bookingFee: number,
    private flightClass: string,
    private meal: string,
    private seatNo: string,
    private legs: TripLeg[],
    private fromLegNo: number) { }
}
