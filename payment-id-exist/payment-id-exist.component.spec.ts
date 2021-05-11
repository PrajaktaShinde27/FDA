import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymentIdExistComponent } from './payment-id-exist.component';

describe('PaymentIdExistComponent', () => {
  let component: PaymentIdExistComponent;
  let fixture: ComponentFixture<PaymentIdExistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PaymentIdExistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PaymentIdExistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
