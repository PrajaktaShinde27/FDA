import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantownerregistrationComponent } from './restaurantownerregistration.component';

describe('RestaurantownerregistrationComponent', () => {
  let component: RestaurantownerregistrationComponent;
  let fixture: ComponentFixture<RestaurantownerregistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestaurantownerregistrationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RestaurantownerregistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
