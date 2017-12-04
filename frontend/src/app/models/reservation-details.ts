import { Include } from './include';

export class ReservationDetails {
  resrNo: number;
  resrDate: Date;
  bookingFee: number;
  totalFare: number;
  repSSN: number;
  accountNo: number;
  includes: Include[];
}
