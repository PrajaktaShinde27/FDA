import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestOwnerRestViewDetailsComponent } from './rest-owner-rest-view-details.component';

describe('RestOwnerRestViewDetailsComponent', () => {
  let component: RestOwnerRestViewDetailsComponent;
  let fixture: ComponentFixture<RestOwnerRestViewDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestOwnerRestViewDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RestOwnerRestViewDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
