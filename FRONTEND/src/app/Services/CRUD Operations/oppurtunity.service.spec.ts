import { TestBed } from '@angular/core/testing';

import { OppurtunityService } from './oppurtunity.service';

describe('OppurtunityService', () => {
  let service: OppurtunityService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OppurtunityService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
