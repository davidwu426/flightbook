import { Component, OnInit } from '@angular/core';
import { RevenueService } from '../../../services/revenue/revenue.service';
import { TotalBookingFee } from '../../../models/total-booking-fee';

@Component({
  selector: 'app-revenue-card',
  templateUrl: './revenue-card.component.html',
  styleUrls: ['./revenue-card.component.css']
})
export class RevenueCardComponent implements OnInit {
  months: string[];
  selectedMonth: number;
  years: number[];
  selectedYear: number;
  totalRevenue: TotalBookingFee;

  constructor(private revenueService: RevenueService) { }

  ngOnInit() {
    this.months = ['January', 'February', 'March', 'April', 'May', 'June',
      'July', 'August', 'September', 'October', 'November', 'December'];
    this.selectedMonth = 0;
    this.selectedYear = 2010;
    this.years = [2017, 2016, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008, 2007, 2006, 2005, 2004, 2003, 2002, 2001, 2000]
  }

  getMonthRevenue() {
    this.revenueService.getRevenueByMonth(this.selectedYear, this.selectedMonth).subscribe(b => {
      console.log(b);
      this.totalRevenue = b;
    });
  }

}
