import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantownerloginComponent } from './restaurantownerlogin.component';

describe('RestaurantownerloginComponent', () => {
  let component: RestaurantownerloginComponent;
  let fixture: ComponentFixture<RestaurantownerloginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestaurantownerloginComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RestaurantownerloginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
