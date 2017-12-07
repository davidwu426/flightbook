import { Component, OnInit, Input } from '@angular/core';
import { RevenueService } from '../../../services/revenue/revenue.service';

@Component({
  selector: 'app-revenue-card',
  templateUrl: './revenue-card.component.html',
  styleUrls: ['./revenue-card.component.css']
})
export class RevenueCardComponent implements OnInit {
  @Input()
  filterChoice = 0;
  months: string[];
  selectedMonth: number;
  years: number[];
  selectedYear: number;
  totalRevenue: number;
  airlineId: string;
  flightNo: number;
  city: string;
  accountNo: number;

  chosenMonth: number;
  chosenYear: number;

  constructor(private revenueService: RevenueService) { }

  ngOnInit() {
    this.months = ['January', 'February', 'March', 'April', 'May', 'June',
      'July', 'August', 'September', 'October', 'November', 'December'];
    this.selectedMonth = 9;
    this.selectedYear = 2010;
    this.years = [2017, 2016, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008, 2007, 2006, 2005, 2004, 2003, 2002, 2001, 2000]
  }

  filter() {
    switch (this.filterChoice) {
      case 0:
        this.revenueService.getRevenueByMonth(this.selectedYear, this.selectedMonth + 1).subscribe(b => {
          this.totalRevenue = b;
        });
        this.chosenMonth = this.selectedMonth;
        this.chosenYear = this.selectedYear;
        break;
      case 1:
        this.revenueService.getRevenueByFlight(this.airlineId, this.flightNo).subscribe(b => {
          this.totalRevenue = b;
        })
        break;
      case 2:
        this.revenueService.getRevenueByCity(this.city).subscribe(b => {
          this.totalRevenue = b;
        })
        break;
      case 3:
        this.revenueService.getRevenueByAccountNo(this.accountNo).subscribe(b => {
          this.totalRevenue =b;
        })
        break;
    }
  }
}
