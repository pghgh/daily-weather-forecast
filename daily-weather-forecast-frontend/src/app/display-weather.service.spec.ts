import { TestBed } from '@angular/core/testing';

import { DisplayWeatherService } from './display-weather.service';

describe('DisplayWeatherService', () => {
  let service: DisplayWeatherService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DisplayWeatherService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
