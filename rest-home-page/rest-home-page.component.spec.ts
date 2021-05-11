import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestHomePageComponent } from './rest-home-page.component';

describe('RestHomePageComponent', () => {
  let component: RestHomePageComponent;
  let fixture: ComponentFixture<RestHomePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestHomePageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RestHomePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
