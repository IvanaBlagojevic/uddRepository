import { TestBed } from '@angular/core/testing';

import { MembershipFeesService } from './membership-fees.service';

describe('MembershipFeesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MembershipFeesService = TestBed.get(MembershipFeesService);
    expect(service).toBeTruthy();
  });
});
