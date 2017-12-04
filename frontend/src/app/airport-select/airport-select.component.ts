import { Component, OnInit, Input, forwardRef, Output, EventEmitter } from '@angular/core';
import { AirportService } from '../services/airport/airport.service';
import { Airport } from '../models/airport';
import { ControlValueAccessor, NG_VALUE_ACCESSOR, FormsModule } from '@angular/forms';

@Component({
  selector: 'app-airport-select',
  templateUrl: './airport-select.component.html',
  styleUrls: ['./airport-select.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => AirportSelectComponent),
      multi: true
    }
  ]
})
export class AirportSelectComponent implements OnInit, ControlValueAccessor {
  @Input()
  model: string;
  @Output()
  modelChange = new EventEmitter();

  airports: Airport[];

  private onChange(value) {
    this.model = value;
    this.modelChange.emit(value);
  }
  private onTouched = (_) => {};

  constructor(private airportService: AirportService) { }

  ngOnInit() {
    this.airportService.getAirports().subscribe(airports => this.airports = airports);
  }

  writeValue(obj: any): void {
    this.model = obj;
  }
  registerOnChange(fn: any): void {
    this.onChange = fn;
  }
  registerOnTouched(fn: any): void {
    this.onTouched = fn;
  }
}
