import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddItemInRestComponent } from './add-item-in-rest.component';

describe('AddItemInRestComponent', () => {
  let component: AddItemInRestComponent;
  let fixture: ComponentFixture<AddItemInRestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddItemInRestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddItemInRestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
