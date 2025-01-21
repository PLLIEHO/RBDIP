import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MatDialogModule, MatDialogRef } from '@angular/material/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ActivatedRoute, convertToParamMap } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { NgxSpinnerService } from 'ngx-spinner';
import { of } from 'rxjs';
import { CrudService } from 'src/app/core/services/crud.service';
import { ErrorHandlerDescriptor } from 'src/app/core/services/error-handling/error-handler-descriptor';

import { OrdersListComponent } from './orders-list.component';

describe('OrdersListComponent', () => {
  let component: OrdersListComponent;
  let fixture: ComponentFixture<OrdersListComponent>;

  const fakeActivatedRoute = {
    snapshot : {
    }
  } as ActivatedRoute;

  const spinnerMock = {
    hide: () => { },
    show: () => { }
  };

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule, RouterTestingModule, MatDialogModule, BrowserAnimationsModule],
      declarations: [ OrdersListComponent ],
      providers: [ {provide: ActivatedRoute, useValue: fakeActivatedRoute},
        {provide: NgxSpinnerService, useValue: spinnerMock},
        CrudService,
        ErrorHandlerDescriptor]
    })
    .compileComponents();
    jasmine.DEFAULT_TIMEOUT_INTERVAL = 1000000;
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrdersListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });


  it('hide spinner', async () => {
    let spy = spyOn<any>(component['spinner'], 'hide').and.callThrough();
    await component.ngOnInit();
    expect(spy).toHaveBeenCalled();
  });
});
