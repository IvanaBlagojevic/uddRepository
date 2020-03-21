import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchReviewersComponent } from './search-reviewers.component';

describe('SearchReviewersComponent', () => {
  let component: SearchReviewersComponent;
  let fixture: ComponentFixture<SearchReviewersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchReviewersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchReviewersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
