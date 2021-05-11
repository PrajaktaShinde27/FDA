import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MakepayementComponent } from './makepayement.component';

describe('MakepayementComponent', () => {
  let component: MakepayementComponent;
  let fixture: ComponentFixture<MakepayementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MakepayementComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MakepayementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
