import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MatDialogModule, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

import { OrdersListDialogComponent } from './orders-list-dialog.component';

describe('OrdersListDialogComponent', () => {
  let component: OrdersListDialogComponent;
  let fixture: ComponentFixture<OrdersListDialogComponent>;

  const dialogMock = {
    close: () => { }
  }

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MatDialogModule],
      declarations: [ OrdersListDialogComponent ],
      providers: [{provide: MatDialogRef, useValue: dialogMock},
        { provide: MAT_DIALOG_DATA, useValue: {} }]
    })
    .compileComponents();
    jasmine.DEFAULT_TIMEOUT_INTERVAL = 1000000;
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrdersListDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('return ok', () => {
    let spy = spyOn(component.dialogRef, 'close').and.callThrough();
    component.ok();
    expect(spy).toHaveBeenCalled();
  })

  it('retrun notOk', () => {
    let spy = spyOn(component.dialogRef, 'close').and.callThrough();
    component.notOk();
    expect(spy).toHaveBeenCalled();
  })
});
