import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OppComponent } from './opp.component';

describe('OppComponent', () => {
  let component: OppComponent;
  let fixture: ComponentFixture<OppComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OppComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
