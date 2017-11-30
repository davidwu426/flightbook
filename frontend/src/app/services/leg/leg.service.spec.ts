import { TestBed, inject } from '@angular/core/testing';

import { LegService } from './leg.service';

describe('LegService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LegService]
    });
  });

  it('should be created', inject([LegService], (service: LegService) => {
    expect(service).toBeTruthy();
  }));
});
