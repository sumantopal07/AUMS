import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddOppComponent } from './add-opp.component';

describe('AddOppComponent', () => {
  let component: AddOppComponent;
  let fixture: ComponentFixture<AddOppComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddOppComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddOppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
