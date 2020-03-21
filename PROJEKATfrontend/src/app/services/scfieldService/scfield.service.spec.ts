import { TestBed } from '@angular/core/testing';

import { ScfieldService } from './scfield.service';

describe('ScfieldService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ScfieldService = TestBed.get(ScfieldService);
    expect(service).toBeTruthy();
  });
});
